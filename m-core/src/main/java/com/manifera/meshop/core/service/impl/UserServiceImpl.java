package com.manifera.meshop.core.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.manifera.meshop.core.dao.UserDao;
import com.manifera.meshop.core.domain.User;
import com.manifera.meshop.core.service.UserService;
import com.manifera.meshop.core.service.common.BaseService;


/**
 *  
 * @author Phat Nguyen
 * 
 */

@Service("userService")
public class UserServiceImpl implements UserService, BaseService {

	@Autowired
	private UserDao userDao;
	
	@Override
	public User getUserByUsername(String userName) {
		return userDao.getUserByUsername(userName);
	}
}
