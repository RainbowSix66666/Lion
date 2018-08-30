package com.rainbowsix.cbec.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rainbowsix.cbec.dao.IModuleDao;
import com.rainbowsix.cbec.model.ModuleModel;
import com.rainbowsix.cbec.service.IModuleService;

@Service()
@Transactional
public class ModuleServiceImpl implements IModuleService {
	
	private IModuleDao moduleDao = null;	
	@Autowired
	public void setModuleDao(IModuleDao moduleDao) {
		this.moduleDao = moduleDao;
	}

	@Override
	public List<ModuleModel> getListByUserId(int userId) throws Exception {
		// TODO Auto-generated method stub
		return moduleDao.selectListByUserId(userId);
	}

	@Override
	public void add(ModuleModel module) throws Exception {
		// TODO Auto-generated method stub
		moduleDao.add(module);
	}

	@Override
	public List<ModuleModel> getListByAll() throws Exception {
		// TODO Auto-generated method stub
		return moduleDao.selectAll();
	}

}
