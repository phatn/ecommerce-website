package com.manifera.meshop.core.dao.impl;

import java.util.List;

import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.manifera.meshop.core.dao.ManufacturerDao;
import com.manifera.meshop.core.dao.common.AbstractGenericDao;
import com.manifera.meshop.core.domain.Category;
import com.manifera.meshop.core.domain.Manufacturer;

@Repository("manufacturerDao")
public class ManufacturerDaoImpl extends AbstractGenericDao<Manufacturer, Long> implements ManufacturerDao {

	@Override
	public List<Manufacturer> getManufacturersByCategory(Category category) {
		StringBuilder queryBuilder = new StringBuilder();
		queryBuilder.append("select m from Manufacturer m join m.products p ");
		queryBuilder.append("where p.categories.id = :categoryId");
		
		TypedQuery<Manufacturer> query = getEntityManager().createQuery(queryBuilder.toString(), Manufacturer.class);
		query.setParameter("categoryId", category.getId());
		
		return query.getResultList();
	}

	@Override
	public Manufacturer getByName(String name) {
		TypedQuery<Manufacturer> query = getEntityManager().createQuery("select m from Manufacturer m where m.name = :name", Manufacturer.class);
		query.setParameter("name", name);
		return query.getSingleResult();
	}

}
