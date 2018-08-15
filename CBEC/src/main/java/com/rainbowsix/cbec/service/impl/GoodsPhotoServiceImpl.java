package com.rainbowsix.cbec.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rainbowsix.cbec.dao.IGoodsPhotoDao;
import com.rainbowsix.cbec.model.GoodsPhotoModel;
import com.rainbowsix.cbec.service.IGoodsPhotoService;

@Service
@Transactional
public class GoodsPhotoServiceImpl implements IGoodsPhotoService {
	private IGoodsPhotoDao goodsPhotoDao = null;
	
	@Autowired
	public void setGoodsPhotoDao(IGoodsPhotoDao goodsPhotoDao) {
		this.goodsPhotoDao = goodsPhotoDao;
	}
	//取得所有照片列表有商品   无分页（无图片）
	public List<GoodsPhotoModel> selectListWithGoodsByAll() throws Exception {	
		return goodsPhotoDao.selectListWithGoodsByAll();
	}
	
	//取得所有照片列表无商品   无分页（无图片）
	public List<GoodsPhotoModel> selectListWithoutGoodsByAll() throws Exception {	
		return goodsPhotoDao.selectListWithoutGoodsByAll();
	}
	
	//取得单个商品照片列表 
	@Override
	public GoodsPhotoModel selectByPhotoId(int photoId) throws Exception {
		return goodsPhotoDao.selectByPhotoId(photoId);
	}
	
	//取得所有GoodsPhoto列表有商品   无分页（有图片）
	@Override
	public List<GoodsPhotoModel> selectLisAllWithGoods() throws Exception {	
		return goodsPhotoDao.selectLisAllWithGoods();
	}
	
	//取得所有GoodsPhoto列表无商品   无分页（有图片）
	@Override
	public List<GoodsPhotoModel> selectLisAllWithoutGoods() throws Exception {	
		return goodsPhotoDao.selectLisAllWithoutGoods();
	}
	
	
}
