package com.velogexport.velogexport.domain.body.response.user;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class UserData {
    private UserDetail userDetail;

    public UserData(@JsonProperty("user") UserDetail userDetail) {
        this.userDetail = userDetail;
    }

}