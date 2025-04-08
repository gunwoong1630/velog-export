package com.velogexport.velogexport.domain.body.response.posts;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class Post {
    private String id;
    private String title;
    private String urlSlug;

    public Post(@JsonProperty("id") String id, @JsonProperty("title") String title, @JsonProperty("url_slug") String urlSlug) {
        this.id = id;
        this.title = title;
        this.urlSlug = urlSlug;
    }
}
