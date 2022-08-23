package com.example.accountengine.customer;

import com.example.accountengine.customer.request.CreateCustomerRequest;
import com.example.accountengine.customer.response.CreateCustomerResponse;
import com.example.accountengine.customer.response.GetCustomerResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import javax.validation.Valid;
import javax.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * The type Customer controller.
 */
@RestController
@RequestMapping(value = "customer")
@Validated
@Tag(name = "Customer Controller")
@Log4j2
@AllArgsConstructor
public class CustomerController {

  private final CustomerService customerService;


  /**
   * Create customer response entity.
   *
   * @param createCustomerRequest the create customer request
   * @return the response entity
   */
  @PostMapping
  public ResponseEntity<CreateCustomerResponse> createCustomer(
      @RequestBody
      @Valid
          CreateCustomerRequest createCustomerRequest) {
    log.info("Invoke createCustomer. request {}", createCustomerRequest);
    /*
    Get customer response from the customer service class
     */
    int id = customerService
        .createCustomer(
            createCustomerRequest.getName(),
            createCustomerRequest.getSurname());
    /*
    prepare the returned result
     */
    CreateCustomerResponse response = new CreateCustomerResponse();
    response.setId(id);
    /*
    returning the response as 200 OK
     */
    log.info("Exiting createCustomer. response {}", response);
    return ResponseEntity.status(HttpStatus.OK).body(response);
  }

  /**
   * Gets customer.
   *
   * @param id the id
   * @return the customer
   */
  @GetMapping("/{id}")
  public ResponseEntity<GetCustomerResponse> getCustomer(
      @PathVariable
      @Positive
          int id) {
    log.info("Invoke getCustomer. request {}", id);
    /*
    Get customer response from the customer service class
     */
    GetCustomerResponse result = customerService
        .getCustomer(id);
    /*
    returning the response as 200 OK
     */
    log.info("Exiting getCustomer. response {}", result);
    return ResponseEntity.status(HttpStatus.OK).body(result);
  }

}
