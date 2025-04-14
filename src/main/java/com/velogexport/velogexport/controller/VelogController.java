package com.velogexport.velogexport.controller;

import com.velogexport.velogexport.domain.VelogDetail;
import com.velogexport.velogexport.service.GraphQLClientService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.method.annotation.StreamingResponseBody;

@Controller
@RequiredArgsConstructor
@Slf4j
public class VelogController {
    private final GraphQLClientService graphQLClientService;

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("velogDetail", new VelogDetail());
        model.addAttribute("errorMessage", null);
        return "index";
    }

    @PostMapping("/download")
    public String downloadVelogPosts(@ModelAttribute VelogDetail velogDetail, Model model) {
        if (!graphQLClientService.existVelogId(velogDetail.getId())) {
            model.addAttribute("errorMessage", "잘못된 Velog id를 입력했습니다. 다시 입력해주세요. ");
            return "index";
        }

        if (!velogDetail.getIsImageGroup() && !velogDetail.getImageUrlReplacePath().isBlank()) {
            model.addAttribute("errorMessage", "잘못된 접근입니다. 다시 입력해주세요. ");
            return "index";
        }
        return "forward:/download/stream";
    }

    @PostMapping("/download/stream")
    public ResponseEntity<StreamingResponseBody> streamDownload(@ModelAttribute VelogDetail velogDetail) {
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"%s.zip\"".formatted(velogDetail.getId()))
                .body(graphQLClientService.downloadAllVelogPost(velogDetail));
    }
}
