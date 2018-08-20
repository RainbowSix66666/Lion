package com.rainbowsix.cbec.service;

import java.util.List;

import com.rainbowsix.cbec.model.LogisticsModel;

//物流的业务层接口
public interface ILogisticsService {
	//新增物流
	public void add(LogisticsModel logistics) throws Exception;
	//新增物流-关联订单
	public void addWithOrder(LogisticsModel logistics) throws Exception;
	//修改物流
	public void modify(LogisticsModel logistics) throws Exception;
	//修改物流-关联订单
	public void modifyWithOrder(LogisticsModel logistics) throws Exception;
	//删除物流
	public void delete(int logisticsid) throws Exception;
	//取得所有物流列表
	public List<LogisticsModel> getLogisticsListByAll() throws Exception;
	//通过物流ID取得物流
	public LogisticsModel getLogisticsListById(int logisticsid) throws Exception;
	//取得所有关联订单的物流列表
	public List<LogisticsModel> getLogisticsListWithOrder() throws Exception;
	//按检索条件获得物流列表-无分页
	public List<LogisticsModel> getLogisticsListByCondition(String address,int expressnumber,String consignee,int phone) throws Exception;
	//按检索条件获得物流列表-有分页
	public List<LogisticsModel> getLogisticsListByConditionWithPage(String address,int expressnumber,String consignee,int phone,int start,int end) throws Exception;
	//根据检索条件取得物流条数
	public int getCountByCondition(String address,int expressnumber,String consignee,int phone) throws Exception;
	//根据检索条件取得物流显示页数
	public int getPageCountByCondition(String address,int expressnumber,String consignee,int phone,int rows) throws Exception;
}
