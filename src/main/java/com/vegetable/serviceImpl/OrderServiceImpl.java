package com.vegetable.serviceImpl;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vegetable.dto.OrderDTO;
import com.vegetable.entity.Order;
import com.vegetable.exception.DuplicateOrderFoundException;
import com.vegetable.exception.OrderNotFoundException;
import com.vegetable.repository.OrderRepository;
import com.vegetable.service.OrderService;

@Service
public class OrderServiceImpl implements OrderService{
	
	@Autowired
	private OrderRepository orderRepository;

	@Override
	public Order createOrder(OrderDTO order) throws DuplicateOrderFoundException {
		List<Order> list = this.getAllOrders();
		Order o = new Order(LocalDate.now(),order.getBillingAmount(),order.getStatus());
		for(Order l : list) {
			if(l.getBillingDate().equals(o.getBillingDate()) 
					&& l.getBillingAmount().equals(o.getBillingAmount())
					&& l.getStatus().equals(o.getStatus())) {
				throw new DuplicateOrderFoundException("Duplicate Order Found...");
			}
		}
		return orderRepository.save(o);
	}

	@Override
	public Order updateOrder(OrderDTO order,Long orderId) throws OrderNotFoundException {
		Order o = getOrderById(orderId);
		o.setBillingAmount(order.getBillingAmount());
		o.setStatus(order.getStatus());
		return orderRepository.save(o);
	}

	@Override
	public Order deleteOrder(Long orderId) throws OrderNotFoundException {
		Order o = getOrderById(orderId);
		orderRepository.delete(o);
		return o;
	}

	@Override
	public Order getOrderById(Long orderId) throws OrderNotFoundException {
		Optional<Order> o = orderRepository.findById(orderId);
		if(o.isEmpty()) {
			throw new OrderNotFoundException("Order Not Found...");
		}
		return o.get();
	}

	@Override
	public List<Order> getAllOrders() {
		return orderRepository.findAll();
	}
	
}
