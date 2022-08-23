package com.example.accountengine.customer.account.request;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.math.BigDecimal;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * The type Create account request.
 */
@Getter
@Setter
@ToString
public class CreateAccountRequest {

  private BigDecimal initialAmount;


  /**
   * To json string.
   *
   * @return the string
   * @throws JsonProcessingException the json processing exception
   */
  public String toJson() throws JsonProcessingException {
    ObjectMapper mapper = new ObjectMapper();
    return mapper.writeValueAsString(this);
  }
}
