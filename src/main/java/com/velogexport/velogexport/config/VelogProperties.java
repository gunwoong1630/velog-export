package com.velogexport.velogexport.config;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
@Getter
public class VelogProperties {
    @Value("${velog.url-v2}")
    private String urlV2;
    @Value("${velog.url-v3}")
    private String urlV3;
}
