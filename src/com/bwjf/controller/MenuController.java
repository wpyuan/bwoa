package com.bwjf.controller;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bwjf.entity.Menu;
import com.bwjf.service.MenuService;
import com.bwjf.service.RoleMenuService;

/**
 * @author 张恭雨
 * 创建时间：2017年10月24日 下午5:16:24
 * 类描述：菜单管理
 * 版本：v1.0 
 */
@Controller
@RequestMapping("/menu")
public class MenuController {
	
	private MenuService menuService;
	private RoleMenuService roleMenuService;

	public MenuService getMenuService() {
		return menuService;
	}
	@Resource
	public void setMenuService(MenuService menuService) {
		this.menuService = menuService;
	}
	public RoleMenuService getRoleMenuService() {
		return roleMenuService;
	}
	@Resource
	public void setRoleMenuService(RoleMenuService roleMenuService) {
		this.roleMenuService = roleMenuService;
	}
	/*
	 * 菜单管理，获取所有的菜单信息
	 */
	@RequestMapping("/allMenu.do")
	@ResponseBody
	public List<Menu> getAllMenu(){
		try {
			return menuService.getAllMenu();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	/*
	 * 跳转菜单设置页面
	 */
	@RequestMapping("/toSet")
	public String toSet(){
		return "menu/menuSet";
	}
	
	/*
	 * ajax添加菜单
	 */
	 
	@RequestMapping("add.do")
	@ResponseBody
	public String add(int parentId){
		//消息声明
		String msg;
		//判断父节点是否为空
		if(parentId==0){
			msg="1";
			return msg;
		}
			
		//创建一个菜单对象
		Menu menu=new Menu();
		//初始化菜单信息
		menu.setName("新节点");
		menu.setParentId(parentId);
		//将菜单信息保存到数据库
		try {
			menuService.saveMenu(menu);
		} catch (Exception e) {
			//异常处理
			e.printStackTrace();
			msg="2";
			return msg;
		}
		msg="3";
		return msg;
	}
	/*
	 * 修改菜单名称
	 */
	@RequestMapping("/alter.do")
	@ResponseBody
	public String alter(Menu menu){
		//消息声明
		String msg;
		//判断对象是否为空
		if(menu==null){
			msg="fail";
			return msg;
		}
		//进行编码格式转换
		try {
			menu.setName(URLDecoder.decode(menu.getName(), "utf-8"));
		} catch (UnsupportedEncodingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		//更新菜单信息
		try {
			menuService.updateMenu(menu);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			msg="fail";
			return msg;
		}			
		msg="success";
		return msg;
	}
	
	/*
	 * 删除菜单
	 */
	@RequestMapping("/delete.do")
	@ResponseBody
	public String delete(int menuId){
		//消息声明
		String msg;
		//判断id是否为空
		if(menuId==0){
			msg="fail";
			return msg;
		}
		
		//删除菜单以及下面的子菜单
		try {
			//获取菜单下的所有子菜单
			List<Menu> menus=menuService.getMenuByParentId(menuId);
			//删除子菜单rolemenumenu相关信息
			for(Menu menu:menus){
				roleMenuService.deleteByMenuId(menu.getMenuId());
			}
			//删除菜单rolemenu信息
			roleMenuService.deleteByMenuId(menuId);
			//删除菜单以及子菜单信息
			menuService.deleteById(menuId);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			msg="fail";
			return msg;
		}
		msg="success";
		return msg;
	}

}
