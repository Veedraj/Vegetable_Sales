package com.vegetable.service;

import java.util.List;

import com.vegetable.entity.Customer;
import com.vegetable.exception.CustomerAlreadyExistsException;
import com.vegetable.exception.CustomerNotFoundException;

public interface CustomerService {
	public List<Customer> getAllCustomers();

	public Customer addCustomer(Customer customer) throws CustomerAlreadyExistsException;

	public Customer updateCustomer(Customer customer);

	public Customer getCustomerById(Long customerId) throws CustomerNotFoundException;

	public List<Customer> deleteCustomer(Long customerId);
}
