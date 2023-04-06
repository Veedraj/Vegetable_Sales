package com.vegetable.service;

import java.util.List;

import com.vegetable.entity.Payment;
import com.vegetable.exception.PaymentNotFoundException;

public interface PaymentService {
	public List<Payment> getAllPayments();

	public Payment addPayment(Payment payment);

	public Payment updatePayment(Payment payment) throws PaymentNotFoundException ;

	public Payment getPaymentById(Long paymentId);

	public List<Payment> deletePayment(Long paymentId);
}
