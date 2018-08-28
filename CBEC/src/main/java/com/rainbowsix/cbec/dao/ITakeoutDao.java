package com.rainbowsix.cbec.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface ITakeoutDao {
	public void add(com.rainbowsix.cbec.model.TakeoutModel takeout) throws Exception;
	public List<com.rainbowsix.cbec.model.TakeoutModel> selectListByAll() throws Exception;
	
	public void setProduct(@Param("id")int id, @Param("productId") int productId) 
			throws Exception;
}
