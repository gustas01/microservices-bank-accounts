package com.gustavo.microservices.msclients.adapters.DTOs;

import com.gustavo.microservices.msclients.domain.entities.Client;
import jakarta.validation.constraints.*;

public record CreateClientDTO(
        @NotNull(message = "O nome é obrigatório")
        @NotEmpty(message = "O nome não pode estar vazio")
        @Size(max = 30, message = "O nome deve ter no máximo {max} caracteres")
        String firstName,

        @NotNull(message = "O sobrenome é obrigatório")
        @NotEmpty(message = "O sobrenome não pode estar vazio")
        @Size(max = 30, message = "O sobrenome deve ter no máximo {max} caracteres")
        String lastName,

        @Email(message = "Email inválido")
        @NotNull(message = "O sobrenome é obrigatório")
        String email,

        @Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#$%¨&*()_{}/^+=])(?=\\S+$).{8,200}$",
                message = "A senha deve conter entre 8 e 200 caracteres, sendo 1 letra maiúscula, 1 minúscula, 1 número e 1 símbolo pelo menos")
        @NotNull(message = "A senha é obrigatória")
        String password,

        @NotNull(message = "O CPF é obrigatória")
        String cpf,

        @NotNull(message = "O endereço é obrigatória")
        String address
  ) {
  public Client toEntity(){
    return new Client(firstName, lastName, email, password, cpf, address);
  }
}
