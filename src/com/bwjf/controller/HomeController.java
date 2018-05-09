package com.bwjf.controller;

import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bwjf.entity.Account;
import com.bwjf.service.EmployeeService;
import com.bwjf.utils.LoginContextUtil;

/**
 * @author 张恭雨
 * 创建时间：2017年10月20日 下午3:45:23
 * 类描述：主页
 * 版本：v1.0 
 */
@Controller
@RequestMapping("/home")
public class HomeController {
	
	public EmployeeService eService;
	
	public EmployeeService geteService() {
		return eService;
	}
	@Resource
	public void seteService(EmployeeService eService) {
		this.eService = eService;
	}

	/**
	 * 主页跳转
	 */
	@RequestMapping("/index.do")
	public String toIndex(Model model,HttpServletRequest req){
		Account account = (Account) req.getSession().getAttribute("account");
		String userName = null;
		try {
			userName = eService.getNameById(account.getEmployeeId());
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		model.addAttribute("userName", userName);
		return "index";
		
	}
	/*
	 * 扑捉浏览器或者页面关闭事件
	 */
	@RequestMapping("/close.do")
	public void close(HttpServletRequest request){
		//获取帐户信息
		Account account = (Account) request.getSession().getAttribute("account");
		//移除绑定的sessionMap
		//LoginContextUtil.removeSession(account.getAccountId(), request);
		//移除session
		request.getSession().removeAttribute("account");
	}
	
	/**
	 * @作者 王培源
	 * @描述 主页退出登录
	 */
	@RequestMapping("/exit")
	public String exit(HttpServletRequest req) {
		/*1.先移除seesionMap
		 *2.跳转登陆界面
		 */
		// 移除
		Account account = (Account) req.getSession().getAttribute("account");
		//ServletContext context = req.getSession().getServletContext();
		//Map<String, HttpSession> sessionMap = (Map<String, HttpSession>) context.getAttribute("sessionMap");
		//sessionMap.remove(account.getAccountId());
		req.getSession().removeAttribute("account");
		return "redirect:/login.jsp";
	}
}
