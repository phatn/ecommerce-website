package com.manifera.meshop.core.dao.test;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import com.manifera.meshop.core.dao.common.Page;
import com.manifera.meshop.core.domain.ImageSize;
import com.manifera.meshop.core.domain.Manufacturer;
import com.manifera.meshop.core.domain.Product;
import com.manifera.meshop.core.domain.ProductAttribute;
import com.manifera.meshop.core.domain.ProductAttributeType;
import com.manifera.meshop.core.domain.ProductAttributeValue;
import com.manifera.meshop.core.domain.ProductDescription;
import com.manifera.meshop.core.domain.ProductImage;

public class ProductTest extends AbstractDomainTest {
	
	public static void main(String[] args) {
		EntityTransaction tx = entityManager.getTransaction();
		try {
			tx.begin();
			
			/*StringBuilder queryBuilder = new StringBuilder();
			queryBuilder.append("select distinct p.manufacturer from Product p ");
			queryBuilder.append("inner join p.categories c inner join c.descriptions cd ");
			queryBuilder.append("where cd.name = 'Laptop'");*/
			
			StringBuilder queryBuilder = new StringBuilder();
			queryBuilder.append("select distinct m from Manufacturer m ");
			queryBuilder.append("left join m.products p left join p.categories c ");
			queryBuilder.append("left join c.descriptions cd ");
			queryBuilder.append("left join cd.language l ");
			queryBuilder.append("where cd.name = 'Laptop' or cd.name is null order by m.sortOrder asc");
			
			TypedQuery<Manufacturer> query = entityManager.createQuery(queryBuilder.toString(), Manufacturer.class);
			List<Manufacturer> manufacturers = query.getResultList();
			for(Manufacturer manufacturer :  manufacturers) {
				System.out.println("id: " + manufacturer.getId() + ", name: " + manufacturer.getName());
			}
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
	
	public static void createProducts() {
		
		//createProd1();
		createProd5();
		createProd6();
		createProd7();
		createProd8();
	}
	
	public static Page<Product> getNewArrival() {
		return productDao.getNewArrivalProducts(languageDao.getByCode("en"));
	}
	
	
	public static void updateProd() {
		Product prod = productDao.get(1L);
		
		ProductDescription prodDesEn = new ProductDescription();
		prodDesEn.setLanguage(languageDao.getByCode("en"));
		prodDesEn.setDescription("The best laptop HP");
		
		ProductDescription prodDesVn = new ProductDescription();
		prodDesVn.setLanguage(languageDao.getByCode("vn"));
		prodDesVn.setDescription("Laptop HP tốt nhất");
		
		prod.getDescriptions().add(prodDesEn);
		prod.getDescriptions().add(prodDesVn);
		
		prodDesEn.setProduct(prod);
		prodDesVn.setProduct(prod);
		
		productDao.update(prod);
	}
	
	public static void createProd1() {
		ProductAttributeValue nameAttributeValue = new ProductAttributeValue();
		nameAttributeValue.setValue("HP Pavilion 15-P224TU L1M32PA 15.6\" Core i3 4GB 500GB Win8.1");
		
		ProductAttribute nameAttribute = new ProductAttribute();
		nameAttribute.setName("Name");
		nameAttribute.setAttributeType(ProductAttributeType.TEXT);
		nameAttribute.getAttributeValues().add(nameAttributeValue);
		nameAttributeValue.setAttribute(nameAttribute);
		
		ProductImage prodSmallImage = new ProductImage();
		prodSmallImage.setImage("2016/02/ab61605.jpg");
		prodSmallImage.setImageSize(ImageSize.MEDIUM);
		prodSmallImage.setActive(true);
		
		Product prod1 = new Product();
		prod1.setNewArrival(true);
		prod1.setAvailable(true);
		prod1.setFeaturedSeller(true);
		prod1.setPrice(new BigDecimal(532.98));
		
		prod1.setManufacturer(manufacturerDao.getByName("HP"));
		prod1.getCategories().add(categoryDao.getByName("Laptop"));
		prod1.getAttributes().add(nameAttribute);
		prod1.getProductImages().add(prodSmallImage);
		
		nameAttribute.setProduct(prod1);
		prodSmallImage.setProduct(prod1);
		
		productDao.create(prod1);
	}
	
	public static void createProd2() {
		
		ProductDescription prodDesEn = new ProductDescription();
		prodDesEn.setLanguage(languageDao.getByCode("en"));
		prodDesEn.setDescription("The best laptop Toshiba");
		
		ProductDescription prodDesVn = new ProductDescription();
		prodDesVn.setLanguage(languageDao.getByCode("vn"));
		prodDesVn.setDescription("Laptop Toshiba tốt nhất");
		
		
		ProductAttributeValue nameAttributeValue = new ProductAttributeValue();
		nameAttributeValue.setValue("Toshiba Satellite Pro C70 PSCNRA-00E00J 17.3\" Notebook i5 8GB 1TB Win 7/8.1 Pro");
		
		ProductAttribute nameAttribute = new ProductAttribute();
		nameAttribute.setName("Name");
		nameAttribute.setAttributeType(ProductAttributeType.TEXT);
		nameAttribute.getAttributeValues().add(nameAttributeValue);
		nameAttributeValue.setAttribute(nameAttribute);
		
		ProductImage prodSmallImage = new ProductImage();
		prodSmallImage.setImage("2016/02/ab61268_13.jpg");
		prodSmallImage.setImageSize(ImageSize.MEDIUM);
		prodSmallImage.setActive(true);
		
		Product prod1 = new Product();
		prod1.setNewArrival(true);
		prod1.setAvailable(true);
		prod1.setFeaturedSeller(true);
		prod1.setPrice(new BigDecimal(1430.98));
		prod1.setSalePrice(new BigDecimal(1300.98));
		
		prod1.setManufacturer(manufacturerDao.getByName("Toshiba"));
		prod1.getCategories().add(categoryDao.getByName("Laptop"));
		prod1.getAttributes().add(nameAttribute);
		prod1.getProductImages().add(prodSmallImage);
		prod1.getDescriptions().add(prodDesEn);
		prod1.getDescriptions().add(prodDesVn);
		
		prodDesEn.setProduct(prod1);
		prodDesVn.setProduct(prod1);
		
		nameAttribute.setProduct(prod1);
		prodSmallImage.setProduct(prod1);
		
		productDao.create(prod1);
	}
	
	public static void createProd3() {
		
		ProductDescription prodDesEn = new ProductDescription();
		prodDesEn.setLanguage(languageDao.getByCode("en"));
		prodDesEn.setDescription("The best laptop Acer");
		
		ProductDescription prodDesVn = new ProductDescription();
		prodDesVn.setLanguage(languageDao.getByCode("vn"));
		prodDesVn.setDescription("Laptop Acer tốt nhất");
		
		
		ProductAttributeValue nameAttributeValue = new ProductAttributeValue();
		nameAttributeValue.setValue("Acer Aspire V Nitro VN7-592G-76DD 15.6\" i7-6700HQ 16GB 128GB 2TB GTX960M Win10");
		
		ProductAttribute nameAttribute = new ProductAttribute();
		nameAttribute.setName("Name");
		nameAttribute.setAttributeType(ProductAttributeType.TEXT);
		nameAttribute.getAttributeValues().add(nameAttributeValue);
		nameAttributeValue.setAttribute(nameAttribute);
		
		ProductImage prodSmallImage = new ProductImage();
		prodSmallImage.setImage("2016/02/ab68633.jpg");
		prodSmallImage.setImageSize(ImageSize.MEDIUM);
		prodSmallImage.setActive(true);
		
		Product prod1 = new Product();
		prod1.setNewArrival(true);
		prod1.setAvailable(true);
		prod1.setFeaturedSeller(true);
		prod1.setPrice(new BigDecimal(1999.00));
		
		prod1.setManufacturer(manufacturerDao.getByName("Acer"));
		prod1.getCategories().add(categoryDao.getByName("Laptop"));
		prod1.getAttributes().add(nameAttribute);
		prod1.getProductImages().add(prodSmallImage);
		prod1.getDescriptions().add(prodDesEn);
		prod1.getDescriptions().add(prodDesVn);
		
		prodDesEn.setProduct(prod1);
		prodDesVn.setProduct(prod1);
		
		nameAttribute.setProduct(prod1);
		prodSmallImage.setProduct(prod1);
		
		productDao.create(prod1);
	}
	
	public static void createProd4() {
		
		ProductDescription prodDesEn = new ProductDescription();
		prodDesEn.setLanguage(languageDao.getByCode("en"));
		prodDesEn.setDescription("The best laptop Acer");
		
		ProductDescription prodDesVn = new ProductDescription();
		prodDesVn.setLanguage(languageDao.getByCode("vn"));
		prodDesVn.setDescription("Laptop Acer tốt nhất");
		
		
		ProductAttributeValue nameAttributeValue = new ProductAttributeValue();
		nameAttributeValue.setValue("ACER Predator G9-591-72LV 15.6\" Gaming Notebook i7 16GB 1TB 128GB GTX970M Win 10");
		
		ProductAttribute nameAttribute = new ProductAttribute();
		nameAttribute.setName("Name");
		nameAttribute.setAttributeType(ProductAttributeType.TEXT);
		nameAttribute.getAttributeValues().add(nameAttributeValue);
		nameAttributeValue.setAttribute(nameAttribute);
		
		ProductImage prodSmallImage = new ProductImage();
		prodSmallImage.setImage("2016/02/ab69922_5.jpg");
		prodSmallImage.setImageSize(ImageSize.MEDIUM);
		prodSmallImage.setActive(true);
		
		Product prod1 = new Product();
		prod1.setNewArrival(true);
		prod1.setAvailable(true);
		prod1.setFeaturedSeller(true);
		prod1.setPrice(new BigDecimal(2999.00));
		
		prod1.setManufacturer(manufacturerDao.getByName("Acer"));
		prod1.getCategories().add(categoryDao.getByName("Laptop"));
		prod1.getAttributes().add(nameAttribute);
		prod1.getProductImages().add(prodSmallImage);
		prod1.getDescriptions().add(prodDesEn);
		prod1.getDescriptions().add(prodDesVn);
		
		prodDesEn.setProduct(prod1);
		prodDesVn.setProduct(prod1);
		
		nameAttribute.setProduct(prod1);
		prodSmallImage.setProduct(prod1);
		
		productDao.create(prod1);
	}
	
	public static void createProd5() {
		
		ProductDescription prodDesEn = new ProductDescription();
		prodDesEn.setLanguage(languageDao.getByCode("en"));
		prodDesEn.setDescription("The best laptop Asus");
		
		ProductDescription prodDesVn = new ProductDescription();
		prodDesVn.setLanguage(languageDao.getByCode("vn"));
		prodDesVn.setDescription("Laptop Asus tốt nhất");
		
		
		ProductAttributeValue nameAttributeValue = new ProductAttributeValue();
		nameAttributeValue.setValue("ASUS ROG G501JW-FI398T 15.6 UHD Notebook i7-4750HQ 16GB 512GB GTX 960M 4GB Win10");
		
		ProductAttribute nameAttribute = new ProductAttribute();
		nameAttribute.setName("Name");
		nameAttribute.setAttributeType(ProductAttributeType.TEXT);
		nameAttribute.getAttributeValues().add(nameAttributeValue);
		nameAttributeValue.setAttribute(nameAttribute);
		
		ProductImage prodSmallImage = new ProductImage();
		prodSmallImage.setImage("2016/02/ab66755.jpg");
		prodSmallImage.setImageSize(ImageSize.MEDIUM);
		prodSmallImage.setActive(true);
		
		Product prod1 = new Product();
		prod1.setNewArrival(true);
		prod1.setAvailable(true);
		prod1.setFeaturedSeller(true);
		prod1.setPrice(new BigDecimal(2539.00));
		
		prod1.setManufacturer(manufacturerDao.getByName("Asus"));
		prod1.getCategories().add(categoryDao.getByName("Laptop"));
		prod1.getAttributes().add(nameAttribute);
		prod1.getProductImages().add(prodSmallImage);
		prod1.getDescriptions().add(prodDesEn);
		prod1.getDescriptions().add(prodDesVn);
		
		prodDesEn.setProduct(prod1);
		prodDesVn.setProduct(prod1);
		
		nameAttribute.setProduct(prod1);
		prodSmallImage.setProduct(prod1);
		
		productDao.create(prod1);
	}
	
	public static void createProd6() {
		
		ProductDescription prodDesEn = new ProductDescription();
		prodDesEn.setLanguage(languageDao.getByCode("en"));
		prodDesEn.setDescription("The best laptop Asus");
		
		ProductDescription prodDesVn = new ProductDescription();
		prodDesVn.setLanguage(languageDao.getByCode("vn"));
		prodDesVn.setDescription("Laptop Asus tốt nhất");
		
		
		ProductAttributeValue nameAttributeValue = new ProductAttributeValue();
		nameAttributeValue.setValue("ASUS F555UJ-XO050T 15.6\" Notebook i5 8GB 1TB GeForce 920M Win 10 Home - Black");
		
		ProductAttribute nameAttribute = new ProductAttribute();
		nameAttribute.setName("Name");
		nameAttribute.setAttributeType(ProductAttributeType.TEXT);
		nameAttribute.getAttributeValues().add(nameAttributeValue);
		nameAttributeValue.setAttribute(nameAttribute);
		
		ProductImage prodSmallImage = new ProductImage();
		prodSmallImage.setImage("2016/02/ab69989.jpg");
		prodSmallImage.setImageSize(ImageSize.MEDIUM);
		prodSmallImage.setActive(true);
		
		Product prod1 = new Product();
		prod1.setNewArrival(true);
		prod1.setAvailable(true);
		prod1.setFeaturedSeller(true);
		prod1.setPrice(new BigDecimal(938.98));
		
		prod1.setManufacturer(manufacturerDao.getByName("Asus"));
		prod1.getCategories().add(categoryDao.getByName("Laptop"));
		prod1.getAttributes().add(nameAttribute);
		prod1.getProductImages().add(prodSmallImage);
		prod1.getDescriptions().add(prodDesEn);
		prod1.getDescriptions().add(prodDesVn);
		
		prodDesEn.setProduct(prod1);
		prodDesVn.setProduct(prod1);
		
		nameAttribute.setProduct(prod1);
		prodSmallImage.setProduct(prod1);
		
		productDao.create(prod1);
	}
	
	public static void createProd7() {
		
		ProductDescription prodDesEn = new ProductDescription();
		prodDesEn.setLanguage(languageDao.getByCode("en"));
		prodDesEn.setDescription("The best laptop HP");
		
		ProductDescription prodDesVn = new ProductDescription();
		prodDesVn.setLanguage(languageDao.getByCode("vn"));
		prodDesVn.setDescription("Laptop HP tốt nhất");
		
		
		ProductAttributeValue nameAttributeValue = new ProductAttributeValue();
		nameAttributeValue.setValue("HP EliteBook 840 G2 14\" Notebook i7-5600U 4GB 32GB 500GB R7 M260X Win 7 Pro");
		
		ProductAttribute nameAttribute = new ProductAttribute();
		nameAttribute.setName("Name");
		nameAttribute.setAttributeType(ProductAttributeType.TEXT);
		nameAttribute.getAttributeValues().add(nameAttributeValue);
		nameAttributeValue.setAttribute(nameAttribute);
		
		ProductImage prodSmallImage = new ProductImage();
		prodSmallImage.setImage("2016/02/ab73260.jpg");
		prodSmallImage.setImageSize(ImageSize.MEDIUM);
		prodSmallImage.setActive(true);
		
		Product prod1 = new Product();
		prod1.setNewArrival(true);
		prod1.setAvailable(true);
		prod1.setFeaturedSeller(true);
		prod1.setPrice(new BigDecimal(2499.00));
		
		prod1.setManufacturer(manufacturerDao.getByName("HP"));
		prod1.getCategories().add(categoryDao.getByName("Laptop"));
		prod1.getAttributes().add(nameAttribute);
		prod1.getProductImages().add(prodSmallImage);
		prod1.getDescriptions().add(prodDesEn);
		prod1.getDescriptions().add(prodDesVn);
		
		prodDesEn.setProduct(prod1);
		prodDesVn.setProduct(prod1);
		
		nameAttribute.setProduct(prod1);
		prodSmallImage.setProduct(prod1);
		
		productDao.create(prod1);
	}
	
	public static void createProd8() {
		
		ProductDescription prodDesEn = new ProductDescription();
		prodDesEn.setLanguage(languageDao.getByCode("en"));
		prodDesEn.setDescription("The best laptop Dell");
		
		ProductDescription prodDesVn = new ProductDescription();
		prodDesVn.setLanguage(languageDao.getByCode("vn"));
		prodDesVn.setDescription("Laptop Dell tốt nhất");
		
		
		ProductAttributeValue nameAttributeValue = new ProductAttributeValue();
		nameAttributeValue.setValue("Dell Latitude E6330 13.3\" Notebook i5 3360M 4GB 256GB SSD Win7Pro - Refurbished");
		
		ProductAttribute nameAttribute = new ProductAttribute();
		nameAttribute.setName("Name");
		nameAttribute.setAttributeType(ProductAttributeType.TEXT);
		nameAttribute.getAttributeValues().add(nameAttributeValue);
		nameAttributeValue.setAttribute(nameAttribute);
		
		ProductImage prodSmallImage = new ProductImage();
		prodSmallImage.setImage("2016/02/ab73593.jpg");
		prodSmallImage.setImageSize(ImageSize.MEDIUM);
		prodSmallImage.setActive(true);
		
		Product prod1 = new Product();
		prod1.setNewArrival(true);
		prod1.setAvailable(true);
		prod1.setFeaturedSeller(true);
		prod1.setPrice(new BigDecimal(399.00));
		
		prod1.setManufacturer(manufacturerDao.getByName("Dell"));
		prod1.getCategories().add(categoryDao.getByName("Laptop"));
		prod1.getAttributes().add(nameAttribute);
		prod1.getProductImages().add(prodSmallImage);
		prod1.getDescriptions().add(prodDesEn);
		prod1.getDescriptions().add(prodDesVn);
		
		prodDesEn.setProduct(prod1);
		prodDesVn.setProduct(prod1);
		
		nameAttribute.setProduct(prod1);
		prodSmallImage.setProduct(prod1);
		
		productDao.create(prod1);
	}
}
