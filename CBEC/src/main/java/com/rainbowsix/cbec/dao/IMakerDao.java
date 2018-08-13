package com.rainbowsix.cbec.dao;

import java.util.List;

import com.rainbowsix.cbec.model.MakerModel;



public interface IMakerDao {
		//新增品牌制造商
		public void create(MakerModel maker) throws Exception;
		//修改品牌商信息
		public void update(MakerModel maker) throws Exception;
		//删除品牌商信息
		public void delete(int  makerId) throws Exception;
		//获取品牌商的所有商品
		public List<MakerModel> selectListByAll() throws Exception;
		//获取品牌商的所有商品
		public List<MakerModel> selectListByAllWithPage(int rows, int page) throws Exception;
		//通过品牌商id取得品牌商的商品
		public MakerModel selectByMakerId(int makerId) throws Exception;
		//取得所有品牌商的个数
		public int selectCoutByAll() throws Exception;
		
}
