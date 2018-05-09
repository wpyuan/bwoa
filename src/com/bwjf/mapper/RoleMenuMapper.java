package com.bwjf.mapper;

import java.util.List;

import com.bwjf.entity.RoleMenu;

/**
 * @author 张恭雨
 * 创建时间：2017年10月20日 上午10:20:14
 * 类描述：角色菜单接口mapper
 * 版本：v1.0 
 */
public interface RoleMenuMapper {
	public List<Integer> getRoleMenuByRoleId (int roleId) throws Exception;		//获取菜单ID
	public void deleteByMenuId(int menuId) throws Exception;			//删除角色权限信息
	public void deleteByRoleId(int roleId) throws Exception;			//删除关于角色的所有菜单信息
	public void saveRoleMenu(RoleMenu roleMenu) throws Exception;		//保存权限信息
}
