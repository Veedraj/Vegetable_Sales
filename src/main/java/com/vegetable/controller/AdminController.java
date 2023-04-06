package com.vegetable.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vegetable.entity.Order;
import com.vegetable.entity.Product;
import com.vegetable.exception.OrderNotFoundException;
import com.vegetable.exception.ProductAlreadyExistException;
import com.vegetable.exception.ProductNotFoundException;
import com.vegetable.service.AdminService;

@RestController
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	AdminService adminService;
	
	@GetMapping("/view/orders")
	public List<Order> allOrders() throws OrderNotFoundException
	{
		return adminService.allOrders();
	}
	
	@GetMapping("/view/order/{orderId}")
	public Order viewOrder(@PathVariable("orderId") long orderId) throws OrderNotFoundException
	{
		return adminService.viewOrder(orderId);
	}
	
	@GetMapping("/view/products")
	public List<Product> allProducts () throws ProductNotFoundException
	{
		return adminService.allProducts();
	}
	
	@PutMapping("update/products")
	public ResponseEntity<Product> updateproduct(@RequestBody Product product) throws ProductAlreadyExistException{
		return new ResponseEntity<Product>(adminService.updateProduct(product), HttpStatus.OK);
	}
	
	@DeleteMapping("delete/products/{productId}")
	public ResponseEntity<List<Product>> deleteProductById(@PathVariable("productId") Long productId) throws ProductNotFoundException{
		List<Product> productList = adminService.deleteProductById(productId);
		return new ResponseEntity<List<Product>>(productList, HttpStatus.OK);
	}
}
