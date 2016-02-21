package com.manifera.meshop.core.dao.impl;

import javax.persistence.TypedQuery;
import org.springframework.stereotype.Repository;

import com.manifera.meshop.core.dao.CustomerDao;
import com.manifera.meshop.core.dao.common.AbstractGenericDao;
import com.manifera.meshop.core.domain.Customer;

/**
 *  
 * @author Phat Nguyen
 * 
 */

@Repository("customerDao")
public class CustomerDaoImpl extends AbstractGenericDao<Customer, Long> implements
		CustomerDao {
	
	@Override
	public Customer getCustomerByUsername(String userName) {
		StringBuilder queryBuilder = new StringBuilder();
		queryBuilder.append("select c from Customer c join fetch c.roles r where c.userName = :userName");
		TypedQuery<Customer> query = getEntityManager().createQuery(queryBuilder.toString(), Customer.class);
		query.setParameter("userName", userName);
		return query.getSingleResult();
	}
	
	@Override
	public void register(Customer customer) {
		create(customer);
	}
}
