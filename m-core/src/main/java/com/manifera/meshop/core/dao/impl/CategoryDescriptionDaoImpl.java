package com.manifera.meshop.core.dao.impl;

import org.springframework.stereotype.Repository;

import com.manifera.meshop.core.dao.CategoryDescriptionDao;
import com.manifera.meshop.core.dao.common.AbstractGenericDao;
import com.manifera.meshop.core.domain.CategoryDescription;

@Repository("categoryDescriptionDao")
public class CategoryDescriptionDaoImpl extends AbstractGenericDao<CategoryDescription, Long> implements CategoryDescriptionDao {
	
}
