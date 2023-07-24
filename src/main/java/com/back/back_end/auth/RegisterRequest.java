package com.back.back_end.auth;

import com.back.back_end.model.Role;
import com.back.back_end.model.Status;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegisterRequest {



  private String email;
  private String password;
  private String nom;
  private String telephone;
  private String  infocartebancaire;
  private String idAdress;
  private Status status;

}
