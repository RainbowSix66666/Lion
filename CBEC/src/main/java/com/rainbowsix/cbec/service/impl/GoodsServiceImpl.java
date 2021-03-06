package com.rainbowsix.cbec.service.impl;

import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rainbowsix.cbec.dao.IGoodsDao;
import com.rainbowsix.cbec.model.GoodsModel;
import com.rainbowsix.cbec.service.IGoodsService;
@Service
public class GoodsServiceImpl implements IGoodsService {
	private IGoodsDao goodsdao=null;
	
	@Autowired
	public void setGoodsdao(IGoodsDao goodsdao) {
		this.goodsdao = goodsdao;
	}

	public void add(GoodsModel good) throws Exception {
//		String resource = "wv_config.xml";
//		Reader reader = Resources.getResourceAsReader(resource);
//		SqlSessionFactory sqlSessionFactory= new SqlSessionFactoryBuilder().build(reader);
//		SqlSession session = sqlSessionFactory.openSession();
//		IGoodsDao goodsdao = session.getMapper(IGoodsDao.class);
//		goodsdao.create(good);
//		session.commit();
//		session.close();
		goodsdao.create(good);
	}

	public void modify(GoodsModel good) throws Exception {
//		String resource = "wv_config.xml";
//		Reader reader = Resources.getResourceAsReader(resource);
//		SqlSessionFactory sqlSessionFactory= new SqlSessionFactoryBuilder().build(reader);
//		SqlSession session = sqlSessionFactory.openSession();
//		
//		IGoodsDao goodsdao = session.getMapper(IGoodsDao.class);
//		goodsdao.update(proid);
//		
//		session.commit();
//		session.close();
		goodsdao.update(good);
		

	}

	public void del(int proid) throws Exception {
//		String resource = "wv_config.xml";
//		Reader reader = Resources.getResourceAsReader(resource);
//		SqlSessionFactory sqlSessionFactory= new SqlSessionFactoryBuilder().build(reader);
//		SqlSession session = sqlSessionFactory.openSession();
//		
//		IGoodsDao goodsdao = session.getMapper(IGoodsDao.class);
//		goodsdao.delete(proid);
//		
//		session.commit();
//		session.close();
		goodsdao.delete(proid);

	}
	
	public GoodsModel one(int proid) throws Exception {
		
//		String resource = "wv_config.xml";
//		Reader reader = Resources.getResourceAsReader(resource);
//		SqlSessionFactory sqlSessionFactory= new SqlSessionFactoryBuilder().build(reader);
//		SqlSession session = sqlSessionFactory.openSession();
//		
//		IGoodsDao goodsdao = session.getMapper(IGoodsDao.class);
//		GoodsModel one=goodsdao.byone(proid);
//		
//		session.commit();
//		session.close();
		return goodsdao.byone(proid);
	}
	
	public List<GoodsModel> all() throws Exception {
		
//		String resource = "wv_config.xml";
//		Reader reader = Resources.getResourceAsReader(resource);
//		SqlSessionFactory sqlSessionFactory= new SqlSessionFactoryBuilder().build(reader);
//		SqlSession session = sqlSessionFactory.openSession();
//		
//		IGoodsDao goodsdao = session.getMapper(IGoodsDao.class);
//		List<GoodsModel> all=goodsdao.byall();
//		
//		session.commit();
//		session.close();
		
		return goodsdao.byall();
	}

	public List<GoodsModel> alltype() throws Exception{
		return goodsdao.alltype();
	}
	
	public List<GoodsModel> bytype(int typeno) throws Exception{
		return goodsdao.bytype(typeno);
	}

	@Override
	public List<GoodsModel> bycomid(String comid) throws Exception {
		return goodsdao.bycomid(comid);
	}

	@Override
	public void buygood(int proid, int count) throws Exception {
		goodsdao.buygood(proid,count);
		
	}


}
