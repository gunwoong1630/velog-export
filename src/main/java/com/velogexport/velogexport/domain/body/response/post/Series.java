package com.velogexport.velogexport.domain.body.response.post;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class Series {
    private String id;
    private String name;

    public Series(@JsonProperty("id") String id,@JsonProperty("name") String name) {
        this.id = id;
        this.name = name;
    }
}
