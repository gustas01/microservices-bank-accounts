package com.gustavo.microservices.msclients.infra.repositories;

import com.gustavo.microservices.msclients.domain.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface ClientRepository extends JpaRepository<Client, UUID> {
  Optional<Client> findByEmail(String email);
}
