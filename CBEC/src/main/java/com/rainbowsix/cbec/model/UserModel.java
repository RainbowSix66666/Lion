package com.rainbowsix.cbec.model;

import org.apache.ibatis.type.Alias;

@Alias("User")
public class UserModel {
	private long no;
	private String name;
	private String password;
	private long bvoid;
	private long mvoid;
	private long paypackageid;
	
	private RoleModel role = null;
//	private String role;
	public long getNo() {
		return no;
	}
	public void setNo(long no) {
		this.no = no;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public long getBvoid() {
		return bvoid;
	}
	public void setBvoid(long bvoid) {
		this.bvoid = bvoid;
	}
	public long getMvoid() {
		return mvoid;
	}
	public void setMvoid(long mvoid) {
		this.mvoid = mvoid;
	}
	public long getPaypackageid() {
		return paypackageid;
	}
	public void setPaypackageid(long paypackageid) {
		this.paypackageid = paypackageid;
	}
//	public String getRole() {
//		return role;
//	}
//	public void setRole(String role) {
//		this.role = role;
//	}
	
	
}
