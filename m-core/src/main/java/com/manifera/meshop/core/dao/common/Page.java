package com.manifera.meshop.core.dao.common;

import java.util.List;

import com.manifera.meshop.core.constant.Constant;

public class Page<T> {
	
	private int currentPage = 1;
	
	private long totalRecords;
	
	private int pageSize = Constant.PAGE_SIZE;
	
	private int totalPages;
	
	private List<T> list;

	public Page() {}
	
	public Page(List<T> list) {
		this.list = list;
	}
	
	public Page(long totalRecord, List<T> list) {
		this.totalRecords = totalRecord;
		this.list = list;
	}
	
	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public long getTotalRecords() {
		return totalRecords;
	}

	public void setTotalRecords(long totalRecords) {
		this.totalRecords = totalRecords;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getTotalPages() {
		return totalPages;
	}

	public void setTotalPages(int totalPages) {
		this.totalPages = totalPages;
	}

	public List<T> getList() {
		return list;
	}

	public void setList(List<T> list) {
		this.list = list;
	}
}
