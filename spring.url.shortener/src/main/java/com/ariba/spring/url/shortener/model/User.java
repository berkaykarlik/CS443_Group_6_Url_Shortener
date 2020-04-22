package com.ariba.spring.url.shortener.model;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "User")
public class User {
    private  String username;
    private  String password;
    private  String email;
    private  String[] link_ids;

    public User(String username, String password, String email, String[] link_ids) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.link_ids = link_ids;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String[] getLink_ids() {
        return link_ids;
    }

    public void setLink_ids(String[] link_ids) {
        this.link_ids = link_ids;
    }


}
