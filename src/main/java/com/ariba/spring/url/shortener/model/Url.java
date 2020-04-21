package com.ariba.spring.url.shortener.model;

import com.fasterxml.jackson.annotation.JsonProperty;


public class Url {

    private final String id;
    private final String url;

    public Url(@JsonProperty("id") String id,
               @JsonProperty("url")String url) {
        this.id = id;
        this.url = url;
    }

    public String getId() {
        return id;
    }

    public String getUrl() {
        return url;
    }
}
