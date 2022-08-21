package com.example.accountengine.customer.account;

import com.example.accountengine.customer.CustomerEntity;
import com.example.accountengine.customer.CustomerRepository;
import com.example.accountengine.customer.account.accountnumber.AccountGenerator;
import com.example.accountengine.customer.account.currency.CurrencyRepository;
import com.example.accountengine.customer.account.response.CreateAccountResponse;
import com.example.accountengine.customer.exception.CustomerNotFoundException;
import com.example.accountengine.shared.transferengine.TransferEngineNetwork;
import java.math.BigDecimal;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
@Log4j2
public class AccountService {

  private static final String POOL_SOURCE_ACCOUNT_NUMBER = "1234567001840";
  private static final String POOL_SOURCE_ACCOUNT_CURRENCY = "USD";
  private final AccountRepository accountRepository;
  private final CustomerRepository customerRepository;
  private final CurrencyRepository currencyRepository;
  private final AccountGenerator accountGenerator;
  private final TransferEngineNetwork transferEngineNetwork;

  @Transactional
  public CreateAccountResponse createAccount(int customerId, BigDecimal initialCredit) {
    /*
    Check if customerId exists
     */
    CustomerEntity customerEntity = customerRepository.findById(customerId);
    /*
    Throw exception if customer does not exists
     */
    if (customerEntity == null) {
      throw new CustomerNotFoundException(customerId);
    }
    /*
    Generate account number. By default all the customer accounts will be USD, we can change
    this implementation based on the business requirement.
     */
    String accountNumber = accountGenerator.generateAccountNumber(
        customerEntity.getCustomerId(),
        "USD");
    /*
    Fill the account Entity object
     */
    AccountEntity accountEntity = new AccountEntity();
    accountEntity.setAccountNumber(accountNumber);
    accountEntity.setCurrency(currencyRepository.findByCode("USD"));
    accountEntity.setCustomer(customerEntity);
    accountEntity.setBalance(initialCredit);
    /*
    Save the account entity in the database;
     */
    accountRepository.save(accountEntity);
    if (initialCredit.compareTo(new BigDecimal("0")) > 0) {

      transferEngineNetwork.executeTransaction(
          initialCredit,
          customerEntity.getId(),
          accountEntity.getAccountNumber(),
          accountEntity.getCurrency().getCode(),
          POOL_SOURCE_ACCOUNT_NUMBER,
          POOL_SOURCE_ACCOUNT_CURRENCY,
          initialCredit,
          initialCredit
      );
    }
    /*
    Prepare the Create Account Response
     */
    CreateAccountResponse createAccountResponse = new CreateAccountResponse();
    createAccountResponse.setAccountNumber(accountEntity.getAccountNumber());
    createAccountResponse.setBalance(accountEntity.getBalance());

    return createAccountResponse;
  }
}
