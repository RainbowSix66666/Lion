package com.rainbowsix.cbec.model;

public class OrderModel {
	private int orderid=0; //订单ID
	private int comid=0; //公司ID
	private String orderstate=null; //订单状态
	private int bsid=0; //借卖方ID
	
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
	
	

}
