package com.manifera.meshop.core.dao.test;

import javax.persistence.EntityTransaction;

import com.manifera.meshop.core.domain.Manufacturer;

public class ManufacturerTest extends AbstractDomainTest {
	
	public static void main(String[] args) {
		EntityTransaction tx = entityManager.getTransaction();
		try {
			tx.begin();
			
			// Create categories
			/*createManufacturerApple();
			createManufacturerDell();
			createManufacturerLenovo();
			createManufacturerAcer();
			createManufacturerAsus();
			createManufacturerHP();
			createManufacturerToshiba();*/
			
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
	
	public static void createManufacturerHP() {
		Manufacturer mfHP = new Manufacturer();
		mfHP.setName("HP");
		manufacturerDao.create(mfHP);
	}
	
	public static void createManufacturerDell() {
		Manufacturer mfDell = new Manufacturer();
		mfDell.setName("Dell");
		manufacturerDao.create(mfDell);
	}
	
	public static void createManufacturerApple() {
		Manufacturer mfApple = new Manufacturer();
		mfApple.setName("Apple (Macbook)");
		manufacturerDao.create(mfApple);
	}
	
	public static void createManufacturerLenovo() {
		Manufacturer mfLenovo = new Manufacturer();
		mfLenovo.setName("Lenovo");
		
		manufacturerDao.create(mfLenovo);
	}
	
	public static void createManufacturerAcer() {
		Manufacturer mfAcer = new Manufacturer();
		mfAcer.setName("Acer");
		manufacturerDao.create(mfAcer);
	}
	
	public static void createManufacturerAsus() {
		Manufacturer mfAsus = new Manufacturer();
		mfAsus.setName("Asus");
		manufacturerDao.create(mfAsus);
	}
	
	public static void createManufacturerToshiba() {
		Manufacturer mfToshiba = new Manufacturer();
		mfToshiba.setName("Toshiba");
		manufacturerDao.create(mfToshiba);
	}
	
}
