package com.rainbowsix.cbec.service.impl;

import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.stereotype.Service;

import com.rainbowsix.cbec.dao.IRoleDao;
import com.rainbowsix.cbec.model.RoleModel;
import com.rainbowsix.cbec.service.IRoleService;

@Service
public class RoleServiceImpl implements IRoleService {

	public void add(RoleModel role) throws Exception {
		// TODO Auto-generated method stub
		
		String resource = "mzy_mybaits.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		SqlSession session = sqlSessionFactory.openSession();
		IRoleDao roledao = session.getMapper(IRoleDao.class);
		roledao.create(role);
		
		session.commit();
		session.close();
		
	}

	public void delete(RoleModel role) throws Exception {
		// TODO Auto-generated method stub

	}

	public void update(RoleModel role) throws Exception {
		// TODO Auto-generated method stub

	}

	public void getAll() throws Exception {
		// TODO Auto-generated method stub

	}

	public RoleModel getById(int id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
