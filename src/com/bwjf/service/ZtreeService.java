package com.bwjf.service;

import java.util.List;

import com.bwjf.entity.Menu;

/**
 * @author 张恭雨
 * 创建时间：2017年10月20日 上午10:53:14
 * 类描述：ztree菜单service层
 * 版本：v1.0 
 */
public interface ZtreeService {
	public List<Menu> getMenuByRoleId(int roleId) throws Exception;	//通过角色id获取ztree菜单信息
}
