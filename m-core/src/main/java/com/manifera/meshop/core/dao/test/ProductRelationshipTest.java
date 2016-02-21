package com.manifera.meshop.core.dao.test;

import java.util.List;

import javax.persistence.EntityTransaction;

import com.manifera.meshop.core.domain.Product;
import com.manifera.meshop.core.domain.ProductRelationship;

public class ProductRelationshipTest extends AbstractDomainTest {

	public static void main(String[] args) {
		EntityTransaction tx = entityManager.getTransaction();
		try {
			tx.begin();
			Product product = productDao.get(205L);
			List<Product> relatedProducts = productDao.getAll();
			relatedProducts.remove(product);
			
			createProductRelationship(product, relatedProducts);
			
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

	public static void createProductRelationship(Product product, List<Product> relatedProducts) {
		
		
		for(Product relatedProduct : relatedProducts) {
			ProductRelationship productRelationship = new ProductRelationship();
			productRelationship.setRelatedProduct(relatedProduct);
			productRelationship.setProduct(product);
			product.getRelationships().add(productRelationship);
			
			productDao.update(product);
		}
		
	}
}
