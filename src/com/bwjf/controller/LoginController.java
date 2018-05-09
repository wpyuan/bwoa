package com.bwjf.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bwjf.entity.Account;
import com.bwjf.service.AccountService;
import com.bwjf.utils.LoginContextUtil;
import com.bwjf.utils.MD5Util;

/**
 * @author 张恭雨
 * 创建时间：2017年10月20日 上午11:51:29
 * 类描述：登录控制处理
 * 版本：v1.0 
 */
@Controller
public class LoginController {
	private AccountService accountService;
	
	public AccountService getAccountService() {
		return accountService;
	}
	
	@Resource
	public void setAccountService(AccountService accountService) {
		this.accountService = accountService;
	}
	@RequestMapping("/login.do")
	public String login(String username,String password,HttpServletRequest request){
		//session声明
		HttpSession session;
		//错误信息声明
		String error="";
		//将密码进行md5加密
		password=MD5Util.getMD5(password);
		//查询帐户信息
		try {
			Account account=accountService.getAcccountByConditions(username, 1);
			//判断帐户信息是否存在
			if(account==null){
				//设置错误信息
				error="帐户不存在或已失效";
				//将错误信息放到session中
				request.getSession().setAttribute("error", error);
				//重定向到登录页面
				return "redirect:/login.jsp";
			}
			//判断密码信息是否正确
			if(!account.getPassword().equals(password)){
				//设置错误信息
				error="密码错误！";
				//将错误信息放到model中
				request.getSession().setAttribute("error", error);
				//重定向到登录页面
				return "redirect:/login.jsp";
				
			}
			//判断用户是否已经登录,如果已经登录，跳转到已经登录页面
//			if(LoginContextUtil.checkIsLogin(username, request)){
//				return "error/test";
//			}
			//验证通过，登录用户
			//将账户信息放到session中
			session=request.getSession();
			session.setAttribute("account", account);
			//将用户session与id绑定
//			LoginContextUtil.putContext(username, session, request);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "error/500";
		}
		return "redirect:home/index.do";
	}

}
