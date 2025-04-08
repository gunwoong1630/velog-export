package com.velogexport.velogexport.service;

import com.velogexport.velogexport.domain.body.response.PostMD;
import com.velogexport.velogexport.domain.body.response.post.PostResponseBody;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@TestPropertySource("classpath:test-application.properties")
class GraphQLClientServiceImplTest {
    @Autowired
    private GraphQLClientService graphQLClientService;

    @Test
    void should_existUser() {
        // given
        String username = "gwj0421";
        String notUsername = ".";

        // when
        boolean successResult = graphQLClientService.existVelogId(username);
        boolean failResult = graphQLClientService.existVelogId(notUsername);

        // then
        assertThat(successResult).isTrue();
        assertThat(failResult).isFalse();
    }

    @Test
    void test() {
        graphQLClientService.requestPosts("gwj0421", null);
    }

    @Test
    void should_readPost() {
        // given
        String username = "gwj0421";
        String urlSlugWithSeries = "MSA-적용기";
        String urlSlugWithoutSeries = "Refactor-Point-Utility-classes-should-not-have-public-constructors";

        // when
        List<PostResponseBody> result = new ArrayList<>();
        for (String urlSlug : List.of(urlSlugWithSeries, urlSlugWithoutSeries)) {
            result.add(graphQLClientService.requestPost(username, urlSlug));
        }

        // then
        assertThat(result.get(0)).matches(it -> it.getData().getPost().getId() != null && it.getData().getPost().getSeries() == null);
        assertThat(result.get(1)).matches(it -> it.getData().getPost().getId() != null && it.getData().getPost().getSeries() != null);
    }

    @Test
    void should_readTotalPostMD() {
        // given
        String username = "zhyun";

        // when
        Map<String, List<PostMD>> result = graphQLClientService.searchMdFiles(username);

        // then
        int cnt = 0;
        for (List<PostMD> value : result.values()) {
            cnt += value.size();
        }
        assertThat(cnt).isEqualTo(476);
    }
}