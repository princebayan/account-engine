package com.example.accountengine.customer.account.response;

import java.math.BigDecimal;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class CreateAccountResponse {

  private String accountNumber;
  private BigDecimal balance;

}
