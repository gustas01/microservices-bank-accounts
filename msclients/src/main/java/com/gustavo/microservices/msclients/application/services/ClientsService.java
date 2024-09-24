package com.gustavo.microservices.msclients.application.services;

import com.gustavo.microservices.msclients.adapters.DTOs.*;
import com.gustavo.microservices.msclients.domain.entities.Client;
import com.gustavo.microservices.msclients.infra.clients.MsAccountsClient;
import com.gustavo.microservices.msclients.infra.mqueue.ClientNotificationsPublisher;
import com.gustavo.microservices.msclients.infra.repositories.ClientRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ClientsService {

  private final ClientRepository clientRepository;
  private final PasswordEncoder passwordEncoder;
  private final ClientNotificationsPublisher publisher;
  private final MsAccountsClient msAccountsClient;

  public ClientDTO register(Client client){
    client.setPassword(passwordEncoder.encode(client.getPassword()));
    Client newClient = clientRepository.save(client);

    PayloadQueueMessageDTO payloadQueueMessageDTO = new PayloadQueueMessageDTO(
            client.getEmail(), "Notificação da sua conta",
            "Conta client criada com sucesso!.");

    AccountDataRequest accountDataRequest = new AccountDataRequest("SAVINGSACCOUNT", 1);
    ResponseEntity<AccountDataResponse> accountDataResponse = msAccountsClient.create(newClient.getId().toString(), accountDataRequest);

    if (accountDataResponse.getStatusCode() != HttpStatus.CREATED)
      throw new RuntimeException();

    publisher.sendMessage(payloadQueueMessageDTO);

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
