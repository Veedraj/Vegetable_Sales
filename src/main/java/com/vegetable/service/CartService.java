package com.vegetable.service;

import com.vegetable.entity.Cart;
import com.vegetable.exception.CartItemDoesNotExistsException;
import com.vegetable.exception.CartNotFoundException;
import com.vegetable.exception.InvalidCartItemDataException;

public interface CartService {

	public Cart createCart();

	public Cart getCartById(Long cartId) throws CartNotFoundException;

	public Cart addToCart(Long cartId, Long productId) throws CartNotFoundException, InvalidCartItemDataException;

	public Cart increaseQuantity(Long cartId, Long cartItemId)
			throws CartNotFoundException, CartItemDoesNotExistsException, InvalidCartItemDataException;

	public Cart removeFromCart(Long cartId, Long cartItemId)
			throws CartNotFoundException, CartItemDoesNotExistsException;

	public Cart removeAllFromCart(Long cartId) throws CartNotFoundException;

}
