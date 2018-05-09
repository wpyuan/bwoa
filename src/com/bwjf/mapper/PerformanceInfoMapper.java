package com.bwjf.mapper;


import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.bwjf.entity.PerformanceInfo;

import com.bwjf.entity.form.PerformanceForm;
import com.bwjf.entity.view.EquipmentView;

import com.bwjf.entity.view.ServiceView;
import com.bwjf.entity.view.TaxView;
/**
 * @author 张恭雨
 * 创建时间：2017年11月15日 上午8:19:36
 * 类描述：绩效信息实体
 * 版本：v1.0 
 */
public interface PerformanceInfoMapper {
	public void saveServiceChargeInfo(PerformanceInfo info) throws Exception;	//保存服务费信息
	
	/*
	 * @作者:张恭雨
	 * 
	 * @时间 : 2017年11月21日 下午4:31:03
	 * 
	 * @方法描述:保存税控盘信息
	 */
	public void saveTaxInfo(PerformanceInfo info)throws Exception;
	public void savaEscalationTaxInfo(PerformanceInfo info) throws Exception;	//保存报税盘信息
	
	
	/*
	 * @作者:王培源
	 * 
	 * @时间 : 2017年11月22日 
	 * 
	 * @方法描述:tab2设备销售记录录入
	 */
	public void eqmAdd(PerformanceInfo info)throws Exception; //设备销售记录录入
	
	/*
	 * @作者:张恭雨
	 * 
	 * @时间 : 2017年11月22日 下午7:27:56
	 * 
	 * @方法描述:
	 */
	public Integer getTaxNumByTime(@Param("startTime")String startTime,
			@Param("endTime")String endTime,@Param("employeeIds")List<Integer> employeeIds) throws Exception;		//获取所有税控盘的数量
	/*
	 * @作者:张恭雨
	 * 
	 * @时间 : 2017年11月24日 上午8:28:19
	 * 
	 * @方法描述:
	 */
	public Integer getServiceNumByTime(@Param("startTime")String startTime,
			@Param("endTime")String endTime,@Param("employeeIds")List<Integer> employeeIds) throws Exception;		//获取所有税控盘的数量

	public Integer getEscalationNumByTime(@Param("startTime")String startTime,
			@Param("endTime")String endTime,@Param("employeeIds")List<Integer> employeeIds) throws Exception;		//获取所有报税盘的数量
	
	public Integer getEquipmentNumByTime(@Param("startTime")String startTime,
			@Param("endTime")String endTime,@Param("employeeIds")List<Integer> employeeIds) throws Exception;		//获取所有报税盘的数量
	
	
	public List<String> getUUIDByCondition(@Param("startTime")String startTime,
			@Param("endTime")String endTime,@Param("employeeIds")List<Integer> employeeIds) throws Exception;		//获取UUID

	
	public List<EquipmentView> getEquipmentViewByCondition(@Param("startTime")String startTime,
			@Param("endTime")String endTime,@Param("employeeIds")List<Integer> employeeIds) throws Exception;		//获取各类型通用设备的数量
	
	public List<TaxView> getTaxViewByCondition(@Param("startTime")String startTime,
			@Param("endTime")String endTime,@Param("employeeIds")List<Integer> employeeIds) throws Exception;		//获取各类型税控盘的数量
	
	public List<ServiceView> getServiceViewByCondition(@Param("startTime")String startTime,
			@Param("endTime")String endTime,@Param("employeeIds")List<Integer> employeeIds) throws Exception;		//获取各类型服务费的数量
	
	public Integer getYearServiceNumByTime(@Param("startYear")String startYear,
			@Param("endYear")String endYear,
			@Param("employeeIds")List<Integer> employeeIds) throws Exception;		//获取年服务费收取的数量
	
	
	/*
	 * 张恭雨
	 * 2018-2-2
	 * 获取折线图数据信息
	 */
	public Integer getChartDateByTime(@Param("startTime")String startTime,
			@Param("endTime")String endTime,@Param("employeeIds")List<Integer> employeeIds) throws Exception;
	
	/*
	 * @作者:王培源
	 * 
	 * @时间 : 2017年11月28日 上午11:47:05
	 * 
	 * @方法描述:
	 */
	public PerformanceForm toAlter(String uuid)throws Exception;//修改界面数据显示
	public List<String> getToAlterEqmNum(String uuid)throws Exception;//修改界面设备销售数量显示
	public void deletPerformanceInfo(String uuid)throws Exception; //指定uuid 删除performanceInfo
	public String check(@Param("employeeId")int employeeId,@Param("dataDate")String dataDate)throws Exception;//检查是否有当天录入记录
	public Date getCreateDate(String uuid)throws Exception;//根据uuid获取绩效录入时间
	public PerformanceForm toAlterOnlyTaxdiscReplace(String uuid)throws Exception;//修改界面数据显示【只有税控盘更换】


}
