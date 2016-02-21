package com.manifera.meshop.core.dao.impl;

import org.springframework.stereotype.Repository;

import com.manifera.meshop.core.dao.OrderDao;
import com.manifera.meshop.core.dao.common.AbstractGenericDao;
import com.manifera.meshop.core.domain.Order;


@Repository("orderDao")
public class OrderDaoImpl extends AbstractGenericDao<Order, Long> implements OrderDao {
	
	@Override
	public void create(Order order) {
		super.create(order);
	}
}
