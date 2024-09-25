package com.gustavo.microservices.msaccounts.application;

import com.gustavo.microservices.msaccounts.adapters.DTOs.AccountDTO;
import com.gustavo.microservices.msaccounts.adapters.DTOs.AccountDataRequest;
import com.gustavo.microservices.msaccounts.domain.entities.Account;
import com.gustavo.microservices.msaccounts.domain.enums.AccountTypes;
import com.gustavo.microservices.msaccounts.infra.repositories.AccountsRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AccountsService {

  private final AccountsRepository accountsRepository;

  public AccountDTO create(String clientId, AccountDataRequest accountDataRequest){
    Account account = new Account(accountDataRequest.agencyNumber(), accountDataRequest.accountType(), UUID.fromString(clientId));
    return accountsRepository.save(account).toDTO();
  }

  public List<Account> findAllByClientId(String clientId){
    List<Account> accouts = accountsRepository.findAllByClientId(UUID.fromString(clientId));
    return accountsRepository.findAllByClientId(UUID.fromString(clientId));
  }

  public AccountDTO update(String accountId, AccountTypes accountType){
    Account account = accountsRepository.findById(UUID.fromString(accountId)).orElseThrow(() -> new EntityNotFoundException("Conta não encontrada!"));
    account.setAccountType(accountType);

    return accountsRepository.save(account).toDTO();
  }

  public void delete(String accountId){
    Account account = accountsRepository.findById(UUID.fromString(accountId)).orElseThrow(() -> new EntityNotFoundException("Conta inexistente!"));
    account.setActive(false);
    accountsRepository.save(account);
  }
}
