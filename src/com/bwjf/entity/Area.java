package com.bwjf.entity;

import java.util.Date;

/**
 * @author 张恭雨
 * 创建时间：2017-10-17 下午3:08:15
 * 类描述：区域树实体类
 * 版本：v1.0 
 */
public class Area {
	private int areaId;		//区域ID
	private	String name;	//区域名称
	private int parentId;	//父区域ID
	private int status;	//区域是否有效，1：有效，0无效。
	private String description;		//区域描述
	private int provinceId;			//省ID
	private int cityId;				//市ID	
	private Date createDate;		//创建时间
	private String createBy;		//创建人
	private Date updateDate;		//更新时间
	private String updateBy;		//更新人
	private int regionLevel;		//区域等级  省为一级，依次类推
	private int townsId;			//乡镇ID
	private String link;			//区域跳转链接
	public int getAreaId() {
		return areaId;
	}
	public void setAreaId(int areaId) {
		this.areaId = areaId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getParentId() {
		return parentId;
	}
	public void setParentId(int parentId) {
		this.parentId = parentId;
	}
	
	
	public int getProvinceId() {
		return provinceId;
	}
	public void setProvinceId(int provinceId) {
		this.provinceId = provinceId;
	}
	public int getCityId() {
		return cityId;
	}
	public void setCityId(int cityId) {
		this.cityId = cityId;
	}	
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public String getCreateBy() {
		return createBy;
	}
	public void setCreateBy(String createBy) {
		this.createBy = createBy;
	}
	public Date getUpdateDate() {
		return updateDate;
	}
	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}
	public String getUpdateBy() {
		return updateBy;
	}
	public void setUpdateBy(String updateBy) {
		this.updateBy = updateBy;
	}
	public int getRegionLevel() {
		return regionLevel;
	}
	public void setRegionLevel(int regionLevel) {
		this.regionLevel = regionLevel;
	}
	public int getTownsId() {
		return townsId;
	}
	public void setTownsId(int townsId) {
		this.townsId = townsId;
	}
	public String getLink() {
		return link;
	}
	public void setLink(String link) {
		this.link = link;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	
	
}
