package com.rainbowsix.cbec.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

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
	
	//练习登录-根据员工账号和密码取得员工个数
	public int selectCountByOrderidAndComid(@Param("orderid") int orderid,@Param("comid") int comid) throws Exception;
	
	//取得所有关联商品的订单列表
	public List<OrderModel> selectOrderListWithGoodsByAll() throws Exception;
	//取得一条关联商品的订单
	public OrderModel selectOrderListWithGoodsById(int orderid) throws Exception;
}
