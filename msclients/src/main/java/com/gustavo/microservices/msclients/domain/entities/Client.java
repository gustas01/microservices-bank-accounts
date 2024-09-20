package com.gustavo.microservices.msclients.domain.entities;

import com.gustavo.microservices.msclients.adapters.DTOs.ClientDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Client {
  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  private UUID id;

  @Column(length = 30, nullable = false)
  private String firstName;

  @Column(length = 30, nullable = false)
  private String lastName;

  @Column(unique = true, nullable = false)
  private String email;

  @Column(nullable = false)
  private String password;

  @Column(nullable = false)
  private String cpf;

  @Column(nullable = false)
  private String address;

  @Column(nullable = false)
  private LocalDate birth;

  @Column
  private Boolean active = true;

  public Client(String firstName, String lastName, String email, String password, String cpf, String address, LocalDate age) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.email = email;
    this.password = password;
    this.cpf = cpf;
    this.address = address;
    this.birth = age;
  }

  public ClientDTO toDTO(){
    return new ClientDTO(firstName, lastName, email, cpf, address, birth);
  }
}
