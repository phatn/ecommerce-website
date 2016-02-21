package com.manifera.meshop.core.util;

import com.google.common.base.Joiner;

public class DomainUtil {
	
	private DomainUtil() {}
	
	public static String getSefUrl(String aString) {
		if(aString == null || aString.trim().isEmpty()) {
			return "";
		}
		
		aString = aString.replaceAll("('|\")", "").replaceAll("[()]", "").replace(".", " ").replaceAll("-", "").toLowerCase();
		return Joiner.on("-").join(aString.split("\\s+"));
	}
}
