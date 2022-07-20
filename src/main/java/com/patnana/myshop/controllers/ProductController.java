package com.patnana.myshop.controllers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.patnana.myshop.Entities.Product;
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
}
