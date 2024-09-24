package com.gustavo.microservices.msaccounts.adapters.DTOs;

import com.gustavo.microservices.msaccounts.domain.enums.Agencies;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

public record AccountDTO(
        UUID accountNumber,
        Agencies agencyNumber,
        BigDecimal balance,
        String accountType,
        Integer bankCode,
        LocalDateTime createdAt
) {
}
