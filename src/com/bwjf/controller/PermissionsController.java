package com.bwjf.controller;


import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bwjf.entity.Menu;
import com.bwjf.entity.Role;
import com.bwjf.service.PermissionsService;
import com.bwjf.service.RoleService;

/**
 * @author 张恭雨
 * 创建时间：2017年10月31日 上午11:49:24
 * 类描述：权限管理控制层
 * 版本：v1.0 
 */
@Controller
@RequestMapping("/permissions")
public class PermissionsController {
	
	private RoleService roleService;
	private PermissionsService permissionsService;
	private int roleId;					//全局变量roleId定义
	public RoleService getRoleService() {
		return roleService;
	}
	@Resource
	public void setRoleService(RoleService roleService) {
		this.roleService = roleService;
	}
	
	public PermissionsService getPermissionsService() {
		return permissionsService;
	}
	@Resource
	public void setPermissionsService(PermissionsService permissionsService) {
		this.permissionsService = permissionsService;
	}
	
	/*
	 * 查看所有角色列表
	 */
	@RequestMapping("/see.do")
	public String see(Model model){
		//获取所有角色信息
		try {
			List<Role> roles=roleService.getAllRole();
			model.addAttribute("roles",roles);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "error/500";
		}
		//跳转显示页面
		return "rolePermissions/roleList";
	}
	
	/*
	 * ztree生成角色权限树
	 */
	@RequestMapping("/permissionsTree.do")
	@ResponseBody
	public List<Menu> permissionsTree(){
		//判断roleId是否为零
		if(roleId==0)
			return null;
		
		try {			
			return permissionsService.getInitMenuByRoleId(roleId);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
	/*
	 *跳转权限树
	 */
	@RequestMapping("/toTree.do")
	public String toTree(int roleId){
		this.roleId=roleId;
		return	"rolePermissions/toAllocate";
	}
	/*
	 * 保存权限树的改变情况
	 */
	@RequestMapping("/saveAlter.do")
	public String saveAlter(String menuIds){
		//判断menuIds是否为空
		if("".equals(menuIds))
			return "error/500";		
		//分割字符串
		String s[]=menuIds.split("\\,");
		//更新权限信息
		try {
			permissionsService.saveAlter(s, roleId);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "error/500";
		}
		return "redirect:see.do";
	}
	
	/*
	 * 搜素功能实现
	 */
	@RequestMapping("/search.do")
	public String search(String msg,Model model){
		//判断msg是否为空
		if("".equals(msg))
			return "error/500";
		//搜索信息
		try {
			List<Role> roles=permissionsService.searchRole(msg);
			//将信息放到model中
			model.addAttribute("roles", roles);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "error/500";
		}
		return "rolePermissions/roleList";
	}
}

