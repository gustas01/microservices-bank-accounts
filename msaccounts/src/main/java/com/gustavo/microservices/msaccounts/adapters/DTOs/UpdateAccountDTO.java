package com.gustavo.microservices.msaccounts.adapters.DTOs;

import com.gustavo.microservices.msaccounts.domain.enums.AccountTypes;

public record UpdateAccountDTO(AccountTypes accountType) {
}
