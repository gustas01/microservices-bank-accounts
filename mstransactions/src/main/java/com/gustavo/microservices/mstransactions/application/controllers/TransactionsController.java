package com.gustavo.microservices.mstransactions.application.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("transactions")
public class TransactionsController {

  @GetMapping
  public String teste(){
    return "do controller de mstransactions";
  }
}
