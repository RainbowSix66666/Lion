package com.rainbowsix.cbec.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.rainbowsix.cbec.model.RoleModel;
import com.rainbowsix.cbec.service.IRoleService;

@RestController
@RequestMapping("/role")
public class RoleController {
	private IRoleService roleService = null;
	
	@Autowired
	public void setRoleService(IRoleService roleService) {
		this.roleService = roleService;
	}
	
	@RequestMapping(value="/add",method={RequestMethod.POST})
	public String add(RoleModel role) throws Exception{
		
		roleService.add(role);		
		
		return "nice";
	}
	
	@RequestMapping(value="/all",method={RequestMethod.POST})
	public List<RoleModel> all() throws Exception{
		
		return roleService.getAll();
		
	}
	
}
