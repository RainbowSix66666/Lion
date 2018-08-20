package com.rainbowsix.cbec.model;

import org.apache.ibatis.type.Alias;

//物流Model LOGISTICSID ADDRESS EXPRESSNUMBER CONSIGNEE PHONE
@Alias("Logistics") //别名
public class LogisticsModel {
	private int logisticsid=0; //物流ID
	private String address=null; //收货地址
	private int expressnumber=0; //快递单号
	private String consignee=null; //收货人
	private int phone=0; //手机号
	//与订单关联-对一
	private OrderModel order=null;
	
	public int getLogisticsid() {
		return logisticsid;
	}
	public void setLogisticsid(int logisticsid) {
		this.logisticsid = logisticsid;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getExpressnumber() {
		return expressnumber;
	}
	public void setExpressnumber(int expressnumber) {
		this.expressnumber = expressnumber;
	}
	public String getConsignee() {
		return consignee;
	}
	public void setConsignee(String consignee) {
		this.consignee = consignee;
	}
	public int getPhone() {
		return phone;
	}
	public void setPhone(int phone) {
		this.phone = phone;
	}
	//与订单关联的getter and setter方法
	public OrderModel getOrder() {
		return order;
	}
	public void setOrder(OrderModel order) {
		this.order = order;
	}
	
	
}
