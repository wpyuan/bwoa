package com.bwjf.entity;


/**
 * @author 张恭雨
 * 创建时间：2017-10-17 下午4:00:50
 * 类描述：角色信息实体类
 * 版本：v1.0 
 */
public class Role {
	private int roleId;			//角色ID
	private String name;		//角色名称
	public int getRoleId() {
		return roleId;
	}
	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "Role [roleId=" + roleId + ", name=" + name + "]";
	}
	
	
}
