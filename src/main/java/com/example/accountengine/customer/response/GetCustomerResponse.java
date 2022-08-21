package com.example.accountengine.customer.response;

import java.util.List;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class GetCustomerResponse {

  private int id;
  private String name;
  private String surname;
  private String customerNumber;
  private List<Account> accounts;

}
