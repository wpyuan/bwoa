package com.bwjf.entity;

/**
 * @author 张恭雨
 * 创建时间：2017年11月14日 下午2:24:36
 * 类描述：服务费信息实体类
 * 版本：v1.0 
 */
public class ServiceCharge {
	private int serviceChargeId;		//服务费编号（主键）
	private String familyType;			//户型
	private String plateType;			//盘型
	private double price;				//价格
	
	public int getServiceChargeId() {
		return serviceChargeId;
	}
	public void setServiceChargeId(int serviceChargeId) {
		this.serviceChargeId = serviceChargeId;
	}
	public String getFamilyType() {
		return familyType;
	}
	public void setFamilyType(String familyType) {
		this.familyType = familyType;
	}
	public String getPlateType() {
		return plateType;
	}
	public void setPlateType(String plateType) {
		this.plateType = plateType;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	
	
}
