package com.ariba.spring.url.shortener.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Repository;


@Repository("urlRepo")
public class UrlRepository {

    private StringRedisTemplate redisTemplate;
    private ValueOperations valueOperations;

    @Autowired
    public UrlRepository( StringRedisTemplate redisTemplate) {
        this.redisTemplate = redisTemplate;
        this.valueOperations = redisTemplate.opsForValue();
    }


    public void insertUrl(String id,String url) {
        valueOperations.set(id,url);
    }

    public String nextIDVal(){
        valueOperations.setIfAbsent("autoID","0");
        int currentId = Integer.parseInt((String) valueOperations.get("autoID"));
        currentId++;
        valueOperations.set("autoID",Integer.toString(currentId));
        return Integer.toString(currentId);
    }

    public String getUrlById(String id) {
        return (String)valueOperations.get(id);
    }
}
