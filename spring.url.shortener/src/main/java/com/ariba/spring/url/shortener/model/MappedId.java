package com.ariba.spring.url.shortener.model;

import com.sun.xml.internal.ws.developer.Serialization;

@Serialization
public class MappedId {
        public String mapped_id;

    public MappedId(String mapped_id) {
        this.mapped_id = mapped_id;
    }
}
