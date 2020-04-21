package com.ariba.spring.url.shortener.api;

import com.ariba.spring.url.shortener.dao.UrlDao;
import com.ariba.spring.url.shortener.model.Url;
import com.ariba.spring.url.shortener.service.UrlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;


@RestController
public class UrlController {

    private final UrlService urlService;

    private UrlDao urlDao;

    @Autowired
    public UrlController(UrlService urlService,
                         UrlDao urlDao) {
        this.urlService = urlService;
        this.urlDao = urlDao;
    }

    @PostMapping
    public Url addUrl (@RequestBody Url url){
        urlService.addUrl(url);
        return url;
    }

    @GetMapping("/{id}")
    public RedirectView getOriginalUrl(@PathVariable("id") final String id){
        Url oUrl = urlDao.getUrlById(id);
        RedirectView redirectView = new RedirectView();
        redirectView.setUrl(oUrl.getUrl());
        return redirectView;
    }



}
