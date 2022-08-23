package com.example.accountengine.shared.transferengine.response;

import java.util.List;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * The type Transactions response.
 */
@Getter
@Setter
@ToString
public class TransactionsResponse {

  private List<Transaction> transactions;
}
