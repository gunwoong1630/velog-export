package com.velogexport.velogexport.utils;

import lombok.experimental.UtilityClass;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@UtilityClass
public class MDUtils {
    public static List<String> extractImageUrls(String markdown) {
        List<String> imageUrls = new ArrayList<>();
        Pattern pattern = Pattern.compile("!\\[[^\\]]*]\\(([^)]+)\\)");
        Matcher matcher = pattern.matcher(markdown);

        while (matcher.find()) {
            imageUrls.add(matcher.group(1)); // URL
        }
        return imageUrls;
    }

    // https://velog.velcdn.com/images/gwj0421/post/58e5ac98-5b49-4cba-be7d-a4b2d75246cd/image.png
    public String getImageFileExtension(String url) {
        String cleanUrl = url.split("\\?")[0];
        int lastSlash = cleanUrl.lastIndexOf('/');
        int lastDot = cleanUrl.lastIndexOf('.');
        if (lastDot > lastSlash && lastDot != -1 && lastDot < cleanUrl.length() - 1) {
            return cleanUrl.substring(lastDot);
        }
        return ".jpg";
    }
}
