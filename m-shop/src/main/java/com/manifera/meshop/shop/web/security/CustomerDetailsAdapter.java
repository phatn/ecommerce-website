package com.manifera.meshop.shop.web.security;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.manifera.meshop.core.domain.Customer;
import com.manifera.meshop.core.domain.Role;

/**
 *  
 * @author Phat Nguyen
 * 
 */

public class CustomerDetailsAdapter implements UserDetails {

	private static final long serialVersionUID = 1L;
	
	private Customer customer;

	public CustomerDetailsAdapter(Customer customer) {
		this.customer = customer;
	}
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		Set<SimpleGrantedAuthority> authorities = new HashSet<SimpleGrantedAuthority>();
		for(Role role : customer.getRoles()) {
			authorities.add(new SimpleGrantedAuthority(role.getName()));
		}
		return authorities;
	}

	@Override
	public String getPassword() {
		return customer.getPassword();
	}

	@Override
	public String getUsername() {
		return customer.getUserName();
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
		return customer.isEnable();
	}

	public boolean isAnonymous() {
		return customer.isAnonymous();
	}
	
	public String getEmail() {
		return customer.getEmailAddress();
	}
	
	public Customer getCustomer() {
		return customer;
	}
}
