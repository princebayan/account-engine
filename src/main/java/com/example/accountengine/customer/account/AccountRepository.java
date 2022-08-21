package com.example.accountengine.customer.account;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Mapper
public interface AccountRepository {

  int save(AccountEntity accountEntity);

  List<AccountEntity> findByCustomerId(int customerId);


}
