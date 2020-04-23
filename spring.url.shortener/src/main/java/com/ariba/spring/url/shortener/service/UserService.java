package com.ariba.spring.url.shortener.service;

import com.ariba.spring.url.shortener.dao.UserDao;
import com.ariba.spring.url.shortener.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;

@Service
public class UserService {

    private UserDao userDao;

    @Autowired
    public UserService(UserDao userDao) {
        this.userDao = userDao;
    }

    public int registerUser(User user){
        User existing = userDao.getUserByUsername(user.getUsername());
        if (existing == null) {
            return this.userDao.saveUser(user);
        }
        else return -1;
    }

    public User getUser (String username){
        return userDao.getUserByUsername(username);
    }

    public void addToUsersLink (String username,String url_id) {
        User theUser = getUser(username);
        ArrayList<String> tmp = theUser.getLink_ids();
        tmp.add(url_id);
        userDao.saveUser(theUser);
    }

    public Iterator getUserLinks (String username) {
        User theUser = getUser(username);
        return theUser.getLink_ids().iterator();
    }

    public boolean userDoExist(String username){
        User tmp = getUser(username);
        if (tmp == null)
            return false;
        else return true;
    }
}
