package com.rainbowsix.cbec.service;

import java.util.Date;
import java.util.List;

import com.rainbowsix.cbec.model.UserModel;

public interface IUserService {
	public void add(UserModel user) throws Exception;
	public void delete(UserModel user) throws Exception;
	public void update(UserModel user) throws Exception;
	public List<UserModel> selectAll() throws Exception;
	public UserModel selectById(long id) throws Exception;
	public List<UserModel> selectListByCondiction(String name, Date before, Date after, int[] roles) 
			throws Exception;
	public List<UserModel> selectListByCondictionWithPage(String name, Date before, Date after, int[] roles, int start, int end) 
			throws Exception;
	public int getCountByCondictionWithoutRole(String name, Date before, Date after) throws Exception;
	public List<UserModel> selectListByCondictionWithPageWithoutRole(String name, Date before, Date after, int start, int end) throws Exception;
	
} 
