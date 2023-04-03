package com.vegetable.serviceImpl;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vegetable.entity.Order;
import com.vegetable.exception.OrderNotFoundException;
import com.vegetable.repository.OrderRepository;
import com.vegetable.service.OrderService;

@Service
public class OrderServiceImpl implements OrderService{
	
	@Autowired
	private OrderRepository orderRepository;

	@Override
	public Order createOrder(Order order) {
		return orderRepository.save(order);
	}

	@Override
	public Order updateOrder(Order order) throws OrderNotFoundException {
		Order o = getOrderById(order.getId());
		o.setBillingDate(order.getBillingDate());
		o.setBillingAmount(order.getBillingAmount());
		o.setStatus(order.getStatus());
		return orderRepository.save(o);
	}

	@Override
	public Order deleteOrder(Order order) throws OrderNotFoundException {
		Order o = getOrderById(order.getId());
		orderRepository.delete(o);
		return o;
	}

	@Override
	public Order getOrderById(Long orderId) throws OrderNotFoundException {
		Optional<Order> o = orderRepository.findById(orderId);
		return o.get();
	}

	@Override
	public List<Order> getAllOrders() {
		return orderRepository.findAll();
	}
	
}
