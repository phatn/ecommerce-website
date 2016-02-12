package com.manifera.meshop.core.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.manifera.meshop.core.dao.CategoryDescriptionDao;
import com.manifera.meshop.core.domain.CategoryDescription;
import com.manifera.meshop.core.service.CategoryDescriptionService;

@Repository("categoryDescriptionService")
public class CategoryDescriptionServiceImpl implements  CategoryDescriptionService{

	@Autowired
	private CategoryDescriptionDao categoryDescriptionDao;
	
	@Override
	public void create(CategoryDescription categoryDescription) {
		categoryDescriptionDao.create(categoryDescription);
	}

}
