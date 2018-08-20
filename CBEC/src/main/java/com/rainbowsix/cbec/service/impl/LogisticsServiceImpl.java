package com.rainbowsix.cbec.service.impl;

import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.stereotype.Service;

import com.rainbowsix.cbec.dao.ILogisticsDao;
import com.rainbowsix.cbec.model.LogisticsModel;
import com.rainbowsix.cbec.service.ILogisticsService;
@Service
public class LogisticsServiceImpl implements ILogisticsService {
	//增加物流
	@Override
	public void add(LogisticsModel logistics) throws Exception {
		String resource = "ldj_config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		SqlSession session = sqlSessionFactory.openSession();
		ILogisticsDao logisticsDao=session.getMapper(ILogisticsDao.class);
		logisticsDao.create(logistics);
		session.commit();
		session.close();
	}
	//增加物流-关联订单
	@Override
	public void addWithOrder(LogisticsModel logistics) throws Exception {
		String resource = "ldj_config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		SqlSession session = sqlSessionFactory.openSession();
		ILogisticsDao logisticsDao=session.getMapper(ILogisticsDao.class);
		logisticsDao.createWithOrder(logistics);
		session.commit();
		session.close();
		
	}
		
	//修改物流
	@Override
	public void modify(LogisticsModel logistics) throws Exception {
		String resource = "ldj_config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		SqlSession session = sqlSessionFactory.openSession();
		ILogisticsDao logisticsDao=session.getMapper(ILogisticsDao.class);
		logisticsDao.update(logistics);
		session.commit();
		session.close();

	}
	//修改物流-关联订单
	@Override
	public void modifyWithOrder(LogisticsModel logistics) throws Exception {
		String resource = "ldj_config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		SqlSession session = sqlSessionFactory.openSession();
		ILogisticsDao logisticsDao=session.getMapper(ILogisticsDao.class);
		logisticsDao.updateWithOrder(logistics);
		session.commit();
		session.close();
		
	}
	
	//删除物流
	@Override
	public void delete(int logisticsid) throws Exception {
		String resource = "ldj_config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		SqlSession session = sqlSessionFactory.openSession();
		ILogisticsDao logisticsDao=session.getMapper(ILogisticsDao.class);
		logisticsDao.delete(logisticsid);
		session.commit();
		session.close();
	}
	//取得所有物流列表
	@Override
	public List<LogisticsModel> getLogisticsListByAll() throws Exception {
		String resource = "ldj_config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		SqlSession session = sqlSessionFactory.openSession();
		ILogisticsDao logisticsDao=session.getMapper(ILogisticsDao.class);
		List<LogisticsModel> list=logisticsDao.selectLogisticsListByAll();
		session.commit();
		session.close();
		
		return list;
	}
	//取得单条物流
	@Override
	public LogisticsModel getLogisticsListById(int logisticsid) throws Exception {
		String resource = "ldj_config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		SqlSession session = sqlSessionFactory.openSession();
		ILogisticsDao logisticsDao=session.getMapper(ILogisticsDao.class);
		LogisticsModel lm=logisticsDao.selectLogisticsListById(logisticsid);
		session.commit();
		session.close();
		
		return lm;
	}

	//取得所有关联订单的物流列表
	@Override
	public List<LogisticsModel> getLogisticsListWithOrder() throws Exception {
		String resource = "ldj_config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		SqlSession session = sqlSessionFactory.openSession();
		ILogisticsDao logisticsDao=session.getMapper(ILogisticsDao.class);
		List<LogisticsModel> list=logisticsDao.selectLogisticsListWithOrder();
		session.commit();
		session.close();
		
		return list;
	}
	@Override
	public List<LogisticsModel> getLogisticsListByCondition(String address, int expressnumber, String consignee,
			int phone) throws Exception {
		String resource = "ldj_config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		SqlSession session = sqlSessionFactory.openSession();
		ILogisticsDao logisticsDao=session.getMapper(ILogisticsDao.class);
		List<LogisticsModel> list=logisticsDao.selectLogisticsListByCondition(address,expressnumber,consignee,phone);
		session.commit();
		session.close();
		
		return list;
	}
	@Override
	public List<LogisticsModel> getLogisticsListByConditionWithPage(String address, int expressnumber, String consignee,
			int phone, int rows, int page) throws Exception {
		String resource = "ldj_config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		SqlSession session = sqlSessionFactory.openSession();
		ILogisticsDao logisticsDao=session.getMapper(ILogisticsDao.class);
		List<LogisticsModel> list=logisticsDao.selectLogisticsListByConditionWithPage(address,expressnumber,consignee,phone, rows*(page-1)+1, rows*page);
		session.commit();
		session.close();
		
		return list;
	}
	@Override
	public int getCountByCondition(String address, int expressnumber, String consignee, int phone) throws Exception {
		String resource = "ldj_config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		SqlSession session = sqlSessionFactory.openSession();
		ILogisticsDao logisticsDao=session.getMapper(ILogisticsDao.class);
		int lscount=logisticsDao.selectCountByCondition(address,expressnumber,consignee,phone);
		session.commit();
		session.close();
		
		return lscount;
	}
	@Override
	public int getPageCountByCondition(String address, int expressnumber, String consignee, int phone, int rows)
			throws Exception {
		String resource = "ldj_config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		SqlSession session = sqlSessionFactory.openSession();
		ILogisticsDao logisticsDao=session.getMapper(ILogisticsDao.class);
		int pageCount=0;
		//int count=this.getCountByCondition(address,expressnumber,consignee,phone);
		int count=logisticsDao.selectCountByCondition(address,expressnumber,consignee,phone);
		if(count%rows==0) {
			pageCount=count/rows;
		}
		else {
			pageCount=count/rows+1;
		}
		session.commit();
		session.close();
		return pageCount;
	}
	
	@Override
	public List<LogisticsModel> getAddress() throws Exception {
		String resource = "ldj_config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		SqlSession session = sqlSessionFactory.openSession();
		ILogisticsDao logisticsDao=session.getMapper(ILogisticsDao.class);
		List<LogisticsModel> list=logisticsDao.selectAddress();
		session.commit();
		session.close();
		
		return list;
	}
	
	
}
