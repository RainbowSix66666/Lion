package com.rainbowsix.cbec.service;

import java.util.List;

import com.rainbowsix.cbec.model.AreaModel;

public interface IAreaService {
	//基本操作
	public void add(AreaModel area) throws Exception;
	public void delete(AreaModel area) throws Exception;
	public List<AreaModel> selectAll() throws Exception;
	public void modify(AreaModel area) throws Exception;
	public AreaModel getById(int id) throws Exception;
}
