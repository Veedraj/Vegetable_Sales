package com.vegetable.exception;

<<<<<<<< HEAD:src/main/java/com/vegetable/exception/ProductAlreadyExistException.java
public class ProductAlreadyExistException extends Exception {

========
public class CartItemDoesNotExistsException extends Exception{
	
>>>>>>>> master:src/main/java/com/vegetable/exception/CartItemDoesNotExistsException.java
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

<<<<<<<< HEAD:src/main/java/com/vegetable/exception/ProductAlreadyExistException.java
	public ProductAlreadyExistException(String message) {
========
	public CartItemDoesNotExistsException(String message ) {
>>>>>>>> master:src/main/java/com/vegetable/exception/CartItemDoesNotExistsException.java
		super(message);
	}

}
