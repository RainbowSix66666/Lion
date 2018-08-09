package com.rainbowsix.cbec.dao;

import java.util.List;

import com.rainbowsix.cbec.model.UserModel;

public interface IUserDao {
	
	public void create(UserModel userModel) throws Exception;
	public void update(UserModel userModel) throws Exception;
	public void delete(UserModel userModel) throws Exception;
	public List<UserModel> selectAllWithPage(int rows, int page)
		throws Exception;
	public UserModel selectById(int id) throws Exception;
}
