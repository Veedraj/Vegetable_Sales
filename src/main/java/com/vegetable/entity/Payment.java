package com.vegetable.entity;

import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class Payment {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long paymentId;
	@NotNull(message = "Payment date cannot be null.")
	private LocalDate paymentDate;
	@NotNull(message = "Payment time cannot be null.")
	private LocalTime paymentTime;
	@NotNull(message = "Payment type cannot be null.")
	private Type paymentType;

	public Payment() {
		super();
	}

	public Payment(Long paymentId, LocalDate paymentDate, LocalTime paymentTime, Type paymentType) {
		super();
		this.paymentId = paymentId;
		this.paymentDate = paymentDate;
		this.paymentTime = paymentTime;
		this.paymentType = paymentType;
	}

	public Long getPaymentId() {
		return paymentId;
	}

	public void setPaymentId(Long paymentId) {
		this.paymentId = paymentId;
	}

	public LocalDate getPaymentDate() {
		return paymentDate;
	}

	public void setPaymentDate(LocalDate paymentDate) {
		this.paymentDate = paymentDate;
	}

	public LocalTime getPaymentTime() {
		return paymentTime;
	}

	public void setPaymentTime(LocalTime paymentTime) {
		this.paymentTime = paymentTime;
	}

	public Type getPaymentType() {
		return paymentType;
	}

	public void setPaymentType(Type paymentType) {
		this.paymentType = paymentType;
	}

}
