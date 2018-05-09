package com.bwjf.mapper;

import java.util.List;


import com.bwjf.entity.AccountAreaEmployeeRoleView;


/**
 * @author 王培源
 * @创建时间：2017年11月3日 @类描述：AccountAreaEmployeeRoleView视图Mapper
 */
public interface AccountAreaEmployeeRoleViewMapper {
	public List<AccountAreaEmployeeRoleView> getAccountAreaEmployeeRoleView() throws Exception;

	public List<AccountAreaEmployeeRoleView> getAccountAreaEmployeeRoleViewByEmployeeName(String employeeName)
			throws Exception;

	public List<AccountAreaEmployeeRoleView> getAccountAreaEmployeeRoleViewByAreaId(int areaId) throws Exception;
	
	public List<AccountAreaEmployeeRoleView> getAAERVByEName(String employeeName) throws Exception; //精确查找
}
