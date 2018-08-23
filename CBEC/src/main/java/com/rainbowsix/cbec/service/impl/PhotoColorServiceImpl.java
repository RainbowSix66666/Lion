package com.rainbowsix.cbec.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rainbowsix.cbec.dao.IPhotoColorDao;
import com.rainbowsix.cbec.model.PhotoColorModel;
import com.rainbowsix.cbec.service.IPhotoColorService;

@Service
@Transactional
public class PhotoColorServiceImpl implements IPhotoColorService {
	private IPhotoColorDao photoColorDao = null;

	@Autowired
	public void setPhotoColorDao(IPhotoColorDao photoColorDao) {
		this.photoColorDao = photoColorDao;
	}
	
	//取得所有颜色列表，无关联的颜色列表 无分页
	@Override
	public List<PhotoColorModel> getListWithoutPhotoByAll() throws Exception {
		return photoColorDao.getListWithoutPhotoByAll();
	}
	
	
}
