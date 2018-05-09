package com.bwjf.serviceImpl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bwjf.mapper.RoleMenuMapper;
import com.bwjf.service.RoleMenuService;

/**
 * @author 张恭雨
 * 创建时间：2017年10月20日 上午10:36:21
 * 类描述：	roleMenuService接口实现类
 * 版本：v1.0 
 */
@Service
@Transactional
public class RoleMenuServiceImpl implements RoleMenuService {
	private RoleMenuMapper roleMenuMapper;
	
	public RoleMenuMapper getRoleMenuMapper() {
		return roleMenuMapper;
	}
	@Resource
	public void setRoleMenuMapper(RoleMenuMapper roleMenuMapper) {
		this.roleMenuMapper = roleMenuMapper;
	}
	@Override
	public List<Integer> getRoleMenuByRoleId(int roleId) throws Exception {
		// 调用rolemenumapper
		return roleMenuMapper.getRoleMenuByRoleId(roleId);
	}
	@Override
	public void deleteByMenuId(int menuId) throws Exception {
		//删除菜单相关信息
		roleMenuMapper.deleteByMenuId(menuId);
	}

}
