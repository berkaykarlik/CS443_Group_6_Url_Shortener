package com.ariba.spring.url.shortener.service;

import com.ariba.spring.url.shortener.dao.UrlRepository;
import com.ariba.spring.url.shortener.model.Url;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class UrlService {

    private final UrlRepository urlRepository;

    @Autowired
    public UrlService(UrlRepository urlRepository) {
        this.urlRepository = urlRepository;
    }

    public int addUrl (Url url){
        return urlRepository.insertUrl(url);
    }

    public Map<String,Url> getAllUrl(){
        return urlRepository.findAll();
    }

    public String getOriginalUrl(String id){
        return urlRepository.getUrlById(id);
    }
}
