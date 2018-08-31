package com.rainbowsix.cbec.dao;

import java.util.List;

import com.rainbowsix.cbec.model.ModuleModel;

public interface IModuleDao {
	public void add(ModuleModel module) throws Exception;
	public void delete(ModuleModel module) throws Exception;
	public void update(ModuleModel modele) throws Exception;
	
	public List<ModuleModel> selectAll() throws Exception;
	public List<ModuleModel> selectListByUserId(int userid) throws Exception;
	public ModuleModel selectByName(String name) throws Exception;
}
