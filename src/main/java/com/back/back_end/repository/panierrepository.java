package com.back.back_end.repository;

import com.back.back_end.model.Panier;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface panierrepository extends MongoRepository<Panier, String> {
}
