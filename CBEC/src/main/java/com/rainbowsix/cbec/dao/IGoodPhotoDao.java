package com.rainbowsix.cbec.dao;

import java.util.List;

import com.rainbowsix.cbec.model.GoodsModel;

public interface IGoodPhotoDao {
		//添加商品照片
		public void create(GoodsModel good) throws Exception;
		
		//修改商品照片
		public void update(int proid) throws Exception;
		
		//删除商品照片
		public void delete(int proid) throws Exception;
		
		//分页取得所有商品照片列表
		public List<GoodsModel> byAll(int rows,int page) throws Exception;
		
		//分页取得所有商品照片列表
		public List<GoodsModel> selectByGoodsId() throws Exception;
		
		//取得指定的商品照片信息
		public GoodsModel byNO(int proid) throws Exception;
		
		//取得所有商品总数
//		public int Count() throws Exception;
		
}
