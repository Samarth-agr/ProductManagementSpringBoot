package com.cts.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.cts.exception.ProductCategoryNotFound;
import com.cts.exception.ProductNotFoundException;
import com.cts.model.Product;
import com.cts.repository.ProductRepository;

import lombok.AllArgsConstructor;

@Service("service")
@AllArgsConstructor
public class ProductServiceImp implements ProductService {

	ProductRepository repo;


	@Override
	public String addProduct(Product product) {

		repo.save(product);
		return "Product Save Successfully";
	}

	@Override
	public String updateProduct(Product product) {

		repo.save(product);
		return "Product Update Successfully";
	}

	@Override
	public String deleteProductById(int productId) throws ProductNotFoundException {

		repo.delete(getProductById(productId));
		return "Product Deleted";
	}

	@Override
	public Product getProductById(int productId) throws ProductNotFoundException {

		Optional<Product> optionalP = repo.findById(productId);
		if(optionalP.isEmpty()) {
			throw new ProductNotFoundException("Product not found with given Id");
		}
		return optionalP.get();
	}  

	@Override
	public List<Product> getAllProducts() {
		
		return repo.findAll();
	}

	@Override
	public List<Product> getProductsByCategory(String productCategory) throws ProductCategoryNotFound {
		
		List<Product> products =  repo.findByProductCategory(productCategory);
		if(products.size()==0) {
			throw new ProductCategoryNotFound("Product Category Not Available");
		}
		return products;
	}

	@Override
	public List<Product> getProductsBetweenPriceRange(int intialPrice, int finalPrice) {

		return repo.findByProductPriceBetween(intialPrice, finalPrice);
	}

}
