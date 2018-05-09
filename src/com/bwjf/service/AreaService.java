package com.bwjf.service;

import java.util.List;

import net.sf.json.JSONArray;



import com.bwjf.entity.Account;
import com.bwjf.entity.Area;

/**
 * @author 张恭雨
 * 创建时间：2017年10月20日 下午3:59:53
 * 类描述：area业务层接口
 * 版本：v1.0 
 */
public interface AreaService {
	public List<Area> getAllArea(int status) throws Exception;			//查询所有区域信息
	public void deleteById(int areaId) throws Exception;			//删除区域根据ID
	public void updateById(int status,int areaId) throws Exception;		//更新节点是否有效信息
	public List<Object> getAreaById(int areaId) throws Exception;					//查询区域的详细信息
	public String getNameById(int areaId) throws Exception;				//获取区域名称
	public void saveArea(List<Object> list) throws Exception;					//保存区域信息
	public void updateArea(List<Object> list) throws Exception;					//更新区域信息
	public	JSONArray getAllProvinceName(int status) throws Exception;			//获取所有省的名称
	public	JSONArray getAllCityName(int status) throws Exception;			//获取所有城市的名称
	public	JSONArray getAllTownName(int status) throws Exception;			//获取所有乡镇的名称	
	public int getCountByName(String name) throws Exception;				//获取指定名称的记录数
	public int getCityIdByName(String name) throws Exception;				//通过名称获取城市id
	public JSONArray getNamesByCondition(String num) throws Exception;	//条件查询城镇信息
	public void updateStatusById(int status,int areaId) throws Exception;	//更新区域状态
	public int getIdByName(String name) throws Exception;		//获取区域id通过名称
	/*
	 * 王培源
	 */
	public List<Area> getChooseArea(List<Account> accountAllList) throws Exception;
	public Area getAreaByIdOne(int areaId) throws Exception;
}
