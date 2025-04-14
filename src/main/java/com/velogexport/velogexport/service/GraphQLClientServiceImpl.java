package com.velogexport.velogexport.service;

import com.velogexport.velogexport.config.VelogProperties;
import com.velogexport.velogexport.domain.GraphQLQuery;
import com.velogexport.velogexport.domain.KeyName;
import com.velogexport.velogexport.domain.VelogDetail;
import com.velogexport.velogexport.domain.body.request.ReadPostBody;
import com.velogexport.velogexport.domain.body.request.ReadPostsBody;
import com.velogexport.velogexport.domain.body.request.ReadUserBody;
import com.velogexport.velogexport.domain.body.response.PostMD;
import com.velogexport.velogexport.domain.body.response.post.PostResponseBody;
import com.velogexport.velogexport.domain.body.response.posts.Post;
import com.velogexport.velogexport.domain.body.response.posts.PostsResponseBody;
import com.velogexport.velogexport.domain.body.response.user.UserResponseBody;
import com.velogexport.velogexport.exception.GraphQLException;
import com.velogexport.velogexport.utils.MDUtils;
import com.velogexport.velogexport.utils.URLUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.mvc.method.annotation.StreamingResponseBody;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

@Service
@RequiredArgsConstructor
@Slf4j
public class GraphQLClientServiceImpl implements GraphQLClientService {
    private static final String BASE_POST_PATH = "posts/";
    private final RestTemplate restTemplate;
    private final VelogProperties velogProperties;


    /***
     * 1. 그냥 오리지널 파일 다운로드
     *  - NONE
     *  - 시리즈별 이미지 저장
     *  - 특정 경로에 몰아 저장
     *
     *  posts
     *   - s1
     *      - p1
     *          - post
     *          - images ( optional )
     *              - img1
     *              - img2
     *      - p2
     *      - p3
     *   - s2
     *   - s3
     *  images ( optional )
     *   - s1
     *      - p1
     *      - p2
     *      - p3
     *   - s2
     * @param velogDetail
     * @return
     */
    @Override
    public StreamingResponseBody downloadAllVelogPost(VelogDetail velogDetail) {
        velogDetail.processImageUrlReplacePath();

        Map<String, List<PostMD>> mdFiles = searchMdFiles(velogDetail.getId());

        StreamingResponseBody responseBody = outputStream -> {
            try (ZipOutputStream zipOut = new ZipOutputStream(outputStream)) {
                if (velogDetail.isImageGrouping() && !velogDetail.getImageUrlReplacePath().isBlank()) {
                    zipOut.putNextEntry(new ZipEntry("images/"));
                    zipOut.closeEntry();
                }
                for (Map.Entry<String, List<PostMD>> entry : mdFiles.entrySet()) {
                    String seriesPath = BASE_POST_PATH + URLUtils.preprocessURL(entry.getValue().get(0).getSeriesName());
                    zipOut.putNextEntry(new ZipEntry(seriesPath));
                    zipOut.closeEntry();
                    Map<String, String> urlToLocalPath = new LinkedHashMap<>();

                    for (PostMD postMD : entry.getValue()) {
                        if (!velogDetail.isImageGrouping()) {
                            zipOut.putNextEntry(new ZipEntry(seriesPath + postMD.getTitle() + ".md"));
                            zipOut.write(postMD.writeMD().getBytes(StandardCharsets.UTF_8));
                            zipOut.closeEntry();
                            continue;
                        }
                        List<String> originalImageUrls = MDUtils.extractImageUrls(postMD.getContent());
                        for (String originalImageUrl : originalImageUrls) {
                            try (InputStream in = new URL(originalImageUrl).openStream()) {
                                String imageName = UUID.randomUUID() + MDUtils.getImageFileExtension(originalImageUrl);
                                String postImagePath = "images/" + URLUtils.preprocessURL(postMD.getSeriesName()) + imageName;

                                if (velogDetail.getImageUrlReplacePath().isBlank()) {
                                    zipOut.putNextEntry(new ZipEntry(seriesPath + postImagePath));
                                } else {
                                    zipOut.putNextEntry(new ZipEntry(postImagePath));
                                }

                                byte[] buffer = new byte[1024];
                                int len;
                                while ((len = in.read(buffer)) > 0) {
                                    zipOut.write(buffer, 0, len);
                                }
                                zipOut.closeEntry();

                                if (velogDetail.getImageUrlReplacePath().isBlank()) {
                                    urlToLocalPath.put(originalImageUrl, "<%s>".formatted(seriesPath+postImagePath));
                                } else {
                                    urlToLocalPath.put(originalImageUrl, "<%s>".formatted(velogDetail.getImageUrlReplacePath() + imageName));

                                }

                            } catch (IOException e) {
//                                    throw new NotImageUrlException();
                            }
                        }
                        String updatedMarkdown = postMD.getContent();
                        for (Map.Entry<String, String> urlEntry : urlToLocalPath.entrySet()) {
                            updatedMarkdown = updatedMarkdown.replace(urlEntry.getKey(), urlEntry.getValue());
                        }
                        zipOut.putNextEntry(new ZipEntry(seriesPath + postMD.getTitle() + ".md"));
                        zipOut.write(updatedMarkdown.getBytes(StandardCharsets.UTF_8));
                        zipOut.closeEntry();
                    }
                }
                zipOut.finish();
            }
        };
        return responseBody;
    }

    @Override
    public boolean existVelogId(String username) {
        ReadUserBody request = new ReadUserBody(GraphQLQuery.READ_USER, username);
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        try {
            ResponseEntity<UserResponseBody> result = restTemplate.postForEntity(
                    velogProperties.getUrlV3(),
                    new HttpEntity<>(request, headers),
                    UserResponseBody.class
            );
            return result.getBody().isExist();
        } catch (RestClientException e) {
            throw new GraphQLException();
        }
    }

    @Override
    public Map<String, List<PostMD>> searchMdFiles(String username) {
        String cursor = null;
        Map<String, List<PostMD>> result = new HashMap<>();
        result.put(KeyName.NO_SERIES.getKey(), new ArrayList<>());
        while (true) {
            List<Post> posts = requestPosts(username, cursor).getPostData().getPosts();
            if (posts.isEmpty()) {
                break;
            }
            for (Post post : posts) {
                PostResponseBody postResponseBody = requestPost(username, post.getUrlSlug());
                if (postResponseBody.getData().getPost().getSeries() == null) {
                    result.get(KeyName.NO_SERIES.getKey()).add(new PostMD(
                            "",
                            postResponseBody.getData().getPost().getTitle(),
                            postResponseBody.getData().getPost().getBody()
                    ));
                } else {
                    if (result.containsKey(postResponseBody.getData().getPost().getSeries().getId())) {
                        result.get(postResponseBody.getData().getPost().getSeries().getId()).add(new PostMD(
                                postResponseBody.getData().getPost().getSeries().getName(),
                                postResponseBody.getData().getPost().getTitle(),
                                postResponseBody.getData().getPost().getBody()
                        ));
                    } else {
                        result.put(postResponseBody.getData().getPost().getSeries().getId(), new ArrayList<>(List.of(new PostMD(
                                postResponseBody.getData().getPost().getSeries().getName(),
                                postResponseBody.getData().getPost().getTitle(),
                                postResponseBody.getData().getPost().getBody()
                        ))));
                    }
                }
            }

            cursor = posts.get(posts.size() - 1).getId();

        }
        return result;
    }

    @Override
    public PostsResponseBody requestPosts(String username, String cursor) {
        ReadPostsBody request = new ReadPostsBody(GraphQLQuery.READ_POSTS, username, Optional.ofNullable(cursor));
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        try {
            ResponseEntity<PostsResponseBody> result = restTemplate.postForEntity(
                    velogProperties.getUrlV3(),
                    new HttpEntity<>(request, headers),
                    PostsResponseBody.class
            );
            return result.getBody();
        } catch (RestClientException e) {
            throw new GraphQLException();
        }
    }

    @Override
    public PostResponseBody requestPost(String username, String urlSlug) {
        ReadPostBody request = new ReadPostBody(GraphQLQuery.READ_POST, username, urlSlug);
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        try {
            ResponseEntity<PostResponseBody> result = restTemplate.postForEntity(
                    velogProperties.getUrlV2(),
                    new HttpEntity<>(request, headers),
                    PostResponseBody.class
            );
            return result.getBody();
        } catch (RestClientException e) {
            throw new GraphQLException();
        }
    }
}
