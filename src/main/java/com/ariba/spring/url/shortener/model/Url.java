package com.ariba.spring.url.shortener.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Url {

    @Id
    private final String id;

    private final String url;

    public Url(@JsonProperty("id") String id,
               @JsonProperty("url") String url) {
        this.id = id;
        this.url = url;
    }

    @Override
    public String toString() {
        return "Url{" +
                "id='" + id + '\'' +
                ", Url='" + url + '\'' +
                '}';
    }

    public String getId() {
        return id;
    }

    public String getUrl() {
        return url;
    }
}
