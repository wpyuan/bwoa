package com.bwjf.mapper;

import java.util.List;



import com.bwjf.entity.Employee;

/**
 * @author 张恭雨
 * 创建时间：2017年10月20日 下午3:55:35
 * 类描述：员工mapper接口
 * 版本：v1.0 
 */
public interface EmployeeMapper {
	public String getNameById(int employeeId) throws Exception;		//获取员工的姓名
	public List<Employee> getEmployee() throws Exception;	//获取所有员工信息。
	public Employee getEmployeeDetailById(int employeeId) throws Exception;	//获取员工详细信息
	public int getDepartmentIdById(int employeeId) throws Exception;		//获取员工部门Id
	public void updateEmployeeById(Employee employee) throws Exception;		//更新用户信息
	public void deleteEmployeeById(int employeeId) throws Exception;		//删除员工信息，将状态设置为离职
	public void saveEmployee(Employee employee) throws Exception;			//保存员工信息
	public List<Employee> searchEmployeeByName(String name) throws Exception;		///搜索员工信息
	public List<Employee> searchEmployeeByJob(String nowJob) throws Exception;		///搜索员工信息
	public List<Employee> searchEmployeeByPhone(String phone) throws Exception;		///搜索员工信息
	public int getEmployeeIdByCard(String idCard) throws Exception;			//通过身份证号获取用户id
	/*
	 * 王培源
	 */
	public Employee getEmployeeById(int employeeId) throws Exception;
	public List<Employee> getEmployeeByName(String name) throws Exception;
	public List<Employee> getOneEmployeeByName(String name) throws Exception;	
	
}
