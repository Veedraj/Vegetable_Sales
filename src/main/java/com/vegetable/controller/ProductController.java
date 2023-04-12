package com.vegetable.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vegetable.entity.Product;
import com.vegetable.exception.ProductAlreadyExistException;
import com.vegetable.exception.ProductNotFoundException;
import com.vegetable.service.ProductService;

@CrossOrigin(value = "http://localhost:4200/")
@RestController
@RequestMapping("/api/v1")
public class ProductController {

	@Autowired
	private ProductService productService;

	@PostMapping("/product")
	public ResponseEntity<Product> addProduct(@RequestBody Product product) throws ProductAlreadyExistException{
		return new ResponseEntity<Product>(productService.addProduct(product), HttpStatus.OK);
	}

	@GetMapping("/product")
	public ResponseEntity<List<Product>> getAllProducts() {
		return new ResponseEntity<List<Product>>(productService.getAllProducts(), HttpStatus.OK);
	}

	@GetMapping("/product/ById/{productId}")
	public ResponseEntity<Product> getProductById(@PathVariable("productId") Long productId) throws ProductNotFoundException{
		return new ResponseEntity<Product>(productService.getProductById(productId), HttpStatus.OK);
	}

	@GetMapping("/product/ByName/{productName}")
	public ResponseEntity<List<Product>> getProductByName(@PathVariable("productName") String productName) throws ProductNotFoundException{
		return new ResponseEntity<List<Product>>(productService.getProductByName(productName), HttpStatus.OK);
	}

	@PutMapping("/product")
	public ResponseEntity<Product> updateproduct(@RequestBody Product product) throws ProductAlreadyExistException{
		return new ResponseEntity<Product>(productService.updateProduct(product), HttpStatus.OK);
	}

	@DeleteMapping("/product/{productId}")
	public ResponseEntity<List<Product>> deleteProductById(@PathVariable("productId") Long productId) throws ProductNotFoundException{
		List<Product> productList = productService.deleteProductById(productId);
		return new ResponseEntity<List<Product>>(productList, HttpStatus.OK);
	}
}
