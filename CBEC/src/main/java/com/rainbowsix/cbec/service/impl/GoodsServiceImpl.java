package com.rainbowsix.cbec.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.rainbowsix.cbec.dao.IGoodsDao;
import com.rainbowsix.cbec.model.GoodsModel;
import com.rainbowsix.cbec.service.GoodsService;
@Service
public class GoodsServiceImpl implements GoodsService {
	private IGoodsDao goodsdao=null;
	
	public void add(GoodsModel good) throws Exception {
		goodsdao.create(good);
	}

	public void modify(int proid) throws Exception {
		goodsdao.update(proid);

	}

	public void del(int proid) throws Exception {
		goodsdao.delete(proid);

	}
	
	public GoodsModel one(int proid) throws Exception {
		return goodsdao.byone(proid);
	}
	
	public List<GoodsModel> listbypage(int rows, int page) throws Exception {

		return goodsdao.allbypage(rows, page);
	}

	

}
