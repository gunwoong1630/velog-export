package com.velogexport.velogexport.controller;

import com.velogexport.velogexport.domain.VelogDetail;
import com.velogexport.velogexport.service.GraphQLClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.method.annotation.StreamingResponseBody;

@Controller
@RequiredArgsConstructor
public class VelogController {
    private final GraphQLClientService graphQLClientService;

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("velogDetail", new VelogDetail());
        return "index";
    }

    @PostMapping("/download")
    @ResponseBody
    public StreamingResponseBody downloadVelogPosts(@ModelAttribute VelogDetail velogDetail) {
        return graphQLClientService.downloadAllVelogPost(velogDetail);
    }
}
