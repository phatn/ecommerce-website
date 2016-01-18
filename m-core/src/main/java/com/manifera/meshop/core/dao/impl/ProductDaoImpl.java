package com.manifera.meshop.core.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.manifera.meshop.core.constant.ConstantKey;
import com.manifera.meshop.core.dao.ProductDao;
import com.manifera.meshop.core.dao.common.AbstractGenericDao;
import com.manifera.meshop.core.domain.Category;
import com.manifera.meshop.core.domain.Product;

@Repository("productDao")
public class ProductDaoImpl extends AbstractGenericDao<Product> implements ProductDao {

	@Override
	public List<Product> getAllProducts() {
		TypedQuery<Product> query = getEntityManager().createQuery("select p from Product", Product.class);
		return query.getResultList();
	}

	@Override
	public Map<String, ?> getAllProducts(int offet, int limit) {
		TypedQuery<Product> query = getEntityManager().createQuery("select p from Product", Product.class);
		query.setFirstResult(offet);
		query.setMaxResults(limit);
		Map<String, Object> resultMap = new HashMap<>();
		resultMap.put(ConstantKey.PRODUCTS, query.getResultList());
		resultMap.put(ConstantKey.TOTAL_RECORDS, count());
		return resultMap;
	}

	@Override
	public Map<String, ?> getProductsByCategory(Category category, int offset, int limit) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<String, ?> getProductsByCategoryId(Category categoryId, int offset, int limit) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<String, ?> getProductsByCategories(List<Category> categories, int offset, int limit) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<String, ?> getProductsByCategoryIds(Set<Long> categoryIds) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<String, ?> getRelatedProductsById(long productId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteById(long productId) {
		// TODO Auto-generated method stub
		
	}

}
