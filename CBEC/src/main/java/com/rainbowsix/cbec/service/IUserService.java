package com.rainbowsix.cbec.service;

import java.util.Date;
import java.util.List;

import com.rainbowsix.cbec.model.UserModel;

public interface IUserService {
	public void add(UserModel user) throws Exception;
	public void delete(UserModel user) throws Exception;
	public void update(UserModel user) throws Exception;
	//查询所有
	public List<UserModel> selectAll() throws Exception;
	public List<UserModel> selectAllWithArea() throws Exception;
	
	public UserModel selectById(long id) throws Exception;
	//条件查询
	public List<UserModel> selectListByCondiction(String name, Date before, Date after, int[] roles, int area) 
			throws Exception;
	public List<UserModel> selectListByCondictionWithPage(String name, Date before, Date after, int[] roles, int area, int start, int end) 
			throws Exception;
	public int getCountByCondictionWithoutRole(String name, Date before, Date after, int area) throws Exception;
	public List<UserModel> selectListByCondictionWithPageWithoutRole(String name, Date before, Date after, int area, int start, int end) 
			throws Exception;
	
	//查询单个用户
	public UserModel getByName(String name) throws Exception;
	
} 
