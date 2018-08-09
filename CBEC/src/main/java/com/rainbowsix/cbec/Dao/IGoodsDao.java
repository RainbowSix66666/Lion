package com.rainbowsix.cbec.Dao;

import com.rainbowsix.cbec.model.GoodsModel;

public interface IGoodsDao {
	//添加商品
	public void create(GoodsModel good) throws Exception;
	
	//修改商品
	public void update(GoodsModel good) throws Exception;
	
	//删除商品
	public void delete(GoodsModel good) throws Exception;


}
