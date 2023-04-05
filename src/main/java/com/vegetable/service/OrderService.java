package com.vegetable.service;

import java.util.List;

import com.vegetable.entity.Order;
import com.vegetable.exception.DuplicateOrderFoundException;
import com.vegetable.exception.OrderNotFoundException;

public interface OrderService {
	
	// CRUD
	public Order createOrder(Order order) throws DuplicateOrderFoundException;
	public Order updateOrder(Order order,Long orderId) throws OrderNotFoundException;
	public Order deleteOrder(Long orderId) throws OrderNotFoundException;
	public Order getOrderById(Long orderId) throws OrderNotFoundException;
	public List<Order> getAllOrders();

}
