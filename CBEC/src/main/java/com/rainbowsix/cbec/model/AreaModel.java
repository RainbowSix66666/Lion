package com.rainbowsix.cbec.model;

import org.apache.ibatis.type.Alias;

@Alias("Area")
public class AreaModel {
	private int id;
	private String desc = null;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	
}
