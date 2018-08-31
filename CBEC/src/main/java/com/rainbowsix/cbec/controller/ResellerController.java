package com.rainbowsix.cbec.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.rainbowsix.cbec.model.ResellerModel;
import com.rainbowsix.cbec.service.IResellerService;

@RestController
@RequestMapping("reseller")
public class ResellerController {
	private IResellerService resellerService = null;
	
	@Autowired
	public void setResellerService(IResellerService resellerService) {
		this.resellerService = resellerService;
	}
	
	//通过id取得买家的信息
	@RequestMapping(value="selectresellerbyid", method= {RequestMethod.GET})
	@ResponseBody
	public ResellerModel selectResellerById(int resellId) throws Exception{
		return resellerService.selectResellerById(resellId);
	}
	
}









