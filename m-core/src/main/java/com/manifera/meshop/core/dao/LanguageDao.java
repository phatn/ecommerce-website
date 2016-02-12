package com.manifera.meshop.core.dao;

import java.util.List;

import com.manifera.meshop.core.domain.Language;

public interface LanguageDao {
	
	public Language getByCode(String code);
	
	public List<Language> getAllLanguages();
	
	public void create(Language language);
}
