package com.velogexport.velogexport.domain.body.response.posts;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

import java.util.List;

@Getter
public class PostData {
    List<Post> posts;

    public PostData(@JsonProperty("posts") List<Post> posts) {
        this.posts = posts;
    }
}
