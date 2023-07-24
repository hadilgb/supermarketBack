package com.back.back_end.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "historiquecommande")
public class HistoriqueCommande {
    @Id
    private String id;
    private List<Commande> listcommande;
}
