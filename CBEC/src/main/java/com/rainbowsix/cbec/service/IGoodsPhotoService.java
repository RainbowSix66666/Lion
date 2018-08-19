package com.rainbowsix.cbec.service;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

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
	
	//根据条件取照片列表 无分页
	public List<GoodsPhotoModel> selectListByCondition(int photoId,int proid,  
			String des, int rank) throws Exception;
	
	//根据条件取照片列表 分页
	public List<GoodsPhotoModel> selectListByConditionWithPage(int photoId,int proid,  
			String des, int rank, int rows, int page, Date startDate, Date endDate) throws Exception;


	//根据检索条件取得照片的个数
	 public int getCountWithPhoto(int photoId,int proid,  
				String des, int rank) throws Exception;
	 
	 //根据检索条件取得照片的页数
	 public int getPageWithPhoto(int photoId,int proid,  
				String des, int rank, int rows) throws Exception;
	 
	 //取得照片等级
	 public List<GoodsPhotoModel> selectRankCondition() throws Exception;
	 
	 //添加有照片的goodsphoto
	 public void addWithPhoto(GoodsPhotoModel goodsPhoto) throws Exception;
	 
	 //添加无照片的goodsphoto	 
	 public void addWithoutPhoto(GoodsPhotoModel goodsPhoto) throws Exception;
	 
	
}
