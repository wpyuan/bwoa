package com.bwjf.mapper;

import java.util.List;


/**
 * @author 张恭雨
 * 创建时间：2017年11月3日 上午9:15:15
 * 类描述：城镇mapper接口
 * 版本：v1.0 
 */
public interface TownMapper {
	public List<String> getAllName(int status) throws Exception;		//获取所有乡镇的ID
	public int getIdByName(String name) throws Exception;			//获取编码通过名字
	public String getNameById(int townId) throws Exception;		//通过id获取名字
}
