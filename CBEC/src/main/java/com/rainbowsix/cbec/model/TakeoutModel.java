package com.rainbowsix.cbec.model;

import java.util.Date;

import org.apache.ibatis.type.Alias;

@Alias("Takeout")
public class TakeoutModel {
	private int id;
	private int quantity;
	private Date outdate;
	private String Handler;
	
	private ProductModel product;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Date getOutdate() {
		return outdate;
	}

	public void setOutdate(Date outdate) {
		this.outdate = outdate;
	}

	public String getHandler() {
		return Handler;
	}

	public void setHandler(String handler) {
		Handler = handler;
	}

	public ProductModel getProduct() {
		return product;
	}

	public void setProduct(ProductModel product) {
		this.product = product;
	}
	
	
}
