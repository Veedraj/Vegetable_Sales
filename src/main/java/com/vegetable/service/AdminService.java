package com.vegetable.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.vegetable.entity.Customer;
import com.vegetable.entity.Order;
import com.vegetable.entity.Payment;
import com.vegetable.entity.Product;
import com.vegetable.exception.CustomerNotFoundException;
import com.vegetable.exception.InvalidProductDetailsException;
import com.vegetable.exception.OrderNotFoundException;
import com.vegetable.exception.PaymentNotFoundException;
import com.vegetable.exception.ProductNotFoundException;

public interface AdminService {
	
	public List<Order> allOrders()throws OrderNotFoundException;
	
	public Order viewOrder(long orderId)throws OrderNotFoundException;
	
	public List<Product> allProducts() throws ProductNotFoundException;

	public Product updateProductById(Product product) throws InvalidProductDetailsException;

	public List<Product> deleteProductById(Long productId)throws ProductNotFoundException;
	
	public List<Customer> allCustomers() throws CustomerNotFoundException;
	
	public Customer updateCustomerById(Customer customer);
	
	public List<Customer> deleteCustomerById(Long customerId);
	
	public List<Payment> allPayments() throws PaymentNotFoundException;
	
	public Payment updatePaymentById(Payment paymentId);
	
	public List<Payment> deletePaymentById(Long paymentId);
}
