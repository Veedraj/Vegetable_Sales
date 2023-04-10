package com.vegetable.entity;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "orders")
public class Order {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "order_id")
	private Long orderId;

	@NotNull
	@Column(name = "billing_date")
	private LocalDate billingDate;

	@NotNull
	@Column(name = "billing_amount")
	private Double billingAmount;

	@JsonBackReference
	@ManyToOne
	@JoinColumn(name = "customerId")
	private Customer customer;

	@JsonManagedReference
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "payment_id")
	private Payment payment;

	public Order() {
		super();
	}

	public Order(Long orderId, @NotNull LocalDate billingDate, @NotNull Double billingAmount, Customer customer,
			Payment payment) {
		super();
		this.orderId = orderId;
		this.billingDate = billingDate;
		this.billingAmount = billingAmount;
		this.customer = customer;
		this.payment = payment;
	}

	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
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

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Payment getPayment() {
		return payment;
	}

	public void setPayment(Payment payment) {
		this.payment = payment;
	}

	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", billingDate=" + billingDate + ", billingAmount=" + billingAmount
				+ ", customer=" + customer + ", payment=" + payment + "]";
	}

}
