package com.rainbowsix.cbec.dao;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.rainbowsix.cbec.model.UserModel;

public interface IUserDao {
	
	public void create(UserModel userModel) throws Exception;
	public void update(UserModel userModel) throws Exception;
	public void delete(UserModel userModel) throws Exception;
	
	public List<UserModel> selectAllWithPage(int rows, int page)
		throws Exception;
	public UserModel selectById(long no) throws Exception;
	public List<UserModel> selectAll()
			throws Exception;
	public List<UserModel> selectAllWithRole()
			throws Exception;
	public List<UserModel> selectByCondiction(@Param("name")String name,@Param("before")Date before, 
			@Param("after")Date after, @Param("roles") int[] roles) throws Exception;
	public List<UserModel> selectByCondictionWithPage(@Param("name")String name, @Param("before")Date before, 
			@Param("after")Date after, @Param("roles") int[] roles, @Param("start")int start, @Param("end")int end)
			throws Exception;
}
