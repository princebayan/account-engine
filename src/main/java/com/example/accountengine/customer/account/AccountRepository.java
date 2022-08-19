package com.example.accountengine.customer.account;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface AccountRepository {

  List<AccountEntity> findByCustomerId(int customerId);
}
