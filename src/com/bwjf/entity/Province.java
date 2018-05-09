package com.bwjf.entity;

/**
 * @author 张恭雨
 * 创建时间：2017年11月3日 上午8:01:51
 * 类描述：省实体
 * 版本：v1.0 
 */
public class Province {
	private int privinceId;			//省编码
	private String name;			//省名称
	private int status;				//是否有效1：有效 0：无效
	public int getPrivinceId() {
		return privinceId;
	}
	public void setPrivinceId(int privinceId) {
		this.privinceId = privinceId;
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
