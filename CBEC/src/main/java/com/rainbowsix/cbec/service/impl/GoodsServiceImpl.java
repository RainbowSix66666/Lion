package com.rainbowsix.cbec.service.impl;

import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.stereotype.Service;

import com.rainbowsix.cbec.dao.IGoodsDao;
import com.rainbowsix.cbec.model.GoodsModel;
import com.rainbowsix.cbec.service.IGoodsService;
@Service
public class GoodsServiceImpl implements IGoodsService {
	private IGoodsDao goodsdao=null;
	
	public void add(GoodsModel good) throws Exception {
		String resource = "wv_config.xml";
		Reader reader = Resources.getResourceAsReader(resource);
		SqlSessionFactory sqlSessionFactory= new SqlSessionFactoryBuilder().build(reader);
		SqlSession session = sqlSessionFactory.openSession();
		IGoodsDao goodsdao = session.getMapper(IGoodsDao.class);
		goodsdao.create(good);
		session.commit();
		session.close();
	}

	public void mod(int proid) throws Exception {
		String resource = "wv_config.xml";
		Reader reader = Resources.getResourceAsReader(resource);
		SqlSessionFactory sqlSessionFactory= new SqlSessionFactoryBuilder().build(reader);
		SqlSession session = sqlSessionFactory.openSession();
		
		IGoodsDao goodsdao = session.getMapper(IGoodsDao.class);
		goodsdao.update(proid);
		
		session.commit();
		session.close();
		

	}

	public void del(int proid) throws Exception {
		String resource = "wv_config.xml";
		Reader reader = Resources.getResourceAsReader(resource);
		SqlSessionFactory sqlSessionFactory= new SqlSessionFactoryBuilder().build(reader);
		SqlSession session = sqlSessionFactory.openSession();
		
		IGoodsDao goodsdao = session.getMapper(IGoodsDao.class);
		goodsdao.delete(proid);
		
		session.commit();
		session.close();

	}
	
	public GoodsModel one(int proid) throws Exception {
		
		String resource = "wv_config.xml";
		Reader reader = Resources.getResourceAsReader(resource);
		SqlSessionFactory sqlSessionFactory= new SqlSessionFactoryBuilder().build(reader);
		SqlSession session = sqlSessionFactory.openSession();
		
		IGoodsDao goodsdao = session.getMapper(IGoodsDao.class);
		GoodsModel one=goodsdao.byone(proid);
		
		session.commit();
		session.close();
		return one;
	}
	
	public List<GoodsModel> all() throws Exception {
		
		String resource = "wv_config.xml";
		Reader reader = Resources.getResourceAsReader(resource);
		SqlSessionFactory sqlSessionFactory= new SqlSessionFactoryBuilder().build(reader);
		SqlSession session = sqlSessionFactory.openSession();
		
		IGoodsDao goodsdao = session.getMapper(IGoodsDao.class);
		List<GoodsModel> all=goodsdao.byall();
		
		session.commit();
		session.close();
		
		return all;
	}

	

}
