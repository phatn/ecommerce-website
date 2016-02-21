package com.manifera.meshop.shop.web.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.manifera.meshop.core.domain.User;
import com.manifera.meshop.core.service.UserService;

/**
 *  
 * @author Phat Nguyen
 * 
 */

@Service("userDetailsService")
public class UserDetailsServiceAdapter implements UserDetailsService {
	
	@Autowired
	private UserService userService;
	
	@Override
	public UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException {
		
		User userAdmin = userService.getUserByUsername(username);
		if(userAdmin == null) {
			throw new UsernameNotFoundException("No such user: " + username);
		} else if(userAdmin.getRoles().isEmpty()) {
			throw new UsernameNotFoundException("User " + username + " has no authorities");
		}
		UserDetailsAdapter user = new UserDetailsAdapter(userAdmin);
		return user;
	}

}
