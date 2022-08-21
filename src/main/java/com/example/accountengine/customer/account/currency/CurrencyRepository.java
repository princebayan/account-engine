package com.example.accountengine.customer.account.currency;

import com.example.accountengine.customer.CustomerEntity;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface CurrencyRepository {

  CurrencyEntity findByCode(String code);
}
