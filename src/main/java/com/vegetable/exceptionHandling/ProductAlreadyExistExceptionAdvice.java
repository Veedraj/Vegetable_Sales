package com.vegetable.exceptionHandling;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import com.vegetable.exception.ProductAlreadyExistException;
import com.vegetable.payload.ErrorDetails;

@ControllerAdvice
public class ProductAlreadyExistExceptionAdvice {

	// handle ProductAlreadyExistException exceptions
	@ExceptionHandler(ProductAlreadyExistException.class)
	public ResponseEntity<ErrorDetails> handleProductAlreadyExistException(ProductAlreadyExistException exception,
			WebRequest webRequest) {
		ErrorDetails errorDetails = new ErrorDetails(new Date(), exception.getMessage(),
				webRequest.getDescription(false));
		return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
	}
}
