package com.ariba.spring.url.shortener.dao;


import com.ariba.spring.url.shortener.model.Url;
import com.ariba.spring.url.shortener.Repository.UrlRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class UrlDao {

    private UrlRepository repository;

    @Autowired
    public UrlDao(UrlRepository repository) {
        this.repository = repository;
    }

    public int saveUrl(Url url){
        repository.save(url);
        return 1;
    }

    public Url getUrlById(String id){
        Optional<Url> result = repository.findById(id);
        return result.orElse(null);
    }





}
