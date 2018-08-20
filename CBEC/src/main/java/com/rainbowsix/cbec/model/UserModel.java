package com.rainbowsix.cbec.model;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.type.Alias;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

@Alias("User")
public class UserModel {
	private long no;
	private String name;
	private String password;
	private long mvoid;
	private long paypackageid;
	@DateTimeFormat(pattern = "yyy-MM-dd")
	@JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd")
	private Date createDate;
	//头像信息
	private byte[] avatar;
	private String avatar_name;
	private String avayar_type;
	
	private AreaModel area = null;
	private ResellerModel reseller = null;
	private List<RoleModel> roles = null;	
	
	public byte[] getAvatar() {
		return avatar;
	}
	public void setAvatar(byte[] avatar) {
		this.avatar = avatar;
	}
	public AreaModel getArea() {
		return area;
	}
	public void setArea(AreaModel area) {
		this.area = area;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
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
