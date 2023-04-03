package com.vegetable.entity;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

enum Status{
	Success, Fail
}

@Entity
@Table(name = "Order")
public class Order implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	@NotBlank
	private LocalDate billingDate;
	
	@NotNull
	@NotBlank
	private Double billingAmount;
	
	@NotNull
	@NotBlank
	private Status status;
	
	public Order() {
		super();
	}

	public Order(LocalDate billingDate, Double billingAmount, Status status) {
		super();
		this.billingDate = billingDate;
		this.billingAmount = billingAmount;
		this.status = status;
	}

	public LocalDate getBillingDate() {
		return billingDate;
	}

	public void setBillingDate(LocalDate billingDate) {
		this.billingDate = billingDate;
	}

	public Double getBillingAmount() {
		return billingAmount;
	}

	public void setBillingAmount(Double billingAmount) {
		this.billingAmount = billingAmount;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}
	
	public Long getId() {
		return id;
	}
	
	@Override
	public String toString() {
		return "Order [id=" + id + ", billingDate=" + billingDate + ", billingAmount=" + billingAmount + ", status="
				+ status + "]";
	}
	
}
