package com.rainbowsix.cbec.dao;

import java.util.List;

import com.rainbowsix.cbec.model.RoleModel;

public interface IRoleDao {
	public void create(RoleModel role) throws Exception;
	public void delece(RoleModel role) throws Exception;
	public void update(RoleModel role) throws Exception;
	public RoleModel selectByRoleName(String name) throws Exception;
	public void selectById(int id) throws Exception;
	public List<RoleModel> selectAll() throws Exception;
	public void setMenuId(RoleModel role) throws Exception;
}
