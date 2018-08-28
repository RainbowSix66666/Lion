package com.rainbowsix.cbec.dao;

import java.util.List;

import com.rainbowsix.cbec.model.ProductModel;

public interface IProductDao {
	public void add(com.rainbowsix.cbec.model.ProductModel product) throws Exception;
	public void update(ProductModel product) throws Exception;
	
	public List<ProductModel> selectListByAll() throws Exception;
	public ProductModel selectById(int id) throws Exception; 
}	
