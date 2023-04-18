package com.vegetable.service;

import java.util.List;

import com.vegetable.dto.PaymentDTO;
import com.vegetable.entity.Order;
import com.vegetable.entity.Payment;
import com.vegetable.exception.CartNotFoundException;
import com.vegetable.exception.CustomerNotFoundException;
import com.vegetable.exception.EmptyCartException;
import com.vegetable.exception.PaymentNotFoundException;

public interface PaymentService {
	public List<Payment> getAllPayments();

	public Payment addPayment(PaymentDTO payment);

	public Payment updatePayment(Payment payment) throws PaymentNotFoundException;

	public Payment getPaymentById(Long paymentId);

	public List<Payment> deletePayment(Long paymentId);

	public Order convertOrderToPayment(PaymentDTO payment, Long customerId)
			throws CustomerNotFoundException, EmptyCartException, CartNotFoundException;
}
