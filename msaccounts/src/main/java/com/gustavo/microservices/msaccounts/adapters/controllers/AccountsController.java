package com.gustavo.microservices.msaccounts.adapters.controllers;

import com.gustavo.microservices.msaccounts.adapters.DTOs.AccountDTO;
import com.gustavo.microservices.msaccounts.adapters.DTOs.AccountDataRequest;
import com.gustavo.microservices.msaccounts.adapters.DTOs.UpdateAccountDTO;
import com.gustavo.microservices.msaccounts.application.AccountsService;
import com.gustavo.microservices.msaccounts.domain.entities.Account;
import com.gustavo.microservices.msaccounts.domain.enums.AccountTypes;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("accounts")
@RequiredArgsConstructor
public class AccountsController {

  private final AccountsService accountsService;

  @GetMapping
  public String teste(){
    return "do accounts controllers";
  }

  @PostMapping(params = "clientId")
  public ResponseEntity<AccountDTO> create(@RequestParam("clientId") String clientId, @RequestBody AccountDataRequest accountDataRequest){
    return ResponseEntity.status(HttpStatus.CREATED).body(accountsService.create(clientId, accountDataRequest));
  }

  @PatchMapping(params = "accountId")
  public ResponseEntity<AccountDTO> update(@RequestParam("accountId") String accountId, @RequestBody UpdateAccountDTO updateAccountDTO){
    return ResponseEntity.status(HttpStatus.OK).body(accountsService.update(accountId, updateAccountDTO.accountType()));
  }

  @DeleteMapping(params = "accountId")
  public ResponseEntity<?> delete(@RequestParam("accountId") String accountId){
    accountsService.delete(accountId);
    return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
  }

  @GetMapping(params = "clientId")
  ResponseEntity<List<AccountDTO>> findAllByClientId(@RequestParam("clientId") String clientId){
    List<Account> accounts = accountsService.findAllByClientId(clientId);
    List<AccountDTO> accountDTOS = accounts.stream().map(Account::toDTO).toList();
    return ResponseEntity.status(HttpStatus.OK).body(accountDTOS);
  }
}
