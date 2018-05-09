package com.bwjf.utils;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.sun.corba.se.spi.orbutil.fsm.State;

/**
 * @author 张恭雨
 * 创建时间：2017年10月20日 下午5:25:01
 * 类描述：单点登录工具类。
 * 版本：v1.0 
 */
public class LoginContextUtil {
	private static Map<String,HttpSession> sessionMap;		//声明一个sessionMap
	private static ServletContext context;					//声明一个servletcontext	
	private static HttpSession session;						//声明一个session对象
	/*
	 * 将帐号绑定的信息放到context中
	 */
	@SuppressWarnings("unchecked")
	public static void putContext(String accountId,HttpSession session,HttpServletRequest request){
		//获取context对象
		context=request.getSession().getServletContext();
		//获取context中的sessionMap对象
		sessionMap=(Map<String, HttpSession>) context.getAttribute("sessionMap");
		
		//判断sessionMap是否为空，如果为空就创建一个sessionMap对象
		if("".equals(sessionMap)||sessionMap==null){
			sessionMap=new HashMap<String, HttpSession>();
		}
		//将用户ID与session绑定
		sessionMap.put(accountId, session);
		//将绑定后得sessionMap放到context中
		context.setAttribute("sessionMap", sessionMap);
		
	}
	/*
	 * 检查用户是否已经登录
	 */
	@SuppressWarnings("unchecked")
	public static boolean checkIsLogin(String accountId,HttpServletRequest request){
		//获取context对象
		context=request.getSession().getServletContext();
		//获取context中的sessionMap
		sessionMap=(Map<String, HttpSession>) context.getAttribute("sessionMap");
		//判断sessionMap是否为空
		if("".equals(sessionMap)||sessionMap==null){
			sessionMap=new HashMap<String, HttpSession>();
		}
		//获取session
		session=sessionMap.get(accountId);
		//判断session是否为空
		if("".equals(session)||session==null)
			return false;
		return true;		
		
	}
	/*
	 * 移除sessionMap中绑定的帐户信息
	 * 
	 */
	public static void removeSession(String accountId,HttpServletRequest request){
		//获取context对象
		context=request.getSession().getServletContext();
		//获取context中的sessionMap
		sessionMap=(Map<String, HttpSession>) context.getAttribute("sessionMap");
		//移除绑定的session
		sessionMap.remove(accountId);
	}
	

}
