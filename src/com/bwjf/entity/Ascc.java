package com.bwjf.entity;

import java.util.Date;

/**
 * @author 张恭雨
 * 创建时间：2017-12-4 上午9:15:46
 * 类描述：年服务费收取户数实体类
 * 版本：v1.0 
 */
public class Ascc {
	private int asccId;			//主键
	private String year;			//年份
	private int householdNumber;	//户数
	private Date createDate;		//创建时间
	private Date updateDate;		//更新时间
	private	String createBy;			//创建人（外键）
	private int areaId;				//所属区域（外键）
	
	public int getAsccId() {
		return asccId;
	}
	public void setAsccId(int asccId) {
		this.asccId = asccId;
	}
	
	public int getHouseholdNumber() {
		return householdNumber;
	}
	public void setHouseholdNumber(int householdNumber) {
		this.householdNumber = householdNumber;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public Date getUpdateDate() {
		return updateDate;
	}
	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}
	
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	public String getCreateBy() {
		return createBy;
	}
	public void setCreateBy(String createBy) {
		this.createBy = createBy;
	}
	public int getAreaId() {
		return areaId;
	}
	public void setAreaId(int areaId) {
		this.areaId = areaId;
	}
	
	
}
