package com.rainbowsix.cbec.service;

import java.util.List;

import com.rainbowsix.cbec.model.GoodsModel;

public interface IGoodsService {

	//增加商品
	public void add(GoodsModel good) throws Exception;
	
	//修改商品
	public void modify(GoodsModel good) throws Exception;
	
	//删除商品
	public void del(int proid) throws Exception;
	
	//购买商品
	public void buygood(int proid,int count) throws Exception;
	
	//显示单个商品
	public GoodsModel one(int proid) throws Exception;
	
	//显示全部商品
	public List<GoodsModel> all() throws Exception;
	
	//显示所有商品类型
	public List<GoodsModel> alltype() throws Exception;
	
	//显示类型所有的商品
	public List<GoodsModel> bytype(int typeno) throws Exception;
	
	//显示某品牌商的商品
	public List<GoodsModel> bycomid(String comid) throws Exception;
}
