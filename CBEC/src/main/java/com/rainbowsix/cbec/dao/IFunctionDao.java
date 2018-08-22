package com.rainbowsix.cbec.dao;

import java.util.List;

import com.rainbowsix.cbec.model.FunctionModel;

public interface IFunctionDao {
	public void add(FunctionModel function) throws Exception;
	public void delete(FunctionModel function) throws Exception;
	public void update(FunctionModel function) throws Exception;
	
	public List<FunctionModel> selectAll() throws Exception;
	public List<FunctionModel> selectListByModuleId(int moduleId) throws Exception;
	public FunctionModel selectByName(String name) throws Exception;
	public FunctionModel selectById(int id) throws Exception;
}
