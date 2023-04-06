package com.vegetable.exception;

public class ProductAlreadyExistException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ProductAlreadyExistException(String message) {
		super(message);
	}
}
