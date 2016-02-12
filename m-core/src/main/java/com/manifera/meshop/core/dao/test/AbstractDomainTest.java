package com.manifera.meshop.core.dao.test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import com.manifera.meshop.core.dao.impl.CategoryDaoImpl;
import com.manifera.meshop.core.dao.impl.LanguageDaoImpl;
import com.manifera.meshop.core.dao.impl.ManufacturerDaoImpl;
import com.manifera.meshop.core.dao.impl.ProductDaoImpl;

public abstract class AbstractDomainTest {
	
private static EntityManagerFactory emf;
	
	protected static EntityManager entityManager;
	
	protected static ManufacturerDaoImpl manufacturerDao = new ManufacturerDaoImpl();
	
	protected static CategoryDaoImpl categoryDao = new CategoryDaoImpl();
	
	protected static ProductDaoImpl productDao = new ProductDaoImpl();
	
	protected static LanguageDaoImpl languageDao = new LanguageDaoImpl();
	
	static {
		emf = PersistenceHelper.getEntityManagerFactory();
		entityManager = emf.createEntityManager();
		manufacturerDao.setEntityManager(entityManager);
		categoryDao.setEntityManager(entityManager);
		productDao.setEntityManager(entityManager);
		languageDao.setEntityManager(entityManager);
	}
	
	public static void closeEntityManager() {
		entityManager.close();
		emf.close();
	}
	
}
