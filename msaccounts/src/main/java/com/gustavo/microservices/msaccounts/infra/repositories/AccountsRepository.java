package com.gustavo.microservices.msaccounts.infra.repositories;

import com.gustavo.microservices.msaccounts.domain.entities.Account;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface AccountsRepository extends JpaRepository<Account, UUID> {
  List<Account> findAllByClientId(UUID clientId);
}
