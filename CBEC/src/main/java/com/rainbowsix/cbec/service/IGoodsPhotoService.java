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
			String des, int rank, int rows, int page, Date startDate, Date endDate, int[] colors) throws Exception;


	//根据检索条件取得照片的个数
	 public int getCountWithPhoto(int photoId,int proid,  
				String des, int rank, int[] colors) throws Exception;
	 
	 //根据检索条件取得照片的页数
	 public int getPageWithPhoto(int photoId,int proid,  
				String des, int rank, int rows, int[] colors) throws Exception;
	 
	 //取得照片等级
	 public List<GoodsPhotoModel> selectRankCondition() throws Exception;
	 
	 //取得商品id
	 public List<GoodsPhotoModel> selectProidCondition() throws Exception;
	 
	 //添加有照片的goodsphoto
	 public int addWithPhoto(GoodsPhotoModel goodsPhoto) throws Exception;
	 
	 //添加无照片的goodsphoto	 
	 public int addWithoutPhoto(GoodsPhotoModel goodsPhoto) throws Exception;
	 
	 //为选中的照片添加授权照片颜色的方法
	 public void grantColor(int id, int[] colors) throws Exception;
	 
	//为指定照片添加颜色
	public void grantColorById(int id,int colorId) throws Exception;
	 
	 //修改照片信息(无图片)
	public void modifyWithoutPhoto(GoodsPhotoModel goodsPhoto) throws Exception; 

	//修改照片信息(无图片)
	public void modifyWithPhoto(GoodsPhotoModel goodsPhoto) throws Exception; 
	
}
