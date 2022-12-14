package com.example.accountengine.customer.response;

import java.math.BigDecimal;
import lombok.Getter;
import lombok.Setter;

/**
 * The type Account.
 */
@Getter
@Setter
public class Account {

  private String accountNumber;
  private String currency;
  private BigDecimal balance;
}
