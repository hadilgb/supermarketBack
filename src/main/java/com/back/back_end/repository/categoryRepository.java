package com.back.back_end.repository;


import com.back.back_end.model.category;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface categoryRepository extends MongoRepository<category, String> {

    @Query("{name:'?0'}")
    List<category> findItemByName(String name);



}

