package com.gustavo.microservices.msclients.adapters.DTOs;

import java.time.LocalDateTime;

public record StandardErrorResponseDTO (
        LocalDateTime timestamp,
        Integer status,
        String error,
        Object message
  )
{}
