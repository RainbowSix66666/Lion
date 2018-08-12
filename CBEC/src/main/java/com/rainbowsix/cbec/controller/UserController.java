package com.rainbowsix.cbec.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.rainbowsix.cbec.model.UserModel;
import com.rainbowsix.cbec.service.IUserService;

@RestController
@RequestMapping("/user")
public class UserController {
	private IUserService userService = null;
	
	@Autowired
	public void setUserService(IUserService userService) {
		this.userService = userService;
	}
	
	@RequestMapping("add")
	public String add(UserModel user) throws Exception{
		
		userService.add(user);
		
		return "OK";
	}
	
	@RequestMapping(value="delete", method={RequestMethod.POST})
	public String delete(UserModel user) throws Exception{
		
		userService.delete(user);
		
		return "OK";
	}
	
	@RequestMapping("all")
	public List<UserModel> all() throws Exception{
		return userService.selectAll();
	}
	
}
