package com.vegetable.exceptionHandling;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.vegetable.exception.OrderNotFoundException;

@RestControllerAdvice
public class OrderControllerAdvice {
	
	@ExceptionHandler(OrderNotFoundException.class)
	public ResponseEntity<String> orderExceptionHandler(OrderNotFoundException e) {

		return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
	}

	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public Map<String, String> handleValidationsExceptionsForOrders(MethodArgumentNotValidException e) {
		Map<String, String> errors = new HashMap<String, String>();
		e.getBindingResult().getAllErrors().forEach((error) -> {
			String fieldName = ((FieldError) error).getField();
			String errorMsg = error.getDefaultMessage();
			errors.put(fieldName, errorMsg);
		});
		return errors;
	}
}
