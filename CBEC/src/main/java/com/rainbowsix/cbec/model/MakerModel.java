package com.rainbowsix.cbec.model;

import org.apache.ibatis.type.Alias;

@Alias("Maker")
public class MakerModel {
	private int makerId;
	private int makerNO;
	private String makerName;
	private String makerPassword;
	private String address;
//	private byte[] photo;
	private String email;
	private String phoneNumber;
	
	
	public int getMakerId() {
		return makerId;
	}
	public void setMakerId(int makerId) {
		this.makerId = makerId;
	}
	public int getMakerNO() {
		return makerNO;
	}
	public void setMakerNO(int makerNO) {
		this.makerNO = makerNO;
	}
	public String getMakerName() {
		return makerName;
	}
	public void setMakerName(String makerName) {
		this.makerName = makerName;
	}
	public String getMakerPassword() {
		return makerPassword;
	}
	public void setMakerPassword(String makerPassword) {
		this.makerPassword = makerPassword;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
/*	public byte[] getPhoto() {
		return photo;
	}
	public void setPhoto(byte[] photo) {
		this.photo = photo;
	}*/
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	
}
