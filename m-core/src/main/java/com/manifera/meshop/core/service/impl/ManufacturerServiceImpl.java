package com.manifera.meshop.core.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.manifera.meshop.core.dao.ManufacturerDao;
import com.manifera.meshop.core.domain.Category;
import com.manifera.meshop.core.domain.Manufacturer;
import com.manifera.meshop.core.service.ManufacturerService;

@Service("manufacturerService")
public class ManufacturerServiceImpl implements ManufacturerService {

	@Autowired
	private ManufacturerDao manufacturerDao;
	
	@Override
	public List<Manufacturer> getManufacturersByCategory(Category category) {
		return manufacturerDao.getManufacturersByCategory(category);
	}

}
