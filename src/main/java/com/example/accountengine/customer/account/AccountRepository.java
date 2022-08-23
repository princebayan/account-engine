package com.example.accountengine.customer.account;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * The interface Account repository.
 */
@Repository
@Mapper
public interface AccountRepository {

  /**
   * Save int.
   *
   * @param accountEntity the account entity
   * @return the int
   */
  int save(AccountEntity accountEntity);

  /**
   * Find by customer id list.
   *
   * @param customerId the customer id
   * @return the list
   */
  List<AccountEntity> findByCustomerId(int customerId);


}
