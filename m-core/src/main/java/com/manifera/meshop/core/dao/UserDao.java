package com.manifera.meshop.core.dao;

import com.manifera.meshop.core.domain.User;

/**
 *  
 * @author Phat Nguyen
 * 
 */

public interface UserDao {
	
	public User getUserByUsername(String userName);
}
