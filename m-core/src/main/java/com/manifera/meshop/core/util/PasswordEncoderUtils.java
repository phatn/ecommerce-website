package com.manifera.meshop.core.util;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 *  
 * @author Phat Nguyen
 * 
 */

public class PasswordEncoderUtils {
	
	private PasswordEncoderUtils() {}
	
	private static PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
	
	public static String encode(String rawPassword) {
		return passwordEncoder.encode(rawPassword);
	}
}
