package com.velogexport.velogexport.domain;

import lombok.Getter;

@Getter
public enum ImageURLReplaceMode {
    NONE("그대로 저장",false),
    REPLACE_IMAGE_URL_GROUP("이미지의 URL을 로컬 경로로 대치하여 저장",true);
    private String desc;
    private boolean param;

    ImageURLReplaceMode(String desc, boolean param) {
        this.desc = desc;
        this.param = param;
    }

    public ImageURLReplaceMode[] getModes() {
        return values();
    }
}
