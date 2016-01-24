package com.manifera.meshop.core.dao;

import java.util.List;
import java.util.Set;

import com.manifera.meshop.core.dao.common.Page;
import com.manifera.meshop.core.domain.Category;
import com.manifera.meshop.core.domain.Product;

public interface ProductDao {
	 
	// ======================= GET =========================================
	public Page<Product> getAllProducts();
	
	public Page<Product> getAllProducts(int offet, int limit);
	
	public Page<Product> getProductsByCategory(Category category, int offset, int limit);
	
	public Page<Product> getProductsByCategoryId(long categoryId, int offset, int limit);
	
	public Page<Product> getProductsByCategories(List<Category> categories, int offset, int limit);
	
	public Page<Product> getProductsByCategoryIds(Set<Long> categoryIds);
	
	public Page<Product> getRelatedProductsById(long productId);
	
	// ======================= UPDATE ======================================
	public void update(Product product);
	
	// ======================= DELETE ======================================
	public void deleteById(long productId);
	
	// ======================= CREATE ======================================
	public void create(Product product);
}
