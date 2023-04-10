package com.vegetable.service;

import java.util.List;

import com.vegetable.dto.CustomerDTO;
import com.vegetable.dto.CustomerLoginDTO;
import com.vegetable.entity.Customer;
import com.vegetable.exception.CustomerAlreadyExistsException;
import com.vegetable.exception.CustomerNotFoundException;
import com.vegetable.exception.WrongPasswordException;

public interface CustomerService {
	public List<Customer> getAllCustomers();

	public Customer addCustomer(Customer customer) throws CustomerAlreadyExistsException;

	public Customer updateCustomer(Customer customer) throws CustomerNotFoundException ;

	public Customer getCustomerById(Long customerId) throws CustomerNotFoundException;

	public List<Customer> deleteCustomer(Long customerId);
	
	
	// Login & Registration
	public Customer registerCustomer(CustomerDTO cust) throws CustomerAlreadyExistsException;
	public Customer login(CustomerLoginDTO cust) throws CustomerNotFoundException , WrongPasswordException;
}
