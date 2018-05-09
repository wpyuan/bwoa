package com.bwjf.entity;

/**
 * @author 张恭雨
 * 创建时间：2017-10-17 下午5:15:03
 * 类描述：角色菜单信息实体类
 * 版本：v1.0 
 */
public class RoleMenu {
	private int roleMenuId;		//角色菜单ID
	private int menuId;			//菜单ID
	private int roleId;			//角色ID
	public int getRoleMenuId() {
		return roleMenuId;
	}
	public void setRoleMenuId(int roleMenuId) {
		this.roleMenuId = roleMenuId;
	}
	public int getMenuId() {
		return menuId;
	}
	public void setMenuId(int menuId) {
		this.menuId = menuId;
	}
	public int getRoleId() {
		return roleId;
	}
	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}
	
	
}
