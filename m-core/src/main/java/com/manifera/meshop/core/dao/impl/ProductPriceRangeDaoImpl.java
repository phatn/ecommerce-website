package com.manifera.meshop.core.dao.impl;

import java.util.List;

import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.manifera.meshop.core.dao.ProductPriceRangeDao;
import com.manifera.meshop.core.dao.common.AbstractGenericDao;
import com.manifera.meshop.core.domain.ProductPriceRange;

@Repository("productPriceRangeDao")
public class ProductPriceRangeDaoImpl extends 
	AbstractGenericDao<ProductPriceRange, Long> implements ProductPriceRangeDao {

	@Override
	public List<ProductPriceRange> getAllPriceRanges() {
		
		return getEntityManager().
				createQuery("select pr from ProductPriceRange pr order by pr.sortOrder asc", 
						ProductPriceRange.class).getResultList();
	}

	@Override
	public ProductPriceRange getBySefUrl(String sefUrl) {
		TypedQuery<ProductPriceRange> query = getEntityManager().createQuery("select pr from ProductPriceRange pr where pr.sefUrl = :sefUrl", ProductPriceRange.class);
		query.setParameter("sefUrl", sefUrl);
		return query.getSingleResult();
	}

}
