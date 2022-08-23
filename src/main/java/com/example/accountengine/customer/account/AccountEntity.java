package com.example.accountengine.customer.account;

import com.example.accountengine.customer.CustomerEntity;
import com.example.accountengine.customer.account.currency.CurrencyEntity;
import java.math.BigDecimal;
import lombok.Getter;
import lombok.Setter;

/**
 * The type Account entity.
 */
@Getter
@Setter
public class AccountEntity {

  private int id;
  private String accountNumber;
  private BigDecimal balance;
  private CurrencyEntity currency;
  private CustomerEntity customer;
}
