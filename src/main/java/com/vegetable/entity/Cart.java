package com.vegetable.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "CART")
public class Cart {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long cartId;

	@Min(value = 0, message = "Total amount cannot be less than 0")
	@NotNull(message = "Total amount should not be null")
	private Double totalAmount = 0.0;

	@JsonBackReference
	@OneToOne(mappedBy = "cart", fetch = FetchType.LAZY)
	private Customer customer;

	@JsonManagedReference
	@OneToMany(mappedBy = "cart", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<CartItem> cartItems = new ArrayList<>();

	public Cart() {
		super();
	}

	public Cart(Long cartId,
			@Min(value = 0, message = "Total amount cannot be less than 0") @NotNull(message = "Total amount should not be null") Double totalAmount,
			Customer customer, List<CartItem> cartItems) {
		super();
		this.cartId = cartId;
		this.totalAmount = totalAmount;
		this.customer = customer;
		this.cartItems = cartItems;
	}

	public Long getCartId() {
		return cartId;
	}

	public void setCartId(Long cartId) {
		this.cartId = cartId;
	}

	public Double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(Double totalAmount) {
		this.totalAmount = totalAmount;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public List<CartItem> getCartItems() {
		return cartItems;
	}

	public void setCartItems(List<CartItem> cartItems) {
		this.cartItems = cartItems;
	}

	@Override
	public String toString() {
		return "Cart [cartId=" + cartId + ", totalAmount=" + totalAmount + ", customer=" + customer + ", cartItems="
				+ cartItems + "]";
	}

}
