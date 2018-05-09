package com.bwjf.entity;

/**
 * @author 张恭雨
 * 创建时间：2017年11月3日 上午8:05:00
 * 类描述：城镇实体类
 * 版本：v1.0 
 */
public class Town {
	private int townId;			//城镇编码	
	private String name;		//城镇名称
	private int status;				//是否有效1：有效 0：无效
	
	public int getTownId() {
		return townId;
	}
	public void setTownId(int townId) {
		this.townId = townId;
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
