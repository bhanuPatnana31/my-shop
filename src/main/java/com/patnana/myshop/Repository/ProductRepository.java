package com.patnana.myshop.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.patnana.myshop.Entities.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {


}
