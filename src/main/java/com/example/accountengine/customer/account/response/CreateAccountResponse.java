package com.example.accountengine.customer.account.response;

import java.math.BigDecimal;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * The type Create account response.
 */
@Getter
@Setter
@ToString
public class CreateAccountResponse {

  private String accountNumber;
  private BigDecimal balance;

}
