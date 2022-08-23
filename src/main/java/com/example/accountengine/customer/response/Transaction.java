package com.example.accountengine.customer.response;

import java.math.BigDecimal;
import java.util.Date;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * The type Transaction.
 */
@Getter
@Setter
@ToString
public class Transaction {

  private Date createdDate;
  private Date updatedDate;
  private int id;
  private BigDecimal amount;
  private String account;
}
