package com.manifera.meshop.core.dao.impl;

import java.util.Iterator;
import java.util.List;

import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.google.common.base.Strings;
import com.manifera.meshop.core.constant.Constant;
import com.manifera.meshop.core.dao.CategoryDao;
import com.manifera.meshop.core.dao.common.AbstractGenericDao;
import com.manifera.meshop.core.domain.Category;
import com.manifera.meshop.core.domain.Language;

@Repository("categoryDao")
public class CategoryDaoImpl extends AbstractGenericDao<Category, Long> implements CategoryDao {

	@Override
	public Category getById(long id, Language language) {
		StringBuilder queryBuilder = new StringBuilder();
		queryBuilder.append("select DISTINCT c from Category c left join fetch c.descriptions cd ");
		queryBuilder.append("where c.id =:id and cd.language.code = :code ");
		queryBuilder.append("and c.available is true and c.deleted is false");
		
		TypedQuery<Category> query = getEntityManager().createQuery(queryBuilder.toString(), Category.class);
		query.setParameter("id", id);
		query.setParameter("code", language.getCode());
		
		return query.getSingleResult();
	}

	@Override
	public List<Category> getAllCategories(Language language) {
		return getAllCategories(language.getCode());
	}

	@Override
	public List<Category> getAllCategories(String languageCode) {
		StringBuilder queryBuilder = new StringBuilder();
		queryBuilder.append("select DISTINCT c from Category c left join fetch c.descriptions cd ");
		queryBuilder.append("join fetch c.products p join fetch p.manufacturer m ");
		queryBuilder.append("where cd.language.code = :code ");
		queryBuilder.append("and c.available is true and c.deleted is false");
		
		TypedQuery<Category> query = getEntityManager().createQuery(queryBuilder.toString(), Category.class);
		query.setParameter("code", Strings.isNullOrEmpty(languageCode) ? Constant.DEFAULT_LANGUAGE_CODE : languageCode);
		
		return query.getResultList();
	}
	
	@Override
	public List<Category> getAllRootCategories(Language language) {
		StringBuilder queryBuilder = new StringBuilder();
		queryBuilder.append("select DISTINCT c from Category c left join fetch c.categories cats ");
		queryBuilder.append("left join fetch c.descriptions cd ");
		queryBuilder.append("join cd.language lang where c.parent is null and lang.code = :Code");
		
		TypedQuery<Category> query = getEntityManager().createQuery(queryBuilder.toString(), Category.class);
		query.setParameter("code", language.getCode());
		
		List<Category> rootCategories = query.getResultList();
		Iterator<Category> iterator = rootCategories.iterator();
		
		while(iterator.hasNext()) {
			if(iterator.next().getParent() != null) {
				iterator.remove();
			}
		}
		return rootCategories;
	}

	@Override
	public Category getByName(String name) {
		StringBuilder queryBuilder = new StringBuilder();
		queryBuilder.append("select c from Category c join c.descriptions cd ");
		queryBuilder.append("join cd.language l where l.code = :code and cd.name = :name");
		
		TypedQuery<Category> query = getEntityManager().createQuery(queryBuilder.toString(), Category.class);
		query.setParameter("code", "en");
		query.setParameter("name", name);
		
		return query.getSingleResult();
	}

}
