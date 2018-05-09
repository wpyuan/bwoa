package com.bwjf.mapper;

import java.util.List;

/**
 * @author 张恭雨
 * 创建时间：2017年11月3日 上午9:00:49
 * 类描述：城市mapper接口
 * 版本：v1.0 
 */
public interface CityMapper {
	public List<String> getAllName(int status) throws Exception;		//获取所有城市的ID
	public int getIdByName(String name) throws Exception;			//获取编码通过名字
	public String getNameById(int cityId) throws Exception;		//通过id获取名字
	public List<String> getNamesByCondition(String num) throws Exception;	//条件查询城镇信息
}