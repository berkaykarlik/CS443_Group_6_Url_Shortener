package com.ariba.spring.url.shortener.api;

import com.ariba.spring.url.shortener.dao.SeqDaoImpl;
import com.ariba.spring.url.shortener.dao.UrlDao;
import com.ariba.spring.url.shortener.model.MappedId;
import com.ariba.spring.url.shortener.model.Url;
import com.ariba.spring.url.shortener.service.UrlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.util.Map;


@RestController
public class UrlController {

    private final UrlService urlService;
    private static final String HOSTING_SEQ_KEY = "hosting";

    private UrlDao urlDao;
    private SeqDaoImpl seqDaoImpl;

    @Autowired
    public UrlController(UrlService urlService,
                         UrlDao urlDao,
                         SeqDaoImpl seqDaoImpl) {
        this.urlService = urlService;
        this.urlDao = urlDao;
        this.seqDaoImpl = seqDaoImpl;
    }

    @PostMapping
    public MappedId addUrl (@RequestBody Map<String, Object> payload){
        String url = (String)payload.get("url");
        Url tmp = new Url(Long.toString(seqDaoImpl.getNextSequenceId(HOSTING_SEQ_KEY)),url);
        urlService.addUrl(tmp);
        MappedId id_holder = new MappedId(urlService.numericIdToMapped(tmp.getId()));
        return id_holder;
    }

    @GetMapping("/{id}")
    public RedirectView getOriginalUrl(@PathVariable("id") final String id){
        String original_id = urlService.mappedIdToNumeric(id);
        Url oUrl = urlService.getUrlById(original_id);
        RedirectView redirectView = new RedirectView();
        redirectView.setUrl(oUrl.getUrl());
        return redirectView;
    }


}
