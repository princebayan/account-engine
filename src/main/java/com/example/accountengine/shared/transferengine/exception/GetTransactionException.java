package com.example.accountengine.shared.transferengine.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * The type Get transaction exception.
 */
@Getter
@Setter
@AllArgsConstructor
public class GetTransactionException extends RuntimeException {

  private int customerId;

}
