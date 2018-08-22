package com.rainbowsix.cbec.model;

import java.util.List;

import org.apache.ibatis.type.Alias;

@Alias("Role")
public class RoleModel {
	private int id;
	private String name;
	private String detial;
	
	private List<UserModel> users = null;	
	
	public List<UserModel> getUsers() {
		return users;
	}
	public void setUsers(List<UserModel> users) {
		this.users = users;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDetial() {
		return detial;
	}
	public void setDetial(String detial) {
		this.detial = detial;
	}
	
	
	
	
}
