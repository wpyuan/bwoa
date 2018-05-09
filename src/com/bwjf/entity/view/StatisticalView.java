package com.bwjf.entity.view;

/**
 * @author 张恭雨
 * 创建时间：2017年11月24日 上午8:12:30
 * 类描述：统计显示视图实体类
 * 版本：v1.0 
 */
public class StatisticalView {
	private int taxNumber;			//售盘数量
	private int serviceNumber;		//服务费数量
	private String percent;				//所占年比率
	private int escalationNumber;	//报税盘数量
	private int equipmentNumber;	//通用设备数量
	private int freeReplacementNumber;	//税控盘免费更换
	private int replacementNumber;		//税控盘有偿更换数量
	private double totalSalesAmount;	//总销售金额
	private double hasHandIn;			//已上交
	private double notPay;				//未上交
	private int areaId;					//该条记录所属区域ID
	private  int level;
	
	public int getTaxNumber() {
		return taxNumber;
	}
	public void setTaxNumber(int taxNumber) {
		this.taxNumber = taxNumber;
	}
	public int getServiceNumber() {
		return serviceNumber;
	}
	public void setServiceNumber(int serviceNumber) {
		this.serviceNumber = serviceNumber;
	}
	public int getEscalationNumber() {
		return escalationNumber;
	}
	public void setEscalationNumber(int escalationNumber) {
		this.escalationNumber = escalationNumber;
	}
	public int getEquipmentNumber() {
		return equipmentNumber;
	}
	public void setEquipmentNumber(int equipmentNumber) {
		this.equipmentNumber = equipmentNumber;
	}
	public int getFreeReplacementNumber() {
		return freeReplacementNumber;
	}
	public void setFreeReplacementNumber(int freeReplacementNumber) {
		this.freeReplacementNumber = freeReplacementNumber;
	}
	public int getReplacementNumber() {
		return replacementNumber;
	}
	public void setReplacementNumber(int replacementNumber) {
		this.replacementNumber = replacementNumber;
	}
	public double getTotalSalesAmount() {
		return totalSalesAmount;
	}
	public void setTotalSalesAmount(double totalSalesAmount) {
		this.totalSalesAmount = totalSalesAmount;
	}
	public double getHasHandIn() {
		return hasHandIn;
	}
	public void setHasHandIn(double hasHandIn) {
		this.hasHandIn = hasHandIn;
	}
	public double getNotPay() {
		return notPay;
	}
	public void setNotPay(double notPay) {
		this.notPay = notPay;
	}
	public int getAreaId() {
		return areaId;
	}
	public void setAreaId(int areaId) {
		this.areaId = areaId;
	}
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}
	public String getPercent() {
		return percent;
	}
	public void setPercent(String percent) {
		this.percent = percent;
	}
	
	
}
