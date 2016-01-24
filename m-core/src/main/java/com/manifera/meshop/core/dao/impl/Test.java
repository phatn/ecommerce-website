package com.manifera.meshop.core.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.manifera.meshop.core.domain.Product;

public class Test {
	public static void main(String[] args) {
		EntityManagerFactory emf  = Persistence.createEntityManagerFactory("ms-corePU");
		EntityManager entityManager = emf.createEntityManager();
		
		ProductDaoImpl productDao = new ProductDaoImpl();
		productDao.setEntityManager(entityManager);
		
		EntityTransaction tx = entityManager.getTransaction();
		tx.begin();
		List<Product> products =  productDao.getAll();
		tx.commit();
		entityManager.close();
	}
}
