package com.vegetable.entity;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;


@Entity
@Table( name = "orders")
public class Order implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="order_id")
	private long orderId;
	
	@NotNull
	@Column(name="billing_date")
	private LocalDate billingDate;
	
	@NotNull
	@Column(name="billing_amount")
	private Double billingAmount;
	
	public Order() {
		super();
	}

	public Order(LocalDate billingDate, Double billingAmount) {
		super();
		this.billingDate = billingDate;
		this.billingAmount = billingAmount;
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
	
	public Long getId() {
		return orderId;
	}
	
	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", billingDate=" + billingDate + ", billingAmount=" + billingAmount + "]";
	}
	
}
