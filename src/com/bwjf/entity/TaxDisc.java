package com.bwjf.entity;

/**
 * @author 张恭雨
 * 创建时间：2017年11月29日 上午8:55:12
 * 类描述：税控盘实体类
 * 版本：v1.0 
 */
public class TaxDisc {
	private int taxDiscId;
	private String userType;
	private String taxDiscType;
	private double price;
	
	public int getTaxDiscId() {
		return taxDiscId;
	}
	public void setTaxDiscId(int taxDiscId) {
		this.taxDiscId = taxDiscId;
	}
	public String getUserType() {
		return userType;
	}
	public void setUserType(String userType) {
		this.userType = userType;
	}
	public String getTaxDiscType() {
		return taxDiscType;
	}
	public void setTaxDiscType(String taxDiscType) {
		this.taxDiscType = taxDiscType;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	
	
}
