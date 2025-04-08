package com.velogexport.velogexport.domain.body.response.post;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class PostResponseBody {
    private Data data;

    public PostResponseBody(@JsonProperty("data") Data data) {
        this.data = data;
    }
}
