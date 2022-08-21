package com.example.accountengine.customer.request;

import javax.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class CreateCustomerRequest {

  @NotBlank
  private String name;
  @NotBlank
  private String surname;
}
