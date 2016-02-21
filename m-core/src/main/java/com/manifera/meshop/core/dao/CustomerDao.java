package com.manifera.meshop.core.dao;

import com.manifera.meshop.core.domain.Customer;

/**
 *  
 * @author Phat Nguyen
 * 
 */

public interface CustomerDao {
	
	public Customer getCustomerByUsername(String userName);
	
	public void register(Customer customer);
	
	public void update(Customer customer);
	
}
