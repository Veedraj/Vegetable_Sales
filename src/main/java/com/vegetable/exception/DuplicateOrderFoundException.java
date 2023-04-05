package com.vegetable.exception;

public class DuplicateOrderFoundException extends Exception {

	private static final long serialVersionUID = 1L;

	public DuplicateOrderFoundException(String message) {
		super(message);
	}
}
