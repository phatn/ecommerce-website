package com.manifera.meshop.core.dao.impl;

import java.util.HashSet;
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
import com.manifera.meshop.core.domain.Language;
import com.manifera.meshop.core.domain.Manufacturer;
import com.manifera.meshop.core.domain.Product;

@Repository("productDao")
public class ProductDaoImpl extends AbstractGenericDao<Product, Long> implements ProductDao {

	private static final Logger LOG = LoggerFactory.getLogger(ProductDaoImpl.class);
	
	@Override
	public List<Product> getAllProducts(Language language) {
		StringBuilder queryBuilder = new StringBuilder();
		queryBuilder.append("select DISTINCT p from Product p ");
		queryBuilder.append("left join p.descriptions pd ");
		queryBuilder.append("where pd.language.code = :code ");
		queryBuilder.append("p.available is true and p.deleted is false");
		
		TypedQuery<Product> query = getEntityManager().createQuery(queryBuilder.toString(), Product.class);
		query.setParameter("code", language.getCode());
		
		return query.getResultList();
	}

	@Override
	public Page<Product> getAllProducts(Language language, int offet, int limit) {
		StringBuilder queryBuilder = new StringBuilder();
		queryBuilder.append("select DISTINCT p from Product p ");
		queryBuilder.append("left join p.descriptions pd ");
		queryBuilder.append("where pd.language.code = :code ");
		queryBuilder.append("p.available is true and p.deleted is false");
		
		TypedQuery<Product> query = getEntityManager().createQuery(queryBuilder.toString(), Product.class);
		query.setParameter("code", language.getCode());
		query.setFirstResult(offet).setMaxResults(limit);
		
		return new Page<Product>(count(), query.getResultList());
	}

	@Override
	public Page<Product> getProductsByCategoryId(long categoryId, Language language, int offset, int limit) {
		StringBuilder queryBuilder = new StringBuilder();
		queryBuilder.append("select DISTINCT p from Product p ");
		queryBuilder.append("left join p.descriptions pd ");
		queryBuilder.append("join fetch p.attributes a join fetch a.attributeValues av ");
		queryBuilder.append("join fetch p.productImages i join  p.categories c ");
		queryBuilder.append("where pd.language.code = :code ");
		queryBuilder.append("and c.id = :categoryId");
		
		TypedQuery<Product> query = getEntityManager().createQuery(queryBuilder.toString(), Product.class);
		query.setParameter("code", language.getCode());
		query.setParameter("categoryId", categoryId);
		query.setFirstResult(offset).setMaxResults(limit);
		
		// Count total records
		TypedQuery<Long> queryCount = getEntityManager().createQuery("select count(*) from Product p join p.categories c where c.id = :categoryId", Long.class);
		queryCount.setParameter("categoryId", categoryId);
		Long totalRecords = queryCount.getSingleResult();
		LOG.info("getProductsByCategoryId method - total records: " + totalRecords);
		return new Page<Product>(totalRecords, query.getResultList());
	}

	@Override
	public Page<Product> getProductsByCategory(Category category, Language language, int offset, int limit) {
		return getProductsByCategoryId(category.getId(), language, offset, limit);
	}
	
	@Override
	public Page<Product> getProductsByCategories(List<Category> categories, Language language, int offset, int limit) {
		Set<Long> categoryIds = new HashSet<>();
		for(Category cat : categories) {
			categoryIds.add(cat.getId());
		}
		return getProductsByCategoryIds(categoryIds, language, offset, limit);
	}

	@Override
	public Page<Product> getProductsByCategoryIds(Set<Long> categoryIds, Language language, int offset, int limit) {
		StringBuilder queryBuilder = new StringBuilder();
		queryBuilder.append("select DISTINCT p from Product p ");
		queryBuilder.append("left join p.descriptions pd ");
		queryBuilder.append("join fetch p.attributes a join fetch a.attributeValues av ");
		queryBuilder.append("join fetch p.productImages i join p.categories c ");
		queryBuilder.append("where pd.language.code = :code ");
		queryBuilder.append("and c.id in :categoryIds");
		
		TypedQuery<Product> query = getEntityManager().createQuery(queryBuilder.toString(), Product.class);
		query.setParameter("code", language.getCode());
		
		query.setParameter("categoryIds", categoryIds);
		query.setFirstResult(offset).setMaxResults(limit);
		
		// Count total records
		TypedQuery<Long> queryCount = getEntityManager().createQuery("select count(*) from Product p join p.categories c where c.id in :categoryIds", Long.class);
		queryCount.setParameter("categoryIds", categoryIds);
		Long totalRecords = queryCount.getSingleResult();
		LOG.info("getProductsByCategories method - Total records: " + totalRecords);
		return new Page<Product>(totalRecords, query.getResultList());
	}

	@Override
	public Page<Product> getFeaturedProducts(Language language) {
		return getFeaturedProducts(language.getCode());
	}

	@Override
	public Page<Product> getFeaturedProducts(String languageCode) {
		
		// Construct query to get featured products
		StringBuilder queryBuilder = new StringBuilder();
		queryBuilder.append("select DISTINCT p from Product p join fetch p.descriptions pd left join fetch p.attributes a ");
		queryBuilder.append("join fetch a.attributeValues av left join fetch p.productImages i ");
		queryBuilder.append("where p.featuredSeller is true ");
		queryBuilder.append("and pd.language.code = :languageCode ");
		queryBuilder.append("and p.available is true and p.deleted is false");
		
		TypedQuery<Product> query = getEntityManager().createQuery(queryBuilder.toString(), Product.class);
		query.setParameter("languageCode", languageCode);
		
		
		// Construct query to count featured products
		StringBuilder queryBuilderCount = new StringBuilder();
		queryBuilderCount.append("select count(*) from Product p ");
		queryBuilderCount.append("where p.featuredSeller is true ");
		queryBuilderCount.append("and p.available is true and p.deleted is false");
		TypedQuery<Long> queryCount = getEntityManager().createQuery(queryBuilderCount.toString(), Long.class);
		
		return new Page<Product>(queryCount.getSingleResult(), query.getResultList());
	}
	
	@Override
	public Page<Product> getClearanceProducts(Language language) {
		
		// Construct query to get clearance products
		StringBuilder queryBuilder = new StringBuilder();
		queryBuilder.append("select DISTINCT p from Product p join fetch p.descriptions pd left join fetch p.attributes a ");
		queryBuilder.append("join fetch a.attributeValues av left join fetch p.productImages i ");
		queryBuilder.append("where p.clearance is true ");
		queryBuilder.append("and pd.language.code = :languageCode ");
		queryBuilder.append("and p.available is true and p.deleted is false");
		
		TypedQuery<Product> query = getEntityManager().createQuery(queryBuilder.toString(), Product.class);
		query.setParameter("languageCode", language.getCode());
		
		// Construct query to count clearance products
		StringBuilder queryBuilderCount = new StringBuilder();
		queryBuilderCount.append("select count(*) from Product p ");
		queryBuilderCount.append("where p.clearance is true ");
		queryBuilderCount.append("and p.available is true and p.deleted is false");
		TypedQuery<Long> queryCount = getEntityManager().createQuery(queryBuilderCount.toString(), Long.class);
		
		return new Page<Product>(queryCount.getSingleResult(), query.getResultList());
	}

	@Override
	public Page<Product> getNewArrivalProducts(Language language) {
		return getNewArrivalProducts(language.getCode());
	}

	@Override
	public Page<Product> getNewArrivalProducts(String languageCode) {
		if(languageCode == null || languageCode.isEmpty()) {
			languageCode = "en";
		}
		
		// Construct query to get new arrival products
		StringBuilder queryBuilder = new StringBuilder();
		queryBuilder.append("select DISTINCT p from Product p left join fetch p.descriptions pd ");
		queryBuilder.append("left join fetch p.attributes a left join fetch a.attributeValues av ");
		queryBuilder.append("left join fetch p.productImages i ");
		queryBuilder.append("where p.newArrival is true ");
		queryBuilder.append("and pd.language.code = :languageCode ");
		queryBuilder.append("and p.available is true and p.deleted is false");
		
		TypedQuery<Product> query = getEntityManager().createQuery(queryBuilder.toString(), Product.class);
		query.setParameter("languageCode", languageCode);
		
		// Construct query to count new release products
		StringBuilder queryBuilderCount = new StringBuilder();
		queryBuilderCount.append("select count(*) from Product p ");
		queryBuilderCount.append("where p.newArrival is true ");
		queryBuilderCount.append("and p.available is true and p.deleted is false");
		TypedQuery<Long> queryCount = getEntityManager().createQuery(queryBuilderCount.toString(), Long.class);
		
		return new Page<Product>(queryCount.getSingleResult(), query.getResultList());
	}
	
	@Override
	public Product getById(long id, Language language) {
		StringBuilder queryBuilder = new StringBuilder();
		queryBuilder.append("select p from Product p ");
		queryBuilder.append("left join fetch p.descriptions pd ");
		queryBuilder.append("join fetch p.attributes a join fetch a.attributeValues av ");
		queryBuilder.append("join fetch p.productImages ");
		queryBuilder.append("and p.id = :id and pd.language.code = :code");
		
		TypedQuery<Product> query = getEntityManager().createQuery(queryBuilder.toString(), Product.class);
		query.setParameter("id", id);
		query.setParameter("code", language.getCode());
		
		return query.getSingleResult();
	}

	@Override
	public Page<Product> getProductsByManufacturer(Manufacturer manufacturer, Language language, int offset,
			int limit) {
		
		return null;
	}

	@Override
	public Page<Product> getProductsByManufacturerId(long manufacturerId, Language language, int offset, int limit) {
		return null;
	}

	@Override
	public Page<Product> getProductsByManufacturerSefUrl(String manufacturerSefUrl, Language language, int offset,
			int limit) {
		return getProductsByManufacturerSefUrl(manufacturerSefUrl, language.getCode(), offset, limit);
	}

	@Override
	public Page<Product> getProductsByManufacturerSefUrl(String manufacturerSefUrl, String languageCode, int offset,
			int limit) {
		StringBuilder queryBuilder = new StringBuilder();
		queryBuilder.append("select DISTINCT p from Product p ");
		queryBuilder.append("left join p.descriptions pd ");
		queryBuilder.append("join fetch p.attributes a join fetch a.attributeValues av ");
		queryBuilder.append("join fetch p.productImages i join  p.manufacturer m ");
		queryBuilder.append("where pd.language.code = :code ");
		queryBuilder.append("and m.sefUrl = :sefUrl");
		
		TypedQuery<Product> query = getEntityManager().createQuery(queryBuilder.toString(), Product.class);
		query.setParameter("code", languageCode);
		query.setParameter("sefUrl", manufacturerSefUrl);
		query.setFirstResult(offset).setMaxResults(limit);
		
		// Count total records
		TypedQuery<Long> queryCount = getEntityManager().createQuery("select count(*) from Product p join p.manufacturer m where m.sefUrl = :sefUrl", Long.class);
		queryCount.setParameter("sefUrl", manufacturerSefUrl);
		Long totalRecords = queryCount.getSingleResult();
		LOG.info("getProductsByCategoryId method - total records: " + totalRecords);
		
		return new Page<Product>(totalRecords, query.getResultList());
	}

	@Override
	public Page<Product> getByCatSefUrlAndManuSefUrl(String categorySefUrl, String manufacturerSefUrl,
			String languageCode, int offset, int limit) {
		StringBuilder queryBuilder = new StringBuilder();
		queryBuilder.append("select DISTINCT p from Product p ");
		queryBuilder.append("left join p.categories c ");
		queryBuilder.append("left join c.descriptions cd ");
		queryBuilder.append("left join p.descriptions pd ");
		queryBuilder.append("join fetch p.attributes a join fetch a.attributeValues av ");
		queryBuilder.append("join fetch p.productImages i join  p.manufacturer m ");
		queryBuilder.append("where pd.language.code = :pdcode ");
		queryBuilder.append("and cd.language.code = :cdcode ");
		queryBuilder.append("and cd.sefUrl = :categorySefUrl ");
		queryBuilder.append("and m.sefUrl = :manufacturerSefUrl");
		
		TypedQuery<Product> query = getEntityManager().createQuery(queryBuilder.toString(), Product.class);
		query.setParameter("pdcode", languageCode);
		query.setParameter("cdcode", languageCode);
		query.setParameter("categorySefUrl", categorySefUrl);
		query.setParameter("manufacturerSefUrl", manufacturerSefUrl);
		
		query.setFirstResult(offset).setMaxResults(limit);
		
		// Count total records
		StringBuilder queryCountBuilder = new StringBuilder();
		queryCountBuilder.append("select count(DISTINCT p) from Product p ");
		queryCountBuilder.append("left join p.categories c ");
		queryCountBuilder.append("left join c.descriptions cd ");
		queryCountBuilder.append("left join p.manufacturer m ");
		queryCountBuilder.append("where cd.sefUrl = :categorySefUrl ");
		queryCountBuilder.append("and m.sefUrl = :manufacturerSefUrl");
		
		TypedQuery<Long> queryCount = getEntityManager().createQuery(queryCountBuilder.toString(), Long.class);
		queryCount.setParameter("categorySefUrl", categorySefUrl);
		queryCount.setParameter("manufacturerSefUrl", manufacturerSefUrl);
		
		Long totalRecords = queryCount.getSingleResult();
		LOG.info("getProductsByCategoryId method - total records: " + totalRecords);
		
		return new Page<Product>(totalRecords, query.getResultList());
	}

}
