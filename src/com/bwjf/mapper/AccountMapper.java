package com.bwjf.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.bwjf.entity.Account;


/**
 * @author 张恭雨
 * 创建时间：2017年10月20日 下午12:02:10
 * 类描述：帐户mapper接口
 * 版本：v1.0 
 */
public interface AccountMapper {	
	public Account getAcccountByConditions(@Param("accountId")String accountId,@Param("status")int status) throws Exception;	//条件查询获取帐户信息
	public void deleteAccountByEmployeeId(int employeeId) throws Exception;		//更新员工帐户状态为0
	public void saveAccount(Account account) throws Exception;		//保存帐户信息
	/*
	 * 王培源
	 */
	public Account getAccountByEmployeeId(int employeeId) throws Exception;		//获取帐户信息通过员工ID
	public List<Account> getAccountList(int start) throws Exception;						//获取当页所有账户
	public int getPage() throws Exception;	
	public List<Account> getAreaAccount(int areaId) throws Exception;		  //获得区域内所有账户
	
	public void UpdateRole(@Param("employeeId")int employeeId,@Param("roleId")int roleId) throws Exception;					//根据工号修改用户角色
	public void setPasswordById(Account account) throws Exception;//通过Id修改账号密码
	public int getAreaByEmployeeId(int employeeId) throws Exception;
	public void areaChange(@Param("employeeId")int employeeId, @Param("areaId")int areaId) throws Exception;
	public void updateRoleId(int roleId) throws Exception;  					//改角色为默认角色
	
	/*
	 * @作者:张恭雨
	 * 
	 * @时间 : 2017年11月24日 上午9:42:07
	 * 
	 * @方法描述:通过区域id获取员工ID
	 * 
	 */
	public List<Integer> getEmployeeIdByAreaId(@Param("areaIds")List<Integer> areaIds) throws Exception;		//通过区域ID获取员工信息
	/*
	 * @作者:张恭雨
	 * 
	 * @时间 : 2017年12月1日 上午10:10:53
	 * 
	 * @方法描述:通过员工编号更新状态信息
	 * 
	 */
	public void updateStatusByEmployeeId(
			@Param("employeeId")int employeeId,@Param("status")int status) throws Exception;
}
