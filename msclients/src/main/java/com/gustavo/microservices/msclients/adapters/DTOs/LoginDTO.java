package com.gustavo.microservices.msclients.adapters.DTOs;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record LoginDTO (
        @NotNull(message = "Email obrigatório!")
        @Email(message = "Email inválido!")
        String email,


        @Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#$%¨&*()_{}/^+=])(?=\\S+$).{8,200}$",
                message = "A senha deve conter entre 8 e 200 caracteres, sendo 1 letra maiúscula, 1 minúscula, 1 número e 1 símbolo pelo menos")
        @NotNull(message = "A senha é obrigatória")
        String password
  )
{}
