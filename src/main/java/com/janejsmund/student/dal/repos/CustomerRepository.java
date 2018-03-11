package com.janejsmund.student.dal.repos;

import com.janejsmund.student.dal.entities.Customer;
import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository extends CrudRepository<Customer, Long> {
}
