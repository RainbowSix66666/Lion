package com.rainbowsix.cbec.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rainbowsix.cbec.model.AreaModel;
import com.rainbowsix.cbec.result.JqGridJson;
import com.rainbowsix.cbec.service.IAreaService;

@RestController
@RequestMapping("area")
public class AreaController {
	private IAreaService areaService = null;
	
	@Autowired
	public void setAreaService(IAreaService areaService) {
		this.areaService = areaService;
	}
	
	@RequestMapping("list/all")
	public JqGridJson<AreaModel> listByAll() throws Exception{
		JqGridJson<AreaModel> result = new JqGridJson<AreaModel>();
		
		result.setPage(1);
		result.setRows(areaService.selectAll());
		result.setRecords(result.getRows().size());
		result.setTotal(1);
		
		return result;
	}
	
}
