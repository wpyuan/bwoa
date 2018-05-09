package com.bwjf.controller;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bwjf.entity.AccountAreaEmployeeRoleView;

import com.bwjf.entity.Role;
import com.bwjf.service.AccountService;
import com.bwjf.service.AreaService;
import com.bwjf.service.EmployeeService;
import com.bwjf.service.RoleService;
import com.bwjf.utils.CodeChangeUtil;

import net.sf.json.JSONObject;

/**
 * @作者 王培源
 * @创建日期 2017/10/23
 * @描述 角色分配页面role.jsp控制层
 * @方法名解释 roleIndex - 角色分配首页 rolePageContent - 所有角色role.jsp翻页显示......
 */
@Controller
public class RoleController {
	public RoleService roleService;
	public AccountService accountService;
	public EmployeeService employeeService;
	public AreaService areaService;
	private CodeChangeUtil codeChangeUtil;
	private JSONObject jsonData;

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

	public RoleService getRoleService() {
		return roleService;
	}

	@Resource
	public void setRoleService(RoleService roleService) {
		this.roleService = roleService;
	}

	/**
	 * @描述 角色role.jsp首页显示
	 */
	@RequestMapping("/roleIndex")
	public String roleIndex(Model model) {
		System.out.println("===RoleController.roleIndex()===");

		List<Role> roleList = new ArrayList<>();
		try {
			roleList = roleService.getAllRole();
		} catch (Exception e1) {

			e1.printStackTrace();
		}
		int page = 0;

		/*
		 * 传值到页面： 1.roleList: 用于下拉框显示数据 2.accountAllList: 存放第1行到第20行的账户表记录
		 * 3.employeeAllList: 存放第1行到第20行的账户表对应的员工记录 4.roleAllList 存放第1行到第20行的账户表对应的角色记录
		 * 5.areaAllList 存放第1行到第20行的账户表对应的区域记录
		 * ---------------------以上用accountAreaEmployeeRoleViewList存放--------------------
		 * ------------- 6.pageNumber:总页码
		 */
		List<AccountAreaEmployeeRoleView> accountAreaEmployeeRoleViewAllList = new ArrayList<>();
		try {
			accountAreaEmployeeRoleViewAllList = roleService.getAccountAreaEmployeeRoleView();
		} catch (Exception e1) {

			e1.printStackTrace();
		}
		// 取出当页数据--20条
		List<AccountAreaEmployeeRoleView> accountAreaEmployeeRoleViewList = new ArrayList<>();
		for (int i = page * 20; i < (page + 1) * 20 && i < accountAreaEmployeeRoleViewAllList.size(); i++) {
			accountAreaEmployeeRoleViewList.add(accountAreaEmployeeRoleViewAllList.get(i));
		}
		int pageNumber = 0;
		try {
			pageNumber = accountService.getPage();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		model.addAttribute("roleList", roleList);
		model.addAttribute("accountAreaEmployeeRoleViewList", accountAreaEmployeeRoleViewList);
		model.addAttribute("pageNumber", pageNumber);
		model.addAttribute("nowPage", page);
		model.addAttribute("type", "normal");
		// return "rolePermissions/role";
		return "rolePermissions/role";

	}

	/**
	 * @描述 所有角色role.jsp翻页显示
	 */
	@RequestMapping("/rolePageContent")
	public String rolePageContent(int page, Model model, int pageNumber) {
		System.out.println("===RoleController.rolePageContent(page:" + page + ")===");

		List<Role> roleList = new ArrayList<>();
		try {
			roleList = roleService.getAllRole();
		} catch (Exception e1) {

			e1.printStackTrace();
		}

		List<AccountAreaEmployeeRoleView> accountAreaEmployeeRoleViewAllList = new ArrayList<>();
		try {
			accountAreaEmployeeRoleViewAllList = roleService.getAccountAreaEmployeeRoleView();
		} catch (Exception e1) {

			e1.printStackTrace();
		}
		// 取出当页数据--20条
		List<AccountAreaEmployeeRoleView> accountAreaEmployeeRoleViewList = new ArrayList<>();
		for (int i = page * 20; i < (page + 1) * 20 && i < accountAreaEmployeeRoleViewAllList.size(); i++) {
			accountAreaEmployeeRoleViewList.add(accountAreaEmployeeRoleViewAllList.get(i));
		}
		/*
		 * 传值到页面： 1.roleList: 用于下拉框显示数据 2.accountAreaEmployeeRoleViewList
		 * 存放第page*20+1行到第(page+1)*20行的账户表记录、对应的员工记录、对应的角色记录、对应的区域记录
		 */

		model.addAttribute("roleList", roleList);
		model.addAttribute("accountAreaEmployeeRoleViewList", accountAreaEmployeeRoleViewList);
		model.addAttribute("nowPage", page);
		model.addAttribute("pageNumber", pageNumber);
		model.addAttribute("type", "normal");
		return "rolePermissions/role";

	}

	/**
	 * @描述 异步显示点击树节点后的区域信息
	 */
	@RequestMapping("/showAreaRole")
	@ResponseBody
	public String ShowAreaRole(int areaId, int nowPage, String name) {

		/*
		 * 解决url中文乱码
		 */
		name = codeChangeUtil.changeUTF8(name);
		name = null;// 可以完善这个功能（王培源）
		System.out.println(
				"===RoleController.ShowAreaRole(areaId:" + areaId + ",nowPage:" + nowPage + ",name:" + name + ")===");
		/*
		 * 需要传到页面的数据： 1.对应页员工列表
		 * accountAllList,employeeAllList,roleAllList,下标一一对应。提供页面表格显示数据; 2.roleList:
		 * 用于下拉框显示数据 3.nowPage,pageNumber
		 */
		Map map = new HashMap();
		List<Role> roleList = new ArrayList<>();
		try {
			roleList = roleService.getAllRole();
		} catch (Exception e1) {

			e1.printStackTrace();
		}
		
		int pageNumber = 0;
		List<AccountAreaEmployeeRoleView> accountAreaEmployeeRoleViewList = new ArrayList<>();
		if (name == null || name.equals("")) {

			List<AccountAreaEmployeeRoleView> accountAreaEmployeeRoleViewAllList = new ArrayList<>();
			try {
				accountAreaEmployeeRoleViewAllList = roleService.getAccountAreaEmployeeRoleViewByAreaId(areaId);
			} catch (Exception e) {
				e.printStackTrace();
			}	
			// 计算页码
			pageNumber = accountAreaEmployeeRoleViewAllList.size();
			if (pageNumber % 20 != 0) {
				pageNumber = pageNumber / 20 + 1;
			} else
				pageNumber = pageNumber / 20;

			for (int i = (nowPage * 20); i < (nowPage + 1) * 20&&i < accountAreaEmployeeRoleViewAllList.size(); i++) {
				accountAreaEmployeeRoleViewList.add(accountAreaEmployeeRoleViewAllList.get(i));	
			}

		} /*
			 * else {
			 * 
			 * List<Employee> employeeList = employeeService.getEmployeeByName(name); //
			 * 姓名模糊查询结果集employeeList
			 * 
			 * try { accountList = accountService.getAccountByEmployeeName(employeeList); }
			 * catch (Exception e) {
			 * 
			 * e.printStackTrace(); }// 姓名模糊查询结果集employeeList对应得到accountList List<Account>
			 * accountInArea = new ArrayList<>();//
			 * accountInArea存放accountList里符合areaid区域的账户结果集 Account account = null; for
			 * (Account accounts : accountList) { account = new Account(); if
			 * (accounts.getAreaId() == areaId) {// 判断符合 accountInArea.add(accounts); } } //
			 * 当页10行 for (int i = (nowPage * 10); i < accountInArea.size(); i++) { if (i <
			 * ((nowPage + 1) * 10)) accountAllList.add(accountInArea.get(i)); else break; }
			 * 
			 * // 计算页码 pageNumber = accountInArea.size(); if (pageNumber % 10 != 0) {
			 * pageNumber = pageNumber / 10 + 1; } else { pageNumber = pageNumber / 10; }
			 * 
			 * }
			 */
		/*
		 * 如果accountList记录大于十行，则分页显示 
		 * 提供数据： 
		 * 1.pageNumber：总页码 
		 * 2.nowPage：当前页码
		 * 3.nowPage页的accountAreaEmployeeRoleViewList
		 */
		map.put("accountAreaEmployeeRoleViewList", accountAreaEmployeeRoleViewList);
		map.put("roleList", roleList);
		map.put("nowPage", nowPage);
		map.put("pageNumber", pageNumber);
		// 把map转成 json,然后再前台接收
		jsonData = JSONObject.fromObject(map);
		// System.out.println("最后转成的json为："+jsonData);
		return jsonData.toString();
	}

	/**
	 * @描述 按姓名查找角色role.jsp翻页显示
	 * @实现功能 1.姓名模糊查询 2.姓名模糊+区域精确查询
	 */
	@RequestMapping("/rolePageContentByName")
	public String rolePageContentByName(String name, String areaId, int page, Model model) {
		areaId = null; // 可以完善这个功能（王培源）
		System.out.println("name:" + name);
		/*
		 * 解决url中文乱码
		 */
		name = codeChangeUtil.changeUTF8(name);
		

		System.out.println("===RoleController.rolePageContentByName(name:" + name + ",areaId:" + areaId + ",page:"
				+ page + ")===");
		boolean isNull1 = (name == null || name.equals("")); // 名字为空
		boolean isNull2 = (areaId == null || areaId.equals("")); // 区域id为空
		if (isNull1 && isNull2) {
			System.out.println("2为空");
		} else {
			if (isNull2) {
				System.out.println("名字不为空，区域id为空");
				List<Role> roleList = new ArrayList<>();
				try {
					roleList = roleService.getAllRole();
				} catch (Exception e1) {

					e1.printStackTrace();
				}
				//1.查询视图包含name的记录
				List<AccountAreaEmployeeRoleView> accountAreaEmployeeRoleViewAllList = new ArrayList<>();
				try {
					accountAreaEmployeeRoleViewAllList = roleService.getAccountAreaEmployeeRoleViewByEmployeeName(name);
				} catch (Exception e1) {

					e1.printStackTrace();
				}
				//2. 取出当页数据--20条
				List<AccountAreaEmployeeRoleView> accountAreaEmployeeRoleViewList = new ArrayList<>();
				for (int i = page * 20; i < (page + 1) * 20 && i < accountAreaEmployeeRoleViewAllList.size(); i++) {
					accountAreaEmployeeRoleViewList.add(accountAreaEmployeeRoleViewAllList.get(i));
				}
				
				int pageNumber = accountAreaEmployeeRoleViewAllList.size();
				if (pageNumber % 20 != 0) {
					pageNumber = pageNumber / 20 + 1;
				} else {
					pageNumber = pageNumber / 20;
				}
				model.addAttribute("roleList", roleList);
				model.addAttribute("accountAreaEmployeeRoleViewList", accountAreaEmployeeRoleViewList);
				model.addAttribute("nowPage", page);
				model.addAttribute("pageNumber", pageNumber);
				model.addAttribute("name", name);
				model.addAttribute("dqid", areaId);
				model.addAttribute("type", "search");
			} else {
				/*
				System.out.println("名字，区域id不为空");
				List<Role> roleList = new ArrayList<>();
				;
				try {
					roleList = roleService.getAllRole();
				} catch (Exception e1) {

					e1.printStackTrace();
				}
				List<Employee> employeeList = new ArrayList<>();
				;
				try {
					employeeList = employeeService.getEmployeeByName(name);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} // 姓名模糊查询结果集employeeList

				List<Account> accountList = new ArrayList<>();
				;
				try {
					accountList = accountService.getAccountByEmployeeName(employeeList);
				} catch (Exception e) {

					e.printStackTrace();
				} // 姓名模糊查询结果集employeeList对应得到accountList
				List<Account> accountInArea = new ArrayList<>();// accountInArea存放accountList里符合areaid区域的账户结果集
				Account account = null;
				for (Account accounts : accountList) {
					account = new Account();
					if (accounts.getAreaId() == Integer.parseInt(areaId)) {// 判断符合
						accountInArea.add(accounts);
					}
				}
				List<Account> accountAllList = new ArrayList<>();
				// 当页10行
				for (int i = (page * 10); i < accountInArea.size(); i++) {
					if (i < ((page + 1) * 10))
						accountAllList.add(accountInArea.get(i));
					else
						break;
				}
				List<Employee> employeeAllList = new ArrayList<>();
				;
				try {
					employeeAllList = employeeService.getEmployeeByList(accountAllList);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				List<Role> roleAllList = new ArrayList<>();
				;
				try {
					roleAllList = roleService.getRoleByList(accountAllList);
				} catch (Exception e) {

					e.printStackTrace();
				}
				List<Area> areaAllList = new ArrayList<>();
				try {
					areaAllList = areaService.getChooseArea(accountAllList);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				// 计算页码
				int pageNumber = accountInArea.size();
				if (pageNumber % 10 != 0) {
					pageNumber = pageNumber / 10 + 1;
				} else {
					pageNumber = pageNumber / 10;
				}

				model.addAttribute("roleList", roleList);
				model.addAttribute("accountAllList", accountAllList);
				model.addAttribute("employeeAllList", employeeAllList);
				model.addAttribute("roleAllList", roleAllList);
				model.addAttribute("areaAllList", areaAllList);
				model.addAttribute("nowPage", page);
				model.addAttribute("pageNumber", pageNumber);
				model.addAttribute("name", name);
				model.addAttribute("dqid", areaId);
				model.addAttribute("type", "search");
				*/
			}
		}

		return "rolePermissions/role";

	}

	/**
	 * @描述 角色分配
	 * @实现功能 1.修改用户角色名
	 */
	@RequestMapping("/updateRole")
	@ResponseBody
	public String UpdateRole(int no, int roleId) {
		System.out.println("===RoleController.UpdateRole(no:" + no + ",roleId:" + roleId + ")===");
		try {
			accountService.UpdateRole(no, roleId);
		} catch (Exception e) {

			e.printStackTrace();
		}
		Map map = new HashMap();

		map.put("msg", "修改成功");
		// 把map转成 json,然后再前台接收
		jsonData = JSONObject.fromObject(map);
		// System.out.println("最后转成的json为："+jsonData);
		return jsonData.toString();

	}

	/**
	 * @描述 添加角色首页
	 * @实现功能 1. 查询所有角色
	 */
	@RequestMapping("/addRoleIndex")
	public String addIndex(Model model) {
		System.out.println("===RoleController.addIndex()===");
		List<Role> roleList = new ArrayList<>();
		;
		try {
			roleList = roleService.getAllRole();
		} catch (Exception e) {

			e.printStackTrace();
		}
		model.addAttribute("roleList", roleList);
		return "rolePermissions/addRole";
	}

	/**
	 * @描述 添加角色
	 * @实现功能 1. 添加角色
	 */
	@RequestMapping("/addRole")
	@ResponseBody
	public String addRole(String name) {
		name = codeChangeUtil.changeUTF8(name);
		System.out.println("===RoleController.addRole(name:" + name + ")===");

		Map map = new HashMap();
		Role role = new Role();
		role.setName(name);
		int flag = 0;
		try {
			flag = roleService.add(role);
		} catch (Exception e) {

			e.printStackTrace();
		}
		if (flag == 0) {// 添加失败，已有角色
			map.put("msg", "添加失败，已有角色");
		} else {// 添加成功
			map.put("msg", "添加成功");
		}
		List<Role> roleList = new ArrayList<>();
		;
		try {
			roleList = roleService.getAllRole();
		} catch (Exception e) {

			e.printStackTrace();
		}
		map.put("roleList", roleList);
		// 把map转成 json,然后再前台接收
		jsonData = JSONObject.fromObject(map);
		// System.out.println("最后转成的json为："+jsonData);
		return jsonData.toString();
	}

	/**
	 * @描述 编辑角色首页
	 * @实现功能 1. 查询所有角色
	 */
	@RequestMapping("/editRoleIndex")
	public String editIndex(Model model) {
		System.out.println("===RoleController.editIndex()===");
		List<Role> roleList = new ArrayList<>();
		;
		try {
			roleList = roleService.getAllRole();
		} catch (Exception e) {

			e.printStackTrace();
		}
		model.addAttribute("roleList", roleList);
		return "rolePermissions/editRole";
	}

	/**
	 * @描述 修改角色
	 * @实现功能 1. 修改角色名
	 */
	@RequestMapping("/updateRoleName")
	public String update(Model model, Role role) {
		/*
		 * 解决url中文乱码
		 */
		role.setName(codeChangeUtil.changeUTF8(role.getName()));
		
		System.out.println("===RoleController.update(role:" + role.toString() + ")===");
		try {
			Role role2 = roleService.getRoleByName(role.getName());
			if (role2 == null) {// 不重名，可以修改
				int flag = 0;

				try {
					flag = roleService.update(role);
				} catch (Exception e) {

					e.printStackTrace();
				}

				if (flag == 1) {// 修改成功

				} else {

				}
			}
		} catch (Exception e1) {
			e1.printStackTrace();
		}

		return "redirect:/editRoleIndex.do";
	}

	/**
	 * @描述 删除角色
	 * @实现功能 1. 删除角色
	 */
	@RequestMapping("/deleteRole")
	public String deletRole(int roleId) {
		System.out.println("===RoleController.deletRole()===");
		try {
			roleService.delet(roleId);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "redirect:/editRoleIndex.do";
	}

	/**
	 * @描述 按角色名查询角色
	 * @实现功能 1. 模糊查询角色
	 */
	@RequestMapping("/queryRoleByName")
	public String queryRoleByName(String name, Model model) {
		/*
		 * 解决url中文乱码
		 */
		name = codeChangeUtil.changeUTF8(name);
		
		System.out.println("===RoleController.queryRoleByName(name:" + name + ")===");
		List<Role> roleList = new ArrayList<>();
		
		try {
			roleList = roleService.getRoleByNameMH(name);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		model.addAttribute("roleList", roleList);
		return "rolePermissions/editRole";

	}
}
