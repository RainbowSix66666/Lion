package com.rainbowsix.cbec.service;

import org.springframework.stereotype.Service;

import com.rainbowsix.cbec.model.RoleModel;

public interface RoleService {
	public void add(RoleModel role) throws Exception;
	public void delete(RoleModel role) throws Exception;
	public void update(RoleModel role) throws Exception;
	public void getAll() throws Exception;
	public RoleModel getById(int id) throws Exception;
}
