package com.example.accountengine.customer.customerid;

import java.util.Random;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@Service
@Log4j2
public class CustomerIdGeneratorImpl implements CustomerIdGenerator {

  /**
   * the customer id will be based on the id of the customer then concatenating to it a random
   * number, such that the length of the result will be 7. for example customer id is 1 therefore
   * the result will be : 1234567
   */
  @Override
  public String generateCustomerId(int id) {
    /*
    Get the length of the id inorder to control the size of the customerId
     */
    int lengthOfId = String.valueOf(id).length();

    return String.valueOf(id) + generateRandomDigits(7 - lengthOfId);
  }

  // Generates a random int with n digits
  private int generateRandomDigits(int n) {
    int m = (int) Math.pow(10, n - 1);
    return m + new Random().nextInt(9 * m);
  }
}
