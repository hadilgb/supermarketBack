package com.back.back_end.repository;

import com.back.back_end.model.HistoriqueCommande;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface historiquecommanderepository extends MongoRepository<HistoriqueCommande, String> {
}
