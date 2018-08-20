package com.rainbowsix.cbec.service.impl;

import java.io.InputStream;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.UserCredentialsDataSourceAdapter;
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
		userDao.delete(user);
	}

	public void update(UserModel user) throws Exception {
		// TODO Auto-generated method stub
		userDao.update(user);
	}

	public List<UserModel> selectAll() throws Exception {
		// TODO Auto-generated method stub
		return userDao.selectAll();
//		return userDao.selectAllWithRole();
	}

	public UserModel selectById(long id) throws Exception {
		// TODO Auto-generated method stub
//		System.out.println(id);
		return userDao.selectById(id);
	}

	@Override
	public List<UserModel> selectListByCondiction(String name, Date before, Date after, int[] roles, int area) throws Exception {
		// TODO Auto-generated method stub
		return userDao.selectByCondiction(name, before, after, roles, area);
	}

	@Override
	public List<UserModel> selectListByCondictionWithPage(String name, Date before, Date after, int[] roles, int area, int start,
			int end) throws Exception {
		// TODO Auto-generated method 	stub
		
		return userDao.selectByCondictionWithPage(name, before, after, roles, area, start, end);
	}

	@Override
	public int getCountByCondictionWithoutRole(String name, Date before, Date after, int area) throws Exception {
		// TODO Auto-generated method stub
		
		return userDao.selectCountByCondictionWithoutRole(name, before, after, area);
	}

	@Override
	public List<UserModel> selectListByCondictionWithPageWithoutRole(String name, Date before, Date after, int area, int start,
			int end) throws Exception {
		// TODO Auto-generated method stub
		return userDao.selectByCondictionWithPageWithoutRole(name, before, after, area, start, end);
	}

	@Override
	public List<UserModel> selectAllWithArea() throws Exception {
		return userDao.selectAllWithArea();
	}

	@Override
	public UserModel getByName(String name) throws Exception {
		return userDao.selectByName(name);
	}
	

}
