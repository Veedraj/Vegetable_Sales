package com.vegetable.dto;

import javax.validation.constraints.NotNull;

import com.vegetable.entity.Status;

public class OrderDTO {

	@NotNull
	private Double billingAmount;

	@NotNull
	private Status status;

	public OrderDTO() {
		super();
	}

	public OrderDTO(@NotNull Double billingAmount, @NotNull Status status) {
		super();
		this.billingAmount = billingAmount;
		this.status = status;
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

	@Override
	public String toString() {
		return "OrderDTO [billingAmount=" + billingAmount + ", status=" + status + "]";
	}
}
