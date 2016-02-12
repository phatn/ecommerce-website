package com.manifera.meshop.core.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.manifera.meshop.core.dao.CategoryDao;
import com.manifera.meshop.core.dao.ManufacturerDao;
import com.manifera.meshop.core.domain.Category;
import com.manifera.meshop.core.domain.Manufacturer;
import com.manifera.meshop.core.service.ManufacturerService;

@Service("manufacturerService")
public class ManufacturerServiceImpl implements ManufacturerService {

	@Autowired
	private ManufacturerDao manufacturerDao;
	
	@Autowired
	private CategoryDao categoryDao;
	
	@Override
	public List<Manufacturer> getManufacturersByCategory(Category category) {
		return manufacturerDao.getManufacturersByCategory(category);
	}

	@Override
	public Manufacturer getByName(String name) {
		return manufacturerDao.getByName(name);
	}

	@Override
	public List<Manufacturer> getManufacturersByCategoryName(String categoryName) {
		return getManufacturersByCategory(categoryDao.getByName(categoryName));
	}

}
