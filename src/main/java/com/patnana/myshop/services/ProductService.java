package com.patnana.myshop.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.patnana.myshop.Entities.Product;
import com.patnana.myshop.Repository.ProductRepository;
import com.patnana.myshop.exception.ResourceNotFoundException;

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
	
	public List<Product> getProducts() {
		return this.productRepository.findAll();
	}
	
	public Optional<Product> getProduct(int itemNo) {
		return this.productRepository.findById(itemNo);
	}
	
	public Optional<List<Product>> getProductsByName(String name) {
		return this.productRepository.findByItemName(name);
	}
	
	public String updateProduct(Product product, int id) {
		
		Product product1 = this.productRepository.findById(id).orElseThrow(
				() ->  new ResourceNotFoundException("Product not Found"));
		
		this.productRepository.save(product);
		return "Product updated successfully";
	}
	
	public String deleteProduct(int id) {
		this.productRepository.deleteById(id);
		return "Product deleted successfully";
	}
	
	public List<Product> getProductsByCategoryIdAndBrandId(int categoryId, int brandId) {
		this.productRepository.findAll();
		return this.productRepository.findByCategoryIdAndBrandId(categoryId, brandId);
	}
}
