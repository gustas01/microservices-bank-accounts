package com.gustavo.microservices.msclients.adapters.controllers;

import com.gustavo.microservices.msclients.adapters.DTOs.ClientDTO;
import com.gustavo.microservices.msclients.adapters.DTOs.LoginDTO;
import com.gustavo.microservices.msclients.adapters.controllers.DTOs.CreateClientDTO;
import com.gustavo.microservices.msclients.domain.entities.Client;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("clients")
public class ClientsController {

  @GetMapping
  public String teste(){
    return "teste";
  }


  @PostMapping("/register")
  public ResponseEntity<ClientDTO> register(@RequestBody @Valid CreateClientDTO clientDTO){
    Client client = clientDTO.toEntity();

    return null;
  }

  @PostMapping("/login")
  public ResponseEntity<ClientDTO> login(@RequestBody @Valid LoginDTO loginDTO){
    return null;
  }
}
