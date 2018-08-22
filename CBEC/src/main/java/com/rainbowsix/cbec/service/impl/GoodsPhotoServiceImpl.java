package com.rainbowsix.cbec.service.impl;

import java.util.Date;
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
	
	//	<!-- 根据条件取照片列表 无分页 -->
	@Override
	public List<GoodsPhotoModel> selectListByCondition(int photoId, int proid, String des, int rank) throws Exception {
		return goodsPhotoDao.selectListByCondition(photoId, proid, des, rank);
	}
	
//	<!-- 根据条件取照片列表 有分页 -->
	@Override
	public List<GoodsPhotoModel> selectListByConditionWithPage(int photoId, int proid, String des, int rank, int rows,
			int page, Date startDate, Date endDate,int[] colors) throws Exception {
		return goodsPhotoDao.selectListByConditionWithPage(photoId, proid, des, rank, rows*(page-1)+1, rows*page , startDate, endDate, colors);
	}
	
	//根据检索条件取得照片的个数
	@Override
	public int getCountWithPhoto(int photoId, int proid, String des, int rank, int[] colors) throws Exception {
		return goodsPhotoDao.getCountWithPhoto(photoId, proid, des, rank, colors);
	}
	
	//根据检索条件取得照片的页数
	@Override
	public int getPageWithPhoto(int photoId, int proid, String des, int rank, int rows, int[] colors) throws Exception {
		int pageCount = 0;
		int count = this.getCountWithPhoto(photoId, proid, des, rank, colors);
		if(count%rows ==0) {
			pageCount = count/rows;
		}else {
			pageCount = count/rows + 1;
		}
		
		return pageCount;
	}
	
	//取得照片等级
	@Override
	public List<GoodsPhotoModel> selectRankCondition() throws Exception {
		return goodsPhotoDao.selectRankCondition();
	}
	
	//取得商品id
	@Override
	public List<GoodsPhotoModel> selectProidCondition() throws Exception {
		return goodsPhotoDao.selectProidCondition();
	}
	
	//添加有照片的goodsphoto
	@Override
	public int addWithPhoto(GoodsPhotoModel goodsPhoto) throws Exception {
		goodsPhotoDao.createWithPhoto(goodsPhoto);
		return goodsPhoto.getPhotoId();
	}
	
	//添加无照片的goodsphoto
	@Override
	public int addWithoutPhoto(GoodsPhotoModel goodsPhoto) throws Exception {
		goodsPhotoDao.createWithoutPhoto(goodsPhoto);
		return goodsPhoto.getPhotoId();
	}
	
	//为选中的照片添加授权照片颜色的方法
	@Override
	public void grantColor(int id, int[] colors) throws Exception {
		/*//清除原有的照片颜色
		goodsPhotoDao.revokeAllColors(id);*/
		//授予新的颜色
		for(int colorId:colors) {
			goodsPhotoDao.grantColorById(id, colorId);
		}
	}
	
	//为指定照片添加颜色
	@Override
	public void grantColorById(int id, int colorId) throws Exception {
		goodsPhotoDao.grantColorById(id, colorId);
	}
	
	
}
