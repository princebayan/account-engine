package com.example.accountengine.customer.customerid;

/**
 * The interface Customer id generator.
 */
public interface CustomerIdGenerator {

  /**
   * Generate customer id string.
   *
   * @param id the id
   * @return the string
   */
  public String generateCustomerId (int id);
}
