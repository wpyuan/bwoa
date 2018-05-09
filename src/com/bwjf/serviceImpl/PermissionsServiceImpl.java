package com.bwjf.serviceImpl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bwjf.entity.Menu;
import com.bwjf.entity.Role;
import com.bwjf.entity.RoleMenu;
import com.bwjf.mapper.MenuMapper;
import com.bwjf.mapper.RoleMapper;
import com.bwjf.mapper.RoleMenuMapper;
import com.bwjf.service.PermissionsService;

/**
 * @author 张恭雨
 * 创建时间：2017年10月31日 下午5:00:41
 * 类描述：权限控制业务逻辑实现
 * 版本：v1.0 
 */
@Service
@Transactional
public class PermissionsServiceImpl implements PermissionsService {
	
	private MenuMapper menuMapper;
	private RoleMenuMapper roleMenuMapper;
	private RoleMapper roleMapper;
	public MenuMapper getMenuMapper() {
		return menuMapper;
	}
	@Resource
	public void setMenuMapper(MenuMapper menuMapper) {
		this.menuMapper = menuMapper;
	}
	
	public RoleMenuMapper getRoleMenuMapper() {
		return roleMenuMapper;
	}
	
	@Resource
	public void setRoleMenuMapper(RoleMenuMapper roleMenuMapper) {
		this.roleMenuMapper = roleMenuMapper;
	}
	
	public RoleMapper getRoleMapper() {
		return roleMapper;
	}
	@Resource
	public void setRoleMapper(RoleMapper roleMapper) {
		this.roleMapper = roleMapper;
	}
	@Override
	public List<Menu> getInitMenuByRoleId(int roleId) throws Exception {
		//获取所有的菜单信息
		List<Menu> menus=menuMapper.getAllMenu();
		//获取角色所拥有的菜单ID
		List<Integer> integers=roleMenuMapper.getRoleMenuByRoleId(roleId);
		//设置菜单选中状态
		for(Integer menuId:integers){
			for(Menu menu:menus){
				//判断ID是否相等，
				if(menu.getMenuId()==menuId){
					//相等，设置为选中状态
					menu.setChecked(true);
				}
			}
		}
		return menus;
	}
	@Override
	public void saveAlter(String[] s, int roleId) throws Exception {
		//先删除角色所拥有的菜单
		roleMenuMapper.deleteByRoleId(roleId);
		//创建一个roleMenu对象
		RoleMenu roleMenu=new RoleMenu();
		//设置角色ID
		roleMenu.setRoleId(roleId);
		//遍历数组
		for(int i=0;i<s.length;i++){
			//设置菜单ID
			roleMenu.setMenuId(Integer.parseInt(s[i]));
			//保存权限信息
			roleMenuMapper.saveRoleMenu(roleMenu);
		}
		
	}
	@Override
	public List<Role> searchRole(String msg) throws Exception {
		// TODO Auto-generated method stub
		return roleMapper.searchRole(msg);
	}

}
