package com.bwjf.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.bwjf.entity.view.PerformanceInfoSelectView;

/**
 * 创建时间：2017年11月24日
 */
public interface PerformanceInfoSelectViewMapper {
	public List<PerformanceInfoSelectView> search(@Param("startDate")String startDate,@Param("endDate")String endDate) throws Exception; //管理员查看绩效
	public List<PerformanceInfoSelectView> searchByAreaName(@Param("startDate")String startDate,@Param("endDate")String endDate,@Param("areaName")String areaName) throws Exception; //管理员根据地区查看绩效
	public List<PerformanceInfoSelectView> searchForEmployee(@Param("start")String start,@Param("end")String end,@Param("employeeId")int employeeId) throws Exception; //员工查看绩效
}
