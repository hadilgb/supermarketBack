package com.back.back_end.repository;

import com.back.back_end.model.Adress;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface adresserepository extends MongoRepository<Adress, String> {

}
