package com.example.accountengine.customer.account.request;

import java.math.BigDecimal;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class CreateAccountRequest {

  private BigDecimal initialAmount;

}
