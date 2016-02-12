package com.manifera.meshop.core.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.manifera.meshop.core.dao.LanguageDao;
import com.manifera.meshop.core.domain.Language;
import com.manifera.meshop.core.service.LanguageService;

@Service("languageService")
public class LanguageServiceImpl implements LanguageService {

	@Autowired
	private LanguageDao languageDao;
	
	@Override
	public Language getByCode(String code) {
		return languageDao.getByCode(code);
	}

	@Override
	public void create(Language language) {
		languageDao.create(language);
	}

	@Override
	public List<Language> getAllLanguages() {
		return languageDao.getAllLanguages();
	}

}
