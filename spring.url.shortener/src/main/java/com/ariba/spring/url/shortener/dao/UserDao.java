package com.ariba.spring.url.shortener.dao;

import com.ariba.spring.url.shortener.Repository.UserRepository;
import com.ariba.spring.url.shortener.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class UserDao {

    private UserRepository repository;

    @Autowired
    public UserDao(UserRepository repository) {
        this.repository = repository;
    }

    public int saveUser(User user){
        repository.save(user);
        return 1;
    }

    public User getUserByUsername(String username){
        Optional<User> result = repository.findByUsername(username);
        return result.orElse(null);
    }

}
