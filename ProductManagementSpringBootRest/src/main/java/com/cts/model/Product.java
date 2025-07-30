package com.cts.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "products_info")
public class Product {
	@Id
	@Column(name = "pid", length = 3, nullable = false)
	@GeneratedValue
	private int productId;
	@Min(value=1000, message="Product price must be greater than 1000")
	private int productPrice;
	@Size(min=6 , max= 20, message="Name length should be between 4 to 20")
	private String productName;
	@NotBlank
	private String productCategory;

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public int getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(int productPrice) {
		this.productPrice = productPrice;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductCategory() {
		return productCategory;
	}

	public void setProductCategory(String productCategory) {
		this.productCategory = productCategory;
	}

	public Product() {

	}

	public Product( int productPrice, String productName, String productCategory) {
		super();
	
		this.productPrice = productPrice;
		this.productName = productName;
		this.productCategory = productCategory;
	}

}
