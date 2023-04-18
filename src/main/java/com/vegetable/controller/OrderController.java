package com.vegetable.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vegetable.dto.OrderDTO;
import com.vegetable.entity.Customer;
import com.vegetable.entity.Order;
import com.vegetable.exception.CartNotFoundException;
import com.vegetable.exception.CustomerNotFoundException;
import com.vegetable.exception.DuplicateOrderFoundException;
import com.vegetable.exception.EmptyCartException;
import com.vegetable.exception.OrderNotFoundException;
import com.vegetable.service.OrderService;

@RestController
@RequestMapping("/order-section")
@CrossOrigin(origins = "http://localhost:4200")
public class OrderController {

	@Autowired
	private OrderService orderService;

	@PostMapping("/order")
	public ResponseEntity<Order> postOrder(@Valid @RequestBody OrderDTO order) throws DuplicateOrderFoundException {
		Order orderCreated = orderService.createOrder(order);
		return new ResponseEntity<Order>(orderCreated, HttpStatus.OK);
	}

	@PutMapping("/order/{order-id}")
	public ResponseEntity<Order> putOrder(@Valid @RequestBody OrderDTO order, @PathVariable("order-id") Long orderId)
			throws OrderNotFoundException {
		Order orderCreated = orderService.updateOrder(order, orderId);
		return new ResponseEntity<Order>(orderCreated, HttpStatus.OK);
	}

	@DeleteMapping("/order/{order-id}")
	public ResponseEntity<Order> deleteOrder(@PathVariable("order-id") Long orderId) throws OrderNotFoundException {
		Order orderCreated = orderService.deleteOrder(orderId);
		return new ResponseEntity<Order>(orderCreated, HttpStatus.OK);
	}

	@GetMapping("/order/{order-id}")
	public ResponseEntity<Order> postOrder(@PathVariable("order-id") Long orderId) throws OrderNotFoundException {
		Order orderCreated = orderService.getOrderById(orderId);
		return new ResponseEntity<Order>(orderCreated, HttpStatus.OK);
	}

	@GetMapping("/orders")
	public ResponseEntity<List<Order>> postOrder() {
		List<Order> orderCreated = orderService.getAllOrders();
		return new ResponseEntity<List<Order>>(orderCreated, HttpStatus.OK);
	}

	@PostMapping("/convert-cart-to-order/{customer-id}")
	public ResponseEntity<Order> convertCartToOrder(@PathVariable("customer-id") Long customerId)
			throws CustomerNotFoundException, EmptyCartException, CartNotFoundException {
		Order orderCreated = this.orderService.convertCartToOrder(customerId);
		return new ResponseEntity<Order>(orderCreated, HttpStatus.OK);
	}
	
	@GetMapping("/order-by-email/{customer-email-id}")
	public ResponseEntity<Order> getCustomerOrderByEmailId(@PathVariable("customer-email-id") String customerid)
			throws CustomerNotFoundException, OrderNotFoundException {
		return new ResponseEntity<Order>(orderService.getOrderByCustomerEmail(customerid), HttpStatus.OK);
	}
}
