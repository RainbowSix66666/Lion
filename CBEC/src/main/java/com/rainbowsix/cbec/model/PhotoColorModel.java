package com.rainbowsix.cbec.model;

import java.util.List;

import org.apache.ibatis.type.Alias;

@Alias("PhotoColor")
public class PhotoColorModel {
	private int id;
	private String name;
	private List<PhotoColorModel> photoColor = null;
	
	
	public List<PhotoColorModel> getPhotoColor() {
		return photoColor;
	}
	public void setPhotoColor(List<PhotoColorModel> photoColor) {
		this.photoColor = photoColor;
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
	
	
}
