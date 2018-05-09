package com.bwjf.entity.view;

/**
 * @author 张恭雨
 * 创建时间：2017-12-8 下午2:35:33
 * 类描述：应收管理显示视图
 * 版本：v1.0 
 */
public class AsccView {
	private int asccId;
	private String year;
	private int householdNumber;
	private int areaId;
	private String createDate;
	private String createBy;
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	public int getHouseholdNumber() {
		return householdNumber;
	}
	public void setHouseholdNumber(int householdNumber) {
		this.householdNumber = householdNumber;
	}
	
	public String getCreateBy() {
		return createBy;
	}
	public void setCreateBy(String createBy) {
		this.createBy = createBy;
	}
	public String getCreateDate() {
		return createDate;
	}
	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}
	public int getAsccId() {
		return asccId;
	}
	public void setAsccId(int asccId) {
		this.asccId = asccId;
	}
	public int getAreaId() {
		return areaId;
	}
	public void setAreaId(int areaId) {
		this.areaId = areaId;
	}
	
	
}
