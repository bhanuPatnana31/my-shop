package com.patnana.myshop.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.patnana.myshop.Entities.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

	Optional<List<Product>> findByItemName(String name);
	
	List<Product> findByCategoryIdAndBrandId(int categoryId, int brandId);
}
