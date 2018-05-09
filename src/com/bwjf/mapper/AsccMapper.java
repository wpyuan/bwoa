package com.bwjf.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.bwjf.entity.Ascc;
import com.bwjf.entity.view.AsccView;


/**
 * @author 张恭雨
 * 创建时间：2017-12-4 上午9:21:19
 * 类描述：mapper接口
 * 版本：v1.0 
 */
public interface AsccMapper {
	public Integer getNumberByYear(@Param("year")String year,@Param("areaId")int areaId) throws Exception;		//通过年份获取年户数，
	public void saveAscc(Ascc ascc) throws Exception;			//保存年应收服务费信息。
	public List<AsccView> getAsccViewByYear(String year) throws Exception;		//获取显示视图通过年份
	public Ascc getAsccById(int asccId) throws Exception;		//获取修改信息
	public void updateAscc(@Param("number")int number,@Param("asccId")int asccId) throws Exception;		//更新信息
	public void deleteById(int asccId)throws Exception;		//删除信息
	
	//2018-1-3
	public AsccView getFirstViewByYear(@Param("year")String year,
			@Param("areaId")int areaId) throws Exception;		//获取总部记录信息
	
}
