package com.manifera.meshop.core.dao.test;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class PersistenceHelper {
	
	private PersistenceHelper() {}
	
	public static EntityManagerFactory getEntityManagerFactory() {
		return Persistence.createEntityManagerFactory(ConstantTest.PERSISTENCE_UNIT_NAME);
	}
}
