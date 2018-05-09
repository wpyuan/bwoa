package com.bwjf.mapper;

/**
 * @author 张恭雨
 * 创建时间：2017年11月21日 下午4:48:25
 * 类描述：报税盘mapper
 * 版本：v1.0 
 */
public interface EscalationTaxMapper {
	public int getIdByName(String name) throws Exception;		//根据名字获取ID
	/*
	 * @作者:张恭雨
	 * 
	 * @时间 : 2017年11月22日 上午8:30:10
	 * 
	 * @方法描述:获取报税盘价格
	 */
	public double getPriceByName(String name) throws Exception;	//获取报税盘价格
}
