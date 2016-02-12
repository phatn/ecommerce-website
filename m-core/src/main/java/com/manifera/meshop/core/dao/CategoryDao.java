package com.manifera.meshop.core.dao;

import java.util.List;

import com.manifera.meshop.core.domain.Category;
import com.manifera.meshop.core.domain.Language;

public interface CategoryDao {
	
	// =============================== GET METHODS =====================================
	
	public Category getById(long id, Language language);
	
	public List<Category> getAllCategories(Language language);
	
	public List<Category> getAllCategories(String languageCode);
	
	public List<Category> getAllRootCategories(Language language);
	
	public Category getByName(String name);
	
}
