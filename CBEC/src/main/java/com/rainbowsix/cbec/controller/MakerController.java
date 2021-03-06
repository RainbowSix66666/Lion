package com.rainbowsix.cbec.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.rainbowsix.cbec.model.MakerModel;
import com.rainbowsix.cbec.service.IMakerService;

@RestController
@RequestMapping("/maker")
public class MakerController {
	private IMakerService makerService= null;

	@Autowired
	public void setMakerService(IMakerService makerService) {
		this.makerService = makerService;
	}
	
	@RequestMapping(value="/add",method={RequestMethod.POST})
	@ResponseBody
	public String add(MakerModel maker) throws Exception{
			makerService.add(maker);
					
			
			return "ok";
		}
	
	@RequestMapping(value="/modify",method={RequestMethod.POST})
	@ResponseBody
	public String modify(MakerModel maker) throws Exception{
		
		makerService.modify(maker);		
		
		return "ok";
	}
	
	@RequestMapping(value="/delete",method={RequestMethod.POST})
	@ResponseBody
	public String delete(int makerId) throws Exception{
		
		makerService.delete(makerId);	
		
		return "ok";
	}
	
	@RequestMapping(value="/list/all",method={RequestMethod.GET})
	@ResponseBody
	public List<MakerModel> selectListByAll() throws Exception{
		
		return makerService.selectListByAll();	
		
	}
	
	@RequestMapping(value="/bymakerId",method={RequestMethod.GET})
	@ResponseBody
	public MakerModel selectByMakerId(int makerId) throws Exception{
		
		return makerService.selectByMakerId(makerId);	
		
	}
	
	//制造商的登录验证方法
	@RequestMapping(value="/validate",method=RequestMethod.POST)
	public boolean validate(String makerId,String makerPassword) throws Exception{
		boolean result = false;
		if(makerService.validate(makerId, makerPassword)) {
			result=true;
		}
		return result;
	}
	
	
}
