package com.manifera.meshop.core.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.manifera.meshop.core.dao.ProductPriceRangeDao;
import com.manifera.meshop.core.domain.ProductPriceRange;
import com.manifera.meshop.core.service.ProductPriceRangeService;

@Service("productPriceRangeService")
public class ProductPriceRangeServiceImpl implements ProductPriceRangeService {

	@Autowired
	private ProductPriceRangeDao productPriceRangeDao;
	
	@Override
	public void create(ProductPriceRange productPriceRange) {
		productPriceRangeDao.create(productPriceRange);
	}

	@Override
	public List<ProductPriceRange> getAllPriceRanges() {
		return productPriceRangeDao.getAllPriceRanges();
	}

	@Override
	public ProductPriceRange getBySefUrl(String sefUrl) {
		return productPriceRangeDao.getBySefUrl(sefUrl);
	}
}
