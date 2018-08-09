package com.rainbowsix.cbec.model;

import java.sql.Blob;
import java.util.Date;

public class GoodsModel {
	private static final long serialVersionUID = 1L;
	//field变量
	private String proid=null;//商品编号
	private String comid=null;//公司编号
	private String title=null;//商品标题
	private String state=null;//状态
	private String type=null;//商品类型
	private int stock=0;//库存
	private double price=0;//价格
	private double weight=0;//重量
	private Date gooddate=null;//生产日期
	private String desc=null;//简介
	private Blob  photo=null;//照片
	private String photoname=null;//照片文件名
	private String phototype=null;//照片文件类型
	public String getProid() {
		return proid;
	}
	public void setProid(String proid) {
		this.proid = proid;
	}
	public String getComid() {
		return comid;
	}
	public void setComid(String comid) {
		this.comid = comid;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public double getWeight() {
		return weight;
	}
	public void setWeight(double weight) {
		this.weight = weight;
	}
	public Date getGooddate() {
		return gooddate;
	}
	public void setGooddate(Date gooddate) {
		this.gooddate = gooddate;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public Blob getPhoto() {
		return photo;
	}
	public void setPhoto(Blob photo) {
		this.photo = photo;
	}
	public String getPhotoname() {
		return photoname;
	}
	public void setPhotoname(String photoname) {
		this.photoname = photoname;
	}
	public String getPhototype() {
		return phototype;
	}
	public void setPhototype(String phototype) {
		this.phototype = phototype;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
}
