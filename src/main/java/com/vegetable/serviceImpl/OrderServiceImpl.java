package com.vegetable.serviceImpl;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vegetable.dto.OrderDTO;
import com.vegetable.entity.Cart;
import com.vegetable.entity.Customer;
import com.vegetable.entity.Order;
import com.vegetable.exception.CartNotFoundException;
import com.vegetable.exception.CustomerNotFoundException;
import com.vegetable.exception.DuplicateOrderFoundException;
import com.vegetable.exception.EmptyCartException;
import com.vegetable.exception.OrderNotFoundException;
import com.vegetable.repository.CustomerRepository;
import com.vegetable.repository.OrderRepository;
import com.vegetable.service.OrderService;

@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	private OrderRepository orderRepository;

	@Autowired
	private CustomerRepository customerRepository;

	@Autowired
	private CartRepository cartRepository;

	@Autowired
	private CartService cartService;

	@Override
	public Order createOrder(OrderDTO order) throws DuplicateOrderFoundException {
		List<Order> list = this.getAllOrders();
		Order o = new Order(null, LocalDate.now(), order.getBillingAmount(), null, null, null, null);
		for (Order l : list) {
			if (l.getBillingDate().equals(o.getBillingDate()) && l.getBillingAmount().equals(o.getBillingAmount())) {
				throw new DuplicateOrderFoundException("Duplicate Order Found...");
			}
		}
		return orderRepository.save(o);
	}

	@Override
	public Order updateOrder(OrderDTO order, Long orderId) throws OrderNotFoundException {
		Order o = getOrderById(orderId);
		o.setBillingAmount(order.getBillingAmount());
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
		if (o.isEmpty()) {
			throw new OrderNotFoundException("Order Not Found...");
		}
		return o.get();
	}

	@Override
	public List<Order> getAllOrders() {
		return orderRepository.findAll();
	}

	@Override
	public Order convertCartToOrder(Long customerId)
			throws CustomerNotFoundException, EmptyCartException, CartNotFoundException {
		Optional<Customer> customer = this.customerRepository.findById(customerId);
		if (customer.isEmpty()) {
			throw new CustomerNotFoundException("Customer not Found with Id: " + customerId);
		}
		if (customer.get().getCart().getCartItems().size() == 0) {
			throw new EmptyCartException("Cart is Empty");
		}
		Order order = null;
		List<Order> customerOrders = customer.get().getOrders();
		customerOrders.add(order);
		customer.get().setOrders(customerOrders);
		customer.get().setCart(new Cart());
		this.customerRepository.save(customer.get());
		return order;
	}

	@Override
	public Order getOrderByCustomerEmail(String custEmailId) throws CustomerNotFoundException, OrderNotFoundException {
		Customer customer = this.customerRepository.findByCustomerEmail(custEmailId);
		if(customer == null) {
			throw new CustomerNotFoundException("Customer Not Found with Email Id: "+custEmailId);
		}
		if(customer.getOrders().size()==0) {
			throw new OrderNotFoundException("No Orders For Customer with Email Id: "+custEmailId);
		}
		return customer.getOrders().get(customer.getOrders().size()-1);
	}
}
