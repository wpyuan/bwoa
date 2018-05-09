package com.bwjf.service;

import java.util.List;

import com.bwjf.entity.Menu;
import com.bwjf.entity.Role;

/**
 * @author 张恭雨
 * 创建时间：2017年10月31日 下午4:57:48
 * 类描述:权限管理业务逻辑层
 * 版本：v1.0 
 */
public interface PermissionsService {
	public List<Menu> getInitMenuByRoleId(int roleId) throws Exception;		//通过角色id获取初始化菜单信息
	public void saveAlter(String s[],int roleId) throws Exception;						//保存权限树的更改信息
	public List<Role> searchRole(String msg) throws Exception;		//模糊搜索实现
}
