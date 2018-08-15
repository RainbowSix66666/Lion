package com.rainbowsix.cbec.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.rainbowsix.cbec.model.LogisticsModel;
import com.rainbowsix.cbec.service.ILogisticsService;

@RestController
@RequestMapping("/logistics")
public class LogisticsController {
private ILogisticsService logisticsService = null;
	
	@Autowired
	public void setLogisticsService(ILogisticsService logisticsService) {
	this.logisticsService = logisticsService;
}

	@RequestMapping(value="/add",method= {RequestMethod.POST})
	@ResponseBody	
	public String add(LogisticsModel logistics) throws Exception{
		logisticsService.add(logistics);
		return "Add OK!!!";
	}
	
	@RequestMapping(value="/modify",method= {RequestMethod.POST})
	public String modify(LogisticsModel logistics) throws Exception{
		logisticsService.modify(logistics);
		return "Modify OK!!!";
	}
	
	@RequestMapping(value="/delete",method= {RequestMethod.POST})
	public String delete(int logisticsid) throws Exception{
		logisticsService.delete(logisticsid);
		return "Delete OK!!!";
	}
	
	@RequestMapping(value="/list/all",method= {RequestMethod.GET})
	public List<LogisticsModel> getLogisticsListByAll() throws Exception{
		return logisticsService.getLogisticsListByAll();
	}
	
	@RequestMapping(value="/get",method= {RequestMethod.GET})
	public LogisticsModel getLogisticsListById(int logisticsid) throws Exception{
		return logisticsService.getLogisticsListById(logisticsid);
	}

}
