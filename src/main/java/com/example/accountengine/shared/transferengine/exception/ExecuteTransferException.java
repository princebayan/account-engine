package com.example.accountengine.shared.transferengine.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * The type Execute transfer exception.
 */
@Getter
@Setter
@AllArgsConstructor
public class ExecuteTransferException extends RuntimeException {

  private int customerId;

}
