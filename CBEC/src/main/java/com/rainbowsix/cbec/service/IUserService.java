package com.rainbowsix.cbec.service;

import java.util.List;

import com.rainbowsix.cbec.model.UserModel;

public interface IUserService {
	public void add(UserModel user) throws Exception;
	public void delete(UserModel user) throws Exception;
	public void update(UserModel user) throws Exception;
	public List<UserModel> selectAll() throws Exception;
	public UserModel selectById(long id) throws Exception;
}
