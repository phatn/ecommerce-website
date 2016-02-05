package com.manifera.meshop.core.service;

import java.util.List;

import com.manifera.meshop.core.domain.Category;
import com.manifera.meshop.core.domain.Language;
import com.manifera.meshop.core.service.common.BaseService;

public interface CategoryService extends BaseService {
	
	public Category getById(long id, Language language);
	
	public List<Category> getAllCategories(Language language);
	
	public List<Category> getAllCategories(String languageCode);
	
	public List<Category> getAllRootCategories(Language language);
}
