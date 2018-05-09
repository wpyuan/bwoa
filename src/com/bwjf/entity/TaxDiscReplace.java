package com.bwjf.entity;

import java.util.Date;

/**
 * @author 张恭雨
 * 创建时间：2017年11月21日 上午11:18:14
 * 类描述：税控盘更换记录实体类
 * 版本：v1.0 
 */
public class TaxDiscReplace {
	private int TaxDiscReplaceId;		//税控盘更换编号（主键）
	private int replaceType;			//更换类型（有偿：1/免费：0）
	private double price;				//价格
	private int quantity;				//数量
	private int employeeId;				//员工编号（外键）
	private String uuid;				//收款标识
	private Date dataDate;				//数据日期
	private Date createTime;			//创建时间
	
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public Date getDataDate() {
		return dataDate;
	}
	public void setDataDate(Date dataDate) {
		this.dataDate = dataDate;
	}
	public int getTaxDiscReplaceId() {
		return TaxDiscReplaceId;
	}
	public void setTaxDiscReplaceId(int taxDiscReplaceId) {
		TaxDiscReplaceId = taxDiscReplaceId;
	}
	public int getReplaceType() {
		return replaceType;
	}
	public void setReplaceType(int replaceType) {
		this.replaceType = replaceType;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	public String getUuid() {
		return uuid;
	}
	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
	public int getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}
	
	
}
