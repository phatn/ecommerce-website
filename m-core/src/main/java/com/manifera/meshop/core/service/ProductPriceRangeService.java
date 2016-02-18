package com.manifera.meshop.core.service;

import java.util.List;

import com.manifera.meshop.core.domain.ProductPriceRange;
import com.manifera.meshop.core.service.common.BaseService;

public interface ProductPriceRangeService extends BaseService {
	
	public void create(ProductPriceRange productPriceRange);
	
	public List<ProductPriceRange> getAllPriceRanges();
	
	public ProductPriceRange getBySefUrl(String sefUrl);
	
}
