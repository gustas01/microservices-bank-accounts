package com.gustavo.microservices.msclients.adapters.DTOs;

public record ClientDTO(
        String firstName,
        String lastName,
        String email,
        String cpf,
        String address
  )
{}
