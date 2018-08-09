package com.rainbowsix.cbec.service;

import java.util.List;

import com.rainbowsix.cbec.model.GoodsModel;

public interface IGoodsService {

	//增加商品
	public void add(GoodsModel good) throws Exception;
	
	//修改商品
	public void modify(int proid) throws Exception;
	
	//删除商品
	public void del(int proid) throws Exception;
	
	//显示单个商品
	public GoodsModel one(int proid) throws Exception;
	
	//显示全部商品
	public List<GoodsModel> listbypage(int rows,int page) throws Exception;
}
