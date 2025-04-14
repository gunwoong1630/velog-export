package com.velogexport.velogexport.domain;

import com.velogexport.velogexport.utils.URLUtils;
import lombok.Data;

@Data
public class VelogDetail {
    private String id;
    private Boolean isImageGroup;
    private String imageUrlReplacePath;

    public boolean isImageGrouping() {
        return this.isImageGroup != null && this.isImageGroup;
    }
    public void processImageUrlReplacePath() {
        if (this.imageUrlReplacePath != null) {
            this.imageUrlReplacePath = URLUtils.preprocessURL(this.imageUrlReplacePath);
        }
    }
}
