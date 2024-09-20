package com.gustavo.microservices.msclients.application.services;

import com.gustavo.microservices.msclients.adapters.DTOs.ClientDTO;
import com.gustavo.microservices.msclients.adapters.DTOs.UpdateClientDTO;
import com.gustavo.microservices.msclients.domain.entities.Client;
import com.gustavo.microservices.msclients.infra.repositories.ClientRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.UUID;

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

  public ClientDTO update(UUID clientId, UpdateClientDTO clientDTO){
    Client client = clientRepository.findById(clientId).orElseThrow(() -> new EntityNotFoundException("Usuário não encontrado!"));

    if (clientDTO.firstName() != null) client.setFirstName(clientDTO.firstName());
    if (clientDTO.lastName() != null) client.setLastName(clientDTO.lastName());
    if (clientDTO.email() != null) client.setEmail(clientDTO.email());
    if (clientDTO.password() != null) client.setPassword(passwordEncoder.encode(clientDTO.password()));
    if (clientDTO.cpf() != null) client.setCpf(clientDTO.cpf());
    if (clientDTO.address() != null) client.setAddress(clientDTO.address());
    if (clientDTO.address() != null) client.setAddress(clientDTO.address());
    if (clientDTO.birth() != null) client.setBirth(clientDTO.birth());

    return clientRepository.save(client).toDTO();
  }

  public void delete(UUID clientId){
    Client client = clientRepository.findById(clientId).orElseThrow(() -> new EntityNotFoundException("Usuário não encontrado!"));

    client.setActive(false);
    clientRepository.save(client);
  }

}
