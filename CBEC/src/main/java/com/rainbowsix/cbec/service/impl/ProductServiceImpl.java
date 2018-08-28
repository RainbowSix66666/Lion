package com.rainbowsix.cbec.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rainbowsix.cbec.dao.IProductDao;
import com.rainbowsix.cbec.model.ProductModel;
import com.rainbowsix.cbec.service.IProductService;

@Service
@Transactional
public class ProductServiceImpl implements IProductService {
	
	private IProductDao productDao = null;	
	
	@Autowired
	public void setProductDao(IProductDao productDao) {
		this.productDao = productDao;
	}

	@Override
	public void add(ProductModel product) throws Exception {
		// TODO Auto-generated method stub
		productDao.add(product);
	}

	@Override
	public List<ProductModel> getListByAll() throws Exception {
		// TODO Auto-generated method stub
		return productDao.selectListByAll();
	}

	@Override
	public ProductModel getById(int id) throws Exception {
		// TODO Auto-generated method stub
		return productDao.selectById(id);
	}

}
