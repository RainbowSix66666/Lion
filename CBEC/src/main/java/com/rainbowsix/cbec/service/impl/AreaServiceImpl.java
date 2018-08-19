package com.rainbowsix.cbec.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rainbowsix.cbec.dao.IAreaDao;
import com.rainbowsix.cbec.model.AreaModel;
import com.rainbowsix.cbec.service.IAreaService;

@Service
public class AreaServiceImpl implements IAreaService {

	IAreaDao areaDao = null;
	
	@Autowired	
	public void setAreaDao(IAreaDao areaDao) {
		this.areaDao = areaDao;
	}

	@Override
	public void add(AreaModel area) throws Exception {
		// TODO Auto-generated method stub
		areaDao.add(area);
	}

	@Override
	public void delete(AreaModel area) throws Exception {
		// TODO Auto-generated method stub
		areaDao.delete(area);
	}

	@Override
	public List<AreaModel> selectAll() throws Exception {
		// TODO Auto-generated method stub
		return areaDao.selectAll();
	}

	@Override
	public void modify(AreaModel area) throws Exception {
		// TODO Auto-generated method stub
		areaDao.modify(area);
	}

	@Override
	public AreaModel getById(int id) throws Exception {
		// TODO Auto-generated method stub
		return areaDao.selectById(id);
	}

}
