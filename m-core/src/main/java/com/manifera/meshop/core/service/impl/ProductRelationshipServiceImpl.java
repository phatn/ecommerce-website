package com.manifera.meshop.core.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.manifera.meshop.core.dao.ProductRelationshipDao;
import com.manifera.meshop.core.domain.Product;
import com.manifera.meshop.core.domain.ProductRelationship;
import com.manifera.meshop.core.service.ProductRelationshipService;

@Service("productRelationshipService")
public class ProductRelationshipServiceImpl implements ProductRelationshipService {

	@Autowired
	private ProductRelationshipDao productRelationshipDao;
	
	@Override
	public List<ProductRelationship> getProductRelationships(Product product) {
		return productRelationshipDao.getProductRelationships(product);
	}

	@Override
	public List<ProductRelationship> getProductRelationships(long productId) {
		return productRelationshipDao.getProductRelationships(productId);
	}

}
