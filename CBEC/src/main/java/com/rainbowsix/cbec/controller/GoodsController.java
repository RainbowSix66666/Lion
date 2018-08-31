package com.rainbowsix.cbec.controller;

import java.util.List;

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
	private IGoodsService goodservice = null;
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
		
		return "del complete";
	}
	
	
	@RequestMapping(value="/modify",method={RequestMethod.POST})
	public String modify(GoodsModel good) throws Exception{
		goodservice.modify(good);;		
		
		return "modify complete";
	}
	
	@RequestMapping(value="/bygood",method={RequestMethod.POST})
	public String bygood(int proid,int count) throws Exception{
		goodservice.buygood(proid, count);	
		
		return "buy complete";
	}
	
	@RequestMapping(value="/select/one",method={RequestMethod.GET})
	public GoodsModel one(int proid) throws Exception{
		
		return goodservice.one(proid);
	}
	
	@RequestMapping(value="/select/all",method={RequestMethod.GET})
	public List<GoodsModel> all() throws Exception{
		
		return goodservice.all();
	}
	
	@RequestMapping(value="/select/alltype",method={RequestMethod.GET})
	public List<GoodsModel> typeall() throws Exception{
		
		return goodservice.alltype();
	}
	
	@RequestMapping(value="/select/bytype",method={RequestMethod.GET})
	public List<GoodsModel> bytype(int typeno) throws Exception{
		if(typeno != 0) {
			return goodservice.bytype(typeno);
		}
		else
			return goodservice.all();
	}
	
	@RequestMapping(value="/select/bycomid",method={RequestMethod.GET})
	public List<GoodsModel> bycomid(int comid) throws Exception{
		
		return goodservice.bycomid(comid);
	}
}
