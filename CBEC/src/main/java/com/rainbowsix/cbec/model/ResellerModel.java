package com.rainbowsix.cbec.model;

import org.apache.ibatis.type.Alias;

@Alias("Reseller")
public class ResellerModel {
	private int id;
	//借卖商所属地区
	private String area;
	//借卖商具体地点
	private String location;
	private String mail;
	
	//电话号码前缀
	private String phone_pre;
	//电话号码后缀
	private String phone_suf;	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public String getPhone_pre() {
		return phone_pre;
	}
	public void setPhone_pre(String phone_pre) {
		this.phone_pre = phone_pre;
	}
	public String getPhone_suf() {
		return phone_suf;
	}
	public void setPhone_suf(String phone_suf) {
		this.phone_suf = phone_suf;
	}
	
	
}
