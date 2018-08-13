package com.rainbowsix.cbec.model;

import org.apache.ibatis.type.Alias;

@Alias("Role")
public class RoleModel {
	private int id;
	private String name;
	private int menuid;
	private String detial;
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
	public int getMenuid() {
		return menuid;
	}
	public void setMenuid(int menuid) {
		this.menuid = menuid;
	}
	public String getDetial() {
		return detial;
	}
	public void setDetial(String detial) {
		this.detial = detial;
	}
	
	
	
	
}
