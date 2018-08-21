package com.rainbowsix.cbec.dao;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;

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
		
		//根据条件取照片列表 无分页
		 public List<GoodsPhotoModel> selectListByCondition(@Param("photoId") int photoId,
				 @Param("proid") int proid, @Param("des")  String des,
				 @Param("rank")  int rank) throws Exception;
		 
		 //根据条件取照片列表 分页
		 public List<GoodsPhotoModel> selectListByConditionWithPage(@Param("photoId") int photoId,
				 @Param("proid") int proid, @Param("des")  String des,
				 @Param("rank")  int rank, @Param("start") int start, @Param("end") int end, 
				 @Param("startDate")  Date startDate, 
				 @Param("endDate") Date endDate,
				 @Param("colors") int[] colors) throws Exception;
		
		 //根据检索条件取得照片的个数
		 public int getCountWithPhoto(@Param("photoId") int photoId,
				 @Param("proid") int proid, @Param("des")  String des,
				 @Param("rank")  int rank,@Param("colors") int[] colors) throws Exception;
		 
		 //根据检索条件取得照片的页数
		 public int getPageWithPhoto(@Param("photoId") int photoId,
				 @Param("proid") int proid, @Param("des")  String des,
				 @Param("rank")  int rank, @Param("rows")  int rows,
				 @Param("colors") int[] colors) throws Exception;
		 
		 //取得照片等级
		 public List<GoodsPhotoModel> selectRankCondition() throws Exception;
		 
		 //取得商品id
		 public List<GoodsPhotoModel> selectProidCondition() throws Exception;
		 
		 //添加有照片的goodsphoto
		 public void createWithPhoto(GoodsPhotoModel goodsPhoto) throws Exception;
		 
		 //添加无照片的goodsphoto	 
		 public void createWithoutPhoto(GoodsPhotoModel goodsPhoto) throws Exception;
		 
		 //取得所有商品总数
		 //public int Count() throws Exception;
		
}




















