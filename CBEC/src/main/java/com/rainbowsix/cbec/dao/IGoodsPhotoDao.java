package com.rainbowsix.cbec.dao;

import java.util.List;

import com.rainbowsix.cbec.model.GoodsModel;
import com.rainbowsix.cbec.model.GoodsPhotoModel;

public interface IGoodsPhotoDao {
		//添加商品照片
		public void create(GoodsModel good) throws Exception;
		
		//修改商品照片
		public void update(int proid) throws Exception;
		
		//删除商品照片
		public void delete(int proid) throws Exception;
		
		//取得商品的所有照片列表
		public List<GoodsPhotoModel> selectListByAll() throws Exception;
		
		//取得单个商品照片列表
		public List<GoodsModel> selectByGoodsId() throws Exception;
		
		//取得指定的商品照片信息
		public GoodsModel byNO(int proid) throws Exception;
		
		//取得所有商品总数
//		public int Count() throws Exception;
		
}
