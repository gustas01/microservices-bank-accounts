package com.gustavo.microservices.msclients.adapters.DTOs;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

public record AccountDataResponse(
        String id,
        String accountNumber,
        String agencyNumber,
        BigDecimal balance,
        String accountType,
        Integer bankCode,
        String status,
        UUID clientId,
        LocalDateTime createdAt
) {
}
