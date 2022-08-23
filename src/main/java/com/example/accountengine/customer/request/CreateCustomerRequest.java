package com.example.accountengine.customer.request;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import javax.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.validation.annotation.Validated;

/**
 * The type Create customer request.
 */
@Getter
@Setter
@ToString
@Validated
public class CreateCustomerRequest {

  @NotBlank
  private String name;
  @NotBlank
  private String surname;

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
