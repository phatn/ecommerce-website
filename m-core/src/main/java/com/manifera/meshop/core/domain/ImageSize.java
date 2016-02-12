package com.manifera.meshop.core.domain;

/**
 *  
 * @author Phat Nguyen
 * 
 * Dimensions
 *  TINY   :  50x50
 *  SMALL  :  114x114
 *  MEDIUM :  263x263
 * 	BIG	   :  409x616
 */

public enum ImageSize {
	
	TINY(50, 50), SMALL(114, 114), MEDIUM(263, 263), BIG(409, 616);
	
	private int width;
	
	private int height;
	
	/**
	 * 
	 * @param width width size of image
	 * @param height height size of image
	 */
	private ImageSize(int width, int height) {
		this.width = width;
		this.height = height;
	}
	
	public int getHeight() {
		return height;
	} 
	
	public int getWidth() {
		return width;
	}
	
}
