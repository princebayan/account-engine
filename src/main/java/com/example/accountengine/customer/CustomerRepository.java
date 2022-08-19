package com.example.accountengine.customer;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface CustomerRepository {


  CustomerEntity findById(int id);
}
