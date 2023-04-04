package com.vegetable.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vegetable.entity.Order;
import com.vegetable.exception.OrderNotFoundException;
import com.vegetable.service.OrderService;

@RestController
@RequestMapping("/order_section")
public class OrderController{

	@Autowired
	private OrderService orderService;
	
	@PostMapping("/order")
	public ResponseEntity<Order> postOrder(@RequestBody Order order){
		Order o = orderService.createOrder(order);
		return new ResponseEntity<Order>(o, HttpStatus.OK);
	}
	
	@PutMapping("/order")
	public ResponseEntity<Order> putOrder(@RequestBody Order order) throws OrderNotFoundException{
		Order o = orderService.updateOrder(order);
		return new ResponseEntity<Order>(o, HttpStatus.OK);
	}
	
	@DeleteMapping("/order")
	public ResponseEntity<Order> deleteOrder(@RequestBody Order order) throws OrderNotFoundException{
		Order o = orderService.deleteOrder(order);
		return new ResponseEntity<Order>(o, HttpStatus.OK);
	}
	
	@GetMapping("/order/{orderId}")
	public ResponseEntity<Order> postOrder(@PathVariable("orderId") Long orderId) throws OrderNotFoundException{
		Order o = orderService.getOrderById(orderId);
		return new ResponseEntity<Order>(o, HttpStatus.OK);
	}
	
	@GetMapping("/orders")
	public ResponseEntity<List<Order>> postOrder(){
		List<Order> o = orderService.getAllOrders();
		return new ResponseEntity<List<Order>>(o, HttpStatus.OK);
	}
	
}
