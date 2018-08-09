package com.rainbowsix.cbec.controller;

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
	
	@RequestMapping(value="/add",method={RequestMethod.GET})
	@ResponseBody
	public String add(RoleModel role) throws Exception{
		
		
		
		return "nice";
	}
	
	
}
