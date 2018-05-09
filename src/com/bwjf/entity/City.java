package com.bwjf.entity;

/**
 * @author 张恭雨
 * 创建时间：2017年11月3日 上午8:03:10
 * 类描述：城市实体类
 * 版本：v1.0 
 */
public class City {
	private int cityId;			//城市编码
	private String name;		//城市名称
	private int status;				//是否有效1：有效 0：无效
	public int getCityId() {
		return cityId;
	}
	public void setCityId(int cityId) {
		this.cityId = cityId;
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
	
	
}
