package com.gustavo.microservices.msclients.adapters.DTOs;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record AccountDataResponse(
        String accountNumber,
        String agencyNumber,
        BigDecimal balance,
        String accountType,
        Integer bankCode,
        LocalDateTime createdAt
) {
}
