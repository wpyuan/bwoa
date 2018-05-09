package com.bwjf.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.bwjf.entity.Department;

/**
 * @author 张恭雨
 * 创建时间：2017年10月20日 下午3:55:07
 * 类描述：部门mapper接口
 * 版本：v1.0 
 */
public interface DepartmentMapper {
	public String getDepartmentNameById(int departmentId) throws Exception;		//获取部门名称通过ID
	public List<String> getNameByFiltrate(@Param("status")int status,@Param("departmentId")int departmentId) throws Exception;		//获取筛选条件下的部门名称
	public Integer getIdByName(String name) throws Exception;		//获取部门ID通过名字
	
	/*
	 * 王培源
	 */
	public List<Department> getAllDepartment() throws Exception;
	public void add(Department department) throws Exception;
	public Department getDepartmentByName(String name) throws Exception;
	public List<Department> getDepartmentByNameMH(String name) throws Exception; 
	public void delet(int departmentId) throws Exception;	
	public void update(Department department) throws Exception;	
	public Department getDepartmentById(int departmentId) throws Exception;
}
