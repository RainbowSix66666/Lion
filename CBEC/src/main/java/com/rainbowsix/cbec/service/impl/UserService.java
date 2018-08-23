package com.rainbowsix.cbec.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rainbowsix.cbec.dao.IUserDao;
import com.rainbowsix.cbec.model.UserModel;
import com.rainbowsix.cbec.service.IUserService;

@Service
@Transactional
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
		// TODO Auto-generated method stub
		return userDao.selectByName(name);
	}

	@Override
	public void addWithPoto(UserModel user) throws Exception {
		// TODO Auto-generated method stub
		userDao.createWithPhoto(user);
	}

	@Override
	public void cleanRole(int id) throws Exception {
		// TODO Auto-generated method stub
		userDao.cleanRole(id);
	}

	@Override
	public void grantRole(int id, int role) throws Exception {
		// TODO Auto-generated method stub
		userDao.grantRole(id, role);
	}

	@Override
	public void grantRoles(int id, int[] roles) throws Exception {
		// TODO Auto-generated method stub
		userDao.cleanRole(id);
		for(int role:roles) {
			userDao.grantRole(id, role);
		}
	}

	@Override
	public void setArea(int id, int areaId) throws Exception {
		// TODO Auto-generated method stub
		userDao.updateArea(id, areaId);
	}

	@Override
	public boolean validate(String name, String password) throws Exception {
		boolean result = false;
		
		if(userDao.selectCountByNameAndPassword(name, password) == 1) {
			result = true;
		}
		
		return result;
	}

	
	

}
