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
		queryBuilder.append("select distinct p.manufacturer from Product p ");
		queryBuilder.append("inner join p.categories c ");
		queryBuilder.append("where c.id = :id");
		
		TypedQuery<Manufacturer> query = getEntityManager().createQuery(queryBuilder.toString(), Manufacturer.class);
		query.setParameter("id", category.getId());
		
		return query.getResultList();
	}

	@Override
	public Manufacturer getByName(String name) {
		TypedQuery<Manufacturer> query = getEntityManager().createQuery("select m from Manufacturer m where m.name = :name", Manufacturer.class);
		query.setParameter("name", name);
		return query.getSingleResult();
	}

	@Override
	public List<Manufacturer> getManufacturersByCategoryName(String categoryName) {
		
		StringBuilder queryBuilder = new StringBuilder();
		queryBuilder.append("select distinct m from Manufacturer m ");
		queryBuilder.append("left join m.products p left join p.categories c ");
		queryBuilder.append("left join c.descriptions cd ");
		queryBuilder.append("where cd.name = :name or cd.name is null order by m.sortOrder asc");
		
		TypedQuery<Manufacturer> query = getEntityManager().createQuery(queryBuilder.toString(), Manufacturer.class);
		query.setParameter("name", categoryName);
		
		return query.getResultList();
	}

	@Override
	public Manufacturer getBySelUrl(String selUrl) {
		TypedQuery<Manufacturer> query = getEntityManager().createQuery("select m from Manufacturer m where m.selUrl = :selUrl", Manufacturer.class);
		query.setParameter("selUrl", selUrl);
		return query.getSingleResult();
	}

}
