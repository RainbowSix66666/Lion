package com.rainbowsix.cbec.dao;

import java.util.List;

import com.rainbowsix.cbec.model.AreaModel;

public interface IAreaDao {
	//基础方法
	public void add(AreaModel area) throws Exception;
	public void delete(AreaModel area) throws Exception;
	public List<AreaModel> selectAll() throws Exception;
	public void modify(AreaModel area) throws Exception;
	public AreaModel selectById(int id) throws Exception;
}
