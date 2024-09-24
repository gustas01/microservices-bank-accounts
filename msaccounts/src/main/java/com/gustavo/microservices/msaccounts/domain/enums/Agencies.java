package com.gustavo.microservices.msaccounts.domain.enums;

public enum Agencies {
  AMERICA(1),
  EUROPA(2),
  ASIA(3),
  OCEANIA(4),
  AFRICA(5);

  private final int code;

  Agencies(int code){
    this.code = code;
  }
}
