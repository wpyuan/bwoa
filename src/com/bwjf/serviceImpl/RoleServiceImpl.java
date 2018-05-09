package com.bwjf.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bwjf.entity.Account;
import com.bwjf.entity.AccountAreaEmployeeRoleView;
import com.bwjf.entity.Role;
import com.bwjf.mapper.AccountAreaEmployeeRoleViewMapper;
import com.bwjf.mapper.AccountMapper;
import com.bwjf.mapper.RoleMapper;
import com.bwjf.mapper.RoleMenuMapper;
import com.bwjf.service.RoleService;

/**
 * @作者 王培源
 * @创建日期 2017/10/23
 * @描述 角色逻辑业务层
 */
@Service
@Transactional
public class RoleServiceImpl implements RoleService {

	public RoleMapper roleMapper;

	private AccountMapper accountMapper;
	public RoleMenuMapper roleMenuMapper;
	private AccountAreaEmployeeRoleViewMapper accountAreaEmployeeRoleViewMapper;
	
	public AccountAreaEmployeeRoleViewMapper getAccountAreaEmployeeRoleViewMapper() {
		return accountAreaEmployeeRoleViewMapper;
	}
	@Resource
	public void setAccountAreaEmployeeRoleViewMapper(AccountAreaEmployeeRoleViewMapper accountAreaEmployeeRoleViewMapper) {
		this.accountAreaEmployeeRoleViewMapper = accountAreaEmployeeRoleViewMapper;
	}
	public RoleMenuMapper getRoleMenuMapper() {
		return roleMenuMapper;
	}
	@Resource
	public void setRoleMenuMapper(RoleMenuMapper roleMenuMapper) {
		this.roleMenuMapper = roleMenuMapper;
	}

	public AccountMapper getAccountMapper() {
		return accountMapper;
	}
	
	@Resource
	public void setAccountMapper(AccountMapper accountMapper) {
		this.accountMapper = accountMapper;
	}

	public RoleMapper getRoleMapper() {
		return roleMapper;
	}

	@Resource
	public void setRoleMapper(RoleMapper roleMapper) {
		this.roleMapper = roleMapper;
	}

	@Override
	public List<Role> getAllRole() throws Exception {
		System.out.println("---RoleServiceImpl.getAllRole()---");
		List<Role> roleList = roleMapper.getAllRole();
		return roleList;
	}

	@Override
	public List<Role> getRoleByList(List<Account> accountAllList) throws Exception {

		// 1.输出数据流向日志
		// 2.查询员工信息,插入集合roles
		List<Role> roles = new ArrayList<>();
		Role role = null;
		System.out.println("---RoleServiceImpl.getEmployeeByList(List<Account> accountAllList)---");
		System.out.println("<<---accountAllList:---");

		for (Account account : accountAllList) {
			// System.out.println(account.toString());

			role = new Role();
			role = roleMapper.getRoleById(account.getRoleId());
			roles.add(role);
		}
		System.out.println("---accountAllList:end--->>");

		return roles;
	}

	@Override
	public int add(Role role) throws Exception {
		// 1.先查询是否有该角色
		Role r = roleMapper.getRoleByName(role.getName());
		if (r == null) {// 无
			roleMapper.add(role);
			return 1;
		} else {
			// 有
			return 0;
		}
	}

	@Override
	public int update(Role role) throws Exception {
		roleMapper.update(role);
		Role r = roleMapper.getRoleByName(role.getName());//查询是否修改成功
		if(r==null) {//失败
			return 0;
		}else {//修改成功
			
			return 1;
		}
	}

	@Override
	public Role getRoleByName(String name) throws Exception {
		
		return roleMapper.getRoleByName(name);
	}

	@Override
	public int delet(int roleId) throws Exception {
		/*
		 * 1.设置此角色的账户account
		 * 2.再删除角色和角色菜单roleMenu
		 */
		//1.
		accountMapper.updateRoleId(roleId);
		//2.
		roleMapper.delet(roleId);
		roleMenuMapper.deleteByRoleId(roleId);
		
		Role role = roleMapper.getRoleById(roleId);
		if (role==null) {//删除成功
			return 1;
		}else {
			
			return 0;
		}
	}

	@Override
	public List<Role> getRoleByNameMH(String name) throws Exception {
		return roleMapper.getRoleByNameMH(name);
	}
	@Override
	public List<AccountAreaEmployeeRoleView> getAccountAreaEmployeeRoleView() throws Exception {
		System.out.println("---RoleServiceImpl.getAccountAreaEmployeeRoleView()---");
		return accountAreaEmployeeRoleViewMapper.getAccountAreaEmployeeRoleView();
	}
	@Override
	public List<AccountAreaEmployeeRoleView> getAccountAreaEmployeeRoleViewByEmployeeName(String employeeName)
			throws Exception {
		System.out.println("---RoleServiceImpl.getAccountAreaEmployeeRoleViewByEmployeeName(employeeName:"+employeeName+")---");
		
		return accountAreaEmployeeRoleViewMapper.getAccountAreaEmployeeRoleViewByEmployeeName(employeeName);
	}
	@Override
	public List<AccountAreaEmployeeRoleView> getAccountAreaEmployeeRoleViewByAreaId(int areaId) throws Exception {
		
		System.out.println("---RoleServiceImpl.getAccountAreaEmployeeRoleViewByAreaId(areaId:"+areaId+")---");
		
		return accountAreaEmployeeRoleViewMapper.getAccountAreaEmployeeRoleViewByAreaId(areaId);
	}
	@Override
	public Role getRoleById(int roleId) throws Exception {

		return roleMapper.getRoleById(roleId);
	}

}
