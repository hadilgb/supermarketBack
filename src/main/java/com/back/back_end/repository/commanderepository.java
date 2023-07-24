package com.back.back_end.repository;

import com.back.back_end.model.Commande;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface commanderepository extends MongoRepository<Commande, String> {
}
