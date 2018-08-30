package com.rainbowsix.cbec.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rainbowsix.cbec.model.ModuleModel;
import com.rainbowsix.cbec.service.IModuleService;

@RestController
@RequestMapping("/module")
public class ModuleController {
	
	private IModuleService moduleService = null;
	
	@Autowired
	public ModuleController(IModuleService moduleService) {
		this.moduleService = moduleService;
	}
	
	@RequestMapping("all")
	public List<ModuleModel> all() throws Exception{
		return moduleService.getListByAll();
	}
}
