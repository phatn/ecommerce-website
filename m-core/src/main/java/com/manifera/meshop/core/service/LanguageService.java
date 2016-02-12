package com.manifera.meshop.core.service;

import java.util.List;

import com.manifera.meshop.core.domain.Language;
import com.manifera.meshop.core.service.common.BaseService;

public interface LanguageService extends BaseService {
	
	public Language getByCode(String code);
	
	public List<Language> getAllLanguages();
	
	public void create(Language language);
}
