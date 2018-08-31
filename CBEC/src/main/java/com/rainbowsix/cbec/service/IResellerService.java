package com.rainbowsix.cbec.service;

import com.rainbowsix.cbec.model.ResellerModel;

public interface IResellerService {
	//通过id取得买家的信息
	public ResellerModel selectResellerById(int resellId) throws Exception;
}
