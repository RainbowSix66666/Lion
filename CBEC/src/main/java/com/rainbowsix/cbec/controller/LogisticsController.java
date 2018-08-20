package com.rainbowsix.cbec.controller;

import java.util.List;

import org.apache.logging.log4j.core.tools.picocli.CommandLine.Parameters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.rainbowsix.cbec.model.LogisticsModel;
import com.rainbowsix.cbec.result.LogisticsGridResult;
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
	//关联订单的增加
	@RequestMapping(value="/addwithorder",method= {RequestMethod.POST})
	@ResponseBody	
	public String addWithOrder(LogisticsModel logistics) throws Exception{
		logisticsService.addWithOrder(logistics);
		return "AddWithOrder OK!!!";
	}
	
	@RequestMapping(value="/modify",method= {RequestMethod.POST})
	public String modify(LogisticsModel logistics) throws Exception{
		logisticsService.modify(logistics);
		return "Modify OK!!!";
	}
	//关联订单的修改
	@RequestMapping(value="/modifywithorder",method= {RequestMethod.POST})
	public String modifyWithOrder(LogisticsModel logistics) throws Exception{
		logisticsService.modifyWithOrder(logistics);
		return "ModifyWithOrder OK!!!";
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
	
	@RequestMapping(value="/list/all/withorder",method= {RequestMethod.GET})
	public List<LogisticsModel> getLogisticsListWithOrder() throws Exception{
		return logisticsService.getLogisticsListWithOrder();
	}
	
	@RequestMapping(value="/list/condition",method= {RequestMethod.GET})
	public List<LogisticsModel> getLogisticsListByCondition(@RequestParam(required=false,defaultValue="") String address,
			@RequestParam(required=false,defaultValue="0") int expressnumber,
			@RequestParam(required=false,defaultValue="") String consignee,
			@RequestParam(required=false,defaultValue="0") int phone) throws Exception{
		
		return logisticsService.getLogisticsListByCondition(address,expressnumber,consignee,phone);
	}
	
	@RequestMapping(value="/list/condition/page",method= {RequestMethod.GET})
	public LogisticsGridResult<LogisticsModel> getLogisticsListByConditionWithPage(@RequestParam(required=false,defaultValue="") String address,
			@RequestParam(required=false,defaultValue="0") int expressnumber,
			@RequestParam(required=false,defaultValue="") String consignee,
			@RequestParam(required=false,defaultValue="0") int phone,
			@RequestParam(required=false,defaultValue="5") int rows, 
			@RequestParam(required=false,defaultValue="1") int page) throws Exception{
		
		LogisticsGridResult<LogisticsModel>  result=new LogisticsGridResult<LogisticsModel>();
		
		result.setRecords(logisticsService.getCountByCondition(address,expressnumber,consignee,phone));
		int pageCount=logisticsService.getPageCountByCondition(address,expressnumber,consignee,phone, rows);
		if(page>pageCount) {
			page=pageCount;
		}
		if(page<1) {
			page=1;
		}
		result.setPage(page);
		result.setTotal(pageCount);
		result.setRows(logisticsService.getLogisticsListByConditionWithPage(address,expressnumber,consignee,phone,rows,page));
		
		return result;
	}

	@RequestMapping(value="/list/address",method= {RequestMethod.GET})
	public List<LogisticsModel> getAddress() throws Exception{
		return logisticsService.getAddress();
	}

}
