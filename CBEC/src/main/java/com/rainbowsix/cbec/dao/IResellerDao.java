package com.rainbowsix.cbec.dao;

import java.util.List;

import com.rainbowsix.cbec.model.ResellerModel;

public interface IResellerDao {
	
	//通过id取得买家的信息
	public ResellerModel selectResellerById(int resellId) throws Exception;
	
	public void create(ResellerModel reseller) throws Exception;
	public void delete(ResellerModel reseller) throws Exception;
	public void modify(ResellerModel reseller) throws Exception;
	public ResellerModel selectById(int id) throws Exception;
	public List<ResellerModel> selectAll() throws Exception;
}
