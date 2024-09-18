package com.gustavo.microservices.msclients.application.services;

import com.gustavo.microservices.msclients.infra.repositories.ClientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ClientsService {

  private final ClientRepository clientRepository;

}
