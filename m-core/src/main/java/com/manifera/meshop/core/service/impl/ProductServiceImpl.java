package com.manifera.meshop.core.service.impl;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.manifera.meshop.core.dao.ProductDao;
import com.manifera.meshop.core.dao.common.Page;
import com.manifera.meshop.core.domain.Category;
import com.manifera.meshop.core.domain.Language;
import com.manifera.meshop.core.domain.Product;
import com.manifera.meshop.core.domain.ProductPriceRange;
import com.manifera.meshop.core.service.ProductService;

@Service("productService")
public class ProductServiceImpl implements ProductService {
	
	@Autowired
	private ProductDao productDao;

	@Override
	public Product getById(long id, Language language) {
		return productDao.getById(id, language);
	}

	@Override
	public Product getById(long id, String languageCode) {
		return productDao.getById(id, languageCode);
	}
	
	@Override
	public List<Product> getAllProducts(Language language) {
		return productDao.getAllProducts(language);
	}

	@Override
	public Page<Product> getAllProducts(Language language, int offet, int limit) {
		return productDao.getAllProducts(language, offet, limit);
	}

	@Override
	public Page<Product> getProductsByCategory(Category category, Language language, int offset, int limit) {
		return productDao.getProductsByCategory(category, language, offset, limit);
	}

	@Override
	public Page<Product> getProductsByCategoryId(long categoryId, Language language, int offset, int limit) {
		return productDao.getProductsByCategoryId(categoryId, language, offset, limit);
	}

	@Override
	public Page<Product> getProductsByCategories(List<Category> categories, Language language, int offset, int limit) {
		return productDao.getProductsByCategories(categories, language, offset, limit);
	}

	@Override
	public Page<Product> getProductsByCategoryIds(Set<Long> categoryIds, Language language, int offset, int limit) {
		return productDao.getProductsByCategoryIds(categoryIds, language, offset, limit);
	}

	@Override
	public Page<Product> getFeaturedProducts(Language language) {
		return productDao.getFeaturedProducts(language);
	}

	@Override
	public Page<Product> getClearanceProducts(Language language) {
		return productDao.getClearanceProducts(language);
	}

	@Override
	public Page<Product> getNewArrivalProducts(Language language) {
		return productDao.getNewArrivalProducts(language);
	}

	@Override
	public Page<Product> getNewArrivalProducts(String languageCode) {
		return productDao.getNewArrivalProducts(languageCode);
	}

	@Override
	public Page<Product> getFeaturedProducts(String languageCode) {
		return productDao.getFeaturedProducts(languageCode);
	}

	@Override
	public Page<Product> getProductsByManufacturerSefUrl(String manufacturerSefUrl, String languageCode, int offset,
			int limit) {
		return productDao.getProductsByManufacturerSefUrl(manufacturerSefUrl, languageCode, offset, limit);
	}

	@Override
	public Page<Product> getByCatSefUrlAndManuSefUrl(String categorySefUrl, String manufacturerSefUrl,
			String languageCode, int offset, int limit) {
		return productDao.getByCatSefUrlAndManuSefUrl(categorySefUrl, manufacturerSefUrl, languageCode, offset, limit);
	}

	@Override
	public Page<Product> getByCatUrlAndPriceRange(String categorySefUrl, ProductPriceRange priceRange,
			String languageCode, int offset, int limit) {
		return productDao.getByCatUrlAndPriceRange(categorySefUrl, priceRange, languageCode, offset, limit);
	}

	@Override
	public Product getBySefUrl(String productSefUrl, String languageCode) {
		return productDao.getBySefUrl(productSefUrl, languageCode);
	}

	@Override
	public List<Product> getByIds(List<Long> productIds) {
		return productDao.getByIds(productIds);
	}

}
