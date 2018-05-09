package com.bwjf.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bwjf.entity.Account;
import com.bwjf.entity.AccountAreaEmployeeRoleView;
import com.bwjf.entity.Area;
import com.bwjf.entity.Employee;
import com.bwjf.mapper.AccountAreaEmployeeRoleViewMapper;
import com.bwjf.mapper.AccountMapper;
import com.bwjf.service.AccountService;

/**
 * @author 张恭雨
 * 创建时间：2017年10月20日 下午4:02:29
 * 类描述：登录业务逻辑实现
 * 版本：v1.0 
 */
@Service
@Transactional
public class AccountServiceImpl implements AccountService {
	private AccountMapper accountMapper;
	private AccountAreaEmployeeRoleViewMapper accountAreaEmployeeRoleViewMapper;
	
	public AccountAreaEmployeeRoleViewMapper getAccountAreaEmployeeRoleViewMapper() {
		return accountAreaEmployeeRoleViewMapper;
	}
	@Resource
	public void setAccountAreaEmployeeRoleViewMapper(AccountAreaEmployeeRoleViewMapper accountAreaEmployeeRoleViewMapper) {
		this.accountAreaEmployeeRoleViewMapper = accountAreaEmployeeRoleViewMapper;
	}
	public AccountMapper getAccountMapper() {
		return accountMapper;
	}
	@Resource
	public void setAccountMapper(AccountMapper accountMapper) {
		this.accountMapper = accountMapper;
	}

	@Override
	public Account getAcccountByConditions(String accountId, int status)
			throws Exception {
		//调用mapper方法查询账户信息
		return accountMapper.getAcccountByConditions(accountId, status);
	}
	//----------------------------------------------------------
	/*
	 *王培源
	 */
	@Override
	public List<Account> getAccountList(int page) throws Exception {
		System.out.println("---AccountServiceImpl.getAccountList("+page+")---");
		int start = page*10;
		System.out.println("start:"+start);
		
		List<Account> accountList =	accountMapper.getAccountList(start);
		
		return accountList;
	}
	
	@Override
	public int getPage() throws Exception{
		int num = accountMapper.getPage();
		if (num % 20 != 0) {
			num = num / 20 + 1;
		} else
			num = num / 20;
		return num;
	}
	@Override
	public List<Account> getAreaAccount(int areaId) throws Exception{
		System.out.println("---AccountServiceImpl.getAreaAccount(areaId:"+areaId+")---");	
		return accountMapper.getAreaAccount(areaId);
	}
	@Override
	public List<Account> getAccountByEmployeeName(List<Employee> employeeAllList) throws Exception{
		System.out.println("---AccountServiceImpl.getAccountByEmployeeName(List<Employee> employeeAllList)---");
//		System.out.println("employeeAllList:");
//		for (Employee employee : employeeAllList) {
//			System.out.println(employee.getEmployeeId());
//		}
		
		List<Account> accounts = new ArrayList<>();
		Account account=null;		
		
		for (Employee employee : employeeAllList) {
			account = new Account();
			account = accountMapper.getAccountByEmployeeId(employee.getEmployeeId());
			accounts.add(account);
		}
//		System.out.println("--- accounts:---");
//		for (Account a : accounts) {
//			System.out.println(a.getEmployeeId());
//		}
		return accounts;
	}
	@Override
	public void UpdateRole(int employeeId, int roleId) throws Exception{
		
		accountMapper.UpdateRole(employeeId, roleId);
		
	}
	@Override
	public void setPasswordById(Account account) throws Exception{
		accountMapper.setPasswordById(account);
		
	}
	@Override
	public List<Area> getAreaByEmployeeId(List<Employee> employeeList) throws Exception{
		for (Employee employee : employeeList) {
			System.out.println(">>"+employee.getEmployeeId());
		}
		Area area = null;
		List<Area> areas = new ArrayList<>();
		int areaId;
		for (Employee employee : employeeList) {
			System.out.println("···"+employee.getEmployeeId());
			area = new Area();
			areaId = accountMapper.getAreaByEmployeeId(employee.getEmployeeId());
			area.setAreaId(areaId);
			
			areas.add(area);
		}	
		return areas;
	}
	@Override
	public void areaChange(int employeeId, int areaId) throws Exception {
		System.out.println("---AccountServiceImpl.areaChange(employeeId:"+employeeId+",areaId:"+areaId+")---");
		accountMapper.areaChange(employeeId, areaId);
	}
	@Override
	public List<AccountAreaEmployeeRoleView> getAAERVByEName(String EmployeeName) throws Exception {
		System.out.println("---AccountServiceImpl.getAAERVByEName(EmployeeName:"+EmployeeName+")---");
		return accountAreaEmployeeRoleViewMapper.getAAERVByEName(EmployeeName);
	}

}
