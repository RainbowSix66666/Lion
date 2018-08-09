package com.rainbowsix.cbec.service.impl;

import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.stereotype.Service;

import com.rainbowsix.cbec.dao.IOrderDao;
import com.rainbowsix.cbec.model.OrderModel;
import com.rainbowsix.cbec.service.IOrderService;

//订单业务层的实现类
@Service
public class OrderServiceImpl implements IOrderService {
	
	public void add(OrderModel order) throws Exception {
		String resource = "ldj-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		SqlSession session = sqlSessionFactory.openSession();
		IOrderDao orderDao=session.getMapper(IOrderDao.class);
		orderDao.create(order);
		session.commit();
		session.close();

	}

	public void modify(OrderModel order) throws Exception {
		// TODO Auto-generated method stub

	}

	public void delete(int orderid) throws Exception {
		// TODO Auto-generated method stub

	}

	public List<OrderModel> getOrderListByAll() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	public OrderModel getOrderListById(int orderid) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
