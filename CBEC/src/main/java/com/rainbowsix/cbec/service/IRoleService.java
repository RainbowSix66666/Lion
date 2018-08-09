package com.rainbowsix.cbec.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.rainbowsix.cbec.model.RoleModel;

public interface IRoleService {
	public void add(RoleModel role) throws Exception;
	public void delete(RoleModel role) throws Exception;
	public void update(RoleModel role) throws Exception;
	public List<RoleModel> getAll() throws Exception;
	public RoleModel getById(int id) throws Exception;
}
