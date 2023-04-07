package com.vegetable.controller;

import java.util.List;

import javax.validation.Valid;

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

import com.vegetable.dto.PaymentDTO;
import com.vegetable.entity.Payment;
import com.vegetable.exception.PaymentNotFoundException;
import com.vegetable.service.PaymentService;

@RestController
@RequestMapping("/api/v1")
public class PaymentController {

	@Autowired
	private PaymentService paymentService;

	@GetMapping("/payment")
	public ResponseEntity<List<Payment>> getAllPayments() {
		return new ResponseEntity<List<Payment>>(paymentService.getAllPayments(), HttpStatus.OK);
	}

	@PostMapping("/payment")
	public ResponseEntity<Payment> addPayment(@Valid @RequestBody PaymentDTO payment) {
		return new ResponseEntity<Payment>(paymentService.addPayment(payment), HttpStatus.OK);
	}

	@PutMapping("/payment")
	public ResponseEntity<Payment> updatePayment(@Valid @RequestBody Payment payment) throws PaymentNotFoundException {
		return new ResponseEntity<Payment>(paymentService.updatePayment(payment), HttpStatus.OK);
	}

	@GetMapping("payment/{paymentId}")
	public ResponseEntity<Payment> getPaymentById(@PathVariable("paymentId") Long paymentId) {
		return new ResponseEntity<Payment>(paymentService.getPaymentById(paymentId), HttpStatus.OK);
	}

	@DeleteMapping("payment/{paymentId}")
	public ResponseEntity<List<Payment>> deletePayment(@PathVariable("paymentId") Long paymentId) {
		List<Payment> paymentList = paymentService.deletePayment(paymentId);
		return new ResponseEntity<List<Payment>>(paymentList, HttpStatus.OK);
	}

}
