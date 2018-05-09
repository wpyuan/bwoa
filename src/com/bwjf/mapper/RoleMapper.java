package com.bwjf.mapper;

import java.util.List;

import com.bwjf.entity.Role;

/**
 * @author 张恭雨
 * 创建时间：2017年10月20日 下午3:56:33
 * 类描述：
 * 版本：v1.0 
 */
public interface RoleMapper {
	public int getIdByName(String name) throws Exception;		//获取角色ID通过名字
	public List<Role> searchRole(String msg) throws Exception;	//搜索角色信息
	
	/*
	 * 王培源
	 */
	public List<Role> getAllRole() throws Exception;
	public Role getRoleById(int roleId) throws Exception;
	public int add(Role role) throws Exception;
	public Role getRoleByName(String name) throws Exception;
	public int update(Role role) throws Exception;
	public int delet(int roleId) throws Exception;
	public List<Role> getRoleByNameMH(String name) throws Exception;
}
