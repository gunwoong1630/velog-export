package com.velogexport.velogexport.config;

import com.velogexport.velogexport.service.GraphQLClientService;
import com.velogexport.velogexport.service.GraphQLClientServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
@RequiredArgsConstructor
public class Config {
    private final VelogProperties velogProperties;

    @Bean
    RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @Bean
    GraphQLClientService graphQLClientService() {
        return new GraphQLClientServiceImpl(restTemplate(), velogProperties);
    }
}
