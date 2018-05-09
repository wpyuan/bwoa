package com.bwjf.entity;

import java.util.Date;

/**
 * @author 张恭雨
 * 创建时间：2017年11月14日 下午2:34:18
 * 类描述：绩效信息实体类
 * 版本：v1.0 
 */
public class PerformanceInfo {
	private int PerformanceInfoId;			//绩效信息编号（主键）
	private int employeeId;					//员工编号（外键）
	private int equipmentId;				//设备编号（外键）
	private int serviceChargeId;			//服务费编号（外键）
	private int quantity;					//数量
	private Date createDate;				//创建时间
	private Date updateDate;				//更新时间
	private int isInvoice;					//是否开具发票（1：是  0：否）
	private String uuid;					//收款标识（外键）
	private int	taxDiscId;					//税控盘编号（外键）
	private int escalationTaxId;			//报税盘编号（外键）
	private Date dataTime;					//数据时间。
	
	
	public int getTaxDiscId() {
		return taxDiscId;
	}
	public void setTaxDiscId(int taxDiscId) {
		this.taxDiscId = taxDiscId;
	}
	public int getEscalationTaxId() {
		return escalationTaxId;
	}
	public void setEscalationTaxId(int escalationTaxId) {
		this.escalationTaxId = escalationTaxId;
	}
	public Date getDataTime() {
		return dataTime;
	}
	public void setDataTime(Date dataTime) {
		this.dataTime = dataTime;
	}
	public int getPerformanceInfoId() {
		return PerformanceInfoId;
	}
	public void setPerformanceInfoId(int performanceInfoId) {
		PerformanceInfoId = performanceInfoId;
	}
	public int getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}
	public int getEquipmentId() {
		return equipmentId;
	}
	public void setEquipmentId(int equipmentId) {
		this.equipmentId = equipmentId;
	}
	public int getServiceChargeId() {
		return serviceChargeId;
	}
	public void setServiceChargeId(int serviceChargeId) {
		this.serviceChargeId = serviceChargeId;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public Date getUpdateDate() {
		return updateDate;
	}
	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}
	public int getIsInvoice() {
		return isInvoice;
	}
	public void setIsInvoice(int isInvoice) {
		this.isInvoice = isInvoice;
	}
	public String getUuid() {
		return uuid;
	}
	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
	
}
