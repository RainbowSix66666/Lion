package com.rainbowsix.cbec.service;

import java.util.List;

import com.rainbowsix.cbec.model.ModuleModel;

public interface IModuleService {
	//查询
	public List<ModuleModel> getListByUserId(int userId) throws Exception;
	public List<ModuleModel> getListByAll() throws Exception;
	public ModuleModel getByName(String name) throws Exception;
	
	public void add(ModuleModel Module) throws Exception;
	public void delete(ModuleModel module) throws Exception;
}
