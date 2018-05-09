package com.bwjf.service;

import java.util.List;

import net.sf.json.JSONArray;

import com.bwjf.entity.Area;
import com.bwjf.entity.Ascc;
import com.bwjf.entity.view.AsccView;




/**
 * @author 张恭雨
 * 创建时间：2017-12-8 上午10:19:53
 * 类描述：服务业务逻辑接口
 * 版本：v1.0 
 */
public interface FuWuService {
	
	public List<Area> getAreaNames(int status) throws Exception;		//获取显示区域信息
	public String saveAscc(String str,String year,String accountId) throws Exception;					//保存年服务费信息
	public int getAreaIdByName(String name) throws Exception;			//获取区域ID通过名字
	public boolean checkIsExist(int areaId,String year) throws Exception;		//检查该条记录是否存在
	public List<AsccView> getAsccViewByYear(String year) throws Exception;		//获取显示视图通过年份	
	public void updateAscc(int number,int asccId) throws Exception;							//更新信息
	public void deleteById(int asccId) throws Exception;						//删除信息
	//张恭雨 2018-1-3
	public JSONArray getAreaData(int status,String description) throws Exception;//获取区域树信息
	public AsccView getFirstViewByYear(String year,int areaId) throws Exception;	//单独获取总部记录
}
