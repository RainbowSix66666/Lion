package com.rainbowsix.cbec.dao;

import java.util.List;

import com.rainbowsix.cbec.model.OrderModel;

//订单的DAO层接口
public interface IOrderDao {
	//新增订单
	public void create(OrderModel order) throws Exception;
	//修改订单
	public void update(OrderModel order) throws Exception;
	//删除订单
	public void delete(int orderid) throws Exception;
	//取得所有订单列表
	public List<OrderModel> selectOrderListByAll() throws Exception;
	//通过订单ID取得订单
	public OrderModel selectOrderListById(int orderid) throws Exception;

}
