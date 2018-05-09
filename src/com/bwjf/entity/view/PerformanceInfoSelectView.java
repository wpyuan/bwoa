package com.bwjf.entity.view;



public class PerformanceInfoSelectView {
	private String dataDate;			//数据日期
	private String areaName;				//地区
	private String employeeName;			//员工姓名
	private int newSum;						//新户售盘数量
	private int serviceSum;						//老户服务费户数
	private int bspSum;						//报税盘数量
	private int changeSum;						//税控盘更换总数 （包含有偿、免费）
	private int eqmSum;						//通用设备销售数量
	private double revenue;					//收入金额
	private double transfer;				//转账
	private String uuid;					//收款唯一标识
	
	public String getDataDate() {
		return dataDate;
	}

	public void setDataDate(String dataDate) {
		dataDate = dataDate.substring(0,10);//截取字符串，不需要时间部分
		this.dataDate = dataDate;		
	}

	public String getAreaName() {
		return areaName;
	}

	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public int getNewSum() {
		return newSum;
	}

	public void setNewSum(int newSum) {
		this.newSum = newSum;
	}

	public int getServiceSum() {
		return serviceSum;
	}

	public void setServiceSum(int serviceSum) {
		this.serviceSum = serviceSum;
	}

	public int getBspSum() {
		return bspSum;
	}

	public void setBspSum(int bspSum) {
		this.bspSum = bspSum;
	}

	public int getChangeSum() {
		return changeSum;
	}

	public void setChangeSum(int changeSum) {
		this.changeSum = changeSum;
	}

	public int getEqmSum() {
		return eqmSum;
	}

	public void setEqmSum(int eqmSum) {
		this.eqmSum = eqmSum;
	}

	public double getRevenue() {
		return revenue;
	}

	public void setRevenue(double revenue) {
		this.revenue = revenue;
	}

	public double getTransfer() {
		return transfer;
	}

	public void setTransfer(double transfer) {
		this.transfer = transfer;
	}

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public PerformanceInfoSelectView() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
