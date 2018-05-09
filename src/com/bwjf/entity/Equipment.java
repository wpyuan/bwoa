package com.bwjf.entity;

/**
 * @author 张恭雨
 * 创建时间：2017年11月14日 下午2:19:33
 * 类描述：设备信息实体类
 * 版本：v1.0 
 */
public class Equipment {	
	private int equipmentId;		//设备编号（主键）
	private String name;			//设备名称
	private double unitPrice;		//单价
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getUnitPrice() {
		return unitPrice;
	}
	public void setUnitPrice(double unitPrice) {
		this.unitPrice = unitPrice;
	}
	public int getEquipmentId() {
		return equipmentId;
	}
	public void setEquipmentId(int equipmentId) {
		this.equipmentId = equipmentId;
	}
	
}
