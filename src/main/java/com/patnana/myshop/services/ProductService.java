package com.patnana.myshop.services;

import org.springframework.stereotype.Service;

import com.patnana.myshop.Entities.Product;
import com.patnana.myshop.Repository.ProductRepository;

@Service
public class ProductService {

	private final ProductRepository productRepository;

	public ProductService(ProductRepository productRepository) {
		this.productRepository = productRepository;
	}
	
	public String createProduct(Product product) {
		this.productRepository.save(product);
		return "Product inserted successfully";
	}
	
}
