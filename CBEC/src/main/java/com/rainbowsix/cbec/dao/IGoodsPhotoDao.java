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
		
		//取得所有照片、照片信息列表无商品   无分页
		public List<GoodsPhotoModel> selectListWithPhotoByAll() throws Exception;
		//取得所有照片信息列表 无图片  无商品   无分页
		public List<GoodsPhotoModel> selectListWithPhotoInfoByAll() throws Exception;
		
		
		
		
		
		
		//取得所有GoodsPhoto列表有商品   无分页
		public List<GoodsPhotoModel> selectListWithGoodsByAll() throws Exception;
		//取得所有照片列表无商品   无分页
		public List<GoodsPhotoModel> selectListWithoutGoodsByAll() throws Exception;
	

		//取得商品的所有照片列表   有分页
		public List<GoodsPhotoModel> selectListWithoutGoodsByAllWithPage() throws Exception;
		//取得商品的所有照片列表   有分页
		public List<GoodsPhotoModel> selectListWithGoodsByAllWithPage() throws Exception;
		
		
		//取得单个商品照片列表
		public List<GoodsPhotoModel> selectByGoodsId() throws Exception;
		
		
		
		
		
		
		
		//取得照片列表无商品信息
		public List<GoodsModel> selectListWithoutGoods() throws Exception;
		
		//取得照片列表商品信息
		public List<GoodsModel> selectListWithGoods() throws Exception;
		
		//取得指定的商品照片信息
		//public GoodsModel byNO(int proid) throws Exception;
		 
		//取得所有商品总数
//		public int Count() throws Exception;
		
}
