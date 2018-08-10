package com.rainbowsix.cbec.service.impl;

import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rainbowsix.cbec.dao.IRoleDao;
import com.rainbowsix.cbec.dao.IUserDao;
import com.rainbowsix.cbec.model.UserModel;
import com.rainbowsix.cbec.service.IUserService;

@Service
public class UserService implements IUserService {
	
	private IUserDao userDao = null;
	
	@Autowired
	public void setUserDao(IUserDao userDao) {
		this.userDao = userDao;
	}

	public void add(UserModel user) throws Exception {
		// TODO Auto-generated method stub
		userDao.create(user);
	}

	public void delete(UserModel user) throws Exception {
		// TODO Auto-generated method stub
		
	}

	public void update(UserModel user) throws Exception {
		// TODO Auto-generated method stub

	}

	public List<UserModel> selectAll() throws Exception {
		// TODO Auto-generated method stub
		return userDao.selectAll();
	}

	public void selectById(int id) throws Exception {
		// TODO Auto-generated method stub

	}

}
