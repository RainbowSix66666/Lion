package com.rainbowsix.cbec.dao;

import java.util.List;

import com.rainbowsix.cbec.model.LogisticsModel;

//物流的Dao层接口
public interface ILogisticsDao {
	//新增物流
	public void create(LogisticsModel logistics) throws Exception;
	//修改物流
	public void update(LogisticsModel logistics) throws Exception;
	//删除物流
	public void delete(int logisticsid) throws Exception;
	//取得所有物流列表
	public List<LogisticsModel> selectLogisticsListByAll() throws Exception;
	//通过物流ID取得物流
	public LogisticsModel selectLogisticsListById(int logisticsid) throws Exception;

}
