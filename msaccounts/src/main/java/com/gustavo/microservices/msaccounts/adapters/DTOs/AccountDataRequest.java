package com.gustavo.microservices.msaccounts.adapters.DTOs;

import com.gustavo.microservices.msaccounts.domain.enums.AccountTypes;
import com.gustavo.microservices.msaccounts.domain.enums.Agencies;

public record AccountDataRequest(AccountTypes accountType, Agencies agencyNumber) {
}
