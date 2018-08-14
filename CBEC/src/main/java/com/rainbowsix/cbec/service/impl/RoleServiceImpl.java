package com.rainbowsix.cbec.service.impl;

import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rainbowsix.cbec.dao.IRoleDao;
import com.rainbowsix.cbec.model.RoleModel;
import com.rainbowsix.cbec.service.IRoleService;

@Service
@Transactional
public class RoleServiceImpl implements IRoleService {
	
	private IRoleDao roledao = null;
	
	@Autowired
	public void setRoledao(IRoleDao roledao) {
		this.roledao = roledao;
	}

	public void add(RoleModel role) throws Exception {
		// TODO Auto-generated method stub
		
		roledao.create(role);
		System.out.println(role.getId());
	}

	public void delete(RoleModel role) throws Exception {
		// TODO Auto-generated method stub

	}

	public void update(RoleModel role) throws Exception {
		// TODO Auto-generated method stub

	}

	public List<RoleModel> getAll() throws Exception {
		// TODO Auto-generated method stub
//		return roledao.selectAll();
		return roledao.selectAllWithUsers();
	}

	public RoleModel getById(int id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
