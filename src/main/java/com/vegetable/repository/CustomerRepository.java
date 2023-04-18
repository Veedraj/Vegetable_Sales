package com.vegetable.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vegetable.entity.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

	Customer findByCustomerEmail(String username);

}
