package com.velogexport.velogexport.controller;

import com.velogexport.velogexport.service.GraphQLClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.method.annotation.StreamingResponseBody;

@Controller
@RequiredArgsConstructor
public class VelogController {
    private final GraphQLClientService graphQLClientService;

    @GetMapping("/{velogId}")
    @ResponseBody
    public StreamingResponseBody downloadVelogPosts(@PathVariable String velogId) {
        return graphQLClientService.downloadAllVelogPost(velogId);
    }
}
