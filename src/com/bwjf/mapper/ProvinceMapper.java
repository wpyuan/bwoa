package com.bwjf.mapper;

import java.util.List;

/**
 * @author 张恭雨
 * 创建时间：2017年11月3日 上午8:26:57
 * 类描述：省mapper接口类
 * 版本：v1.0 
 */
public interface ProvinceMapper {
	public	List<String> getAllName(int status) throws Exception;		//获取所有的相关信息
	public int getIdByName(String name) throws Exception;			//获取编码通过名字
	public String getNameById(int provinceId) throws Exception;		//通过id获取名字
}
