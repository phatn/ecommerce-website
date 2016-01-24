package com.manifera.meshop.core.domain.common;

import java.io.Serializable;

public class EmptyList implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private long totalRecords;

	public EmptyList() {}
	
	public EmptyList(long totalRecords) {
		this.totalRecords = totalRecords;
	}
	
	public long getTotalRecords() {
		return totalRecords;
	}

	public void setTotalRecords(long totalRecords) {
		this.totalRecords = totalRecords;
	}
	
}
