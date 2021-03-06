package com.rainbowsix.cbec.dao;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.rainbowsix.cbec.model.UserModel;

public interface IUserDao {
	public void update(UserModel userModel) throws Exception;
	public void delete(UserModel userModel) throws Exception;
	
	/***************************添加新用户***************************************/
	public void create(UserModel userModel) throws Exception;
	//添加用户，含有头像信息
	public void createWithPhoto(UserModel userModel) throws Exception;
	
	/*********************获取单个用户*************************************/
	//根据用户id查询用户
	public UserModel selectById(long no) throws Exception;
	public UserModel selectByIdWithMaker(long id) throws Exception;
	//根据用户名查找用户
	public UserModel selectByName(String name) throws Exception;
	/*******************获取所有用户的不同信息**************************/
	//查询所有用户，
	public List<UserModel> selectAll()
			throws Exception;
	//查询所有用户，带有角色
	public List<UserModel> selectAllWithRole()
			throws Exception;
	public List<UserModel> selectAllWithArea() throws Exception;
	
	/*************************查询用户列表***********************************/
	//查询所有用户，分页，未实现
	public List<UserModel> selectAllWithPage(int rows, int page)
		throws Exception;
	//根据条件查询
	public List<UserModel> selectByCondiction(@Param("name")String name,@Param("before")Date before, 
			@Param("after")Date after, @Param("roles") int[] roles, @Param("area") int area) throws Exception;
	//根据条件查询，分页
	public List<UserModel> selectByCondictionWithPage(@Param("name")String name, @Param("before")Date before, 
			@Param("after")Date after, @Param("roles") int[] roles, @Param("area") int area, 
			@Param("start")int start, @Param("end")int end)
			throws Exception;
	//根据条件查询得到查询结果的个数
	public int selectCountByCondiction(@Param("name")String name, @Param("before")Date before, 
			@Param("after")Date after, @Param("roles") int[] roles, @Param("area") int area) throws Exception;
	//根据条件查询，分页，不带角色差别
	public List<UserModel> selectByCondictionWithPageWithoutRole(@Param("name")String name, @Param("before")Date before, 
			@Param("after")Date after, @Param("area") int area, 
			@Param("start")int start, @Param("end")int end) throws Exception;
	//根据条件查询不带角色的用户个数
	public int selectCountByCondictionWithoutRole(@Param("name")String name, @Param("before")Date before, 
			@Param("after")Date after, @Param("area") int area) throws Exception;
	/***************************角色管理相关********************************/
	//清除授权
	public void cleanRole(int id) throws Exception;
	//授予一个角色
	public void grantRole(@Param("id")int id, @Param("role")int role) 
			throws Exception;
	/***********************地区相关***********************************/
	public void updateArea(@Param("id") int id, @Param("areaid") int areaid) 
			throws Exception;
	
	/******************************验证相关**************************/
	public int selectCountByNameAndPassword(@Param("name") String name,  @Param("password") String password) 
			throws Exception;
}
