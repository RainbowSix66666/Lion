package com.rainbowsix.cbec.model;

import java.util.List;

import org.apache.ibatis.type.Alias;

@Alias("Order")//括号内没指定，默认的是第一个字母小写
public class OrderModel {
	private int orderid=0; //订单ID
	private String comid=null; //公司ID
	private String orderstate=null; //订单状态
	private int bsid=0; //借卖方ID
	
	//关联物流属性-对一
	private List<LogisticsModel> logistics = null;
	
	//关联商品属性-一对多
	private List<GoodsModel> goods = null;
	
	public int getOrderid() {
		return orderid;
	}
	public void setOrderid(int orderid) {
		this.orderid = orderid;
	}
	public String getComid() {
		return comid;
	}
	public void setComid(String comid) {
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
	public List<LogisticsModel> getLogistics() {
		return logistics;
	}
	public void setLogistics(List<LogisticsModel> logistics) {
		this.logistics = logistics;
	}
	public List<GoodsModel> getGoods() {
		return goods;
	}
	public void setGoods(List<GoodsModel> goods) {
		this.goods = goods;
	}

}
