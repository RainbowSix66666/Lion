package com.rainbowsix.cbec.service.impl;

import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.stereotype.Service;

import com.rainbowsix.cbec.dao.IRoleDao;
import com.rainbowsix.cbec.dao.IUserDao;
import com.rainbowsix.cbec.model.UserModel;
import com.rainbowsix.cbec.service.IUserService;

@Service
public class UserService implements IUserService {

	public void add(UserModel user) throws Exception {
		// TODO Auto-generated method stub
		String resource = "mzy_mybaits.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		SqlSession session = sqlSessionFactory.openSession();
		
		IUserDao userDao = session.getMapper(IUserDao.class);
		userDao.create(user);
		
		session.commit();
		session.close();
	}

	public void delete(UserModel user) throws Exception {
		// TODO Auto-generated method stub

	}

	public void update(UserModel user) throws Exception {
		// TODO Auto-generated method stub

	}

	public void selectAll(int rows, int page) throws Exception {
		// TODO Auto-generated method stub

	}

	public void selectById(int id) throws Exception {
		// TODO Auto-generated method stub

	}

}
