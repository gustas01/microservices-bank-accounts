package com.gustavo.microservices.msclients.application.services;

import com.gustavo.microservices.msclients.adapters.DTOs.ClientDTO;
import com.gustavo.microservices.msclients.domain.entities.Client;
import com.gustavo.microservices.msclients.infra.repositories.ClientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ClientsService {

  private final ClientRepository clientRepository;
  private final PasswordEncoder passwordEncoder;

  public ClientDTO register(Client client){
    client.setPassword(passwordEncoder.encode(client.getPassword()));
    Client newClient = clientRepository.save(client);
    return newClient.toDTO();
  }

}
