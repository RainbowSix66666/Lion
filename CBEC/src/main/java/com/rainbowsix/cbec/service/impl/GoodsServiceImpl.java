package com.rainbowsix.cbec.service.impl;

import java.io.InputStream;
import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.stereotype.Service;

import com.rainbowsix.cbec.dao.IGoodsDao;
import com.rainbowsix.cbec.model.GoodsModel;
import com.rainbowsix.cbec.service.IGoodsService;
@Service
public class GoodsServiceImpl implements IGoodsService {
	private IGoodsDao goodsdao=null;
	
	public void add(GoodsModel good) throws Exception {
		String resource = "wv_config.xml";
		Reader reader = Resources.getResourceAsReader(resource);
		SqlSessionFactory sqlSessionFactory= new SqlSessionFactoryBuilder().build(reader);
		SqlSession session = sqlSessionFactory.openSession();
		IGoodsDao departmentDao = session.getMapper(IGoodsDao.class);
		goodsdao.create(good);
		session.commit();
		session.close();
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