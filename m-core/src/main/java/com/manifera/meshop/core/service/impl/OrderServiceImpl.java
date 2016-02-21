package com.manifera.meshop.core.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.manifera.meshop.core.dao.OrderDao;
import com.manifera.meshop.core.domain.Order;
import com.manifera.meshop.core.service.OrderService;
import com.manifera.meshop.core.service.common.BaseService;


@Service("orderService")
public class OrderServiceImpl implements OrderService, BaseService {

	@Autowired
	private OrderDao orderDao;
	
	@Override
	public void create(Order order) {
		orderDao.create(order);
	}
}
