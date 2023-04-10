package com.vegetable.serviceImpl;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.vegetable.dto.CustomerDTO;
import com.vegetable.dto.CustomerLoginDTO;
import com.vegetable.entity.Cart;
import com.vegetable.entity.Customer;
import com.vegetable.entity.Order;
import com.vegetable.exception.CustomerAlreadyExistsException;
import com.vegetable.exception.CustomerNotFoundException;
import com.vegetable.exception.WrongPasswordException;
import com.vegetable.repository.CustomerRepository;
import com.vegetable.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerRepository customerRepo;

	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	@Override
	public List<Customer> getAllCustomers() {
		List<Customer> customerList = customerRepo.findAll();
		return customerList;
	}

	@Override
	public Customer addCustomer(CustomerDTO customer) throws CustomerAlreadyExistsException {
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
		Customer newCustomer = new Customer(null, customer.getCustomerName(), customer.getCustomerEmail(),
				customer.getCustomerPhone(), customer.getCustomerPassword(), null, null, null, new Cart(),
				new ArrayList<Order>());
		return customerRepo.save(newCustomer);
	}

	@Override
	public Customer updateCustomer(Customer customer) throws CustomerNotFoundException {
		if (customerRepo.findById(customer.getCustomerId()).isEmpty()) {
			throw new CustomerNotFoundException("Customer Not Found With Id :" + customer.getCustomerId());
		}
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

	// login/registration module
	@Override
	public Customer registerCustomer(CustomerDTO cust) throws CustomerAlreadyExistsException {
		if (this.customerRepo.findByCustomerEmail(cust.getCustomerEmail()) != null) {
			throw new CustomerAlreadyExistsException(
					"Customer Already Exists with Email Id: " + cust.getCustomerEmail());
		}
		Customer customer = new Customer(null, cust.getCustomerName(), cust.getCustomerEmail(), cust.getCustomerPhone(),
				cust.getCustomerPassword(), null, null, null, new Cart(), new ArrayList<Order>());
		return this.customerRepo.save(customer);
	}

	@Override
	public Customer login(CustomerLoginDTO cust) throws CustomerNotFoundException, WrongPasswordException {
		if (this.customerRepo.findByCustomerEmail(cust.getCustomerEmail()) == null) {
			throw new CustomerNotFoundException("Customer Not Found With Email Id: " + cust.getCustomerEmail());
		}
		String encryptedPassword = this.bCryptPasswordEncoder.encode(cust.getCustomerPassword());
		if (!this.customerRepo.findByCustomerEmail(cust.getCustomerEmail()).getCustomerPassword()
				.equals(encryptedPassword)) {
			throw new WrongPasswordException("Invalid Credentials");
		}
		return this.customerRepo.findByCustomerEmail(cust.getCustomerEmail());
	}

}
