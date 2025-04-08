package com.velogexport.velogexport.domain.body.response.post;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class Data {
    private Post post;

    public Data(@JsonProperty("post") Post post) {
        this.post = post;
    }
}
