package com.manifera.meshop.core.dao.common;

import java.io.Serializable;
import java.util.List;

/**
 *  
 * @author Phat Nguyen
 * 
 */

public interface GenericDao<T, ID extends Serializable> {
	
	void create(T t);
	
	T get(ID id);
	
	List<T> getAll();
	
	List<T> getAll(Integer limit, Integer offset);
	
	void update(T t);
	
	void delete(T t);
	
	void deleteById(ID id);
	
	void deleteAll();
	
	long count();
	
	boolean exists(ID id);
	
}
