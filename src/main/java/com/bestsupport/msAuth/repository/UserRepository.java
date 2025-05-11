package com.bestsupport.msAuth.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.bestsupport.msAuth.model.User;

public interface UserRepository extends MongoRepository<User, String> {

    Optional<User> findByUsername(String username);
    
}
