package com.bwjf.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;



import com.bwjf.entity.Menu;
import com.bwjf.mapper.MenuMapper;
import com.bwjf.mapper.RoleMenuMapper;
import com.bwjf.service.ZtreeService;

/**
 * @author 张恭雨
 * 创建时间：2017年10月20日 上午11:01:36
 * 类描述：ztree菜单业务实现层
 * 版本：v1.0 
 */
@Service
@Transactional
public class ZtreeServiceImpl implements ZtreeService{
	private RoleMenuMapper roleMenuMapper;
	private MenuMapper menuMapper;
	public RoleMenuMapper getRoleMenuMapper() {
		return roleMenuMapper;
	}
	@Resource
	public void setRoleMenuMapper(RoleMenuMapper roleMenuMapper) {
		this.roleMenuMapper = roleMenuMapper;
	}

	public MenuMapper getMenuMapper() {
		return menuMapper;
	}
	
	@Resource
	public void setMenuMapper(MenuMapper menuMapper) {
		this.menuMapper = menuMapper;
	}
	@Override
	public List<Menu> getMenuByRoleId(int roleId) throws Exception {
		//创建一个菜单集合
		List<Menu> menus=new ArrayList<Menu>();
		//获取角色所拥有的菜单id
		List<Integer> roleMenus=roleMenuMapper.getRoleMenuByRoleId(roleId);
		//根据菜单的Id查询菜单的基本信息
		for(Integer menuId:roleMenus){
			//查询菜单信息
			Menu menu=menuMapper.getMenuById(menuId);			
			//将菜单信息添加到menus中,	
			menus.add(menu);
		}				
		return menus;
	}
	
}
