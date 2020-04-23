package com.ariba.spring.url.shortener.Repository;


import com.ariba.spring.url.shortener.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface UserRepository extends MongoRepository<User,String> {
    Optional<User> findByUsername(String username);
}
