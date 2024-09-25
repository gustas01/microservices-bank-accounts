package com.gustavo.microservices.msclients.adapters.DTOs;

import java.time.LocalDate;
import java.util.List;

public record ClientDTO(
        String firstName,
        String lastName,
        String email,
        String cpf,
        String address,
        LocalDate birth,
        List<AccountDataResponse> accounts
  )
{}
