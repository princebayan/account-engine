package com.example.accountengine.customer.account.currency;

import com.example.accountengine.customer.CustomerEntity;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * The interface Currency repository.
 */
@Repository
@Mapper
public interface CurrencyRepository {

  /**
   * Find by code currency entity.
   *
   * @param code the code
   * @return the currency entity
   */
  CurrencyEntity findByCode(String code);
}
