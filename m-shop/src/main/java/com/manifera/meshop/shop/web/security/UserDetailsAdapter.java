package com.manifera.meshop.shop.web.security;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.manifera.meshop.core.domain.Role;
import com.manifera.meshop.core.domain.User;

/**
 *  
 * @author Phat Nguyen
 * 
 */

public class UserDetailsAdapter implements UserDetails {
	
	private static final long serialVersionUID = 1L;

	private User user;
	
	public UserDetailsAdapter(User user) {
		this.user = user;
	}
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		Set<SimpleGrantedAuthority> authorities = new HashSet<SimpleGrantedAuthority>();
		for(Role role : user.getRoles()) {
			authorities.add(new SimpleGrantedAuthority(role.getName()));
		}
		return authorities;
	}

	@Override
	public String getPassword() {
		return user.getAdminPassword();
	}

	@Override
	public String getUsername() {
		return user.getAdminUserName();
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return user.isEnable();
	}
	
	public String getEmail() {
		return user.getAdminEmailAddress();
	}
	
	public User getUser() {
		return user;
	}
}
