package com.rainbowsix.cbec.dao;

import java.util.List;

import com.rainbowsix.cbec.model.FunctionModel;

public interface IFunctionDao {	
	
	public List<FunctionModel> selectAllWithModule() throws Exception;
}
