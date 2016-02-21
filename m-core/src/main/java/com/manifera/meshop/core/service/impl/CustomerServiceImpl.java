package com.manifera.meshop.core.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.manifera.meshop.core.dao.CustomerDao;
import com.manifera.meshop.core.domain.Customer;
import com.manifera.meshop.core.service.CustomerService;
import com.manifera.meshop.core.service.common.BaseService;
import com.manifera.meshop.core.util.PasswordEncoderUtils;

/**
 *  
 * @author Phat Nguyen
 * 
 */

@Service("customerService")
public class CustomerServiceImpl implements CustomerService, BaseService {

	@Autowired
	private CustomerDao customerDao;
	
	@Override
	public Customer getCustomerByUsername(String userName) {
		return customerDao.getCustomerByUsername(userName);
	}

	@Override
	public void register(Customer customer) {
		customer.setPassword(PasswordEncoderUtils.encode(customer.getPassword()));
		customerDao.register(customer);
	}
	
	@Override
	public void update(Customer customer) {
		customerDao.update(customer);
	}
}
