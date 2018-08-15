package com.rainbowsix.cbec.service;

import java.util.List;

import com.rainbowsix.cbec.model.LogisticsModel;

//物流的业务层接口
public interface ILogisticsService {
	//新增物流
	public void add(LogisticsModel logistics) throws Exception;
	//修改物流
	public void modify(LogisticsModel logistics) throws Exception;
	//删除物流
	public void delete(int logisticsid) throws Exception;
	//取得所有物流列表
	public List<LogisticsModel> getLogisticsListByAll() throws Exception;
	//通过物流ID取得物流
	public LogisticsModel getLogisticsListById(int logisticsid) throws Exception;

}
