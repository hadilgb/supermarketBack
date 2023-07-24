package com.back.back_end.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document("product")
public class Product {
	  @Id
      private String prodid;

	  private String reference;
	  @Field("subcategorieid")
	  private String subcategorieid;
	  private String nom;

	  private Long quantite;

	  private double prixunite;
	  private String imgUrl;
	  private long nombreClic = 0;
	  private long nombrevente = 0;


}
