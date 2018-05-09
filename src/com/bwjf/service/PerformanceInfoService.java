package com.bwjf.service;


import java.util.Date;
import java.util.List;

import com.bwjf.entity.Account;
import com.bwjf.entity.Equipment;
import com.bwjf.entity.PerformanceInfo;
import com.bwjf.entity.Role;
import com.bwjf.entity.form.PerformanceForm;
import com.bwjf.entity.form.TaxForm;
import com.bwjf.entity.view.PerformanceInfoSelectView;
import com.bwjf.entity.view.ServiceView;
import com.bwjf.entity.view.StatisticalView;
import com.bwjf.entity.view.EquipmentView;
import com.bwjf.entity.view.TaxView;

import net.sf.json.JSONArray;

/**
 * @author 张恭雨
 * 创建时间：2017年11月15日 上午8:25:15
 * 类描述：绩效信息service接口，
 * 版本：v1.0 
 */
public interface PerformanceInfoService {
	public List<Equipment> getAllEquipmentName() throws Exception;			//获取所有设备的名称 //2017/11/20修改
	/*
	 * @作者:张恭雨
	 * 
	 * @时间 : 2017年11月21日 下午6:26:36
	 * 
	 * @方法描述:
	 */
	public void saveTaxInfo(PerformanceInfo info,TaxForm form) throws Exception;							//保存盘信息
	public double getPriceByType(String type) throws Exception;		//通过类型获取该类型的价格信息
	
	/*
	 * @作者:张恭雨
	 * 
	 * @时间 : 2017年11月22日 下午7:32:11
	 * 
	 * @方法描述:
	 */
	public JSONArray getAreaData(int status,String description) throws Exception;		//获取区域数据
	public StatisticalView getStatisticsInfo(int areaId,String startTime,String endTime) throws Exception;

	/*
	 * @作者:王培源
	 * 
	 * @时间 : 2017年11月24日 上午9:37:00
	 * 
	 * @方法描述:
	 */
	public String addCollectMoney(String ZXS,String YZZ,String createDate) throws Exception; //添加金额记录
	public List<PerformanceInfoSelectView> search(String startDate,String endDate,Account account,String employeeName) throws Exception;//绩效按时间/人员查询
	
	/*
	 * @作者:张恭雨
	 * 
	 * @时间 : 2017年11月27日 上午11:13:02
	 * 
	 * @方法描述:树节点展开时数据加载
	 * 
	 */
	public List<StatisticalView> getUnfurledData(int areaId,String startTime,String endTime) throws Exception;
	public List<EquipmentView> getEquipmentDetail(int areaId,String startTime,String endTime) throws Exception;		//获取设备记录的详细信息
	public List<TaxView> getTaxDetail(int areaId,String startTime,String endTime) throws Exception;		//获取税控盘记录的详细信息
	public List<ServiceView> getServiceDetail(int areaId,String startTime,String endTime) throws Exception;		//获取服务费记录的详细信息
	/*
	 * @作者:王培源
	 * 
	 * @时间 : 2017年11月28日 上午11:43:26
	 * 
	 * @方法描述:
	 */
	public PerformanceForm toAlter(String uuid) throws Exception;//修改界面数据显示
	public List<String> getToAlterEqmNum(String uuid)throws Exception;//修改界面设备销售数量显示
	public void delet(String uuid) throws Exception;//指定uuid删除
	public int check(int employeeId,String dataDate)throws Exception;//检查是否有当天录入记录
	/*
	 * @作者:王培源
	 * 
	 * @时间 : 2017年12月4日 上午9：26
	 * 
	 * @方法描述:
	 */
	public List<PerformanceInfoSelectView> searchByAreaName(Account account,Role role,String startDate,String endDate,String areaName) throws Exception;//【技服/管理员】绩效按【时间/人员/区域】查询
	public Date getCreateDate(String uuid)throws Exception;//根据uuid获取绩效创建时间 
	
	/*
	 * 张恭雨
	 * 2018-2-2
	 * 获取图表信息
	 */
	
	public List<Integer> getChartDate(String year,String month,String day,String areaName)throws Exception;
	
}
