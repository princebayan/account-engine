package com.example.accountengine.customer.response;

import java.math.BigDecimal;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Account {

  private String accountNumber;
  private BigDecimal balance;
}
