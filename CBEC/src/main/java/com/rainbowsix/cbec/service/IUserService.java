package com.rainbowsix.cbec.service;

import com.rainbowsix.cbec.model.UserModel;

public interface IUserService {
	public void add(UserModel user) throws Exception;
	public void delete(UserModel user) throws Exception;
	public void update(UserModel user) throws Exception;
	public void selectAll(int rows, int page) throws Exception;
	public void selectById(int id) throws Exception;
}
