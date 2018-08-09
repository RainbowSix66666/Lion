package com.rainbowsix.cbec.service.impl;

import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.stereotype.Service;

import com.rainbowsix.cbec.dao.IMakerDao;
import com.rainbowsix.cbec.dao.IRoleDao;
import com.rainbowsix.cbec.model.MakerModel;
import com.rainbowsix.cbec.service.IMakerService;

@Service
public class MakerServiceImpl implements IMakerService{

	public void add(MakerModel maker) throws Exception {
		// TODO Auto-generated method stub
		/*String resource = "hmx_config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		SqlSession session = sqlSessionFactory.openSession();
		IMakerDao makerDao = session.getMapper(IMakerDao.class);
		makerDao.create(maker);*/
		
		String resource = "hmx_config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		SqlSession session = sqlSessionFactory.openSession();
		IMakerDao makerDao = session.getMapper(IMakerDao.class);
		makerDao.create(maker);
		
		session.commit();
		session.close();
	}

	public void modify(MakerModel maker) throws Exception {
		// TODO Auto-generated method stub
		
	}

	public void delete(int makerId) throws Exception {
		// TODO Auto-generated method stub
		
	}

	public List<MakerModel> selectProductListByMakerId(int makerId) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
