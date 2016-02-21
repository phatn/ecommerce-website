package com.manifera.meshop.core.dao.impl;

import java.util.List;

import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.manifera.meshop.core.dao.ProductRelationshipDao;
import com.manifera.meshop.core.dao.common.AbstractGenericDao;
import com.manifera.meshop.core.domain.Product;
import com.manifera.meshop.core.domain.ProductRelationship;

@Repository("productRelationshipDao")
public class ProductRelationshipDaoImpl  extends AbstractGenericDao<ProductRelationshipDao, Long> implements ProductRelationshipDao {

	@Override
	public List<ProductRelationship> getProductRelationships(Product product) {
		return getProductRelationships(product.getId());
	}

	@Override
	public List<ProductRelationship> getProductRelationships(long productId) {
		
		StringBuilder queryBuilder = new StringBuilder();
		queryBuilder.append("select DISTINCT pr from ProductRelationship pr join fetch pr.relatedProduct rp ");
		queryBuilder.append("join fetch rp.descriptions pd left join fetch rp.attributes a ");
		queryBuilder.append("join fetch a.attributeValues av left join fetch rp.productImages i ");
		queryBuilder.append("where pr.product.id = :productId");
		
		TypedQuery<ProductRelationship> query = getEntityManager().createQuery(queryBuilder.toString(), ProductRelationship.class);
		query.setParameter("productId", productId);
		
		return query.getResultList();
	}

}
