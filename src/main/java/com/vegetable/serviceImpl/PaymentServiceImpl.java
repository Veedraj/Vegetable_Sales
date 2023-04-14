package com.vegetable.serviceImpl;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vegetable.dto.PaymentDTO;
import com.vegetable.entity.CartItem;
import com.vegetable.entity.Customer;
import com.vegetable.entity.Order;
import com.vegetable.entity.PastCartItem;
import com.vegetable.entity.Payment;
import com.vegetable.exception.CartNotFoundException;
import com.vegetable.exception.CustomerNotFoundException;
import com.vegetable.exception.EmptyCartException;
import com.vegetable.exception.PaymentNotFoundException;
import com.vegetable.repository.CustomerRepository;
import com.vegetable.repository.OrderRepository;
import com.vegetable.repository.PaymentRepository;
import com.vegetable.service.CartService;
import com.vegetable.service.PaymentService;

@Service
public class PaymentServiceImpl implements PaymentService {

	@Autowired
	private PaymentRepository paymentRepo;

	@Autowired
	private OrderRepository orderRepository;

	@Autowired
	private CustomerRepository customerRepository;

	@Autowired
	private CartService cartService;

	@Override
	public List<Payment> getAllPayments() {
		List<Payment> paymentList = paymentRepo.findAll();
		return paymentList;
	}

	@Override
	public Payment addPayment(PaymentDTO payment) {
		Payment newPayment = new Payment(null, LocalDate.now(), LocalTime.now(), payment.getType(), null);
		return paymentRepo.save(newPayment);
	}

	@Override
	public Payment updatePayment(Payment payment) throws PaymentNotFoundException {
		if (paymentRepo.findById(payment.getPaymentId()).isEmpty()) {
			throw new PaymentNotFoundException("Payment Not Found with Id: " + payment.getPaymentId());
		}
		Payment updatedPayment = paymentRepo.save(payment);
		return updatedPayment;
	}

	@Override
	public Payment getPaymentById(Long paymentId) {
		Payment payment = paymentRepo.findById(paymentId).get();
		return payment;
	}

	@Override
	public List<Payment> deletePayment(Long paymentId) {
		paymentRepo.deleteById(paymentId);
		return paymentRepo.findAll();
	}

	@Override
	public Order convertOrderToPayment(PaymentDTO payment, Long customerId)
			throws CustomerNotFoundException, EmptyCartException, CartNotFoundException {
		Payment newPayment = new Payment();
		newPayment.setPaymentDate(LocalDate.now());
		newPayment.setPaymentTime(LocalTime.now());
		newPayment.setPaymentType(payment.getType());
		Optional<Customer> customer = this.customerRepository.findById(customerId);
		if (customer.isEmpty()) {
			throw new CustomerNotFoundException("Customer not Found with Id: " + customerId);
		}
		if (customer.get().getCart().getCartItems().size() == 0) {
			throw new EmptyCartException("Empty Cart");
		}
		List<PastCartItem> customerCart = new ArrayList<>();
		for (CartItem c : customer.get().getCart().getCartItems()) {
			customerCart.add(new PastCartItem(c.getCartItemName(), c.getCartItemPrice(), c.getCartItemQuantity(),
					c.getCartItemImage()));
		}
		Order order = new Order(null, LocalDate.now(), customer.get().getCart().getTotalAmount(),
				customer.get().getCustomerAddress(), customer.get(), newPayment, customerCart);
//		customer.get().setCart(new Cart());
		this.cartService.removeAllFromCart(customer.get().getCart().getCartId());
		this.customerRepository.save(customer.get());
		Order newOrder = orderRepository.save(order);
		customer.get().getOrders().add(newOrder);
		return newOrder;
	}
}
