package com.ariba.spring.url.shortener.api;

import com.ariba.spring.url.shortener.model.Url;
import com.ariba.spring.url.shortener.service.UrlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.util.Map;

@RequestMapping("api/v1/url")
@RestController
public class UrlController {

    private final UrlService urlService;

    @Autowired
    public UrlController(UrlService urlService) {
        this.urlService = urlService;
    }

    @PostMapping
    public void addUrl (@RequestBody Url url){
        urlService.addUrl(url);
    }

    @GetMapping
    public Map<String,Url> getAllUrl(){
        return urlService.getAllUrl();
    }

    @GetMapping("/{id}")
    public RedirectView getOriginalUrl(@PathVariable("id") final String id){
        String oUrl = urlService.getOriginalUrl(id);
        RedirectView redirectView = new RedirectView();
        redirectView.setUrl(oUrl);
        return redirectView;
    }



}
