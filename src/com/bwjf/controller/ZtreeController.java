package com.bwjf.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bwjf.entity.Account;
import com.bwjf.entity.Menu;
import com.bwjf.service.ZtreeService;


/**
 * @author 张恭雨
 * 创建时间：2017年10月20日 上午11:36:48
 * 类描述：ztree菜单控制实现
 * 版本：v1.0 
 */
@Controller
@RequestMapping("/ztree")
public class ZtreeController {
	private ZtreeService ztreeService;
	
	public ZtreeService getZtreeService() {
		return ztreeService;
	}
	@Resource
	public void setZtreeService(ZtreeService ztreeService) {
		this.ztreeService = ztreeService;
	}	
	
	/*
	 * 异步加载菜单信息
	 */
	@RequestMapping("/menu.do")
	@ResponseBody
	public List<Menu> getMenu(HttpServletRequest request){
		try {
			//获取session中的帐户信息
			Account account=(Account) request.getSession().getAttribute("account");			
			return ztreeService.getMenuByRoleId(account.getRoleId());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}		
	}
	
}
