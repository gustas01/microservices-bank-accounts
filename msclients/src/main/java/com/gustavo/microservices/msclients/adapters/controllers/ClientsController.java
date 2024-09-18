package com.gustavo.microservices.msclients.adapters.controllers;

import com.gustavo.microservices.msclients.adapters.DTOs.ClientDTO;
import com.gustavo.microservices.msclients.adapters.DTOs.LoginDTO;
import com.gustavo.microservices.msclients.adapters.DTOs.CreateClientDTO;
import com.gustavo.microservices.msclients.application.services.ClientsService;
import com.gustavo.microservices.msclients.domain.entities.Client;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("clients")
@RequiredArgsConstructor
public class ClientsController {

  private final ClientsService clientsService;

  @GetMapping
  public String teste(){
    return "teste";
  }


  @PostMapping("/register")
  public ResponseEntity<ClientDTO> register(@RequestBody @Valid CreateClientDTO clientDTO){
    Client client = clientDTO.toEntity();

    return ResponseEntity.status(201).body(clientsService.register(client));
  }

  @PostMapping("/login")
  public ResponseEntity<ClientDTO> login(@RequestBody @Valid LoginDTO loginDTO){
    return null;
  }
}
