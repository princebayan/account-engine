package com.example.accountengine.customer.request;

import javax.validation.constraints.Positive;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class GetCustomerRequest {

  @Positive
  private int customerId;
}
