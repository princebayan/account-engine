package com.example.accountengine.customer;

import com.example.accountengine.customer.account.AccountEntity;
import com.example.accountengine.customer.account.AccountRepository;
import com.example.accountengine.customer.exception.CustomerNotFoundException;
import com.example.accountengine.customer.response.Account;
import com.example.accountengine.customer.response.GetCustomerResponse;
import com.example.accountengine.customer.customerid.CustomerIdGeneratorImpl;
import java.util.List;
import java.util.stream.Collectors;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Log4j2
@AllArgsConstructor
public class CustomerService {

  private static final ModelMapper modelMapper = new ModelMapper();
  private final CustomerRepository customerRepository;
  private final AccountRepository accountRepository;

  private final CustomerIdGeneratorImpl customerIdGenerator;

  @Transactional
  public int createCustomer(String name, String surname) {
    /*
    prepare the customer entity object
     */
    CustomerEntity customerEntity = new CustomerEntity();
    customerEntity.setName(name);
    customerEntity.setCustomerId("0");
    customerEntity.setSurname(surname);
    /*
    Save customer in the database
     */
    customerRepository.save(customerEntity);
    /*
    Generate the customer id
     */
    String customerId = customerIdGenerator.generateCustomerId(customerEntity.getId());
    /*
    Set the customer id in the customer entity
     */
    customerEntity.setCustomerId(customerId);
    /*
    Update customer entity in the database
     */
    customerRepository.update(customerEntity);
    /*
    Return id
     */
    return customerEntity.getId();
  }


  public GetCustomerResponse getCustomer(int customerId) {
    /*
    Prepare the result
     */
    GetCustomerResponse result = new GetCustomerResponse();
    /*
    Get the customer by id from the repository
     */
    CustomerEntity customerEntity = customerRepository.findById(customerId);
    /*
    Check if customer entity is null to handle it
     */
    if (customerEntity == null) {
      throw new CustomerNotFoundException(customerId);
    }
    /*
    Mapping customer entity to get customer response.
     */
    modelMapper.map(customerEntity, result);
    result.setCustomerNumber(customerEntity.getCustomerId());
    /*
    Get the related accounts for the customer
     */
    List<AccountEntity> accounts = accountRepository
        .findByCustomerId(customerId);
    /*
    Map the account entity list to the account list
     */
    List<Account> accountList = accounts.parallelStream()
        .map(accountEntity -> {
          Account account = new Account();
          account.setAccountNumber(accountEntity.getAccountNumber());
          account.setCurrency(accountEntity.getCurrency().getCode());
          account.setBalance(accountEntity.getBalance());
          return account;
        })
        .collect(Collectors.toList());
    /*
    Set the account list
     */
    result.setAccounts(accountList);
    return result;
  }


}
