package com.rainbowsix.cbec.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rainbowsix.cbec.dao.IMakerDao;
import com.rainbowsix.cbec.model.MakerModel;
import com.rainbowsix.cbec.service.IMakerService;

//@Service
public class MakerServiceImplWithSpring implements IMakerService {
	private IMakerDao makerDao = null;
	
	@Autowired
	public void setMakerDao(IMakerDao makerDao) {
		this.makerDao = makerDao;
	}

	public void add(MakerModel maker) throws Exception {
		// TODO Auto-generated method stub
		makerDao.create(maker);
	}

	public void modify(MakerModel maker) throws Exception {
		// TODO Auto-generated method stub
		makerDao.update(maker);
	}

	public void delete(int makerId) throws Exception {
		// TODO Auto-generated method stub
		makerDao.delete(makerId);
	}

	public List<MakerModel> selectListByAll() throws Exception {
		// TODO Auto-generated method stub
		
		return makerDao.selectListByAll();
	}

	public MakerModel selectByMakerNO(int makerNO) throws Exception {
		// TODO Auto-generated method stub
		return makerDao.selectByMakerNO(makerNO);
	}

}
