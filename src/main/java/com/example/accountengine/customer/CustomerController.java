package com.example.accountengine.customer;

import com.example.accountengine.customer.request.GetCustomerRequest;
import com.example.accountengine.customer.response.GetCustomerResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import javax.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "customer")
@Validated
@Tag(name = "Customer Controller")
@Log4j2
@AllArgsConstructor
public class CustomerController {

  private final CustomerService customerService;

  @PostMapping
  public ResponseEntity<GetCustomerResponse> getCustomer(
      @RequestBody
      @NotBlank
          GetCustomerRequest getCustomerRequest) {
    log.info("Invoke getCustomer. request {}", getCustomerRequest);
    /*
    Get customer response from the customer service class
     */
    GetCustomerResponse result = customerService
        .getCustomer(getCustomerRequest.getCustomerId());
    /*
    returning the response as 200 OK
     */
    log.info("Exiting getCustomer. response {}", result);
    return ResponseEntity.status(HttpStatus.OK).body(result);
  }

}
