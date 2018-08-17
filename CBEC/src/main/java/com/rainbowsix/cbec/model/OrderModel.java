package com.rainbowsix.cbec.model;

import java.util.List;

import org.apache.ibatis.type.Alias;

@Alias("Order")//括号内没指定，默认的是第一个字母小写
public class OrderModel {
	private int orderid=0; //订单ID
	private int comid=0; //公司ID
	private String orderstate=null; //订单状态
	private int bsid=0; //借卖方ID
	private int logisticsid=0; //物流ID 外键
	
	//关联属性-对一-物流
	private List<LogisticsModel> logistics = null;
	
	public int getOrderid() {
		return orderid;
	}
	public void setOrderid(int orderid) {
		this.orderid = orderid;
	}
	public int getComid() {
		return comid;
	}
	public void setComid(int comid) {
		this.comid = comid;
	}
	public String getOrderstate() {
		return orderstate;
	}
	public void setOrderstate(String orderstate) {
		this.orderstate = orderstate;
	}
	public int getBsid() {
		return bsid;
	}
	public void setBsid(int bsid) {
		this.bsid = bsid;
	}
	public int getLogisticsid() {
		return logisticsid;
	}
	public void setLogisticsid(int logisticsid) {
		this.logisticsid = logisticsid;
	}
	public List<LogisticsModel> getLogistics() {
		return logistics;
	}
	public void setLogistics(List<LogisticsModel> logistics) {
		this.logistics = logistics;
	}

}
