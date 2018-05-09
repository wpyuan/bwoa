package com.bwjf.entity.view;

/**
 * @author 张恭雨
 * 创建时间：2017年11月29日 上午8:22:13
 * 类描述：税控盘详细信息显示视图
 * 版本：v1.0 
 */
public class TaxView {
	private int taxDiscId;
	private String userType;
	private String taxDiscType;
	private double price;
	private Integer total;		//总数
	
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
	public Integer getTotal() {
		return total;
	}
	public void setTotal(Integer total) {
		this.total = total;
	}
	
	
}
