package com.gustavo.microservices.msaccounts.adapters.controllers;

import com.gustavo.microservices.msaccounts.adapters.DTOs.AccountDTO;
import com.gustavo.microservices.msaccounts.adapters.DTOs.AccountDataRequest;
import com.gustavo.microservices.msaccounts.application.AccountsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
}
