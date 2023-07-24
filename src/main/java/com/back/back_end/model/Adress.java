package com.back.back_end.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
@AllArgsConstructor
@Data
@NoArgsConstructor
@Document ("adresse")
public class Adress {
    @Id
    private String idAdress;
    private String adresse;
    private String gouvernorat;
    private String ville;
    private String codePostale;
}
