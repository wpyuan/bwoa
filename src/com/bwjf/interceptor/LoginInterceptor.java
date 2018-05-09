package com.bwjf.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.bwjf.entity.Account;

/**
 * @author 张恭雨
 * 创建时间：2017年10月23日 上午10:19:26
 * 类描述：验证是否登录拦截器
 * 版本：v1.0 
 */
public class LoginInterceptor implements HandlerInterceptor {

	@Override
	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception e)
			throws Exception {
		
	}

	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1,
			Object arg2, ModelAndView arg3) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
			Object handler) throws Exception {
		// TODO Auto-generated method stub
		//获取帐户信息
		Account account=(Account) request.getSession().getAttribute("account");
		//判断帐户是否为空。
		if(account!=null){
			return true;
		}
		//跳转到登录页面
		 request.getRequestDispatcher("/login.jsp").forward(request,response);
		return false;
	}

}
