package com.rainbowsix.cbec.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rainbowsix.cbec.dao.IResellerDao;
import com.rainbowsix.cbec.model.ResellerModel;
import com.rainbowsix.cbec.service.IResellerService;

@Service
@Transactional
public class ResellerServiceImpl implements IResellerService {
	private IResellerDao resellerDao = null;
	
	@Autowired
	public void setResellerDao(IResellerDao resellerDao) {
		this.resellerDao = resellerDao;
	}

	@Override
	public ResellerModel selectResellerById(int resellId) throws Exception {
		return resellerDao.selectResellerById(resellId);
	}

}
