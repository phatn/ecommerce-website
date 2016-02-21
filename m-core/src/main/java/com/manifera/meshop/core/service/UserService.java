package com.manifera.meshop.core.service;

import com.manifera.meshop.core.domain.User;

/**
 *  
 * @author Phat Nguyen
 * 
 */

public interface UserService {
	
	public User getUserByUsername(String userName);
	
}
