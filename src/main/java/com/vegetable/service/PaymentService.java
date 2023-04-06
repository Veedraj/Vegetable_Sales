package com.vegetable.service;

import java.util.List;

import com.vegetable.entity.Payment;

public interface PaymentService {
	public List<Payment> getAllPayments();

	public Payment addPayment(Payment payment);

	public Payment updatePayment(Payment payment);

	public Payment getPaymentById(Long paymentId);

	public List<Payment> deletePayment(Long paymentId);
}
