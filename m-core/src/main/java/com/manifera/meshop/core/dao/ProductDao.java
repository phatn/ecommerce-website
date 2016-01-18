package com.manifera.meshop.core.dao;

import java.util.List;
import java.util.Map;
import java.util.Set;

import com.manifera.meshop.core.domain.Category;
import com.manifera.meshop.core.domain.Product;

public interface ProductDao {
	 
	// ======================= GET =========================================
	public List<Product> getAllProducts();
	
	public Map<String, ?> getAllProducts(int offet, int limit);
	
	public Map<String, ?> getProductsByCategory(Category category, int offset, int limit);
	
	public Map<String, ?> getProductsByCategoryId(Category categoryId, int offset, int limit);
	
	public Map<String, ?> getProductsByCategories(List<Category> categories, int offset, int limit);
	
	public Map<String, ?> getProductsByCategoryIds(Set<Long> categoryIds);
	
	public Map<String, ?> getRelatedProductsById(long productId);
	
	// ======================= UPDATE ======================================
	public void update(Product product);
	
	// ======================= DELETE ======================================
	public void deleteById(long productId);
	
	// ======================= CREATE ======================================
	public void create(Product product);
}
