package com.manifera.meshop.core.dao.impl;

import javax.persistence.TypedQuery;
import org.springframework.stereotype.Repository;

import com.manifera.meshop.core.dao.UserDao;
import com.manifera.meshop.core.dao.common.AbstractGenericDao;
import com.manifera.meshop.core.domain.User;

/**
 *  
 * @author Phat Nguyen
 * 
 */

@Repository("userDao")
public class UserDaoImpl extends AbstractGenericDao<User, Long> implements UserDao {

	@Override
	public User getUserByUsername(String userName) {
		StringBuilder queryBuilder = new StringBuilder();
		queryBuilder.append("select u from User u join fetch u.roles r where u.adminUserName = :userName");
		TypedQuery<User> query = getEntityManager().createQuery(queryBuilder.toString(), User.class);
		query.setParameter("userName", userName);
		return query.getSingleResult();
	}
}
