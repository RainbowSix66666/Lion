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

}
