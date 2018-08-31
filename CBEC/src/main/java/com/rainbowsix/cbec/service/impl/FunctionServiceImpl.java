package com.rainbowsix.cbec.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rainbowsix.cbec.dao.IFunctionDao;
import com.rainbowsix.cbec.model.FunctionModel;
import com.rainbowsix.cbec.service.IFunctionService;
@Service
public class FunctionServiceImpl implements IFunctionService {
	
	private IFunctionDao functionDao;	
	
	@Autowired
	public void setFunctionDao(IFunctionDao functionDao) {
		this.functionDao = functionDao;
	}


	@Override
	public List<FunctionModel> getListByAllWithModule() throws Exception {
		return functionDao.selectAllWithModule();
	}

}
