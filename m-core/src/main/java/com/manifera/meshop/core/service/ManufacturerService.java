package com.manifera.meshop.core.service;

import java.util.List;

import com.manifera.meshop.core.domain.Category;
import com.manifera.meshop.core.domain.Manufacturer;
import com.manifera.meshop.core.service.common.BaseService;

public interface ManufacturerService extends BaseService {
	
	public Manufacturer getByName(String name);
	
	public List<Manufacturer> getManufacturersByCategory(Category category);
	
	public List<Manufacturer> getManufacturersByCategoryName(String categoryName);
	
	public Manufacturer getBySelUrl(String selUrl);
}
