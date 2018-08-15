package com.rainbowsix.cbec.service;

import java.util.List;

import com.rainbowsix.cbec.model.GoodsPhotoModel;

public interface IGoodsPhotoService {
	//取得所有照片列表有商品   无分页（无图片）
	public List<GoodsPhotoModel> selectListWithGoodsByAll() throws Exception;
	//取得所有照片列表无商品   无分页（无图片）
	public List<GoodsPhotoModel> selectListWithoutGoodsByAll() throws Exception;
	//取得单个商品照片列表 
	public GoodsPhotoModel selectByPhotoId(int photoId) throws Exception;
	//取得所有GoodsPhoto列表有商品   无分页（有图片）
	public List<GoodsPhotoModel> selectLisAllWithGoods() throws Exception;
	//取得所有GoodsPhoto列表无商品   无分页（有图片）
	public List<GoodsPhotoModel> selectLisAllWithoutGoods() throws Exception;
}
