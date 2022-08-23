package com.example.accountengine.customer;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * The interface Customer repository.
 */
@Repository
@Mapper
public interface CustomerRepository {

  /**
   * Save int.
   *
   * @param customerEntity the customer entity
   * @return the int
   */
  int save(CustomerEntity customerEntity);

  /**
   * Update int.
   *
   * @param customerEntity the customer entity
   * @return the int
   */
  int update(CustomerEntity customerEntity);

  /**
   * Find by id customer entity.
   *
   * @param id the id
   * @return the customer entity
   */
  CustomerEntity findById(int id);
}
