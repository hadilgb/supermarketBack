package com.back.back_end.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document("reclamation")
public class Reclamation {
    @Id
    private String idrec;
    private String email;
    private String message;
    private String etat;
    private String date;
}
