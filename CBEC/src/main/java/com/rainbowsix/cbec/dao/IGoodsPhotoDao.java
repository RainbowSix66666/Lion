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
	
		//取得所有GoodsPhoto列表有商品   无分页（无图片）
		public List<GoodsPhotoModel> selectListWithGoodsByAll() throws Exception;
		//取得所有照片列表无商品   无分页（无图片）
		public List<GoodsPhotoModel> selectListWithoutGoodsByAll() throws Exception;
		
		//取得所有GoodsPhoto列表有商品   无分页（有图片）
		public List<GoodsPhotoModel> selectLisAllWithGoods() throws Exception;
		//取得所有照片列表无商品   无分页（有图片）
		public List<GoodsPhotoModel> selectLisAllWithoutGoods() throws Exception;
	

		//取得所有GoodsPhoto列表有商品  有分页（无图片）
		public List<GoodsPhotoModel> selectListWithGoodsByAllWithPage() throws Exception;
		//取得所有照片列表无商品   有分页（无图片）
		public List<GoodsPhotoModel> selectListWithoutGoodsByAllWithPage() throws Exception;
		
		
		//取得单个商品照片列表 
		public GoodsPhotoModel selectByPhotoId(int photoId) throws Exception;	
		
		 
		//取得所有商品总数
//		public int Count() throws Exception;
		
}
