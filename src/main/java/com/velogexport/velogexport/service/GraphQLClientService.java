package com.velogexport.velogexport.service;

import com.velogexport.velogexport.domain.VelogDetail;
import com.velogexport.velogexport.domain.body.response.PostMD;
import com.velogexport.velogexport.domain.body.response.post.PostResponseBody;
import com.velogexport.velogexport.domain.body.response.posts.PostsResponseBody;
import org.springframework.web.servlet.mvc.method.annotation.StreamingResponseBody;

import java.util.List;
import java.util.Map;

public interface GraphQLClientService {
    StreamingResponseBody downloadAllVelogPost(VelogDetail velogDetail);

    boolean existVelogId(String username);

    Map<String, List<PostMD>> searchMdFiles(String username);

    PostsResponseBody requestPosts(String username, String cursor);

    PostResponseBody requestPost(String username, String urlSlug);
}
