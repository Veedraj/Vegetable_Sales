package com.vegetable.serviceImpl;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vegetable.dto.PaymentDTO;
import com.vegetable.entity.Payment;
import com.vegetable.exception.PaymentNotFoundException;
import com.vegetable.repository.PaymentRepo;
import com.vegetable.service.PaymentService;

@Service
public class PaymentServiceImpl implements PaymentService {

	@Autowired
	private PaymentRepo paymentRepo;

	@Override
	public List<Payment> getAllPayments() {
		List<Payment> paymentList = paymentRepo.findAll();
		return paymentList;
	}

	@Override
	public Payment addPayment(PaymentDTO payment) {
		Payment newPayment = new Payment(0l, LocalDate.now(), LocalTime.now(), payment.getType());
		return paymentRepo.save(newPayment);
	}

	@Override
	public Payment updatePayment(Payment payment) throws PaymentNotFoundException {
		if(paymentRepo.findById(payment.getPaymentId()).isEmpty()) {
			throw new PaymentNotFoundException("Payment Not Found with Id: "+payment.getPaymentId());
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

}
