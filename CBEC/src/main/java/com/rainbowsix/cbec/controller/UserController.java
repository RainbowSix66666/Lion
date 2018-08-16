package com.rainbowsix.cbec.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.rainbowsix.cbec.model.UserModel;
import com.rainbowsix.cbec.result.JqGridJson;
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
	public JqGridJson<UserModel> listByCondictionWithPage(@RequestParam(required=false)String name, @RequestParam(required=false)Date before, 
			@RequestParam(required=false)Date after, @RequestParam(required=false)int[] roles, 
			@RequestParam(required=false, defaultValue="10") int rows, 
			@RequestParam(required=false, defaultValue="1") int page) throws Exception{
		
		JqGridJson<UserModel> result = new JqGridJson<UserModel>();
		
		if(name != null && name.trim().length() > 0) {
			name = "%" + name + "%";
		}
		int start = rows * (page - 1) + 1;
		int end = rows * page;		
		result.setRows(userService.selectListByCondictionWithPage(name, before, after, roles, start, end));	
		
		result.setPage(page);
		
		return result;
	}
	@RequestMapping("list/condiction/page/without/role")
	public JqGridJson<UserModel> listByCondictionWithPageWithoutRole(@RequestParam(required=false)String name, @RequestParam(required=false)Date before, 
			@RequestParam(required=false)Date after, @RequestParam(required=false, defaultValue="10") int rows, 
			@RequestParam(required=false, defaultValue="1") int page) throws Exception{
		
		JqGridJson<UserModel> result = new JqGridJson<UserModel>();
		
		if(name != null && name.trim().length() > 0) {
			name = "%" + name + "%";
		}
		
		int records = userService.getCountByCondictionWithoutRole(name, before, after);
		int total = ((records + rows - 1) / rows);
		
		if(page < 1) {
			page = 1;
		}else if(page > total) {
			page = total;
		}
			
		int start = rows * (page - 1) + 1;
		int end = rows * page;		
		result.setRows(userService.selectListByCondictionWithPageWithoutRole(name, before, after, start, end));	
		result.setPage(page);		
		result.setRecords(records);
		result.setTotal(total);
		
		return result;
		
	}
	
	@RequestMapping(value="modify", method={RequestMethod.POST})
	public boolean modify(UserModel user) throws Exception{
//		System.out.println(user.getName());
		userService.update(user);
		
		return true;
	}
	
	
	
}
