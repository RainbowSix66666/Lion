package com.rainbowsix.cbec.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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
	@RequestMapping("getbyno")
	public UserModel getByNo(long no) throws Exception{
//		System.out.print(no);
//		return null;
		return userService.selectById(no);
	}
	@RequestMapping("list/condiction")
	public List<UserModel> listByCondiction(@RequestParam(required=false)String name, @RequestParam(required=false)Date before, 
			@RequestParam(required=false)Date after, @RequestParam(required=false)int[] roles) throws Exception{
		
		if(name != null && name.trim().length() > 0) {
			name = "%" + name + "%";
		}
		
		return userService.selectListByCondiction(name, before, after, roles);
	}
	@RequestMapping("list/condiction/page")
	public List<UserModel> listByCondictionWithPage(@RequestParam(required=false)String name, @RequestParam(required=false)Date before, 
			@RequestParam(required=false)Date after, @RequestParam(required=false)int[] roles, 
			@RequestParam(required=false, defaultValue="10") int rows, 
			@RequestParam(required=false, defaultValue="1") int page) throws Exception{
		if(name != null && name.trim().length() > 0) {
			name = "%" + name + "%";
		}
		int start = rows * (page - 1) + 1;
		int end = rows * page;
		
		return userService.selectListByCondictionWithPage(name, before, after, roles, start, end);
	}
	
	@RequestMapping(value="modify", method={RequestMethod.POST})
	public boolean modify(UserModel user) throws Exception{
//		System.out.println(user.getName());
		userService.update(user);
		
		return true;
	}
	
}
