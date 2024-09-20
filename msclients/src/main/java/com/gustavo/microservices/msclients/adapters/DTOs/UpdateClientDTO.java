package com.gustavo.microservices.msclients.adapters.DTOs;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

public record UpdateClientDTO(
        @NotEmpty(message = "O nome não pode estar vazio")
        @Size(max = 30, message = "O nome deve ter no máximo {max} caracteres")
        String firstName,

        @NotEmpty(message = "O sobrenome não pode estar vazio")
        @Size(max = 30, message = "O sobrenome deve ter no máximo {max} caracteres")
        String lastName,

        @Email(message = "Email inválido")
        String email,

        @Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#$%¨&*()_{}/^+=])(?=\\S+$).{8,200}$",
                message = "A senha deve conter entre 8 e 200 caracteres, sendo 1 letra maiúscula, 1 minúscula, 1 número e 1 símbolo pelo menos")
        String password,

        @NotEmpty(message = "O CPF não poder estar vazio")
        @Min(value = 11, message = "O CPF deve conter apenas os {value} números")
        String cpf,

        @NotEmpty(message = "O endereço não poder estar vazio")
        String address,

        @NotEmpty(message = "A data de nascimento não pode estar vazia")
        LocalDate birth
) {
}
