package com.bwjf.service;


import java.util.List;

import com.bwjf.entity.Account;
import com.bwjf.entity.Equipment;





/**
 * @作者 王培源
 * 创建时间：2017年11月21日 
 */
public interface EqmAddService {
	public void add(Account account,List<Equipment> eqmNoList,String[] num,String createDate,String dataTime,String UUID) throws Exception; //录入设备销售记录
}
