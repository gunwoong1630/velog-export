package com.velogexport.velogexport.domain.body.response.post;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class Post {
    private String id;
    private String title;
    private String body;
    private Series series;

    public Post(@JsonProperty("id") String id, @JsonProperty("title") String title, @JsonProperty("body") String body, @JsonProperty("series") Series series) {
        this.id = id;
        this.title = title;
        this.body = body;
        this.series = series;
    }
}
