package com.rainbowsix.cbec.service;

import java.util.List;

import com.rainbowsix.cbec.model.ProductModel;


public interface IProductService {
	public void add(ProductModel product) throws Exception;
	public List<ProductModel> getListByAll() throws Exception;
	public ProductModel getById(int id) throws Exception;
}	
