package com.manifera.meshop.core.dao;

import java.util.List;

import com.manifera.meshop.core.domain.Category;
import com.manifera.meshop.core.domain.Manufacturer;

public interface ManufacturerDao {
	
	// =============================== GET METHODS ====================================
	
	public List<Manufacturer> getManufacturersByCategory(Category category);
	
	public List<Manufacturer> getManufacturersByCategoryName(String categoryName);
	
	public Manufacturer getByName(String name);
	
	public Manufacturer getBySelUrl(String selUrl);
	
}
