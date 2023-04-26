package com.vegetable.serviceImpl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.vegetable.entity.Customer;
import com.vegetable.entity.Order;
import com.vegetable.entity.Payment;
import com.vegetable.entity.Product;
import com.vegetable.exception.CustomerNotFoundException;
import com.vegetable.exception.OrderNotFoundException;
import com.vegetable.exception.PaymentNotFoundException;
import com.vegetable.exception.ProductNotFoundException;
import com.vegetable.repository.CustomerRepository;
import com.vegetable.repository.OrderRepository;
import com.vegetable.repository.PaymentRepository;
import com.vegetable.repository.ProductRepository;
import com.vegetable.service.AdminService;

@Service
public class AdminServiceImpl implements AdminService {
	
	@Autowired
	OrderRepository orderRepository;
	
	@Autowired
	ProductRepository productRepository;
	
	@Autowired
	CustomerRepository customerRepository;
	
	@Autowired
	PaymentRepository paymentRepository;
	
	@Override
	public List<Order> allOrders() throws OrderNotFoundException {
		
		return orderRepository.findAll();
	}

	
	@Override
	public Order viewOrder(long orderId) throws OrderNotFoundException {
		if(orderRepository.existsById(orderId))
		{
			System.out.println("User found with "+orderId);
			return orderRepository.findById(orderId).get();
			
		}
		System.out.println("No user exists with id "+orderId);
		throw new OrderNotFoundException("No user found with id "+orderId);
	}


	@Override
	public List<Product> allProducts() throws ProductNotFoundException {
		
		return productRepository.findAll();
	}


	@Override
	public Product updateProductById(Product productId) {
		return productRepository.save(productId);
	}


	@Override
	public List<Product> deleteProductById(Long productId) throws ProductNotFoundException {
		try {
			productRepository.deleteById(productId);
			return productRepository.findAll();
		}catch (Exception e){
			throw new ProductNotFoundException("No such product found");
		}
	}


	@Override
	public List<Customer> allCustomers() throws CustomerNotFoundException {
		return customerRepository.findAll();
	}


	@Override
	public Customer updateCustomerById(Customer customerId) {
		return customerRepository.save(customerId);
	}


	@Override
	public List<Customer> deleteCustomerById(Long customerId) {
		customerRepository.deleteById(customerId);
		return customerRepository.findAll();
	}


	@Override
	public List<Payment> allPayments() throws PaymentNotFoundException {
	
		return paymentRepository.findAll();
	}


	@Override
	public Payment updatePaymentById(Payment paymentId) {
		
		return paymentRepository.save(paymentId);
	}


	@Override
	public List<Payment> deletePaymentById(Long paymentId) {
		paymentRepository.deleteById(paymentId);
		return paymentRepository.findAll();
	}
	
	
	
}
