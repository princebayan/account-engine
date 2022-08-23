package com.example.accountengine.customer.account.accountnumber;

/**
 * The interface Account generator.
 */
public interface AccountGenerator {

  /**
   * Generate account number string.
   *
   * @param customerId   the customer id
   * @param currencyCode the currency code
   * @return the string
   */
  public String generateAccountNumber(String customerId, String currencyCode);
}
