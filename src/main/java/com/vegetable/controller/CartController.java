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
@RequestMapping("/api/v1/cart")

public class CartController {

	@Autowired
	private CartService cartService;

	@GetMapping("/{cartId}")
	public ResponseEntity<Cart> getCartById(@PathVariable("cartId") Long cartId) throws CartNotFoundException {
		Cart cart = cartService.getCartById(cartId);
		return ResponseEntity.ok(cart);
	}

	@PostMapping("addCart")
	public ResponseEntity<Cart> addCart() {
		Cart cart = cartService.createCart();
		return ResponseEntity.ok(cart);
	}
	
	@PostMapping("addToCart/{cartId}/{productId}")
	public ResponseEntity<Cart> addToCart(@PathVariable("cartId") Long cartId, @PathVariable("productId") Long productId)
			throws CartNotFoundException, InvalidCartItemDataException {
		Cart cart = cartService.addToCart(cartId, productId);
		return ResponseEntity.ok(cart);
	}

	@PostMapping("/{cartId}/{cartItemId}")
	public ResponseEntity<Cart> increaseQuantity(@PathVariable("cartId") Long cartId,
			@PathVariable("cartItemId") Long cartItemId)
			throws InvalidCartItemDataException, CartNotFoundException, CartItemDoesNotExistsException {
		Cart cart = cartService.increaseQuantity(cartId, cartItemId);
		return ResponseEntity.ok(cart);
	}

	@DeleteMapping("/{cartId}/{cartItemId}")
	public ResponseEntity<Cart> removeFromCart(@PathVariable("cartId") Long cartId,
			@PathVariable("cartItemId") Long cartItemId) throws CartNotFoundException, CartItemDoesNotExistsException {
		Cart cart = cartService.removeFromCart(cartId, cartItemId);
		return ResponseEntity.ok(cart);
	}

	@DeleteMapping("/{cartId}")
	public ResponseEntity<Cart> removeAllFromCart(@PathVariable("cartId") Long cartId) throws CartNotFoundException {
		Cart cart = cartService.removeAllFromCart(cartId);
		return ResponseEntity.ok(cart);
	}

}
