package com.manifera.meshop.core.dao.test;

import javax.persistence.EntityTransaction;

import com.manifera.meshop.core.domain.Manufacturer;
import com.manifera.meshop.core.util.DomainUtil;

public class ManufacturerTest extends AbstractDomainTest {
	
	public static void main(String[] args) {
		EntityTransaction tx = entityManager.getTransaction();
		try {
			tx.begin();
			
			// Create categories
			
			Manufacturer apple = manufacturerDao.getByName("Apple (Macbook)");
			apple.setSefUrl(DomainUtil.getSefUrl(apple.getName()));
			
			Manufacturer dell = manufacturerDao.getByName("Dell");
			dell.setSefUrl(DomainUtil.getSefUrl(dell.getName()));
			
			Manufacturer lenovo = manufacturerDao.getByName("Lenovo");
			lenovo.setSefUrl(DomainUtil.getSefUrl(lenovo.getName()));
			
			Manufacturer acer = manufacturerDao.getByName("Acer");
			acer.setSefUrl(DomainUtil.getSefUrl(acer.getName()));
			
			Manufacturer asus = manufacturerDao.getByName("Asus");
			asus.setSefUrl(DomainUtil.getSefUrl(asus.getName()));
			
			Manufacturer hp = manufacturerDao.getByName("HP");
			hp.setSefUrl(DomainUtil.getSefUrl(hp.getName()));
			
			Manufacturer toshiba = manufacturerDao.getByName("Toshiba");
			toshiba.setSefUrl(DomainUtil.getSefUrl(toshiba.getName()));
			
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
