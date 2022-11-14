package com.patnana.myshop.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.patnana.myshop.Entities.Product;
import com.patnana.myshop.exception.ResourceNotFoundException;
import com.patnana.myshop.services.ProductService;

@RestController
@RequestMapping(path="/product")
public class ProductController {
	
	private final ProductService productService;
	
	
	public ProductController(ProductService productService) {
		this.productService = productService;
	}


	@PostMapping
	public String createProduct(@RequestBody Product product) {
		return this.productService.createProduct(product);
	}
	
	@GetMapping
	public List<Product> getProducts() {
		return this.productService.getProducts();
	}
	
	@GetMapping(path="/{id}")
	public Product getProduct(@PathVariable int id) {
		return this.productService.getProduct(id).orElseThrow(() -> new ResourceNotFoundException("Product not Found"));
	}
	
	@PutMapping(path="/{id}")
	public String updateProduct(@RequestBody Product product, @PathVariable int id) {
		return this.productService.updateProduct(product, id);
	}
	
	@DeleteMapping(path="/{id}")
	public String deleteProduct(@PathVariable int id) {
		return this.productService.deleteProduct(id);
	}
	
	@GetMapping("/byName/{name}")
	public List<Product> getProductsByName(@PathVariable String name) {
		return this.productService.getProductsByName(name).orElseThrow(
				() -> new ResourceNotFoundException("Products By given Name not Found"));
	}
	
	@GetMapping("/filter")
	public List<Product> getProductsByCategoryIdAndBrandId(@RequestParam int categoryId, @RequestParam int brandId) {
	return this.productService.getProductsByCategoryIdAndBrandId(categoryId, brandId);	
	}
}
