package com.rainbowsix.cbec.model;

import java.util.List;

import org.apache.ibatis.type.Alias;

@Alias("Function")
public class FunctionModel {
	private int id;
	private String name;
	private String url;
	
	private ModuleModel belong = null;
	private List<RoleModel> roles = null;
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
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public ModuleModel getBelong() {
		return belong;
	}
	public void setBelong(ModuleModel belong) {
		this.belong = belong;
	}
	public List<RoleModel> getRoles() {
		return roles;
	}
	public void setRoles(List<RoleModel> roles) {
		this.roles = roles;
	}
	
	
}
