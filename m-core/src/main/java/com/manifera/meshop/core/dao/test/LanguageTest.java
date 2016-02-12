package com.manifera.meshop.core.dao.test;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityTransaction;

import com.manifera.meshop.core.domain.Language;

public class LanguageTest extends AbstractDomainTest {
	
	public static void main(String[] args) {
		EntityTransaction tx = entityManager.getTransaction();
		List<Language> languages = new ArrayList<>();
		try {
			tx.begin();
			
			//createLanguages();
			languages = getAllLanguages();
			tx.commit();
		} catch(Exception ex) {
			System.err.println("Error: " + ex.getMessage());
			ex.printStackTrace();
			if(tx != null) {
				tx.rollback();
			}
		} finally {
			closeEntityManager();
		}
		
		System.out.println("============ All languages (" + languages.size() + ") =============");
		for(Language language : languages) {
			System.out.println("id: " + language.getId() + ", code: " + language.getCode());
		}
		System.out.println("\n========= DONE =========");
	}
	
	public static void createLanguages() {
		Language languageEn = new Language();
		languageEn.setCode("en");
		
		Language languageVn = new Language();
		languageVn.setCode("vn");
		
		languageDao.create(languageEn);
		languageDao.create(languageVn);
	}
	
	public static List<Language> getAllLanguages() {
		return languageDao.getAllLanguages();
	}
	
}
