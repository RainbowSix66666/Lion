package com.rainbowsix.cbec.model;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.type.Alias;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
@Alias("GoodsModel")
public class GoodsModel {
	private static final long serialVersionUID = 1L;
	//field变量
	private int proid;//商品编号
	private String comid=null;//公司编号
	private String title=null;//商品标题
	private String state=null;//状态
	private int type=0;//商品类型
	private int stock=0;//库存
	private double price=0;//价格
	private double weight=0;//重量
	
	@JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date gooddate=null;//生产日期
	
	private String gooddesc=null;//简介
	
	//关联属性--照片
	private List<GoodsPhotoModel> goodsPhotos=null;
	
	
	public List<GoodsPhotoModel> getGoodsPhotos() {
		return goodsPhotos;
	}
	public void setGoodsPhotos(List<GoodsPhotoModel> goodsPhotos) {
		this.goodsPhotos = goodsPhotos;
	}
	public int getProid() {
		return proid;
	}
	public void setProid(int proid) {
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
	public int getType() {
		return type;
	}
	public void setType(int type) {
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
	public Date getdate() {
		return gooddate;
	}
	public void setdate(Date gooddate) {
		this.gooddate = gooddate;
	}
	public String getDesc() {
		return gooddesc;
	}
	public void setDesc(String gooddesc) {
		this.gooddesc = gooddesc;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
}
