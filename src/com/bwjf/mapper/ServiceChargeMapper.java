package com.bwjf.mapper;

import org.apache.ibatis.annotations.Param;

import com.bwjf.entity.ServiceCharge;

/**
 * @author 张恭雨
 * 创建时间：2017年11月15日 上午8:15:38
 * 类描述：服务费mapper接口
 * 版本：v1.0 
 */
public interface ServiceChargeMapper {
	public int getIdByCondition(@Param("familyType")String familyType,
			@Param("plateType")String plateType) throws Exception;	//根据户型和盘型获取ID
	public ServiceCharge getServiceChargeById(int serviceChargeId) throws Exception;	//获取户型和盘型,价格
	/*
	 * @作者:张恭雨
	 * 
	 * @时间 : 2017年11月22日 上午8:19:56
	 * 
	 * @方法描述:获取服务价格
	 */
	public double getPriceByFamilyType(@Param("familyType")String familyType,
			@Param("plateType")String plateType) throws Exception;		//获取服务费信息
	
}
