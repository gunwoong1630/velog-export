package com.velogexport.velogexport.utils;

import lombok.experimental.UtilityClass;

@UtilityClass
public class URLUtils {
    public static String preprocessURL(String url) {
        url = url.trim();
        if (url.isBlank()) {
            return "";
        }
        return url.charAt(url.length() - 1) == '/' ? url : url + '/';
    }
}
