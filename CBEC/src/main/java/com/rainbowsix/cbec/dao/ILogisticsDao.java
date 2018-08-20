package com.rainbowsix.cbec.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.rainbowsix.cbec.model.LogisticsModel;

//物流的Dao层接口
public interface ILogisticsDao {
	//新增物流
	public void create(LogisticsModel logistics) throws Exception;
	//新增关联订单的物流
	public void createWithOrder(LogisticsModel logistics) throws Exception;
	//修改物流
	public void update(LogisticsModel logistics) throws Exception;
	//修改关联订单的物流
	public void updateWithOrder(LogisticsModel logistics) throws Exception;
	//删除物流
	public void delete(int logisticsid) throws Exception;
	//取得所有物流列表
	public List<LogisticsModel> selectLogisticsListByAll() throws Exception;
	//通过物流ID取得物流
	public LogisticsModel selectLogisticsListById(int logisticsid) throws Exception;
	//取得所有关联订单的物流列表
	public List<LogisticsModel> selectLogisticsListWithOrder() throws Exception;
	//根据检索条件取得物流的列表
	public List<LogisticsModel> selectLogisticsListByCondition(@Param("address") String address,@Param("expressnumber") int expressnumber,@Param("consignee") String consignee,@Param("phone") int phone) throws Exception;
	//根据检索条件取得物流的列表-有分页
	public List<LogisticsModel> selectLogisticsListByConditionWithPage(@Param("address") String address,@Param("expressnumber") int expressnumber,@Param("consignee") String consignee,@Param("phone") int phone,@Param("start")  int start,@Param("end")  int end) throws Exception;
	//根据检索条件取得物流条数
	public int selectCountByCondition(@Param("address") String address,@Param("expressnumber") int expressnumber,@Param("consignee") String consignee,@Param("phone") int phone) throws Exception;
	//按地址分组的查询,用于下拉选项
	public List<LogisticsModel> selectAddress() throws Exception; 
}
