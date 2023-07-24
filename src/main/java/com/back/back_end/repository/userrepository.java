package com.back.back_end.repository;

import com.back.back_end.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface userrepository  extends MongoRepository<User, String> {
    Optional<User> findByEmail(String email);
}
