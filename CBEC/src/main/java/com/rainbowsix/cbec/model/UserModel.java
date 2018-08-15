package com.rainbowsix.cbec.model;

import java.util.List;

import org.apache.ibatis.type.Alias;

@Alias("User")
public class UserModel {
	private long no;
	private String name;
	private String password;
	private long mvoid;
	private long paypackageid;
	
	private ResellerModel reseller = null;
	private List<RoleModel> roles = null;	
	
	public List<RoleModel> getRoles() {
		return roles;
	}
	public void setRoles(List<RoleModel> roles) {
		this.roles = roles;
	}
	public ResellerModel getReseller() {
		return reseller;
	}
	public void setReseller(ResellerModel reseller) {
		this.reseller = reseller;
	}
//	public RoleModel getRole() {
//		return role;
//	}
//	public void setRole(RoleModel role) {
//		this.role = role;
//	}
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
	
	
}
