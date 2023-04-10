package com.vegetable.service;

import java.util.List;

import com.vegetable.dto.OrderDTO;
import com.vegetable.entity.Order;
import com.vegetable.exception.DuplicateOrderFoundException;
import com.vegetable.exception.OrderNotFoundException;

public interface OrderService {
	
	// CRUD
	public Order createOrder(OrderDTO order) throws DuplicateOrderFoundException;
	public Order updateOrder(OrderDTO order,Long orderId) throws OrderNotFoundException;
	public Order deleteOrder(Long orderId) throws OrderNotFoundException;
	public Order getOrderById(Long orderId) throws OrderNotFoundException;
	public List<Order> getAllOrders();

}
