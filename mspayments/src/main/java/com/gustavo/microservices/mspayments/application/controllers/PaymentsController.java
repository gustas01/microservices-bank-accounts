package com.gustavo.microservices.mspayments.application.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("payments")
public class PaymentsController {

  @GetMapping
  public String teste(){
    return "do controller de mspayments";
  }
}
