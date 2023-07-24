package com.back.back_end.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.HashSet;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Document("subcategory")
@Data
public class subcategory {
    @Id
    private String subcategorieid;
    @Field("categorieid")
    private String categorieid;
    private String nom;
    private String image;
    private Set<Product> listeproduits = new HashSet<>();
}
