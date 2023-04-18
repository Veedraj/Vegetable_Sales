package com.vegetable.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vegetable.entity.Customer;
import com.vegetable.entity.Order;
import com.vegetable.entity.Payment;
import com.vegetable.entity.Product;
import com.vegetable.exception.CustomerNotFoundException;
import com.vegetable.exception.OrderNotFoundException;
import com.vegetable.exception.PaymentNotFoundException;
import com.vegetable.exception.ProductNotFoundException;
import com.vegetable.service.AdminService;

@RestController
@RequestMapping("/admin")
@CrossOrigin(origins = "http://localhost:4200/")
public class AdminController {

	@Autowired
	AdminService adminService;

	@GetMapping("/view/orders")
	public List<Order> allOrders() throws OrderNotFoundException {
		return adminService.allOrders();
	}

	@GetMapping("/view/order/{orderId}")
	public Order viewOrder(@PathVariable("orderId") long orderId) throws OrderNotFoundException {
		return adminService.viewOrder(orderId);
	}

	@GetMapping("/view/products")
	public List<Product> allProducts() throws ProductNotFoundException {
		return adminService.allProducts();
	}

	@PutMapping("update/products/{productId}")
	public ResponseEntity<Product> updateproduct(@RequestBody Product productId) {
		return new ResponseEntity<Product>(adminService.updateProductById(productId), HttpStatus.OK);
	}

	@DeleteMapping("delete/products/{productId}")
	public ResponseEntity<List<Product>> deleteProductById(@PathVariable("productId") Long productId)
			throws ProductNotFoundException {
		List<Product> productList = adminService.deleteProductById(productId);
		return new ResponseEntity<List<Product>>(productList, HttpStatus.OK);
	}

	@GetMapping("/view/customers")
	public List<Customer> allCustomers() throws CustomerNotFoundException {
		return adminService.allCustomers();
	}

	@PutMapping("update/customers/{customerId}")
	public ResponseEntity<Customer> updateCustomer(@RequestBody Customer customerId) {
		return new ResponseEntity<Customer>(adminService.updateCustomerById(customerId), HttpStatus.OK);
	}

	@DeleteMapping("delete/customer/{customerId}")
	public ResponseEntity<List<Customer>> deleteCustomerById(@PathVariable("customerId") Long customerId)
			throws CustomerNotFoundException {
		List<Customer> customerList = adminService.deleteCustomerById(customerId);
		return new ResponseEntity<List<Customer>>(customerList, HttpStatus.OK);
	}

	@GetMapping("/view/payments")
	public List<Payment> allPayments() throws PaymentNotFoundException {
		return adminService.allPayments();
	}

	@PutMapping("update/payments/{paymentId}")
	public ResponseEntity<Payment> updatePayments(@RequestBody Payment paymentId) {
		return new ResponseEntity<Payment>(adminService.updatePaymentById(paymentId), HttpStatus.OK);
	}

	@DeleteMapping("delete/payments/{paymentId}")
	public ResponseEntity<List<Payment>> deletePaymentById(@PathVariable("paymentId") Long paymentId)
			throws PaymentNotFoundException {
		List<Payment> paymentList = adminService.deletePaymentById(paymentId);
		return new ResponseEntity<List<Payment>>(paymentList, HttpStatus.OK);
	}

}