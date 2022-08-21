package com.example.accountengine.customer.request;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class CreateCustomerRequest {

  private String name;
  private String surname;
}
