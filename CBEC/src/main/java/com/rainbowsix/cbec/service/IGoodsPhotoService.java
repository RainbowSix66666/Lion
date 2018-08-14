package com.rainbowsix.cbec.service;

import java.util.List;

import com.rainbowsix.cbec.model.GoodsPhotoModel;

public interface IGoodsPhotoService {
	public List<GoodsPhotoModel> selectListByAll() throws Exception;
	
}
