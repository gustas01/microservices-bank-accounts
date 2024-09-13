package com.gustavo.microservices.msclients.application.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("clients")
public class ClientsController {

  @GetMapping
  public String teste(){
    return "teste";
  }
}
