package com.ariba.spring.url.shortener.service;

import com.ariba.spring.url.shortener.dao.UrlDao;
import com.ariba.spring.url.shortener.model.Url;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class UrlService {

    private UrlDao urlDao;

    @Autowired
    public UrlService(UrlDao urlDao) {
        this.urlDao = urlDao;
    }

    public void addUrl (Url url){
        urlDao.saveUrl(url);
    }


    public Url getOriginalUrl(String id){
        return urlDao.getUrlById(id);
    }
}
