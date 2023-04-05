package com.vegetable.service;

import java.util.List;

import com.vegetable.entity.Product;
import com.vegetable.exception.InvalidProductDetailsException;
import com.vegetable.exception.ProductNotFoundException;

public interface ProductService {

	public Product addProduct(Product product) throws InvalidProductDetailsException;
	
	public List<Product> getAllProducts();
	
	public Product getProductById(Long prodoctId) throws ProductNotFoundException;
	
	public List<Product> getProductByName(String productName)throws ProductNotFoundException ;
	
	public Product updateProduct(Product product)throws InvalidProductDetailsException;
	
	public List<Product> deleteProductById(Long productId) throws ProductNotFoundException;
}
