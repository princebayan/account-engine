package com.example.accountengine.customer;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface CustomerRepository {

  int save(CustomerEntity customerEntity);
  int update(CustomerEntity customerEntity);
  CustomerEntity findById(int id);
}
