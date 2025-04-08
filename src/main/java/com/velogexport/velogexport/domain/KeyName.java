package com.velogexport.velogexport.domain;

import lombok.Getter;

@Getter
public enum KeyName {
    NO_SERIES("NO_SERIES");
    private String key;

    KeyName(String key) {
        this.key = key;
    }
}
