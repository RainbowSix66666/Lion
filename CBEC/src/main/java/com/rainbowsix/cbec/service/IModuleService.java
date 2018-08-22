package com.rainbowsix.cbec.service;

import java.util.List;

import com.rainbowsix.cbec.model.ModuleModel;

public interface IModuleService {
	public List<ModuleModel> getListByUserId(int userId) throws Exception;
}
