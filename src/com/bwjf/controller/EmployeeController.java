package com.bwjf.controller;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bwjf.entity.Account;
import com.bwjf.entity.Employee;
import com.bwjf.entity.EmployeeDateVo;
import com.bwjf.service.EmployeeService;
import com.github.pagehelper.PageInfo;

/**
 * @author 张恭雨
 * 创建时间：2017年10月24日 下午5:49:11
 * 类描述：员工信息管理控制层
 * 版本：v1.0 
 */
@Controller
@RequestMapping("/employee")
public class EmployeeController {
	
	private EmployeeService employeeService;
	private int count=0;
	public EmployeeService getEmployeeService() {
		return employeeService;
	}
	@Resource
	public void setEmployeeService(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}
	
	/*
	 * 查看员工信息列,分页显示
	 */
	@RequestMapping("/see.do")
	public String see(Model model,Integer start, int length){
		//获取分页后得员工信息
		try {			
			PageInfo<Employee> pageInfo=
					employeeService.getEmployeeByPage(start, length);
			//将获取的信息放到model中			
			model.addAttribute("employees", pageInfo.getList());
			//将总页数放到model中
			model.addAttribute("total", pageInfo.getTotal());
			//将每页的记录数放到model中
			model.addAttribute("length", length);
			//页号
			model.addAttribute("pageNum", pageInfo.getPageNum());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "error/500";
		}
		
		return "employee/manage";
	}
	/*
	 * 显示员工详细信息
	 */
	@RequestMapping("/detail.do")
	public String detail(int employeeId,Model model){
		//判断id是否为空
		if(employeeId==0)
			return "error/500";
		//查询员工详细信息
		try {
			List<Object> list=employeeService.getEmployeeDetailById(employeeId);
			//将对象从list中取出来放到model中
			model.addAttribute("employee", list.get(0));
			model.addAttribute("name", list.get(1));
			model.addAttribute("dateVo", list.get(2));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "error/500";
		}
		return "employee/detail";
	}
	
	/*
	 * 跳转修改员工信息页面	 * 
	 */
	@RequestMapping("/toAlter.do")
	public String toAlter(int employeeId,Model model){
		//判断id是否为空
		if(employeeId==0)
			return "error/500";
		//查询员工详细信息
		try {
			List<Object> list=employeeService.getAlterEmployeeDetialById(employeeId);			
			//判断地址是否为空
			if(list.size()>3){
				//将地址信息放到model中
				model.addAttribute("province", list.get(0));
				model.addAttribute("city", list.get(1));
				model.addAttribute("town", list.get(2));
				model.addAttribute("addressDetail", list.get(3));
				//将员工对象放到model中
				model.addAttribute("employee", list.get(4));
				//将部门名称放到model中
				model.addAttribute("departmentName",list.get(5));
				
			}else{
				//将员工对象放到model中
				model.addAttribute("employee", list.get(0));
				//将部门名称放到model中
				model.addAttribute("departmentName",list.get(1));
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "error/500";
		}
		return "employee/alter";
	}
	/*
	 * 异步加载部门信息
	 */
	@RequestMapping("/showDepartment.do")
	@ResponseBody
	public String showDepartment(HttpServletRequest request){
		//获取帐户信息
		Account account=(Account) request.getSession().getAttribute("account");
		//获取员工部门ID
		try {
			int departmentId=employeeService.getDepartmentIdById(account.getEmployeeId());
			//查询部门名称,并返回数据
			return employeeService.getDepartmentNameByFiltrate(1, departmentId).toString();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "error/500";
		}
		
	}
	/*
	 * 异步加载地区信息
	 */
	@RequestMapping("/showArea.do")
	@ResponseBody
	public String showArea(){
		try {
			return employeeService.getAllArea(1).toString();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "error/500";
	}
	/*
	 * 修改用户信息
	 */
	
	@RequestMapping("/alter.do")
	public String alter(Employee employee,String province,
			String city,String town,String addressDetail,String departmentName,EmployeeDateVo dateVo){
		//判断员工对象是否为空。
		if(employee==null){
			return "error/500";
		}
		//将传入的信息封装
		List<Object> list=new ArrayList<Object>();
		list.add(employee);
		list.add(province);
		list.add(city);
		list.add(town);
		list.add(addressDetail);
		list.add(departmentName);	
		list.add(dateVo);		
		//保存更新信息
		try {
			employeeService.updateEmployeeById(list);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "error/500";
		}		
		return "redirect:see.do?start=1&length=10";
	}
	/*
	 * 删除员工信息
	 */
	@RequestMapping("/delete.do")
	public String delete(int employeeId){
		//判断员工工号是否为零
		if(employeeId==0)
			return "error/500";
		//更新员工状态信息
		try {
			employeeService.deleteEmployeeById(employeeId);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "error/500";
		}
		return "redirect:see.do?start=1&length=10";
	}
	/*
	 * 跳转添加员工信息页面
	 */
	@RequestMapping("/toAdd.do")
	public String toAdd(){
		return "employee/add";
	}
	/*
	 * 添加员工信息
	 */
	@RequestMapping("/add.do")
	public String add(Employee employee,String province,String areaName,HttpServletRequest request,
			String city,String town,String addressDetail,String departmentName,EmployeeDateVo dateVo){
		String employeeName;
		//判断员工对象是否为空。
		if(employee==null){
			return "error/500";
		}
		//获取帐户信息
		Account account=(Account) request.getSession().getAttribute("account");
		try {
			employeeName=employeeService.getNameById(account.getEmployeeId());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "error/500";
		}
		//创建一个Account对象
		Account account2=new Account();
		//设置创建人名称
		account2.setCreateBy(employeeName);
		//设置创建时间
		account2.setCreateDate(new Date());
		//将传入的信息封装
		List<Object> list=new ArrayList<Object>();
		list.add(employee);		
		list.add(province);
		list.add(city);
		list.add(town);
		list.add(addressDetail);
		list.add(departmentName);	
		list.add(dateVo);
		list.add(areaName);
		list.add(account2);		
		//保存更新信息
		try {
			employeeService.saveEmployee(list);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "error/500";
		}
		return "employee/null";
	}
	/*
	 * 个人信息查看
	 */
	@RequestMapping("/information.do")
	public String information(HttpServletRequest request,Model model){
		//获取帐户信息
		Account account=(Account) request.getSession().getAttribute("account");
		//查询员工详细信息
		try {
			List<Object> list=employeeService.getEmployeeDetailById(account.getEmployeeId());
			//将对象从list中取出来放到model中
			model.addAttribute("employee", list.get(0));
			model.addAttribute("name", list.get(1));
			model.addAttribute("dateVo", list.get(2));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "error/500";
		}
		return "employee/detail";
		
	}
	
	/*
	 * 搜索功能实现
	 */
	@RequestMapping("/search.do")
	public String search(String msg,Model model){				
		int start = 1;
		int length =10;
		//判断搜索信息是否为空
		
		if("".equals(msg)||msg==null)
			return "redirect:see.do?start=1&length=10";
		try {			
			//搜索员工信息
			PageInfo<Employee> pageInfo=employeeService.searchEmployee(msg,(start/length)+1,length);
			//将员工信息放到model中
			model.addAttribute("employees",pageInfo.getList());			
			//将总页数放到model中
			model.addAttribute("total", pageInfo.getTotal());
			//将每页的记录数放到model中
			model.addAttribute("length", length);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "error/500";
		}
		return "employee/manage";
	}
	/*
	 * 跳转分页，避免重复请求事件的发生
	 */
	@RequestMapping("/selectPage")
	@ResponseBody
	public String selectPage(Integer start){
		//判断是否为空，如果为空，返回成功
		if("".equals(start)||start==null)
			return "success";
		//判断是否是重复的请求
		if(this.count!=start){
			this.count=start;
			return "success";
		}
		return "fail";
		
	}
}
