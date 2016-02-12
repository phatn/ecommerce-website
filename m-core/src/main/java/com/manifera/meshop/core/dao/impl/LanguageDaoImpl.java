package com.manifera.meshop.core.dao.impl;

import java.util.List;

import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.manifera.meshop.core.dao.LanguageDao;
import com.manifera.meshop.core.dao.common.AbstractGenericDao;
import com.manifera.meshop.core.domain.Language;

@Repository("languageDao")
public class LanguageDaoImpl extends AbstractGenericDao<Language, Long> implements LanguageDao {

	@Override
	public Language getByCode(String code) {
		TypedQuery<Language> query = getEntityManager().createQuery("select l from Language l where l.code = :code", Language.class);
		query.setParameter("code", code);
		return query.getSingleResult();
	}

	@Override
	public List<Language> getAllLanguages() {
		TypedQuery<Language> query = getEntityManager().createQuery("select l from Language l", Language.class);
		return query.getResultList();
	}

}
