package com.manifera.meshop.core.domain.common;

import java.util.List;

import com.manifera.meshop.core.domain.Product;

public class ProductList extends EmptyList {
	
	private static final long serialVersionUID = 1L;
	
	private List<Product> products;
	
	public ProductList() {}
	
	public ProductList(List<Product> products, long totalRecords) {
		super(totalRecords);
		this.products = products;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}
}
