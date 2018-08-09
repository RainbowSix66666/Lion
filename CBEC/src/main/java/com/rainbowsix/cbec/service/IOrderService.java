package com.rainbowsix.cbec.service;

import java.util.List;

import com.rainbowsix.cbec.model.OrderModel;

//订单的业务层接口
public interface IOrderService {
	//新增订单
	public void add(OrderModel order) throws Exception;
	//修改订单
	public void modify(OrderModel order) throws Exception;
	//删除订单
	public void delete(int orderid) throws Exception;
	//取得所有订单列表
	public List<OrderModel> getOrderListByAll() throws Exception;
	//通过订单ID取得订单
	public OrderModel getOrderListById(int orderid) throws Exception;

}
