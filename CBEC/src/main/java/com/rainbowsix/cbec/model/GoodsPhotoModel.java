package com.rainbowsix.cbec.model;

import org.apache.ibatis.type.Alias;

@Alias("GoodsPhoto")
public class GoodsPhotoModel { 
	private int photoId;
	private int proid;
	private byte[] photo;
	private String des;
	private int rank;
	//关联的属性--商品
	private GoodsModel goods = null;
	
	public GoodsModel getGoods() {
		return goods;
	}
	public void setGoods(GoodsModel goods) {
		this.goods = goods;
	}
	
	public int getProid() {
		return proid;
	}
	public void setProid(int proid) {
		this.proid = proid;
	}
	//关联属性-商品
	private GoodsModel good=null;
	
	
	public GoodsModel getGood() {
		return good;
	}
	public void setGood(GoodsModel good) {
		this.good = good;
	}
	public int getPhotoId() {
		return photoId;
	}
	public void setPhotoId(int photoId) {
		this.photoId = photoId;
	}
	
	public byte[] getPhoto() {
		return photo;
	}
	public void setPhoto(byte[] photo) {
		this.photo = photo;
	}
	public String getDes() {
		return des;
	}
	public void setDes(String des) {
		this.des = des;
	}
	public int getRank() {
		return rank;
	}
	public void setRank(int rank) {
		this.rank = rank;
	}
	
	
}
