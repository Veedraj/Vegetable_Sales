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
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonManagedReference;


@Entity
@Table(name = "CART")

public class Cart {
	
	@Id
	@NotNull
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long cartId;
	
	 @Min(value = 0, message = "Total amount cannot be less than 0")
	    @NotNull(message = "Total amount should not be null")
	    private Double totalAmount;
	
	 	@JsonManagedReference
	    @OneToMany(mappedBy = "cart", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	    private List<CartItem> cartItems= new ArrayList<>();
	 
	public Long getCartId() {
		return cartId;
	}

	@Override
	public String toString() {
		return "Cart [cartId=" + cartId + ", totalAmount=" + totalAmount + ", cartItems=" + cartItems + "]";
	}

	public Cart() {
		super();
	}

	public Cart(@NotNull Long cartId,
			@Min(value = 0, message = "Total amount cannot be less than 0") @NotNull(message = "Total amount should not be null") Double totalAmount,
			List<CartItem> cartItems) {
		super();
		this.cartId = cartId;
		this.totalAmount = totalAmount;
		this.cartItems = cartItems;
	}

	public Double getTotalAmount() {
		return totalAmount;
	}

	public List<CartItem> getCartItems() {
		return cartItems;
	}

	public void setCartId(Long cartId) {
		this.cartId = cartId;
	}

	public void setTotalAmount(Double totalAmount) {
		this.totalAmount = totalAmount;
	}

	public void setCartItems(List<CartItem> cartItems) {
		this.cartItems = cartItems;
	}

}

