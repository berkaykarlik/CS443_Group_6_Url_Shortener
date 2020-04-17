package com.ariba.spring.url.shortener.dao;

import com.ariba.spring.url.shortener.model.Url;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Repository("urlRepo")
public class UrlRepository {

    private StringRedisTemplate redisTemplate;
    private HashOperations hashOperations;

    @Autowired
    public UrlRepository( StringRedisTemplate redisTemplate) {
        this.redisTemplate = redisTemplate;
        this.hashOperations = redisTemplate.opsForHash();
    }


    public int insertUrl(Url url) {
        hashOperations.put("URL",url.getId(),url.getUrl());
        return 1;
    }

    public Map<String,Url> findAll(){
        return hashOperations.entries("URL");
    }

    public String getUrlById(String id) {
        return (String)hashOperations.get("URL",id);
    }
}
