package com.manifera.meshop.core.dao;

import java.util.List;

import com.manifera.meshop.core.domain.Product;
import com.manifera.meshop.core.domain.ProductRelationship;

public interface ProductRelationshipDao {

	public List<ProductRelationship> getProductRelationships(Product product);
	
	public List<ProductRelationship> getProductRelationships(long productId);
	
}
