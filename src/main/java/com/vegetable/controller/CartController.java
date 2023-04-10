package com.vegetable.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vegetable.entity.Cart;
import com.vegetable.exception.CartItemDoesNotExistsException;
import com.vegetable.exception.CartNotFoundException;
import com.vegetable.exception.InvalidCartItemDataException;
import com.vegetable.service.CartService;

//@CrossOrigin(value = "http://localhost:4200/")
@RestController
@RequestMapping("/cart-section")

public class CartController {

	@Autowired
	private CartService cartService;

	@GetMapping("/{cart-id}")
	public ResponseEntity<Cart> getCartById(@PathVariable("cart-id") Long cartId) throws CartNotFoundException {
		Cart cart = cartService.getCartById(cartId);
		return ResponseEntity.ok(cart);
	}

	@PostMapping("add-cart")
	public ResponseEntity<Cart> addCart() {
		Cart cart = cartService.createCart();
		return ResponseEntity.ok(cart);
	}
	
	@PostMapping("add-to-cart/{cart-id}/{product-id}")
	public ResponseEntity<Cart> addToCart(@PathVariable("cart-id") Long cartId, @PathVariable("product-id") Long productId)
			throws CartNotFoundException, InvalidCartItemDataException {
		Cart cart = cartService.addToCart(cartId, productId);
		return ResponseEntity.ok(cart);
	}

	@PostMapping("/{cart-id}/{cart-item-id}")
	public ResponseEntity<Cart> increaseQuantity(@PathVariable("cart-id") Long cartId,
			@PathVariable("cart-item-id") Long cartItemId)
			throws InvalidCartItemDataException, CartNotFoundException, CartItemDoesNotExistsException {
		Cart cart = cartService.increaseQuantity(cartId, cartItemId);
		return ResponseEntity.ok(cart);
	}

	@DeleteMapping("/{cart-id}/{cart-item-id}")
	public ResponseEntity<Cart> removeFromCart(@PathVariable("cart-id") Long cartId,
			@PathVariable("cart-item-id") Long cartItemId) throws CartNotFoundException, CartItemDoesNotExistsException {
		Cart cart = cartService.removeFromCart(cartId, cartItemId);
		return ResponseEntity.ok(cart);
	}

	@DeleteMapping("/{cart-id}")
	public ResponseEntity<Cart> removeAllFromCart(@PathVariable("cart-id") Long cartId) throws CartNotFoundException {
		Cart cart = cartService.removeAllFromCart(cartId);
		return ResponseEntity.ok(cart);
	}

}
