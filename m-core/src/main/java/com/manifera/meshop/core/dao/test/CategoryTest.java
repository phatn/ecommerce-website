package com.manifera.meshop.core.dao.test;

import javax.persistence.EntityTransaction;

import com.manifera.meshop.core.domain.Category;
import com.manifera.meshop.core.domain.CategoryDescription;

public class CategoryTest extends AbstractDomainTest {
	
	public static void main(String[] args) {
		EntityTransaction tx = entityManager.getTransaction();
		try {
			tx.begin();
			
			// Create categories
			createCategories();
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
		
		System.out.println("\n========== DONE ============");
	}
	
	public static void createCategories() {
		createLaptop();
		createDesktop();
	}
	
	public static void createLaptop() {
		
		// Create category description with language is English
		CategoryDescription laptopCatDesEn = new CategoryDescription();
		laptopCatDesEn.setLanguage(languageDao.getByCode("en"));
		laptopCatDesEn.setDescription("Laptop category");
		laptopCatDesEn.setName("Laptop");
		
		// Create category description with language is English
		CategoryDescription laptopCatDesVn = new CategoryDescription();
		laptopCatDesVn.setLanguage(languageDao.getByCode("vn"));
		laptopCatDesVn.setName("Laptop");
		laptopCatDesVn.setDescription("Danh mục Laptop");
		
		// Create Laptop category
		Category laptopCat = new Category();
		laptopCat.getDescriptions().add(laptopCatDesEn);
		laptopCat.getDescriptions().add(laptopCatDesVn);
		laptopCat.setAvailable(true);
		
		laptopCatDesEn.setCategory(laptopCat);
		laptopCatDesVn.setCategory(laptopCat);
		
		categoryDao.create(laptopCat);
	}
	
	public static void createDesktop() {
		
		// Create category description with language is English
		CategoryDescription desktopCatDesEn = new CategoryDescription();
		desktopCatDesEn.setLanguage(languageDao.getByCode("en"));
		desktopCatDesEn.setDescription("Desktops category");
		desktopCatDesEn.setName("Desktops");
		
		// Create category description with language is English
		CategoryDescription desktopCatDesVn = new CategoryDescription();
		desktopCatDesVn.setLanguage(languageDao.getByCode("vn"));
		desktopCatDesVn.setName("Máy Tính");
		desktopCatDesVn.setDescription("Danh mục Máy Tính");
		
		// Create Desktop category
		Category desktopCat = new Category();
		desktopCat.getDescriptions().add(desktopCatDesEn);
		desktopCat.getDescriptions().add(desktopCatDesVn);
		desktopCat.setAvailable(true);
		
		desktopCatDesEn.setCategory(desktopCat);
		desktopCatDesVn.setCategory(desktopCat);
		
		categoryDao.create(desktopCat);
	}
}
