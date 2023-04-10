package com.vegetable.service;

import java.util.List;

import com.vegetable.dto.CustomerDTO;
import com.vegetable.entity.Customer;
import com.vegetable.exception.CustomerAlreadyExistsException;
import com.vegetable.exception.CustomerNotFoundException;

public interface CustomerService {
	public List<Customer> getAllCustomers();

	public Customer addCustomer(CustomerDTO customer) throws CustomerAlreadyExistsException;

	public Customer updateCustomer(Customer customer) throws CustomerNotFoundException ;

	public Customer getCustomerById(Long customerId) throws CustomerNotFoundException;

	public List<Customer> deleteCustomer(Long customerId);
}
