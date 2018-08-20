package com.rainbowsix.cbec.dao;

import java.util.List;

import com.rainbowsix.cbec.model.GoodsModel;

public interface IGoodsDao {
	//添加商品
	public void create(GoodsModel good) throws Exception;
	
	//修改商品
	public void update(GoodsModel good) throws Exception;
	
	//删除商品
	public void delete(int proid) throws Exception;
	
	//分页取得所有商品列表
	public List<GoodsModel> byall() throws Exception;
	
	//取得所有商品的类型
	public List<GoodsModel> alltype() throws Exception;
	
	//取得类型对应的所有商品
	public List<GoodsModel> bytype(int typeno) throws Exception;
	
	//取得指定的商品信息
	public GoodsModel byone(int proid) throws Exception;
	
	//取得所有商品总数
	public int Count() throws Exception;
	
	
}
