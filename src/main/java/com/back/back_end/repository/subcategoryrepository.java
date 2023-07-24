package com.back.back_end.repository;
import com.back.back_end.model.subcategory;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import java.util.List;
public interface subcategoryrepository extends MongoRepository<subcategory, String> {
    @Query("{name:'?0'}")
    List<subcategory> findItemByName(String name);
}
