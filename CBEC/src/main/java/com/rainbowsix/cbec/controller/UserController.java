package com.rainbowsix.cbec.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.rainbowsix.cbec.model.ModuleModel;
import com.rainbowsix.cbec.model.UserModel;
import com.rainbowsix.cbec.result.ControllerResult;
import com.rainbowsix.cbec.result.JqGridJson;
import com.rainbowsix.cbec.service.IModuleService;
import com.rainbowsix.cbec.service.IUserService;

@RestController
@RequestMapping("/user")
public class UserController {
	private IUserService userService = null;
	private IModuleService moduleService = null;
	
	@Autowired
	public void setUserService(IUserService userService) {
		this.userService = userService;
	}
	
	@Autowired
	public void setModuleService(IModuleService moduleService) {
		this.moduleService = moduleService;
	}


	@RequestMapping("add")
	public String add(UserModel user, @RequestParam(required = false)MultipartFile userHead,
			int[] rolesNos) throws Exception{
		user.setCreateDate(new Date());		
		System.out.println(user.getArea().getId());
		if(userHead != null && !userHead.isEmpty()) {			
			System.out.println("get photo");
			
			user.setAvatar(userHead.getBytes());
			user.setAvatar_name(userHead.getOriginalFilename());
			user.setAvatar_type(userHead.getContentType());
			userService.addWithPoto(user);
		}else {			
			userService.add(user);
		}		
		
//		for(int roleNo : rolesNos) {
//			System.out.println(roleNo);
//		}
//		System.out.println("userid = " + user.getNo());
		userService.grantRoles(user.getNo(), rolesNos);
//		userService.setArea(user.getNo(), areaId);
		
		return "OK";
	}
	
	@RequestMapping(value="delete", method={RequestMethod.POST})
	public String delete(UserModel user) throws Exception{
		
		userService.delete(user);
		
		return "OK";
	}
	@RequestMapping(value="checkIdUsed", method= {RequestMethod.GET})
	public boolean checkIdUsed(int id) throws Exception{
		boolean result = false;
		
		if(userService.selectById(id) != null) {
			result = true;
		}
		
		return result;
	}
	
	@RequestMapping(value="checkNameUsed", method= {RequestMethod.GET})
	public boolean checkIdUsed(String name) throws Exception{
		boolean result = false;
		
		if(userService.getByName(name) == null) {
			result = true;
		}
		
		return result;
	}
	
	@RequestMapping("all")
	public List<UserModel> all() throws Exception{
		return userService.selectAll();
	}
	@RequestMapping("all/area")
	public List<UserModel> allWithArea() throws Exception{
		return userService.selectAllWithArea();
	}
	@RequestMapping("getbyno")
	public UserModel getByNo(long no) throws Exception{
//		System.out.print(no);
//		return null;
		return userService.selectById(no);
	}
	@RequestMapping("getbyno/maker")
	public UserModel getByNoWithMaker(long no) throws Exception{
		return userService.getByIdWithMaker(no);
	}
	@RequestMapping("list/condiction")
	public List<UserModel> listByCondiction(@RequestParam(required=false)String name, @RequestParam(required=false)Date before, 
			@RequestParam(required=false)Date after, @RequestParam(required=false)int[] roles,
			@RequestParam(required=false, defaultValue="0")int area) throws Exception{
		
		if(name != null && name.trim().length() > 0) {
			name = "%" + name + "%";
		}
		
		return userService.selectListByCondiction(name, before, after, roles, area);
	}
	@RequestMapping("list/condiction/page")
	public JqGridJson<UserModel> listByCondictionWithPage(@RequestParam(required=false)String name,
			@RequestParam(required=false) @DateTimeFormat(pattern = "yyy-MM-dd") Date before, 
			@RequestParam(required=false) @DateTimeFormat(pattern = "yyy-MM-dd") Date after, 
			@RequestParam(required=false)int[] roles,
			@RequestParam(required=false, defaultValue="0")int area,
			@RequestParam(required=false, defaultValue="10") int rows, 
			@RequestParam(required=false, defaultValue="1") int page) throws Exception{
		
		JqGridJson<UserModel> result = new JqGridJson<UserModel>();
		
		if(name != null && name.trim().length() > 0) {
			name = "%" + name + "%";
		}
		
		int records = userService.getCountByCondictionWithoutRole(name, before, after, area);
		int total = ((records + rows - 1) / rows);
		
		if(page < 1) {
			page = 1;
		}else if(page > total) {
			page = total;
		}
		
		int start = rows * (page - 1) + 1;
		int end = rows * page;		
		result.setRows(userService.selectListByCondictionWithPage(name, before, after, roles, area, start, end));	
		result.setTotal(total);
		result.setRecords(records);
		result.setPage(page);
		
		return result;
	}
	
	@RequestMapping("list/condiction/page/without/role")
	public JqGridJson<UserModel> listByCondictionWithPageWithoutRole(@RequestParam(required=false)String name, @RequestParam(required=false)Date before, 
			@RequestParam(required=false)Date after, 
			@RequestParam(required=false, defaultValue="0")int area,
			@RequestParam(required=false, defaultValue="10") int rows, 
			@RequestParam(required=false, defaultValue="1") int page) throws Exception{
		
		JqGridJson<UserModel> result = new JqGridJson<UserModel>();
		
		if(name != null && name.trim().length() > 0) {
			name = "%" + name + "%";
		}
		
		int records = userService.getCountByCondictionWithoutRole(name, before, after, area);
		int total = ((records + rows - 1) / rows);
		
		if(page < 1) {
			page = 1;
		}else if(page > total) {
			page = total;
		}
			
		int start = rows * (page - 1) + 1;
		int end = rows * page;		
		result.setRows(userService.selectListByCondictionWithPageWithoutRole(name, before, after, area, start, end));	
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
	/*****************************用户登录验证**************************/
	//登录
	@RequestMapping(value="login")
	public ControllerResult login(String name, String password, HttpSession session) throws Exception{
		ControllerResult result = new ControllerResult();
		
		//验证用户名和密码
		if(userService.validate(name, password)) {
			result.setStatus("T");
			session.setAttribute("userInfo", userService.getByName(name));
		}else {
			result.setStatus("F");
			result.setError("用户名或密码错误");
		}
		
		return result;
	}
	//验证是否已登录
	@RequestMapping(value="checkLogin", method={RequestMethod.GET})
	public ControllerResult checkLogin(HttpSession session) throws Exception{
		ControllerResult result = new ControllerResult();
		
		if(session.getAttribute("userInfo") != null) {
			result.setStatus("T");
		}else {
			result.setStatus("F");
//			result.setStatus("T");
		}
		
		return result;
	}
	//注销
	@RequestMapping(value="logout", method={RequestMethod.GET})
	public ControllerResult logout(HttpSession session) throws Exception{
		session.invalidate();
		
		ControllerResult result = new ControllerResult();
		System.out.println("user logout");
		result.setMessage("注销成功");
		result.setStatus("T");
		
		return result;
	}
	@RequestMapping(value="getLoginUser", method= {RequestMethod.GET})
	public UserModel getLoginUserInfo(HttpSession session) throws Exception{
		UserModel userInfo = (UserModel)session.getAttribute("userInfo");
		return userInfo;
	}
	
	/**************************功能模块**************************/
	@RequestMapping(value="getModuleList", method= {RequestMethod.GET})
	public List<ModuleModel> getModuleList(int userId) throws Exception{
		return moduleService.getListByUserId(userId);
	}
}
