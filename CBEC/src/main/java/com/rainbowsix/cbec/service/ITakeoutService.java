package com.rainbowsix.cbec.service;

import com.rainbowsix.cbec.model.ProductModel;
import com.rainbowsix.cbec.model.TakeoutModel;

public interface ITakeoutService {
	public void add(TakeoutModel takeout) throws Exception;
	public void setProdyctId(int id, int productId) throws Exception;
}
