package com.rainbowsix.cbec.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.rainbowsix.cbec.model.ModuleModel;
import com.rainbowsix.cbec.result.JqGridJson;
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
	public JqGridJson<ModuleModel> all() throws Exception{
		JqGridJson<ModuleModel> result = new JqGridJson<ModuleModel>();
		
		result.setRows(moduleService.getListByAll());
		result.setPage(1);
		result.setRecords(result.getRows().size());
		result.setTotal(1);
		
		return result;
	}
	@RequestMapping(value="add", method={RequestMethod.POST})
	public void addModule(ModuleModel module) throws Exception{
		moduleService.add(module);
	}
	@RequestMapping(value="checkname", method={RequestMethod.GET})
	public boolean checkName(String name) throws Exception{
		boolean result = false;
		
		if(moduleService.getByName(name) == null) {
			return true;
		}
		
		return result;
	}
	@RequestMapping(value="delete", method={RequestMethod.POST})
	public String delete(ModuleModel module) throws Exception{
		moduleService.delete(module);
		return "OK";
	}
}
