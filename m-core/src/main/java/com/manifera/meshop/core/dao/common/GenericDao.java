package com.manifera.meshop.core.dao.common;

import java.io.Serializable;
import java.util.List;

/**
 *  
 * @author Phat Nguyen
 * 
 */

public interface GenericDao<T> {
	
	void create(T t);
	
	T get(Serializable id);
	
	List<T> getAll();
	
	List<T> getAll(Integer limit, Integer offset);
	
	void update(T t);
	
	void delete(T t);
	
	void deleteById(Serializable id);
	
	void deleteAll();
	
	long count();
	
	boolean exists(Serializable id);
	
}
