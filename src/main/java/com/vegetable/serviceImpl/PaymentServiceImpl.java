package com.vegetable.serviceImpl;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vegetable.dto.PaymentDTO;
import com.vegetable.entity.Order;
import com.vegetable.entity.Payment;
import com.vegetable.exception.CustomerNotFoundException;
import com.vegetable.exception.EmptyCartException;
import com.vegetable.exception.PaymentNotFoundException;
import com.vegetable.repository.OrderRepository;
import com.vegetable.repository.PaymentRepository;
import com.vegetable.service.OrderService;
import com.vegetable.service.PaymentService;

@Service
public class PaymentServiceImpl implements PaymentService {

	@Autowired
	private PaymentRepository paymentRepo;

	@Autowired
	private OrderService orderService;

	@Autowired
	private OrderRepository orderRepository;

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
			throws CustomerNotFoundException, EmptyCartException {
		Payment newPayment = new Payment();
		newPayment.setPaymentDate(LocalDate.now());
		newPayment.setPaymentTime(LocalTime.now());
		newPayment.setPaymentType(payment.getType());
		Order order = orderService.convertCartToOrder(customerId);
		order.setPayment(newPayment);
		return orderRepository.save(order);
	}
}
