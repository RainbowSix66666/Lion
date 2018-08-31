package com.rainbowsix.cbec.service.impl;

import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rainbowsix.cbec.dao.IOrderDao;
import com.rainbowsix.cbec.model.OrderModel;
import com.rainbowsix.cbec.service.IOrderService;

//订单业务层的实现类
@Service
@Transactional
public class OrderServiceImpl implements IOrderService {
	
	private IOrderDao orderDao=null;
	
	@Autowired
	public void setOrderDao(IOrderDao orderDao) {
		this.orderDao = orderDao;
	}
	
	//增加订单
	public void add(OrderModel order) throws Exception {	
		orderDao.create(order);	
	}
	
	//修改订单
	public void modify(OrderModel order) throws Exception {		
		orderDao.update(order);
	}
	//删除订单
	public void delete(int orderid) throws Exception{
		orderDao.delete(orderid);
	}
	//取得所有订单列表
	public List<OrderModel> getOrderListByAll() throws Exception {
		List<OrderModel> list=orderDao.selectOrderListByAll();
		return list;
	}
	//取得单个订单
	public OrderModel getOrderListById(int orderid) throws Exception {
		OrderModel om=orderDao.selectOrderListById(orderid);
		return om;
	}

	//取得所有关联商品的订单列表 ——品牌商
	@Override
	public List<OrderModel> getOrderListWithGoodsByAll() throws Exception {
		List<OrderModel> list=orderDao.selectOrderListWithGoodsByAll();
		return list;
	}
	//取得单一的关联商品的订单——品牌商
	@Override
	public OrderModel getOrderListWithGoodsById(int orderid) throws Exception {
		OrderModel om=orderDao.selectOrderListWithGoodsById(orderid);
		return om;
	}

	
	/*	//增加订单
	public void add(OrderModel order) throws Exception {
		String resource = "ldj_config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		SqlSession session = sqlSessionFactory.openSession();
		IOrderDao orderDao=session.getMapper(IOrderDao.class);
		orderDao.create(order);
		session.commit();
		session.close();

	}
	//修改订单
	public void modify(OrderModel order) throws Exception {
		String resource = "ldj_config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		SqlSession session = sqlSessionFactory.openSession();
		IOrderDao orderDao=session.getMapper(IOrderDao.class);
		orderDao.update(order);
		session.commit();
		session.close();

	}
	//删除订单
	public void delete(int orderid) throws Exception {
		String resource = "ldj_config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		SqlSession session = sqlSessionFactory.openSession();
		IOrderDao orderDao=session.getMapper(IOrderDao.class);
		orderDao.delete(orderid);
		session.commit();
		session.close();

	}
	//取得所有订单列表
	public List<OrderModel> getOrderListByAll() throws Exception {
		String resource = "ldj_config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		SqlSession session = sqlSessionFactory.openSession();
		IOrderDao orderDao=session.getMapper(IOrderDao.class);
		List<OrderModel> list=orderDao.selectOrderListByAll();
		session.commit();
		session.close();
		
		return list;
	}
	//取得单个订单
	public OrderModel getOrderListById(int orderid) throws Exception {
		String resource = "ldj_config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		SqlSession session = sqlSessionFactory.openSession();
		IOrderDao orderDao=session.getMapper(IOrderDao.class);
		OrderModel om=orderDao.selectOrderListById(orderid);
		session.commit();
		session.close();
		
		return om;
	}*/

}
