package com.manifera.meshop.core.dao;

import java.util.List;

import com.manifera.meshop.core.domain.ProductPriceRange;

public interface ProductPriceRangeDao {
	
	public void create(ProductPriceRange productPriceRange);
	
	public List<ProductPriceRange> getAllPriceRanges();
	
	public ProductPriceRange getBySelUrl(String selUrl);
	
}
