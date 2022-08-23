package com.example.accountengine.customer.account;


import com.example.accountengine.customer.account.request.CreateAccountRequest;
import com.example.accountengine.customer.account.response.CreateAccountResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import javax.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * The type Account controller.
 */
@RestController
@RequestMapping(value = "customer/{id}/account")
@Validated
@Tag(name = "Account Controller")
@Log4j2
@AllArgsConstructor
public class AccountController {

  private final AccountService accountService;


  /**
   * Create account response entity.
   *
   * @param id                   the id
   * @param createAccountRequest the create account request
   * @return the response entity
   */
  @PostMapping
  public ResponseEntity<CreateAccountResponse> createAccount(
      @PathVariable @Positive int id,
      @RequestBody CreateAccountRequest createAccountRequest) {
    log.info("Invoke createAccount. request {}", id);
    /*
    creating the account through the account service class
     */
    CreateAccountResponse createAccountResponse = accountService.createAccount(
        id,
        createAccountRequest.getInitialAmount());
    /*
    Returning the response.
     */
    log.info("Exiting createAccount. response {}", createAccountResponse);
    return ResponseEntity.status(HttpStatus.OK).body(createAccountResponse);
  }
}
