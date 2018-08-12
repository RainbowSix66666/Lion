package com.rainbowsix.cbec.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rainbowsix.cbec.dao.IMakerDao;
import com.rainbowsix.cbec.model.MakerModel;
import com.rainbowsix.cbec.service.IMakerService;

@Service
@Transactional
public class MakerServiceImpl implements IMakerService{
	private IMakerDao makerDao = null;

	@Autowired
	public void setMakerDao(IMakerDao makerDao) {
		this.makerDao = makerDao;
	}

	public void add(MakerModel maker) throws Exception {
		// TODO Auto-generated method stub
		/*String resource = "hmx_config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		SqlSession session = sqlSessionFactory.openSession();
		IMakerDao makerDao = session.getMapper(IMakerDao.class);
		makerDao.create(maker);*/
		
		/*String resource = "hmx_config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		SqlSession session = sqlSessionFactory.openSession();
		IMakerDao makerDao = session.getMapper(IMakerDao.class);
		makerDao.create(maker);
		
		session.commit();
		session.close();*/
		makerDao.create(maker);
		
	}

	public void modify(MakerModel maker) throws Exception {
		// TODO Auto-generated method stub
		/*String resource = "hmx_config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		SqlSession session = sqlSessionFactory.openSession();
		IMakerDao makerDao = session.getMapper(IMakerDao.class);
		makerDao.update(maker);
		
		session.commit();
		session.close();*/
		makerDao.update(maker);
		
	}

	public void delete(int makerNO) throws Exception {
		// TODO Auto-generated method stub
		/*String resource = "hmx_config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		SqlSession session = sqlSessionFactory.openSession();
		IMakerDao makerDao = session.getMapper(IMakerDao.class);
		makerDao.delete(makerId);
		
		session.commit();
		session.close();*/
		makerDao.delete(makerNO);
		
	}

	public List<MakerModel> selectListByAll() throws Exception {
		// TODO Auto-generated method stub
		/*String resource = "hmx_config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		SqlSession session = sqlSessionFactory.openSession();
		
		IMakerDao makerDao = session.getMapper(IMakerDao.class);
		List<MakerModel> mm = makerDao.selectListByAll();
		
		session.commit();
		session.close();*/
		
		return makerDao.selectListByAll();
	}

	public MakerModel selectByMakerNO(int makerNO) throws Exception {
		// TODO Auto-generated method stub
		/*String resource = "hmx_config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		SqlSession session = sqlSessionFactory.openSession();
		IMakerDao makerDao = session.getMapper(IMakerDao.class);
		MakerModel mm = makerDao.selectByMakerId(makerId);
		
		session.commit();
		session.close();*/
		
		return makerDao.selectByMakerNO(makerNO);
	}

}
