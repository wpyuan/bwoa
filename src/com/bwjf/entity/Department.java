package com.bwjf.entity;

/**
 * @author 张恭雨
 * 创建时间：2017-10-17 下午3:20:41
 * 类描述：部门信息实体类
 * 版本：v1.0 
 */
public class Department {
	private int departmentId;		//部门ID
	private String name;			//部门名称
	private int status;			//部门是否有效   1：有效，0无效
	public int getDepartmentId() {
		return departmentId;
	}
	public void setDepartmentId(int departmentId) {
		this.departmentId = departmentId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "Department [departmentId=" + departmentId + ", name=" + name + ", status=" + status + "]";
	}
	
	
	
}
