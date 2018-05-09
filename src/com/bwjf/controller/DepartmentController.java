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

import com.bwjf.entity.Department;
import com.bwjf.service.DepartmentService;
import com.bwjf.utils.CodeChangeUtil;

import net.sf.json.JSONObject;


/**
 * @作者 王培源
 * @创建日期 2017/10/27
 * @描述 部门管理页面department.jsp控制层
 * @方法名解释 roleIndex - 角色分配首页
 */
@Controller
@RequestMapping("/department")
public class DepartmentController {
	
	public DepartmentService dService;
	
	private JSONObject jsonData;
	private CodeChangeUtil codeChangeUtil;
	public JSONObject getJsonData() {
		return jsonData;
	}

	public void setJsonData(JSONObject jsonData) {
		this.jsonData = jsonData;
	}
	
	public DepartmentService getdService() {
		return dService;
	}
	@Resource
	public void setdService(DepartmentService dService) {
		this.dService = dService;
	}

	/**
	 * @描述 查询部门管理首页要显示的数据
	 */
	@RequestMapping("/index")
	public String departmentIndex(Model model) {
		System.out.println("===DepartmentController.departmentIndex()===");
		List<Department> departmentList = new ArrayList<>();
		try {
			departmentList = dService.getAllDepartment();
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
		model.addAttribute("departmentList", departmentList);
		return "department/department";
	}
	
	/**
	 * @描述 添加部门
	 */
	@RequestMapping("/add")
	@ResponseBody
	public String addDepartment(String name) {
		System.out.println("===DepartmentController.addDepartment(name:"+name+")===");
		Map map = new HashMap();
		Department department = new Department();
		department.setName(name);
		department.setStatus(1);
		int flag=0;
		try {
			flag = dService.add(department);
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		if(flag==0) {
			map.put("msg", "部门已存在，不需要反复添加！");
		}else if(flag==-1){
			map.put("msg", "部门已存在但失效，是否将其设置为有效？");
			try {
				department = dService.getDepartmentByName(name);
			} catch (Exception e) {
				e.printStackTrace();
			}//查询得出部门id
			map.put("dId", department.getDepartmentId());
		}else {
			try {
				department = dService.getDepartmentByName(name);
			} catch (Exception e) {
				e.printStackTrace();
			}//查询得出部门id
			map.put("msg", "部门添加成功！");
			map.put("newDepartmentName", name);
			map.put("dId", department.getDepartmentId());
		}
		jsonData = JSONObject.fromObject(map);
		return jsonData.toString();
	}
	
	/**
	 * @描述 由部门名查部门
	 */
	@RequestMapping("/query")
	public String query(String name,Model model) {
		/*
		 * 解决url中文乱码
		 */
		name = codeChangeUtil.changeUTF8(name);
		
		System.out.println("===DepartmentController.query(name:"+name+")===");
		
		List<Department> departmentList = new ArrayList<>();;
		try {
			departmentList = dService.getDepartmentByNameMH(name);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}//模糊查询
		
		model.addAttribute("departmentList", departmentList);
		return "department/department";
	}
	
	/**
	 * @描述 由部门id删除部门
	 */
	@RequestMapping("/delet")
	public String delet(int departmentId/*,Model model*/) {
		System.out.println("===DepartmentController.delet(departmentId:"+departmentId+")===");
		int flag = -1;
		try {
			flag = dService.delet(departmentId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (flag==1) {
			//model.addAttribute("msg", "删除成功");
			return "redirect:/department/index.do";
		}else {
			//model.addAttribute("msg", "删除失败");
			return "department/department";
		}
		
	}
	/**
	 * @描述 由部门id修改部门名
	 */
	@RequestMapping("/update")
	public String update(Department department,Model model) {	
		/*
		 * 解决url中文乱码
		 */
		department.setName(codeChangeUtil.changeUTF8(department.getName()));
		System.out.println("===DepartmentController.update(department:"+department.toString()+")===");
		Department department2 = null;
		try {
			department2 = dService.getDepartmentByName(department.getName());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (department2==null) {//部门名不存在
			try {
				dService.update(department);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//return "redirect:/department/index.do";
		}else {//失效或者重名
			System.out.println("修改失败");
			//修改失败
			//model.addAttribute("msg","修改失败！重名");
			//return "redirect:/jsp/department/department.jsp";
		}
		return "redirect:/department/index.do";
	}
	/**
	 * @描述 由部门id修改部门名
	 */
	@RequestMapping("/setStatus")
	public String setStatus(Department department,Model model) {	
		/*
		 * 解决url中文乱码
		 */
		department.setName(codeChangeUtil.changeUTF8(department.getName()));
		
		System.out.println("===DepartmentController.update(department:"+department.toString()+")===");
		
		try {
			dService.update(department);
		} catch (Exception e) {
			e.printStackTrace();
		}	
		return "redirect:/department/index.do";
	}
}
