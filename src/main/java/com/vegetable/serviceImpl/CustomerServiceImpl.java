package com.vegetable.serviceImpl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vegetable.entity.Customer;
import com.vegetable.exception.CustomerAlreadyExistsException;
import com.vegetable.exception.CustomerNotFoundException;
import com.vegetable.repository.CustomerRepo;
import com.vegetable.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerRepo customerRepo;

	@Override
	public List<Customer> getAllCustomers() {
		List<Customer> customerList = customerRepo.findAll();
		return customerList;
	}

	@Override
	public Customer addCustomer(Customer customer) throws CustomerAlreadyExistsException {
		List<Customer> list = customerRepo.findAll();
		for (Customer c : list) {

			if ((c.getCustomerEmail().equals(customer.getCustomerEmail()))
					&& (c.getCustomerPhone().equals(customer.getCustomerPhone()))) {
				throw new CustomerAlreadyExistsException("Customer with this email and phone number already exists.");
			} else if (c.getCustomerEmail().equals(customer.getCustomerEmail())) {
				throw new CustomerAlreadyExistsException("Customer with this email already exists.");
			} else if (c.getCustomerPhone().equals(customer.getCustomerPhone())) {
				throw new CustomerAlreadyExistsException("Customer with this phone number already exists.");
			}
		}
		Customer newCustomer = customerRepo.save(customer);
		return newCustomer;
	}

	@Override
	public Customer updateCustomer(Customer customer) {
		Customer updatedCustomer = customerRepo.save(customer);
		return updatedCustomer;
	}

	@Override
	public Customer getCustomerById(Long customerId) throws CustomerNotFoundException {
		try {
			Customer customer = customerRepo.findById(customerId).get();
			return customer;
		} catch (Exception e) {
			throw new CustomerNotFoundException("Customer with this id does not exists.");
		}
	}

	@Override
	public List<Customer> deleteCustomer(Long customerId) {
		customerRepo.deleteById(customerId);
		return customerRepo.findAll();
	}

}
