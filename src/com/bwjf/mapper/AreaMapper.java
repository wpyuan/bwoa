package com.bwjf.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.bwjf.entity.Area;

/**
 * @author 张恭雨
 * 创建时间：2017年10月20日 下午3:54:36
 * 类描述：区域mapper接口
 * 版本：v1.0 
 */
public interface AreaMapper {
	public List<Area> getAllArea(int status) throws Exception;			//查询所有是否域信息
	public void deleteById(int areaId) throws Exception;				//删除区域根据ID
	public void updateById(@Param("status")int status,@Param("areaId")int areaId) throws Exception;	//更新节点是否有效信息
	public Area getAreaById(int areId) throws Exception;					//查询区域的详细信息
	public List<Integer> getAreaByParentId(int areaId) throws Exception;					//获取所有的字节点的信息
	public String getNameById(int areaId) throws Exception;				//获取区域名称
	public void saveArea(Area area) throws Exception;					//保存区域信息
	public void updateArea(Area area) throws Exception;					//更新区域信息
	public int getIdByName(String name) throws Exception;				//获取区域ID	
	public void updateLinkById(@Param("link")String link,@Param("areaId")int areaId) throws Exception;	//更新区域链接
	public int getCountByName(String name) throws Exception;		//获取指定名称的记录条数
	public Area getAreaByName(String name) throws Exception;     		//通过区域名获取地区
	/*
	 * @作者:张恭雨
	 * 
	 * @时间 : 2017年11月22日 下午7:10:32
	 * 
	 * @方法描述:条件查询区域信息
	 */
	public List<Area> getAreaByConditon(@Param("status")int status,
			@Param("description")String description) throws Exception; 
	/*
	 * @作者:张恭雨
	 * 
	 * @时间 : 2017年11月24日 下午3:22:38
	 * 
	 * @方法描述:获取所有父节点下的子节点ID
	 */
	public List<Integer> getAreaIdByHasParentId(@Param("parentIds")
							List<Integer> parentIds) throws Exception;
	
	/*
	 * @作者:张恭雨
	 * 
	 * @时间 : 2017年11月27日 上午10:59:38
	 * 
	 * @方法描述:删选出部门信息的查询子节点信息
	 */
	
	public List<Integer> getAreaByParentIdExceptDepart(@Param("status")int status,
			@Param("description")String description,@Param("parentId")int parentId) throws Exception;
}
