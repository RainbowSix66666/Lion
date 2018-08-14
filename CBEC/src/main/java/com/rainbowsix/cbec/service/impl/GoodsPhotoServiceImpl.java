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

	public List<GoodsPhotoModel> selectListByAll() throws Exception {
		
		return goodsPhotoDao.selectListByAll();
	}

}
