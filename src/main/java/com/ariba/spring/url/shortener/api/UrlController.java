package com.ariba.spring.url.shortener.api;

import com.ariba.spring.url.shortener.dao.UrlRepository;
import com.ariba.spring.url.shortener.service.UrlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.util.Map;


@RestController
public class UrlController {

    private final UrlService urlService;

    @Autowired
    public UrlRepository urlRepository;

    @Autowired
    public UrlController(UrlService urlService) {
        this.urlService = urlService;
    }

    @PostMapping
    public String addUrl (@RequestBody Map<String, String> payload){
        String name = payload.get("url");
        String id = urlRepository.nextIDVal();
        urlService.addUrl(id,name);
        return id;
    }

    @GetMapping("/{id}")
    public RedirectView getOriginalUrl(@PathVariable("id") final String id){
        String oUrl = urlService.getOriginalUrl(id);
        RedirectView redirectView = new RedirectView();
        redirectView.setUrl(oUrl);
        return redirectView;
    }



}
