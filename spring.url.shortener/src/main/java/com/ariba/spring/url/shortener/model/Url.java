package com.ariba.spring.url.shortener.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;


@Document(collection = "url")
public class Url {

    @Id
    private final String id;

    private final String url;

    @Indexed(expireAfterSeconds = 3600)
    private Date createdAt;


    public Url(String id, String url) {
        this.id = id;
        this.url = url;
        this.createdAt = new Date();
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
