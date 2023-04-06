package com.vegetable.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vegetable.entity.Product;
import com.vegetable.exception.ProductAlreadyExistException;
import com.vegetable.exception.ProductNotFoundException;
import com.vegetable.repository.ProductRepository;
import com.vegetable.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService{

	@Autowired
	private ProductRepository productRepo;
	
	@Override
	public Product addProduct(Product product)throws ProductAlreadyExistException {
		List<Product> findProduct = productRepo.findAll();
		for(Product p: findProduct) {
			if(p.getProductName().equals(product.getProductName())){
				throw new ProductAlreadyExistException("Product already exist");
			}
		}
		return productRepo.save(product);
	}

	@Override
	public List<Product> getAllProducts() {
		return productRepo.findAll();
	}

	@Override
	public Product getProductById(Long prodoctId) throws ProductNotFoundException{
		try {
			Product productById= productRepo.findById(prodoctId).get();
			return productById;
		}catch(Exception e) {
			throw new ProductNotFoundException("No product found");
		}
	}

	@Override
	public List<Product> getProductByName(String productName) throws ProductNotFoundException{
		List<Product> productByName = productRepo.findAllByProductName(productName);
		if(productByName.size()>=1) {
			return productByName;
		}
		else {
			throw new ProductNotFoundException("No product found");
		}
	}

	@Override
	public Product updateProduct(Product product) throws ProductAlreadyExistException {
		return productRepo.save(product);
	}


	@Override
	public List<Product> deleteProductById(Long productId)throws ProductNotFoundException {
		try {
			productRepo.deleteById(productId);
			return productRepo.findAll();
		}catch (Exception e){
			throw new ProductNotFoundException("No such product found");
		}
	}
}
