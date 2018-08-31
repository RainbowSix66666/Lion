package com.rainbowsix.cbec.service;

import java.util.List;

import com.rainbowsix.cbec.model.FunctionModel;

public interface IFunctionService {
	public List<FunctionModel> getListByAllWithModule() throws Exception;
}
