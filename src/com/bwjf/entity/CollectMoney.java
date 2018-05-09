package com.bwjf.entity;

/**
 * @author 张恭雨
 * 创建时间：2017年11月14日 下午2:29:58
 * 类描述：收款信息实体类
 * 版本：v1.0 
 */
public class CollectMoney {
	private String uuid;		//唯一验证标识（主键）
	private double revenue;		//收入金额
	private double Transfer;	//转账
	public String getUuid() {
		return uuid;
	}
	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
	public double getRevenue() {
		return revenue;
	}
	public void setRevenue(double revenue) {
		this.revenue = revenue;
	}
	public double getTransfer() {
		return Transfer;
	}
	public void setTransfer(double transfer) {
		Transfer = transfer;
	}
		
}
