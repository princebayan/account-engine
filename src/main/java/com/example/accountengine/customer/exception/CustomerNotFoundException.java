package com.example.accountengine.customer.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * The type Customer not found exception.
 */
@Getter
@Setter
@AllArgsConstructor
public class CustomerNotFoundException extends RuntimeException {

  private int customerId;
}
