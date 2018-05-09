package com.bwjf.service;

import java.util.List;

import com.bwjf.entity.Account;
import com.bwjf.entity.AccountAreaEmployeeRoleView;
import com.bwjf.entity.Area;
import com.bwjf.entity.Employee;


/**
 * @author 张恭雨
 * 创建时间：2017年10月20日 下午3:59:53
 * 类描述：登录业务逻辑处理接口
 * 版本：v1.0 
 */
public interface AccountService {
	public Account getAcccountByConditions(String accountId,int status) throws Exception;	//条件查询获取帐户信息
	/*
	 * 王培源
	 */
	public List<Account> getAccountList(int page) throws Exception;											//获得当页所有账户
	public int getPage() throws Exception;													//获取总页码数	
	public List<Account> getAreaAccount(int areaId) throws Exception;										//获得区域内所有账户
	public List<Account> getAccountByEmployeeName(List<Employee> employeeAllList) throws Exception;			//根据employeeAllList集合的employeeId查询账户信息						
	public void UpdateRole(int employeeId,int roleId) throws Exception;					//根据工号修改用户角色id
	public void setPasswordById(Account account) throws Exception;//通过Id修改账号密码
	public List<Area> getAreaByEmployeeId(List<Employee> employeeList) throws Exception;  					//根据工号查询地区id
	public void areaChange(int employeeId,int areaId) throws Exception; //区域变更
	public List<AccountAreaEmployeeRoleView> getAAERVByEName(String EmployeeName)throws Exception;			//精确查找
}
