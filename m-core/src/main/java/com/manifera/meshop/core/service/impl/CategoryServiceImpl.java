package com.manifera.meshop.core.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.manifera.meshop.core.dao.CategoryDao;
import com.manifera.meshop.core.domain.Category;
import com.manifera.meshop.core.domain.Language;
import com.manifera.meshop.core.service.CategoryService;

@Service("categoryService")
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	private CategoryDao categoryDao;
	
	@Override
	public Category getById(long id, Language language) {
		return categoryDao.getById(id, language);
	}

	@Override
	public List<Category> getAllCategories(Language language) {
		return categoryDao.getAllCategories(language);
	}

	@Override
	public List<Category> getAllCategories(String languageCode) {
		return categoryDao.getAllCategories(languageCode);
	}
	
	@Override
	public List<Category> getAllRootCategories(Language language) {
		return categoryDao.getAllRootCategories(language);
	}

}
