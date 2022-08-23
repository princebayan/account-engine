package com.example.accountengine.customer;

import com.example.accountengine.customer.exception.CustomerNotFoundException;
import com.example.accountengine.shared.ResponseBody;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * The type Customer exception handler.
 */
@RestControllerAdvice
@Log4j2
@AllArgsConstructor
@Order(value = Ordered.HIGHEST_PRECEDENCE)
public class CustomerExceptionHandler {

  /**
   * Handle customer not found exception response entity.
   *
   * @param ex the ex
   * @return the response entity
   */
  @ExceptionHandler(CustomerNotFoundException.class)
  public ResponseEntity<?> handleCustomerNotFoundException(CustomerNotFoundException ex) {
    log.warn("handle CustomerNotFoundException, id :{}", ex.getCustomerId());
    /*
    Prepare the response
     */
    ResponseBody<?> responseBody = ResponseBody
        .failedError(HttpStatus.UNPROCESSABLE_ENTITY, "Customer Not Found");
    /*
    Return Unprocessable entity response.
     */
    return new ResponseEntity<>(responseBody, HttpStatus.UNPROCESSABLE_ENTITY);
  }
}
