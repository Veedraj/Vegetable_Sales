package com.vegetable.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vegetable.entity.Customer;
import com.vegetable.exception.CustomerAlreadyExistsException;
import com.vegetable.exception.CustomerNotFoundException;
import com.vegetable.service.CustomerService;

@RestController
@RequestMapping("/api/v1")
public class CustomerController {

	@Autowired
	private CustomerService customerService;

	@GetMapping("/customer")
	public ResponseEntity<List<Customer>> getAllCustomers() {
		return new ResponseEntity<List<Customer>>(customerService.getAllCustomers(), HttpStatus.OK);
	}

	@PostMapping("/customer")
	public ResponseEntity<Customer> addCustomer(@RequestBody Customer customer) throws CustomerAlreadyExistsException {
		return new ResponseEntity<Customer>(customerService.addCustomer(customer), HttpStatus.OK);
	}

	@PutMapping("/customer")
	public ResponseEntity<Customer> updateCustomer(@RequestBody Customer customer) {
		return new ResponseEntity<Customer>(customerService.updateCustomer(customer), HttpStatus.OK);
	}

	@GetMapping("customer/{customerId}")
	public ResponseEntity<Customer> getCustomerById(@PathVariable("customerId") Long customerId)
			throws CustomerNotFoundException {
		return new ResponseEntity<Customer>(customerService.getCustomerById(customerId), HttpStatus.OK);
	}

	@DeleteMapping("customer/{customerId}")
	public ResponseEntity<List<Customer>> deleteCustomer(@PathVariable("customerId") Long customerId) {
		List<Customer> customerList = customerService.deleteCustomer(customerId);
		return new ResponseEntity<List<Customer>>(customerList, HttpStatus.OK);
	}

}
