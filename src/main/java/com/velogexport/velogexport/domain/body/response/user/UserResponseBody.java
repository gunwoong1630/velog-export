package com.velogexport.velogexport.domain.body.response.user;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UserResponseBody {
    private UserData data;

    public UserResponseBody(@JsonProperty("data") UserData data) {
        this.data = data;
    }

    public boolean isExist() {
        return data.getUserDetail() != null;
    }
}
