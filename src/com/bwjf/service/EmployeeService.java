package com.bwjf.service;

import java.util.List;



import net.sf.json.JSONArray;

import com.bwjf.entity.Account;
import com.bwjf.entity.Employee;
import com.github.pagehelper.PageInfo;

/**
 * @author 张恭雨
 * 创建时间：2017年10月20日 下午3:59:53
 * 类描述：员工业务逻辑接口
 * 版本：v1.0 
 */
public interface EmployeeService {
	public String getNameById(int employeeId) throws Exception;		//获取员工的姓名
	public PageInfo<Employee> getEmployeeByPage(Integer pageNum,Integer pageSize) throws Exception;	//获取员工信息分页
	public List<Object> getEmployeeDetailById(int employeeId) throws Exception;	//获取员工详细信息
	public List<Object> getAlterEmployeeDetialById(int employeeId) throws Exception;		//获取员工的详细信息
	public JSONArray getDepartmentNameByFiltrate(int status,int departmentId) throws Exception;		//获取筛选条件下的部门名称
	public int getDepartmentIdById(int employeeId) throws Exception;		//获取员工部门Id
	public void updateEmployeeById(List<Object> list) throws Exception;		//更新用户信息
	public void deleteEmployeeById(int employeeId) throws Exception;		//删除员工信息，将状态设置为离职
	public void saveEmployee(List<Object> list) throws Exception;			//保存员工信息
	public PageInfo<Employee> searchEmployee(String msg,Integer pageNum,Integer pageSize) throws Exception; //搜索员工信息	
						
	public JSONArray getAllArea(int status) throws Exception;		//获取所有的区域信息
	/*
	 * 王培源
	 */
	public List<Employee> getEmployeeByList(List<Account> accountList) throws Exception;			//根据accountList里的员工工号查询员工信息
	public List<Employee> getEmployeeByName(String name) throws Exception;						//根据姓名查询员工id
	public List<Employee> getOneEmployeeByName(String name) throws Exception;					//根据姓名查询一个同名list
	
}
