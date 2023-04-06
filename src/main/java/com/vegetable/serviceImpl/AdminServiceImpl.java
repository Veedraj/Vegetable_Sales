package com.vegetable.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vegetable.entity.Order;
import com.vegetable.entity.Product;
import com.vegetable.exception.OrderNotFoundException;
import com.vegetable.exception.ProductAlreadyExistException;
import com.vegetable.exception.ProductNotFoundException;
import com.vegetable.repository.OrderRepository;
import com.vegetable.repository.ProductRepository;
import com.vegetable.service.AdminService;

@Service
public class AdminServiceImpl implements AdminService {
	
	@Autowired
	OrderRepository orderRepository;
	
	@Autowired
	ProductRepository productRepository;
	
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
	public Product updateProduct(Product product) throws ProductAlreadyExistException {
		return productRepository.save(product);
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

	
}
