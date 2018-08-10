package com.rainbowsix.cbec.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.rainbowsix.cbec.model.GoodsModel;
import com.rainbowsix.cbec.service.IGoodsService;

@RestController
@RequestMapping("/goods")
public class GoodsController {
	public IGoodsService goodservice = null;
	@Autowired
	public void setRoleService(IGoodsService goodservice) {
		this.goodservice = goodservice;
	}
	
	@RequestMapping(value="/add",method={RequestMethod.POST})
	public String add(GoodsModel good) throws Exception{
		
		goodservice.add(good);		
		
		return "add complete";
	}
	
	@RequestMapping(value="/del",method={RequestMethod.POST})
	public String del(int proid) throws Exception{
	
		goodservice.del(proid);		
		
		return "add complete";
	}
	
	
	@RequestMapping(value="/modify",method={RequestMethod.POST})
	public String modify(int proid) throws Exception{
		
		goodservice.mod(proid);;		
		
		return "modify complete";
	}
	
	@RequestMapping(value="/select/one",method={RequestMethod.POST})
	public GoodsModel one(int proid) throws Exception{
		
		return goodservice.one(proid);
	}
}
