package com.vegetable.service;

import java.util.List;

import com.vegetable.entity.Order;
import com.vegetable.entity.Product;
import com.vegetable.exception.OrderNotFoundException;
import com.vegetable.exception.ProductAlreadyExistException;
import com.vegetable.exception.ProductNotFoundException;

public interface AdminService {
	
	public List<Order> allOrders()throws OrderNotFoundException;
	
	public Order viewOrder(long orderId)throws OrderNotFoundException;
	
	public List<Product> allProducts() throws ProductNotFoundException;

	public Product updateProduct(Product product) throws ProductAlreadyExistException;

	public List<Product> deleteProductById(Long productId)throws ProductNotFoundException;
}
