package com.example.accountengine.customer;

import com.example.accountengine.customer.account.AccountEntity;
import com.example.accountengine.customer.account.AccountRepository;
import com.example.accountengine.customer.exception.CustomerNotFoundException;
import com.example.accountengine.customer.response.Account;
import com.example.accountengine.customer.response.GetCustomerResponse;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;

@Service
@Log4j2
@AllArgsConstructor
public class CustomerService {

  private static final ModelMapper modelMapper = new ModelMapper();

  private final CustomerRepository customerRepository;
  private final AccountRepository accountRepository;

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
    /*
    Get the related accounts for the customer
     */
    List<AccountEntity> accounts = accountRepository
        .findByCustomerId(customerId);
    /*
    Map the account entity list to the account list
     */
    List<Account> accountList = modelMapper.map(
        accounts,
        new TypeToken<List<Account>>() {
        }.getType());
    /*
    Set the account list
     */
    result.setAccounts(accountList);
    return result;
  }


}
