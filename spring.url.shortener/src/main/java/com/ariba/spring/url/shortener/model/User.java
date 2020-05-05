package com.ariba.spring.url.shortener.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.UUID;

@Document
public class User {
    @Id
    private UUID id;
    private  String username;
    private  String password;
    private  String email;
    private ArrayList<String> link_ids;
    private  int linkIndex;

    public User(@JsonProperty("username") String username,
                @JsonProperty("password") String password,
                @JsonProperty("email") String email) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.link_ids = new ArrayList<String>();
        this.id = UUID.randomUUID();
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

    public ArrayList<String> getLink_ids() {
        return link_ids;
    }

    public void setLink_ids(ArrayList<String> link_ids) {
        this.link_ids = link_ids;
    }

    public int getLinkIndex() {
        return linkIndex;
    }

    public void setLinkIndex(int linkIndex) {
        this.linkIndex = linkIndex;
    }

    public int deleteUserId(String url_id){
        for (int i = 0 ; i< link_ids.size(); i++)
        {
            if( link_ids.get(i) == url_id){
                link_ids.remove(i);
                return 1;
            }
        }
        return -1;
    }
}
