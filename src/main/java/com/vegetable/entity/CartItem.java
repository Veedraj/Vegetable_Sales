package com.vegetable.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "cartItems")
public class CartItem {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long cartItemId;

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

	@JsonBackReference
	@ManyToOne
	@JoinColumn(name = "cartId")
	private Cart cart;

	public CartItem() {
		super();
	}

	public CartItem(Long cartItemId, @NotNull(message = "Item name cannot be null") String cartItemName,
			@NotNull(message = "Items price cannot be null") @Min(value = 1, message = "Price should be greater than Zero") Double cartItemPrice,
			@NotNull(message = "Quantity Should be Greater Than Zero") @Min(value = 0, message = "Quantity should be greater than 0") Integer cartItemQuantity,
			@NotNull(message = "Items image cannot be null") String cartItemImage, Cart cart) {
		super();
		this.cartItemId = cartItemId;
		this.cartItemName = cartItemName;
		this.cartItemPrice = cartItemPrice;
		this.cartItemQuantity = cartItemQuantity;
		this.cartItemImage = cartItemImage;
		this.cart = cart;
	}

//	public CartItem(@NotNull(message = "Item name cannot be null") String cartItemName,
//			@NotNull(message = "Items price cannot be null") @Min(value = 1, message = "Price should be greater than Zero") Double cartItemPrice,
//			@NotNull(message = "Quantity Should be Greater Than Zero") @Min(value = 0, message = "Quantity should be greater than 0") Integer cartItemQuantity,
//			@NotNull(message = "Items image cannot be null") String cartItemImage) {
//		super();
//		this.cartItemName = cartItemName;
//		this.cartItemPrice = cartItemPrice;
//		this.cartItemQuantity = cartItemQuantity;
//		this.cartItemImage = cartItemImage;
//	}

	public Cart getCart() {
		return cart;
	}

	public Long getCartItemId() {
		return cartItemId;
	}

	public String getCartItemName() {
		return cartItemName;
	}

	public Double getCartItemPrice() {
		return cartItemPrice;
	}

	public Integer getCartItemQuantity() {
		return cartItemQuantity;
	}

	public String getCartItemImage() {
		return cartItemImage;
	}

	public void setCart(Cart cart) {
		this.cart = cart;
	}

	public void setCartItemId(Long cartItemId) {
		this.cartItemId = cartItemId;
	}

	public void setCartItemName(String cartItemName) {
		this.cartItemName = cartItemName;
	}

	public void setCartItemPrice(Double cartItemPrice) {
		this.cartItemPrice = cartItemPrice;
	}

	public void setCartItemQuantity(Integer cartItemQuantity) {
		this.cartItemQuantity = cartItemQuantity;
	}

	public void setCartItemImage(String cartItemImage) {
		this.cartItemImage = cartItemImage;
	}

	@Override
	public String toString() {
		return "CartItem [cartItemId=" + cartItemId + ", cartItemName=" + cartItemName + ", cartItemPrice="
				+ cartItemPrice + ", cartItemQuantity=" + cartItemQuantity + ", cartItemImage=" + cartItemImage
				+ ", cart=" + cart +  "]";
	}

}
