package com.example.accountengine.customer.account.accountnumber;

import java.util.Random;
import org.springframework.stereotype.Service;

@Service
public class AccountGeneratorImpl implements AccountGenerator {

  private static final int USD_CODE = 840;
  private static final int EUR_CODE = 841;

  /**
   * the generation of the account number will be based on the customer id , currency of the account
   * and an auto number generation. for example: customerid + autoNumberGenerated + Currency 1338508
   * + 001 + 840 so the account number will be of length 13.
   */
  @Override
  public String generateAccountNumber(String customerId, String currencyCode) {
    String accountNumber = customerId;
    /*
    Generate a random number
     */
    Random random = new Random();
    int randomNumber = 100 + random.nextInt(900);
    /*
    concatenate the randomNumber with the accountNumber
     */
    accountNumber = accountNumber + randomNumber;
    /*
    Concatenate the Currency_Code based on the currency
     */
    switch (currencyCode) {
      case "EUR":
        accountNumber = accountNumber + EUR_CODE;
        break;
      case "USD":
      default:
        accountNumber = accountNumber + USD_CODE;
    }

    return accountNumber;
  }
}
