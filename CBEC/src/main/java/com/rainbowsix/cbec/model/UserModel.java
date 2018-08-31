package com.rainbowsix.cbec.model;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.type.Alias;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

@Alias("User")
public class UserModel {
	private int no;
	private String name;
	private String password;
	private long paypackageid;
	@DateTimeFormat(pattern = "yyy-MM-dd")
	@JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd")
	private Date createDate;
	//头像信息
	private byte[] avatar;
	private String avatar_name;
	private String avatar_type;
	
	private AreaModel area = null;
	private ResellerModel reseller = null;
	private List<RoleModel> roles = null;	
	private MakerModel maker = null;
	
	
	public MakerModel getMaker() {
		return maker;
	}
	public void setMaker(MakerModel maker) {
		this.maker = maker;
	}
	public String getAvatar_name() {
		return avatar_name;
	}
	public void setAvatar_name(String avatar_name) {
		this.avatar_name = avatar_name;
	}
	public String getAvatar_type() {
		return avatar_type;
	}
	public void setAvatar_type(String avatar_type) {
		this.avatar_type = avatar_type;
	}
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
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
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
	public long getPaypackageid() {
		return paypackageid;
	}
	public void setPaypackageid(long paypackageid) {
		this.paypackageid = paypackageid;
	}
	
	
}
