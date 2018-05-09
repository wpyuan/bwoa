package com.bwjf.serviceImpl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import net.sf.json.JSONArray;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bwjf.entity.Account;
import com.bwjf.entity.Area;
import com.bwjf.mapper.AreaMapper;
import com.bwjf.mapper.CityMapper;
import com.bwjf.mapper.ProvinceMapper;
import com.bwjf.mapper.TownMapper;
import com.bwjf.service.AreaService;

/**
 * @author 张恭雨
 * 创建时间：2017年10月20日 下午4:03:07
 * 类描述：
 * 版本：v1.0 
 */
@Service
@Transactional
public class AreaServiceImpl implements AreaService {
	
	
	private AreaMapper areaMapper;
	private ProvinceMapper provinceMapper;
	private CityMapper cityMapper;
	private TownMapper townMapper;	
	public AreaMapper getAreaMapper() {
		return areaMapper;
	}
	@Resource
	public void setAreaMapper(AreaMapper areaMapper) {
		this.areaMapper = areaMapper;
	}
	
	public ProvinceMapper getProvinceMapper() {
		return provinceMapper;
	}
	@Resource
	public void setProvinceMapper(ProvinceMapper provinceMapper) {
		this.provinceMapper = provinceMapper;
	}

	public CityMapper getCityMapper() {
		return cityMapper;
	}
	@Resource
	public void setCityMapper(CityMapper cityMapper) {
		this.cityMapper = cityMapper;
	}
	public TownMapper getTownMapper() {
		return townMapper;
	}
	@Resource
	public void setTownMapper(TownMapper townMapper) {
		this.townMapper = townMapper;
	}
	
	@Override
	public List<Area> getAllArea(int status) throws Exception {
		//查询所有的区域信息
		return areaMapper.getAllArea(status);
	}
	@Override
	public void deleteById(int areaId) throws Exception{
		//删除区域信息
		areaMapper.deleteById(areaId);
	}
	@Override
	public void updateById(int status, int areaId) throws Exception {
		//更新状态信息,以及所有的子节点状态
		areaMapper.updateById(status, areaId);
		//获取所有的子节点的ID
		List<Integer> areas=areaMapper.getAreaByParentId(areaId);
		//判断集合是否为空
		if(areas==null){
			return;
		}
		//更新所有的子节点
		for(Integer i:areas){
			areaMapper.updateById(status, i);
		}
		
	}
	@Override
	public List<Object> getAreaById(int areaId) throws Exception {
		//获取区域的详细信息
		Area area=areaMapper.getAreaById(areaId);
		//获取地区信息
		String provinceName=provinceMapper.getNameById(area.getProvinceId());
		String cityName=cityMapper.getNameById(area.getCityId());
		String townName=townMapper.getNameById(area.getTownsId());		
		
		//创建一个list集合
		List<Object> list=new ArrayList<Object>();
		list.add(area);
		list.add(provinceName);
		list.add(cityName);
		list.add(townName);		
		
		return list;
	}
	@Override
	public String getNameById(int areaId) throws Exception {
		//获取区域名称
		return areaMapper.getNameById(areaId);
	}
	@Override
	public void saveArea(List<Object> list) throws Exception {
		//获取集合中的信息
		Area area=(Area) list.get(0);
		String provinceName=(String) list.get(1);
		String cityName=(String) list.get(2);
		String townName=(String) list.get(3);		
		//设置area信息
		if(!"".equals(provinceName)){
			area.setProvinceId(provinceMapper.getIdByName(provinceName));
		}
		if(!"".equals(cityName))
		{
			area.setCityId(cityMapper.getIdByName(cityName));
		}
		if(!"".equals(townName)){
			area.setTownsId(townMapper.getIdByName(townName));
		}	
		//设置状态为1
		area.setStatus(1);
		//设置创建时间
		area.setCreateDate(new Date());
		//保存区域信息
		areaMapper.saveArea(area);
		
		//获取保存之后的区域id
		int areaId=areaMapper.getIdByName(area.getName());
		String link="area/detail.do?areaId="+areaId;
		//更新区域链接
		areaMapper.updateLinkById(link, areaId);
		
	}
	@Override
	public void updateArea(List<Object> list) throws Exception {
		//获取集合中的信息
		Area area=(Area) list.get(0);
		String provinceName=(String) list.get(1);
		String cityName=(String) list.get(2);
		String townName=(String) list.get(3);		
		//设置area信息
		if(!"".equals(provinceName)){
			area.setProvinceId(provinceMapper.getIdByName(provinceName));
		}
		if(!"".equals(cityName))
		{
			area.setCityId(cityMapper.getIdByName(cityName));
		}
		if(!"".equals(townName)){
			area.setTownsId(townMapper.getIdByName(townName));
		}
		//更新区域信息
		areaMapper.updateArea(area);
		
	}
	//-------------------------------------------------------------
	/*
	 * 王培源
	 */
	@Override
	public List<Area> getChooseArea(List<Account> accountAllList)  {
		System.out.println("---AreaServiceImpl.getChooseArea(List<Account> accountAllList)---");
		List<Area> areaAllList = new ArrayList<>();
		Area area = null;
		for (Account account : accountAllList) {
			area = new Area();
			try {
				area = areaMapper.getAreaById(account.getAreaId());
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("---AreaServiceImpl.getChooseArea()调用AreaMapper.getAreaById发生异常---");
			}
			areaAllList.add(area);
		}
		return areaAllList;
	}
	@Override
	public JSONArray getAllProvinceName(int status) throws Exception {
		//获取所有省的名称的集合
		List<String> names=provinceMapper.getAllName(status);
		//创建jsonarray对象
		JSONArray array=new JSONArray();
		//将数据转换成jsonarray格式
		array=JSONArray.fromObject(names);
		return array;
	}
	@Override
	public JSONArray getAllCityName(int status) throws Exception {
		//获取所有城市的集合
		List<String> names=cityMapper.getAllName(status);
		//创建jsonarray对象
		JSONArray array=new JSONArray();
		//将数据转换成jsonarray格式
		array=JSONArray.fromObject(names);
		return array;
	}
	@Override
	public JSONArray getAllTownName(int status) throws Exception {
		//获取所有城市的集合
		List<String> names=townMapper.getAllName(status);
		//创建jsonarray对象
		JSONArray array=new JSONArray();
		//将数据转换成jsonarray格式
		array=JSONArray.fromObject(names);
		return array;
	}
	
	@Override
	public int getCountByName(String name) throws Exception {
	
		return areaMapper.getCountByName(name);
	}
	@Override
	public Area getAreaByIdOne(int areaId) throws Exception {
		
		return areaMapper.getAreaById(areaId);
	}
	@Override
	public int getCityIdByName(String name) throws Exception {
		// TODO Auto-generated method stub
		return cityMapper.getIdByName(name);
	}
	@Override
	public JSONArray getNamesByCondition(String num) throws Exception {
		List<String> list=cityMapper.getNamesByCondition(num);
		//创建一个jsonarray对象
		JSONArray array=new JSONArray();
		//数据格式转换
		array=JSONArray.fromObject(list);
		return array;
	}
	@Override
	public void updateStatusById(int status, int areaId) throws Exception {
		// TODO Auto-generated method stub
		areaMapper.updateById(status, areaId);
	}
	@Override
	public int getIdByName(String name) throws Exception {
		// TODO Auto-generated method stub
		return areaMapper.getIdByName(name);
	}	

}
