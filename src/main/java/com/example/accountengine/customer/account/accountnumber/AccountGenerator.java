package com.example.accountengine.customer.account.accountnumber;

public interface AccountGenerator {

  public String generateAccountNumber(String customerId, String currencyCode);
}
