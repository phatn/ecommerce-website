package com.manifera.meshop.core.dao;

import java.util.List;
import java.util.Set;

import com.manifera.meshop.core.dao.common.Page;
import com.manifera.meshop.core.domain.Category;
import com.manifera.meshop.core.domain.Language;
import com.manifera.meshop.core.domain.Manufacturer;
import com.manifera.meshop.core.domain.Product;
import com.manifera.meshop.core.domain.ProductPriceRange;

public interface ProductDao {
	 
	// =============================== GET METHODS ====================================
	
	public Product getById(long id, Language language);
	
	public List<Product> getAllProducts(Language language);
	
	public Page<Product> getAllProducts(Language language, int offet, int limit);
	
	public Page<Product> getProductsByCategory(Category category, Language language, int offset, int limit);
	
	public Page<Product> getProductsByCategoryId(long categoryId, Language language, int offset, int limit);
	
	public Page<Product> getProductsByCategories(List<Category> categories, Language language, int offset, int limit);
	
	public Page<Product> getProductsByManufacturer(Manufacturer manufacturer, Language language, int offset, int limit);
	
	public Page<Product> getProductsByManufacturerId(long manufacturerId, Language language, int offset, int limit);
	
	public Page<Product> getProductsByManufacturerSefUrl(String manufacturerSefUrl, Language language, int offset, int limit);
	
	public Page<Product> getProductsByManufacturerSefUrl(String manufacturerSefUrl, String languageCode, int offset, int limit);
	
	public Page<Product> getByCatSefUrlAndManuSefUrl(String categorySefUrl, String manufacturerSefUrl, String languageCode, int offset, int limit);
	
	public Page<Product> getProductsByCategoryIds(Set<Long> categoryIds, Language language , int offset, int limit);
	
	public Page<Product> getFeaturedProducts(Language language);
	
	public Page<Product> getFeaturedProducts(String languageCode);
	
	public Page<Product> getClearanceProducts(Language language);
	
	public Page<Product> getNewArrivalProducts(Language language);
	
	public Page<Product> getNewArrivalProducts(String languageCode);
	
	public Page<Product> getByCatUrlAndPriceRange(String categorySefUrl, ProductPriceRange priceRange, String languageCode, int offset, int limit);
	
}
