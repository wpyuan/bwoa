package com.bwjf.service;

import java.util.List;

/**
 * @author 张恭雨
 * 创建时间：2017年10月20日 上午10:36:01
 * 类描述：	roleMenuService接口
 * 版本：v1.0 
 */
public interface RoleMenuService {
	public List<Integer> getRoleMenuByRoleId (int roleId) throws Exception;		//获取菜单ID
	public void deleteByMenuId(int menuId) throws Exception;			//删除角色权限信息
}
