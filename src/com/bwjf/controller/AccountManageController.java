package com.bwjf.controller;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.bwjf.utils.CodeChangeUtil;
import javax.annotation.Resource;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bwjf.entity.Account;
import com.bwjf.entity.AccountAreaEmployeeRoleView;
import com.bwjf.entity.Area;
import com.bwjf.service.AccountService;
import com.bwjf.service.AreaService;
import com.bwjf.service.EmployeeService;
import com.bwjf.utils.MD5Util;

import net.sf.json.JSONObject;

/**
 * @类描述 账户维护的控制层
 * 
 * @author1 王培源 创建时间：2017年10月31日 上午11:46:00
 * @实现功能 区域变更
 * 
 * @author2 郑森文
 * @实现功能 修改密码
 */
@Controller
@RequestMapping("/account")
public class AccountManageController {

	private AreaService areaService;
	
	private JSONObject jsonData;

	private AccountService accountService;

	private EmployeeService employeeService;
	private CodeChangeUtil codeChangeUtil;
		
	public EmployeeService getEmployeeService() {
		return employeeService;
	}

	@Resource
	public void setEmployeeService(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}

	public AccountService getAccountService() {
		return accountService;
	}

	@Resource
	public void setAccountService(AccountService accountService) {
		this.accountService = accountService;
	}

	public JSONObject getJsonData() {
		return jsonData;
	}

	public void setJsonData(JSONObject jsonData) {
		this.jsonData = jsonData;
	}

	public AreaService getAreaService() {
		return areaService;
	}

	@Resource
	public void setAreaService(AreaService areaService) {
		this.areaService = areaService;
	}

	@RequestMapping("/areaChangeindex")
	public String areaChangeIndex() {
		System.out.println("===AccountManageController.areaChangeIndex()===");
		return "account/areaChange";
	}

	// 接收修改密码请求
	@RequestMapping("/pwdModify.do")
	public String Modify(Model model, HttpServletRequest httpServletRequest) {
		Account account = (Account) httpServletRequest.getSession().getAttribute("account");
		model.addAttribute("account", account);
		return "account/pwdModify";
	}

	// 输入原密码时触发的异步
	@RequestMapping("/Oldpassword.do")
	@ResponseBody
	public String Oldpassword(String Oldpassword, HttpServletRequest req) {
		System.out.println("==========LoginController.Oldpassword(Oldpassword=" + Oldpassword + ")=========");
		Map map = new HashMap();
		if (Oldpassword == null || Oldpassword.length() <= 0) {
			map.put("msg", "× 请输入原密码");

		} else {
			Oldpassword = MD5Util.getMD5(Oldpassword);
			Account account = (Account) req.getSession().getAttribute("account");

			if (Oldpassword.equals(account.getPassword())) {
				map.put("msg", "√");
			} else {
				map.put("msg", "× 密码错误");
			}

		}
		// 将map转成json，然后接收
		jsonData = JSONObject.fromObject(map);
		return jsonData.toString();
	}

	// 修改密码前的提交
	@RequestMapping("/pwdModify2.do")
	@ResponseBody
	public String Modify2(String Oldpassword, String Newpassword, String Newpassword2, HttpServletRequest req,
			HttpSession session) {
		System.out.println("==========LoginController.Modify2()=========");
		System.out.println(Oldpassword + "----" + Newpassword + "----" + Newpassword2);
		Oldpassword = MD5Util.getMD5(Oldpassword);
		Account account = (Account) req.getSession().getAttribute("account");
		Map map = new HashMap();
		// 判断是否是本人
		if (Oldpassword.equals(account.getPassword())) {
			// System.out.println("是本人");
			// 判断两次密码是否一致
			if (Newpassword.equals(Newpassword2)) {
				// System.out.println("判断两次密码是一致");
				// 进行修改密码操作。
				Newpassword2 = MD5Util.getMD5(Newpassword2);
				account.setPassword(Newpassword2);
				try {
					accountService.setPasswordById(account);
				} catch (Exception e) {
					e.printStackTrace();
				}
				map.put("msg", "√");

				// 修改后移除之前登陆存进sessionMap中的账户对象
				ServletContext context = req.getSession().getServletContext();
				Map<String, HttpSession> sessionMap = (Map<String, HttpSession>) context.getAttribute("sessionMap");
				sessionMap.remove(account.getAccountId());

			} else {
				// System.out.println("判断两次密码不一致");
				map.put("msg", "× 新密码和确认密码不一致，请确认");
			}
		} else {
			map.put("msg", "× 请输入原密码或密码错误");
		}
		// 将map转成json，然后接收
		jsonData = JSONObject.fromObject(map);
		return jsonData.toString();
	}

	/**
	 * @描述 由员工姓名查询员工所在区域
	 */
	@RequestMapping("/queryAreaByEmployeeName")
	public String queryAreaByEmployeeName(String name, Model model) {
		/*
		 * 解决url中文乱码
		 */
		name = codeChangeUtil.changeUTF8(name);
		

		System.out.println("===AccountManageController.queryAreaByEmployeeName(name:" + name + ")===");
		
		List<AccountAreaEmployeeRoleView> accountAreaEmployeeRoleViews = new ArrayList<>();
		try {
			accountAreaEmployeeRoleViews = accountService.getAAERVByEName(name);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			List<Area> areaAllList = areaService.getAllArea(1);
			model.addAttribute("areaAllList", areaAllList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		model.addAttribute("accountAreaEmployeeRoleViews", accountAreaEmployeeRoleViews);
		model.addAttribute("employeeName", name);
		return "account/areaChange";
	}
	
	/**
	 * @描述 有工号、原区域id变更区域
	 */
	@RequestMapping("/areaChange")
	@ResponseBody
	public String areaChange(int employeeId,int areaId) {
		System.out.println("===AccountManageController.areaChange(employeeId:" + employeeId + ",areaId:"+areaId+")===");
		Map map = new HashMap();
		try {
			accountService.areaChange(employeeId, areaId);
			Area area = areaService.getAreaByIdOne(areaId);
			map.put("msg", "区域变更成功");
			map.put("newAreaName", area.getName());
		} catch (Exception e) {
			e.printStackTrace();
		}
		jsonData = JSONObject.fromObject(map);
		return jsonData.toString();
	}
}
