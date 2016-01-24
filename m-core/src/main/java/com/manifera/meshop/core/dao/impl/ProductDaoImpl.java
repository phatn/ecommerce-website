package com.manifera.meshop.core.dao.impl;

import java.util.List;
import java.util.Set;

import javax.persistence.TypedQuery;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.manifera.meshop.core.dao.ProductDao;
import com.manifera.meshop.core.dao.common.AbstractGenericDao;
import com.manifera.meshop.core.dao.common.Page;
import com.manifera.meshop.core.domain.Category;
import com.manifera.meshop.core.domain.ImageSize;
import com.manifera.meshop.core.domain.Product;

@Repository("productDao")
public class ProductDaoImpl extends AbstractGenericDao<Product, Long> implements ProductDao {

	private static final Logger LOG = LoggerFactory.getLogger(ProductDaoImpl.class);
	
	@Override
	public Page<Product> getAllProducts() {
		TypedQuery<Product> query = getEntityManager().createQuery("select p from Product", Product.class);
		Page<Product> page = new Page<Product>();
		page.setList(query.getResultList());
		return page;
	}

	@Override
	public Page<Product> getAllProducts(int offet, int limit) {
		TypedQuery<Product> query = getEntityManager().createQuery("select p from Product", Product.class);
		query.setFirstResult(offet).setMaxResults(limit);
		return new Page<Product>(count(), query.getResultList());
	}

	@Override
	public Page<Product> getProductsByCategory(Category category, int offset, int limit) {
		return getProductsByCategoryId(category.getId(), offset, limit);
	}

	@Override
	public Page<Product> getProductsByCategoryId(long categoryId, int offset, int limit) {
		StringBuilder queryBuilder = new StringBuilder();
		queryBuilder.append("select DISTINCT p from Product p ");
		queryBuilder.append("join fetch p.attributes a join fetch a.attributeValues av ");
		queryBuilder.append("join fetch p.productImages i join  p.categories c  where i.imageSize = :imageSize ");
		queryBuilder.append("and a.name = :name and c.id = :categoryId");
		TypedQuery<Product> query = getEntityManager().createQuery(
				queryBuilder.toString(), Product.class);
		query.setParameter("name", "Name");
		query.setParameter("imageSize", ImageSize.SMALL);
		query.setParameter("categoryId", categoryId);
		query.setFirstResult(offset).setMaxResults(limit);
		
		// Count total records
		TypedQuery<Long> queryCount = getEntityManager().createQuery("select count(*) from Product p join p.categories c where c.id = :categoryId", Long.class);
		queryCount.setParameter("categoryId", categoryId);
		Long totalRecords = queryCount.getSingleResult();
		LOG.info("total records: " + totalRecords);
		return new Page<Product>(totalRecords, query.getResultList());
	}

	@Override
	public Page<Product> getProductsByCategories(List<Category> categories, int offset, int limit) {
		return null;
	}

	@Override
	public Page<Product> getProductsByCategoryIds(Set<Long> categoryIds) {
		return null;
	}

	@Override
	public Page<Product> getRelatedProductsById(long productId) {
		return null;
	}

	@Override
	public void deleteById(long productId) {
		
	}

}
