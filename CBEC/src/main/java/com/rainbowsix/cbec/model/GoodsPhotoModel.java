package com.rainbowsix.cbec.model;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.type.Alias;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

@Alias("GoodsPhoto")
public class GoodsPhotoModel { 
	private int photoId;
	private int proid;
	private byte[] photo;
	private String des;
	private int rank;
	@DateTimeFormat(pattern = "yyy-MM-dd")
	@JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd")
	private Date loaddate;
	private String photoFileName=null; //照片文件名
	private String photoContentType=null; //照片文件类型
	private String photoIsImage=null; //照片是否是图片
	
	
	//关联属性-商品
	private GoodsModel good=null;
	//关联属性-照片颜色
	private List<PhotoColorModel> photoColor = null;
	
	
	
	public List<PhotoColorModel> getPhotoColor() {
		return photoColor;
	}
	public void setPhotoColor(List<PhotoColorModel> photoColor) {
		this.photoColor = photoColor;
	}
	public String getPhotoFileName() {
		return photoFileName;
	}
	public void setPhotoFileName(String photoFileName) {
		this.photoFileName = photoFileName;
	}
	public String getPhotoContentType() {
		return photoContentType;
	}
	public void setPhotoContentType(String photoContentType) {
		this.photoContentType = photoContentType;
	}
	public String getPhotoIsImage() {
		return photoIsImage;
	}
	public void setPhotoIsImage(String photoIsImage) {
		this.photoIsImage = photoIsImage;
	}
	public Date getLoaddate() {
		return loaddate;
	}
	public void setLoaddate(Date loaddate) {
		this.loaddate = loaddate;
	}
	public int getProid() {
		return proid;
	}
	public void setProid(int proid) {
		this.proid = proid;
	}
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
