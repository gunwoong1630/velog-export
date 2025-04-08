package com.velogexport.velogexport.domain.body.response;

import lombok.Getter;

@Getter
public class PostMD {
    private String seriesName;
    private String title;
    private String content;

    public PostMD(String seriesName, String title, String content) {
        this.seriesName = seriesName;
        this.title = title;
        this.content = content;
    }

    public String writeMD() {
        return "# " + title + "\n\n" + content;
    }
}
