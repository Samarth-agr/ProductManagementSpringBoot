package com.cts.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cts.model.Product;

public interface ProductRepository extends JpaRepository<Product, Integer>{
	
//	List<Product> getProductsByCategory(String productCategory);
//
//	List<Product> getProductsBetweenPriceRange(int intialPrice, int finalPrice);
	
	List<Product> findByProductCategory(String productCategory);
	List<Product> findByProductPriceBetween(int intialPrice, int finalPrice);


}
