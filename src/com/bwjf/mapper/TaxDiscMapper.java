package com.bwjf.mapper;

import org.apache.ibatis.annotations.Param;

import com.bwjf.entity.TaxDisc;

/**
 * @author 张恭雨
 * 创建时间：2017年11月21日 下午4:14:01
 * 类描述：税控盘mapper
 * 版本：v1.0 
 */
public interface TaxDiscMapper {
	public int getIdByCondition(@Param("userType")String userType,@Param("taxDiscType")String taxDiscType) throws Exception;		//通过用户类型和户型获取ID
	/*
	 * @作者:张恭雨
	 * 
	 * @时间 : 2017年11月22日 上午8:12:04
	 * 
	 * @方法描述:条件查询价格
	 */
	public double getPriceByCondition(@Param("userType")String userType,@Param("taxDiscType")String taxDiscType) throws Exception;	//条件查询价格
	/*
	 * @作者:张恭雨
	 * 
	 * @时间 : 2017年11月29日 上午8:53:09
	 * 
	 * @方法描述:通过id获取价格和类型，
	 */
	public TaxDisc getTaxDiscById(int taxDiscId) throws Exception;
}
