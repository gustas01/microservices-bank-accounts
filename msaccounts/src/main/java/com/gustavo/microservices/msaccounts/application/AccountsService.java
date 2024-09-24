package com.gustavo.microservices.msaccounts.application;

import com.gustavo.microservices.msaccounts.adapters.DTOs.AccountDTO;
import com.gustavo.microservices.msaccounts.adapters.DTOs.AccountDataRequest;
import com.gustavo.microservices.msaccounts.domain.entities.Account;
import com.gustavo.microservices.msaccounts.infra.repositories.AccountsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AccountsService {

  private final AccountsRepository accountsRepository;

  public AccountDTO create(String clientId, AccountDataRequest accountDataRequest){
    Account account = new Account(accountDataRequest.agencyNumber(), accountDataRequest.accountType(), UUID.fromString(clientId));
    return accountsRepository.save(account).toDTO();
  }
}
