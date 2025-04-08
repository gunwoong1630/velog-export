package com.velogexport.velogexport.domain.body.response.posts;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class PostsResponseBody {
    PostData postData;

    public PostsResponseBody(@JsonProperty("data") PostData postData) {
        this.postData = postData;
    }
}
