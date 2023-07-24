package com.back.back_end.repository;

import com.back.back_end.model.Reclamation;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface reclamationrepository extends MongoRepository<Reclamation, String> {
}
