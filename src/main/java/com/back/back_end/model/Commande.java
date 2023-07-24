package com.back.back_end.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "commande")
public class Commande {
    @Id
    private String idcommande;
    @Field("email")
    private String email;
    private double prixTT;
    private String etat ;
    private String date;
    private List<LigneCommande> lignes;
}
