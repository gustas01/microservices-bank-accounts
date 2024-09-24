package com.gustavo.microservices.msaccounts.domain.entities;

import com.gustavo.microservices.msaccounts.adapters.DTOs.AccountDTO;
import com.gustavo.microservices.msaccounts.domain.enums.AccountTypes;
import com.gustavo.microservices.msaccounts.domain.enums.Agencies;
import com.gustavo.microservices.msaccounts.domain.enums.BankCodes;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Account {
  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  private UUID id;

  @Column(unique = true)
  private UUID accountNumber = UUID.randomUUID();

  @Column(nullable = false)
  @Enumerated(EnumType.ORDINAL)
  private Agencies agencyNumber;

  @Column
  private BigDecimal balance = BigDecimal.valueOf(0);

  @Column
  @Enumerated(EnumType.STRING)
  private AccountTypes accountType;

  @Column
  @Enumerated(EnumType.ORDINAL)
  private BankCodes bankCode = BankCodes.MYBANK;

  @Column(nullable = false)
  private UUID clientId;

  @Column
  private LocalDateTime createdAt = LocalDateTime.now();

  @Column
  private Boolean active = true;

  public Account(Agencies agencyNumber, AccountTypes accountType, UUID clientId) {
    this.agencyNumber = agencyNumber;
    this.accountType = accountType;
    this.clientId = clientId;
  }


  public AccountDTO toDTO(){
    return new AccountDTO(accountNumber, agencyNumber, balance, accountType.name(), bankCode.ordinal(), createdAt);
  }
}
