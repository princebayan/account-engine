package com.example.accountengine.shared.transferengine;

import com.example.accountengine.shared.ResponseBody;
import com.example.accountengine.shared.transferengine.exception.ExecuteTransferException;
import com.example.accountengine.shared.transferengine.exception.GetTransactionException;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * The type Transfer engine exception handler.
 */
@RestControllerAdvice
@Log4j2
@AllArgsConstructor
@Order(value = Ordered.HIGHEST_PRECEDENCE)
public class TransferEngineExceptionHandler {


  /**
   * Handle execute transfer exception response entity.
   *
   * @param ex the ex
   * @return the response entity
   */
  @ExceptionHandler(ExecuteTransferException.class)
  public ResponseEntity<?> handleExecuteTransferException(ExecuteTransferException ex) {
    log.warn("handle ExecuteTransferException, id :{}", ex.getCustomerId());
    /*
    Prepare the response
     */
    ResponseBody<?> responseBody = ResponseBody
        .failedError(
            HttpStatus.UNPROCESSABLE_ENTITY,
            "Exception while communicating with transfer engine");
    /*
    Return Unprocessable entity response.
     */
    return new ResponseEntity<>(responseBody, HttpStatus.UNPROCESSABLE_ENTITY);
  }

  /**
   * Handle get transaction exception response entity.
   *
   * @param ex the ex
   * @return the response entity
   */
  @ExceptionHandler(GetTransactionException.class)
  public ResponseEntity<?> handleGetTransactionException(GetTransactionException ex) {
    log.warn("handle GetTransactionException, id :{}", ex.getCustomerId());
    /*
    Prepare the response
     */
    ResponseBody<?> responseBody = ResponseBody
        .failedError(
            HttpStatus.UNPROCESSABLE_ENTITY,
            "Exception while communicating with transfer engine");
    /*
    Return Unprocessable entity response.
     */
    return new ResponseEntity<>(responseBody, HttpStatus.UNPROCESSABLE_ENTITY);
  }
}
