package com.ariba.spring.url.shortener.service;

import com.ariba.spring.url.shortener.dao.UrlRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class UrlService {

    private final UrlRepository urlRepository;

    @Autowired
    public UrlService(UrlRepository urlRepository) {
        this.urlRepository = urlRepository;
    }

    public void addUrl (String id, String url){
        urlRepository.insertUrl(id,url);
    }


    public String getOriginalUrl(String id){
        return urlRepository.getUrlById(id);
    }
}
