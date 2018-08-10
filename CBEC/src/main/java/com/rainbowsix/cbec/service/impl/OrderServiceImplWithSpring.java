package com.rainbowsix.cbec.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rainbowsix.cbec.dao.IOrderDao;
import com.rainbowsix.cbec.model.OrderModel;
import com.rainbowsix.cbec.service.IOrderService;

@Service
public class OrderServiceImplWithSpring implements IOrderService {
	private IOrderDao orderDao=null;
	
	@Autowired
	public void setOrderDao(IOrderDao orderDao) {
		this.orderDao = orderDao;
	}

	public void add(OrderModel order) throws Exception {
		orderDao.create(order);
	}

	public void modify(OrderModel order) throws Exception {
		orderDao.update(order);

	}

	public void delete(int orderid) throws Exception {
		orderDao.delete(orderid);
	}

	public List<OrderModel> getOrderListByAll() throws Exception {
		return orderDao.selectOrderListByAll();
	}

	public OrderModel getOrderListById(int orderid) throws Exception {
		return orderDao.selectOrderListById(orderid);
	}

}
