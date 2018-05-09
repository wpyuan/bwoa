package com.bwjf.entity.view;

/**
 * @author 张恭雨
 * 创建时间：2017年11月28日 下午4:27:03
 * 类描述：查看通用设备详细信息视图类。
 * 版本：v1.0 
 */
public class EquipmentView {
	private int size;
	private int equipmentId;		//设备ID
	private Integer total;				//设备总数
	private String name;			//设备名称
	private double unitPrice;		//单价
	
	public int getEquipmentId() {
		return equipmentId;
	}
	public void setEquipmentId(int equipmentId) {
		this.equipmentId = equipmentId;
	}
	
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
	public Integer getTotal() {
		return total;
	}
	public void setTotal(Integer total) {
		this.total = total;
	}
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	
}
