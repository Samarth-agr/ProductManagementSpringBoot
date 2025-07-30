package com.cts.service;

import java.util.List;

import com.cts.exception.ProductCategoryNotFound;
import com.cts.exception.ProductNotFoundException;
import com.cts.model.Product;

public interface ProductService {
	String addProduct(Product product);

	String updateProduct(Product product);

	String deleteProductById(int productId) throws ProductNotFoundException;

	Product getProductById(int productId) throws ProductNotFoundException;

	List<Product> getAllProducts();

	List<Product> getProductsByCategory(String productCategory) throws ProductCategoryNotFound;

	List<Product> getProductsBetweenPriceRange(int intialPrice, int finalPrice);

}
