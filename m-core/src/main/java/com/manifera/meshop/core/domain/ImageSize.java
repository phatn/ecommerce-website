package com.manifera.meshop.core.domain;

/**
 *  
 * @author Phat Nguyen
 * 
 * Dimensions
 *  TINY   :  65x65
 *  SMALL  :  150x150
 *  MEDIUM :  255x255
 * 	BIG	   :  360x360
 */

public enum ImageSize {
	
	TINY(65), SMALL(150), MEDIUM(225), BIG(360);
	
	private int height;
	
	private ImageSize(int height) {
		this.height = height;
	}
	
	public int getHeight() {
		return height;
	}
	
}
