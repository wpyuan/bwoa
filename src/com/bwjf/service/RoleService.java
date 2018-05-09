package com.bwjf.service;

import java.util.List;

import com.bwjf.entity.Account;
import com.bwjf.entity.AccountAreaEmployeeRoleView;
import com.bwjf.entity.Role;

/**
 * @作者 王培源
 * @创建日期 2017/10/23
 * @描述 角色逻辑业务层接口
 */
public interface RoleService {
	public List<Role> getAllRole() throws Exception;			//获得所有角色名
	public List<Role> getRoleByList(List<Account> accountAllList) throws Exception;		//根据accountAllList查询对应的角色信息集合	
	public int add(Role role) throws Exception;				//添加角色 
	public int update(Role role) throws Exception;   		//修改角色名
	public Role getRoleByName(String name) throws Exception;//根据角色名精确查询角色
	public int delet(int roleId) throws Exception;   		//删除角色
	public List<Role> getRoleByNameMH(String name) throws Exception;//根据角色名模糊查询角色
	public List<AccountAreaEmployeeRoleView> getAccountAreaEmployeeRoleView() throws Exception; // 获取角色分配所有字段
	public List<AccountAreaEmployeeRoleView> getAccountAreaEmployeeRoleViewByEmployeeName(String employeeName) throws Exception; // 获取角色分配包含employeeName所有字段
	public List<AccountAreaEmployeeRoleView> getAccountAreaEmployeeRoleViewByAreaId(int areaId) throws Exception; // 获取角色分配包含areId地区所有字段
	public Role getRoleById(int roleId)throws Exception;//根据角色id精确查询角色
}
