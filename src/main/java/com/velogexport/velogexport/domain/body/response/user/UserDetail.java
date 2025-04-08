package com.velogexport.velogexport.domain.body.response.user;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UserDetail {
    private String id;

    public UserDetail(@JsonProperty("id") String id) {
        this.id = id;
    }
}
