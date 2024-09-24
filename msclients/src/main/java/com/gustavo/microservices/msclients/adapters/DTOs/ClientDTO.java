package com.gustavo.microservices.msclients.adapters.DTOs;

import java.time.LocalDate;
import java.util.ArrayList;

public record ClientDTO(
        String firstName,
        String lastName,
        String email,
        String cpf,
        String address,
        LocalDate birth,
        ArrayList<AccountDataResponse> accounts
  )
{}
