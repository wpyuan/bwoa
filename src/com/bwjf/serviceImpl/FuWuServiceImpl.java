package com.bwjf.serviceImpl;


import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.annotation.Resource;

import net.sf.json.JSONArray;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bwjf.entity.Area;
import com.bwjf.entity.Ascc;
import com.bwjf.entity.view.AsccView;
import com.bwjf.mapper.AreaMapper;
import com.bwjf.mapper.AsccMapper;
import com.bwjf.service.FuWuService;

/**
 * @author 张恭雨
 * 创建时间：2017-12-8 上午10:21:27
 * 类描述：服务接口实现
 * 版本：v1.0 
 */
@Service
@Transactional
public class FuWuServiceImpl implements FuWuService{
	
	private AreaMapper areaMapper;
	private AsccMapper asccMapper;
	public AreaMapper getAreaMapper() {
		return areaMapper;
	}
	@Resource
	public void setAreaMapper(AreaMapper areaMapper) {
		this.areaMapper = areaMapper;
	}
	public AsccMapper getAsccMapper() {
		return asccMapper;
	}
	@Resource
	public void setAsccMapper(AsccMapper asccMapper) {
		this.asccMapper = asccMapper;
	}
	@Override
	public List<Area> getAreaNames(int status) throws Exception {
		//获取有效区域信息
		return areaMapper.getAreaByConditon(status, "部门");
	}
	@Override
	public String saveAscc(String str,String year,String accountId) throws Exception {
		//字符处理
		str=str.substring(0, str.length()-1);
		//字符分割
		String s[]=str.split("\\:");
		//数组遍历
		for(int i=0;i<s.length;i++){
			//判断奇数位
			if(i%2!=0){
				//判断是否填写了信息
				if(!s[i].equals("zero")){
					//防止数组越界
					if(i-1>=0||i-1<=s.length){
						//判断记录是否已经存在
						boolean falg=checkIsExist(Integer.parseInt(s[i-1]), year);
						if(falg==true)
							return "exist";
						//创建对象
						Ascc ascc=new Ascc();
						//初始化对象
						ascc.setAreaId(Integer.parseInt(s[i-1]));
						ascc.setCreateBy(accountId);
						ascc.setCreateDate(new Date());
						ascc.setHouseholdNumber(Integer.parseInt(s[i]));
						ascc.setYear(year);
						//保存对象
						asccMapper.saveAscc(ascc);
					}
				}
			}
		}
		return "success";
		
	}
	@Override
	public int getAreaIdByName(String name) throws Exception {
		// TODO Auto-generated method stub
		return areaMapper.getIdByName(name);
	}
	@Override
	public boolean checkIsExist(int areaId, String year) throws Exception {
		// TODO Auto-generated method stub
		//检查是否存在
		if(asccMapper.getNumberByYear(year, areaId)!=null){
			return true;
		}
		return false;
	}
	@Override
	public List<AsccView> getAsccViewByYear(String year) throws Exception {
		// TODO Auto-generated method stub
		return asccMapper.getAsccViewByYear(year);
	}
	
	/*
	 * 判断是否是纯数字
	 */
	private boolean isNumeric(String str){ 
		   Pattern pattern = Pattern.compile("[0-9]*"); 
		   Matcher isNum = pattern.matcher(str);
		   if(!isNum.matches() ){
		       return false; 
		   } 
		   return true; 
		}
	
	@Override
	public void updateAscc(int number,int asccId) throws Exception {
		// TODO Auto-generated method stub
		asccMapper.updateAscc(number,asccId);
	}
	@Override
	public void deleteById(int asccId) throws Exception {
		// TODO Auto-generated method stub
		asccMapper.deleteById(asccId);
	}
	@Override
	public JSONArray getAreaData(int status,String description) throws Exception {
		// 获取数据
		List<Area> areas=areaMapper.getAreaByConditon(1, description);
		//创建jsonArray对象
		JSONArray array=new JSONArray();
		array=JSONArray.fromObject(areas);		
		return array;
	}
	@Override
	public AsccView getFirstViewByYear(String year,int areaId) throws Exception {
		// TODO Auto-generated method stub
		return asccMapper.getFirstViewByYear(year, areaId);
	}

}
