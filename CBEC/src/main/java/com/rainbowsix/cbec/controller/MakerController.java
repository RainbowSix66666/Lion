package com.rainbowsix.cbec.controller;

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
	
}
