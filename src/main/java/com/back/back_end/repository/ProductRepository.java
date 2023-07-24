package com.back.back_end.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.back.back_end.model.Product;

public interface ProductRepository extends MongoRepository<Product, String> {
    
    @Query("{name:'?0'}")
    List<Product> findItemByName(String name);
    
    @Query(value="{category:'?0'}")
    List<Product> findAll(String category);
    
    public long count();

}
