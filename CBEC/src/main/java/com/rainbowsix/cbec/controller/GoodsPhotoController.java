package com.rainbowsix.cbec.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.rainbowsix.cbec.model.GoodsPhotoModel;
import com.rainbowsix.cbec.service.IGoodsPhotoService;

@RestController
@RequestMapping("/goodsphoto")
public class GoodsPhotoController {
	private IGoodsPhotoService  goodsPhotoService = null;

	@Autowired
	public void setGoodsPhotoService(IGoodsPhotoService goodsPhotoService) {
		this.goodsPhotoService = goodsPhotoService;
	}
	
	//取得所有照片列表有商品   无分页（无图片）
	@RequestMapping(value="/list/all/withgoods",method={RequestMethod.GET})
	@ResponseBody
	public List<GoodsPhotoModel> selectListWithGoodsByAll() throws Exception{
		return goodsPhotoService.selectListWithGoodsByAll();
	}
	
	//取得所有照片列表无商品   无分页（无图片）
	@RequestMapping(value="/list/all/withoutgoods",method={RequestMethod.GET})
	@ResponseBody
	public List<GoodsPhotoModel> selectListWithoutGoodsByAll() throws Exception{
		return goodsPhotoService.selectListWithoutGoodsByAll();
	}

	//取得单个商品照片列表 
	@RequestMapping(value="/list/byphotoid/withgoods",method={RequestMethod.POST})
	@ResponseBody
	public GoodsPhotoModel selectByPhotoId(int photoId) throws Exception{
		return goodsPhotoService.selectByPhotoId(photoId);
	}
	
	//取得所有GoodsPhoto列表有商品   无分页（有图片）	
	@RequestMapping(value="/list/byphotoid/allwithgoods",method={RequestMethod.GET})
	@ResponseBody
	public List<GoodsPhotoModel> selectLisAllWithGoods() throws Exception{
		return goodsPhotoService.selectLisAllWithGoods();
	}
	
	//取得所有GoodsPhoto列表无商品   无分页（有图片）	
	@RequestMapping(value="/list/byphotoid/allwithoutgoods",method={RequestMethod.GET})
	@ResponseBody
	public List<GoodsPhotoModel> selectLisAllWithoutGoods() throws Exception{
		return goodsPhotoService.selectLisAllWithoutGoods();
	}
	

	
}
