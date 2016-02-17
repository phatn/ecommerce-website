package com.manifera.meshop.core.dao.common;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.manifera.meshop.core.constant.Constant;

public class Page<T> {
	
	private static final Logger LOG = LoggerFactory.getLogger(Page.class);
	
	private int currentPage = 1;
	
	private long totalRecords;
	
	private int pageSize = Constant.PAGE_SIZE;
	
	private List<Integer> pages = new ArrayList<>();
	
	private List<T> list;

	public Page() {}
	
	public Page(List<T> list) {
		this.list = list;
	}
	
	public List<Integer> getPages() {
		pages.clear();
		int totalPages = (int)Math.ceil((double)totalRecords / Constant.PAGE_SIZE);
		LOG.info("Total records: " + totalRecords + ", page size: " + 
				Constant.PAGE_SIZE + ", total pages: " + totalPages);
		System.out.println("Total records: " + totalRecords + ", page size: " + 
				Constant.PAGE_SIZE + ", total pages: " + totalPages);
		for(int i = 1; i <= totalPages; i++) {
			pages.add(i);
		}
		return pages;
	}
	
	public Page(long totalRecords, List<T> list) {
		this.totalRecords = totalRecords;
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

	public List<T> getList() {
		return list;
	}

	public void setList(List<T> list) {
		this.list = list;
	}
}
