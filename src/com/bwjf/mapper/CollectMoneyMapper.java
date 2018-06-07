package com.bwjf.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;

import com.bwjf.entity.CollectMoney;

/**
 * @author 张恭雨
 * 创建时间：2017年11月15日 上午8:17:47
 * 类描述:收款信息mapper接口
 * 版本：v1.0 
 */
public interface CollectMoneyMapper {
	public void addCollectMoney(CollectMoney collectMoney) throws Exception;//金额记录录入 2017/11/22
	/*
	 * @作者:张恭雨
	 * 
	 * @时间 : 2017年11月24日 下午4:21:48
	 * 
	 * @方法描述:统计总金额,已转金额
	 */
	public double getTotalMoneyByUUID(@Param("uuids")List<String> uuids) throws Exception;
	public double getTotalMoneyByuuid(@Param("uuids")List<String> uuids) throws Exception;
	
	public double getTransferMoneyByUUID(@Param("uuids")List<String> uuids) throws Exception;
	public double getTransferMoneyByuuid(@Param("uuids")List<String> uuids) throws Exception;
	/*
	 * @作者:王培源
	 * 
	 * @时间 : 2017年11月28日 上午11:57:05
	 * 
	 * @方法描述:
	 */
	public void deletCollectmoney(String uuid)throws Exception; //指定uuid 删除collectmoney
}
