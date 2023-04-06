package com.vegetable.exception;

import org.springframework.util.MultiValueMap;


public class CartNotFoundException extends Exception {
  
    public CartNotFoundException(String message) {
        super(message);
    }
}
