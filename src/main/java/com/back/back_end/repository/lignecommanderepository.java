package com.back.back_end.repository;

import com.back.back_end.model.LigneCommande;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface lignecommanderepository extends MongoRepository<LigneCommande, String> {
}
