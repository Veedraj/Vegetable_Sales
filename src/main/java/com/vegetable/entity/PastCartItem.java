package com.vegetable.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Entity
public class PastCartItem {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long pastCartItemId;

	@NotNull(message = "Item name cannot be null")
	private String cartItemName;

	@NotNull(message = "Items price cannot be null")
	@Min(value = 1, message = "Price should be greater than Zero")
	private Double cartItemPrice;

	@NotNull(message = "Quantity Should be Greater Than Zero")
	@Min(value = 0, message = "Quantity should be greater than 0")
	private Integer cartItemQuantity;

	@NotNull(message = "Items image cannot be null")
	private String cartItemImage;
	
	public PastCartItem() {
		super();
	}

	public PastCartItem(@NotNull(message = "Item name cannot be null") String cartItemName,
			@NotNull(message = "Items price cannot be null") @Min(value = 1, message = "Price should be greater than Zero") Double cartItemPrice,
			@NotNull(message = "Quantity Should be Greater Than Zero") @Min(value = 0, message = "Quantity should be greater than 0") Integer cartItemQuantity,
			@NotNull(message = "Items image cannot be null") String cartItemImage) {
		super();
		this.cartItemName = cartItemName;
		this.cartItemPrice = cartItemPrice;
		this.cartItemQuantity = cartItemQuantity;
		this.cartItemImage = cartItemImage;
	}

	public Long getPastCartItemId() {
		return pastCartItemId;
	}

	public void setPastCartItemId(Long pastCartItemId) {
		this.pastCartItemId = pastCartItemId;
	}

	public String getCartItemName() {
		return cartItemName;
	}

	public void setCartItemName(String cartItemName) {
		this.cartItemName = cartItemName;
	}

	public Double getCartItemPrice() {
		return cartItemPrice;
	}

	public void setCartItemPrice(Double cartItemPrice) {
		this.cartItemPrice = cartItemPrice;
	}

	public Integer getCartItemQuantity() {
		return cartItemQuantity;
	}

	public void setCartItemQuantity(Integer cartItemQuantity) {
		this.cartItemQuantity = cartItemQuantity;
	}

	public String getCartItemImage() {
		return cartItemImage;
	}

	public void setCartItemImage(String cartItemImage) {
		this.cartItemImage = cartItemImage;
	}

	@Override
	public String toString() {
		return "PastCartItem [pastCartItemId=" + pastCartItemId + ", cartItemName=" + cartItemName + ", cartItemPrice="
				+ cartItemPrice + ", cartItemQuantity=" + cartItemQuantity + ", cartItemImage=" + cartItemImage + "]";
	}

}
