package com.vegetable.service;

import java.util.List;

import com.vegetable.dto.PaymentDTO;
import com.vegetable.entity.Payment;

public interface PaymentService {
	public List<Payment> getAllPayments();

	public Payment addPayment(PaymentDTO payment);

	public Payment updatePayment(Payment payment);

	public Payment getPaymentById(Long paymentId);

	public List<Payment> deletePayment(Long paymentId);
}
