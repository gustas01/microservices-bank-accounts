package com.gustavo.microservices.msclients.domain.entities;

import com.gustavo.microservices.msclients.adapters.DTOs.ClientDTO;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Client {
  @Id
  private UUID id;

  private String firstName;
  private String lastName;
  private String email;
  private String password;
  private String cpf;
  private String address;

  public Client(String firstName, String lastName, String email, String password, String cpf, String address) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.email = email;
    this.password = password;
    this.cpf = cpf;
    this.address = address;
  }

  public ClientDTO toDTO(){
    return new ClientDTO(firstName, lastName, email, cpf, address);
  }
}
