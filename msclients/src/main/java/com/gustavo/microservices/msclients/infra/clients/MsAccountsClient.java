package com.gustavo.microservices.msclients.infra.clients;

import com.gustavo.microservices.msclients.adapters.DTOs.AccountDataRequest;
import com.gustavo.microservices.msclients.adapters.DTOs.AccountDataResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@FeignClient(value = "msaccounts", path = "/accounts")
public interface MsAccountsClient {

  @PostMapping(params = "clientId")
  ResponseEntity<AccountDataResponse> create(@RequestParam("clientId") String clientId, @RequestBody AccountDataRequest accountDataRequest);

  @GetMapping(params = "clientId")
  ResponseEntity<List<AccountDataResponse>> findAllByClientId(@RequestParam("clientId") String clientId);
}
