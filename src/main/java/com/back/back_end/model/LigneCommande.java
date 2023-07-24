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
@Document(collection = "lignecommande")
public class LigneCommande {
    @Id
    private String idligne;
    private String prodid;
    private String nomprod;
    private Long quantite;
    private double prixtotale;
    private String image ;

}
