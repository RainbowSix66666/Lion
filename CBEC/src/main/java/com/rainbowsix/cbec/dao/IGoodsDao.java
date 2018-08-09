package com.rainbowsix.cbec.dao;

import java.util.List;

import com.rainbowsix.cbec.model.GoodsModel;

public interface IGoodsDao {
	//添加商品
	public void create(GoodsModel good) throws Exception;
	
	//修改商品
	public void update(GoodsModel good) throws Exception;
	
	//删除商品
	public void delete(GoodsModel good) throws Exception;
	
	//分页取得所有商品列表
	public List<GoodsModel> AllByPage(int rows,int page) throws Exception;
	
	//取得指定的商品信息
	public GoodsModel byNO(int no) throws Exception;
	
	//取得所有商品总数
	public int Count() throws Exception;
	
	
}
