package com.rainbowsix.cbec.service;

import java.util.List;

import com.rainbowsix.cbec.model.GoodsModel;

public interface GoodsService {

	//增加商品
	public void add(GoodsModel good) throws Exception;
	
	//修改商品
	public void modify(GoodsModel good) throws Exception;
	
	//删除商品
	public void del(GoodsModel good) throws Exception;
	
	//显示商品
	public List<GoodsModel> listbypage(int rows,int page) throws Exception;
}
