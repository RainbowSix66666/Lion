package com.rainbowsix.cbec.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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
	
	//取得所有GoodsPhoto列表商品   无分页（有图片）	
		@RequestMapping(value="/list/byphotoid/all",method={RequestMethod.GET})
		@ResponseBody
	public List<GoodsPhotoModel> selectListByCondition(@RequestParam(required=false,defaultValue="0") int photoId,
			@RequestParam(required=false,defaultValue="0") int proid,  
			@RequestParam(required=false,defaultValue="") String des, 
			@RequestParam(required=false,defaultValue="0") int rank)throws Exception{
			if(des!=null&&des.trim().length()>0) {
				des="%"+des+"%";
			}
			
			return goodsPhotoService.selectListByCondition(photoId, proid, des, rank);
		}
	
		//根据条件取照片列表 分页
		@RequestMapping(value="/list/byphotoid/allwithoutgoods/page",method={RequestMethod.GET})
		@ResponseBody
		public List<GoodsPhotoModel> selectListByConditionWithPage(@RequestParam(required=false,defaultValue="0") int photoId,
				@RequestParam(required=false,defaultValue="0") int proid,  
				@RequestParam(required=false,defaultValue="") String des, 
				@RequestParam(required=false,defaultValue="0") int rank,
				@RequestParam(required=false,defaultValue="1") int rows, 
				@RequestParam(required=false,defaultValue="1") int page) throws Exception{
			
			if(des!=null&&des.trim().length()>0) {
				des="%"+des+"%";
			}
			return goodsPhotoService.selectListByConditionWithPage(photoId, proid,des, rank, rows, page);
		}
}
