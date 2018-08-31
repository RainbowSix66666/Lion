package com.rainbowsix.cbec.controller;

import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.rainbowsix.cbec.model.FunctionModel;
import com.rainbowsix.cbec.service.IFunctionService;

@RestController
@RequestMapping("/function")
public class FunctionController {
	private IFunctionService functionService;

	public void setFunctionService(IFunctionService functionService) {
		this.functionService = functionService;
	}
	@RequestMapping(value="list/all/module")
	public List<FunctionModel> getListByAllWithModule() throws Exception{
		return functionService.getListByAllWithModule();
	}
}
