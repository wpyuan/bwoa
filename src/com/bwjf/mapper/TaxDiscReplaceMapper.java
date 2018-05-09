package com.bwjf.mapper;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.bwjf.entity.TaxDiscReplace;


/**
 * @author 张恭雨
 * 创建时间：2017年11月21日 上午11:39:57
 * 类描述：税控盘更换记录实体类
 * 版本：v1.0 
 */
public interface TaxDiscReplaceMapper {
	/*
	 * @作者:张恭雨
	 * 
	 * @时间 : 2017年11月21日 下午5:16:51
	 * 
	 * @方法描述:
	 */
	public void saveTaxDiscReplace(TaxDiscReplace taxDiscReplace) throws Exception;	//保存更换信息
	//2017-11-24获取更换的税控盘数量
	public Integer getReplaceNumByTime(@Param("startTime")String startTime,
			@Param("endTime")String endTime,@Param("employeeIds")List<Integer> employeeIds,
			@Param("replaceType")int replaceType) throws Exception;
	
	public List<String> getUUIDByCondition(@Param("startTime")String startTime,
			@Param("endTime")String endTime,@Param("employeeIds")List<Integer> employeeIds) throws Exception;		//获取UUID

	/*
	 * @作者:王培源
	 * 
	 * @时间 : 2017年11月28日 上午11:55:59
	 * 
	 * @方法描述:
	 */
	public void deletTaxdiscreplace(String uuid)throws Exception; //指定uuid 删除taxdiscreplace
	public Date getCreateDate(String uuid)throws Exception; //指定uuid 获取绩效创建时间
}
