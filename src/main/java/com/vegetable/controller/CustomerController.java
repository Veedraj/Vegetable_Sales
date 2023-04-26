package com.vegetable.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vegetable.config.JwtUtil;
import com.vegetable.dto.AuthenticationTokenDTO;
import com.vegetable.dto.CustomerDTO;
import com.vegetable.dto.CustomerLoginDTO;
import com.vegetable.entity.Customer;
import com.vegetable.exception.CustomerAlreadyExistsException;
import com.vegetable.exception.CustomerNotFoundException;
import com.vegetable.exception.WrongPasswordException;
import com.vegetable.service.CustomerService;

@RestController
@RequestMapping("/customer-section")
@CrossOrigin(origins = "http://localhost:4200")
public class CustomerController {

	@Autowired
	private CustomerService customerService;

	@Autowired
	private JwtUtil jwtUtil;

	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	@Autowired
	private AuthenticationManager authenticationManager;

	@PostMapping("/login")
	public ResponseEntity<AuthenticationTokenDTO> generateToken(@RequestBody CustomerLoginDTO authRequest)
			throws Exception {
		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authRequest.getCustomerEmail(),
					authRequest.getCustomerPassword()));
		} catch (Exception ex) {
			throw new WrongPasswordException("Inavalid Username/Password");
		}
		AuthenticationTokenDTO authenticationTokenDTO = new AuthenticationTokenDTO(
				jwtUtil.generateToken(authRequest.getCustomerEmail()));
		return new ResponseEntity<AuthenticationTokenDTO>(authenticationTokenDTO, HttpStatus.OK);
	}

	@PostMapping("customer-registration")
	public ResponseEntity<AuthenticationTokenDTO> registerCustomer(@Valid @RequestBody CustomerDTO customer)
			throws Exception {
		String password = customer.getCustomerPassword();
		customer.setCustomerPassword(bCryptPasswordEncoder.encode(customer.getCustomerPassword()));
		Customer cust = customerService.registerCustomer(customer);
		ResponseEntity<AuthenticationTokenDTO> authenticationTokenDTO = null;
		if (cust != null) {
			CustomerLoginDTO regCustomer = new CustomerLoginDTO(customer.getCustomerEmail(), password);
			authenticationTokenDTO = this.generateToken(regCustomer);
		}
		return authenticationTokenDTO;
	}

	@GetMapping("/customers")
	public ResponseEntity<List<Customer>> getAllCustomers() {
		return new ResponseEntity<List<Customer>>(customerService.getAllCustomers(), HttpStatus.OK);
	}

	@PostMapping("/customer")
	public ResponseEntity<Customer> addCustomer(@Valid @RequestBody CustomerDTO customer)
			throws CustomerAlreadyExistsException {
		return new ResponseEntity<Customer>(customerService.addCustomer(customer), HttpStatus.OK);
	}

	@PutMapping("/customer")
	public ResponseEntity<Customer> updateCustomer(@Valid @RequestBody Customer customer)
			throws CustomerNotFoundException {
		return new ResponseEntity<Customer>(customerService.updateCustomer(customer), HttpStatus.OK);
	}

	@GetMapping("/customer/{customer-id}")
	public ResponseEntity<Customer> getCustomerById(@PathVariable("customer-id") Long customerId)
			throws CustomerNotFoundException {
		return new ResponseEntity<Customer>(customerService.getCustomerById(customerId), HttpStatus.OK);
	}

	@GetMapping("/customer/by-email/{customer-email}")
	public ResponseEntity<Customer> getCustomerByEmail(@PathVariable("customer-email") String customerEmail)
			throws CustomerNotFoundException {
		return new ResponseEntity<Customer>(customerService.getCustomerByEmail(customerEmail), HttpStatus.OK);
	}

	@DeleteMapping("customer/{customer-id}")
	public ResponseEntity<List<Customer>> deleteCustomer(@PathVariable("customer-id") Long customerId) {
		List<Customer> customerList = customerService.deleteCustomer(customerId);
		return new ResponseEntity<List<Customer>>(customerList, HttpStatus.OK);
	}

	@GetMapping("customer/check-address/{customer-email-id}")
	public ResponseEntity<Boolean> getCustomerAddress(@PathVariable("customer-email-id") String customerEmailId)
			throws CustomerNotFoundException {
		Boolean response = this.customerService.checkAddress(customerEmailId);
		return new ResponseEntity<Boolean>(response, HttpStatus.OK);
	}

}
