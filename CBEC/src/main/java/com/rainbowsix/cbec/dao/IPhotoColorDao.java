package com.rainbowsix.cbec.dao;

import java.util.List;

import com.rainbowsix.cbec.model.PhotoColorModel;

public interface IPhotoColorDao {
	//取得所有颜色列表，无关联的颜色列表 无分页
	public List<PhotoColorModel> getListWithoutPhotoByAll() throws Exception;
}
