package com.bwjf.controller;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bwjf.entity.Account;
import com.bwjf.entity.Area;
import com.bwjf.service.AreaService;
import com.bwjf.service.EmployeeService;

/**
 * @author 张恭雨
 * 创建时间：2017年10月23日 上午11:18:42
 * 类描述：区域树的控制层
 * 版本：v1.0 
 */
@Controller
@RequestMapping("/area")
public class AreaController {
	
	private AreaService areaService;
	private EmployeeService employeeService;
	private int cityId;
	public int getCityId() {
		return cityId;
	}
	public void setCityId(int cityId) {
		this.cityId = cityId;
	}
	public AreaService getAreaService() {
		return areaService;
	}
	@Resource
	public void setAreaService(AreaService areaService) {
		this.areaService = areaService;
	}
	public EmployeeService getEmployeeService() {
		return employeeService;
	}
	@Resource
	public void setEmployeeService(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}
	/*
	 * ztree实现区域树的加载
	 */
	@RequestMapping("/tree.do")
	@ResponseBody
	public List<Area> tree(){		
		try {
			//返回有效的区域信息
			return areaService.getAllArea(1);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
	/*
	 * ztree实现区域树的加载-不要部门
	 */
	@RequestMapping("/treeNOBM.do")
	@ResponseBody
	public List<Area> treeNOBM(){
		try {
			//返回有效的区域信息
			List<Area> areas = new ArrayList<>();
			List<Area> aList = areaService.getAllArea(1);
			for (Area area : aList) {

				if( area.getDescription().indexOf("部门")==-1) {
					areas.add(area);
				}
			}
			return areas;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	/*
	 * 跳转区域树
	 * 
	 */
	@RequestMapping("/toTree.do")
	public String toTree(){
		return "area/areaTree";
	}
	/*
	 * 查询区域详细信息
	 */
	@RequestMapping("/detail.do")
	public String detail(int areaId,Model model){
		//判断区域id是否为空
		if(areaId==0){
			return	"error";
		}
		//查询详细信息
		try {
			List<Object> list=areaService.getAreaById(areaId);
			Area area=(Area) list.get(0);
			String provinceName=(String) list.get(1);
			String cityName=(String) list.get(2);
			String townName=(String) list.get(3);			
			//将信息放到model中
			model.addAttribute("area", area);
			model.addAttribute("provinceName", provinceName);
			model.addAttribute("cityName", cityName);
			model.addAttribute("townName", townName);			
			return "area/detail";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "error/500";
		}
		
	}
	/*
	 * 跳转编辑页面
	 */
	@RequestMapping("/toEdit.do")
	public String toEdit(){
		return "area/areaEdit";
	}
	/*
	 * ajax删除操作
	 */
	@RequestMapping("/delete.do")
	@ResponseBody
	public String delete(int areaId){
		//消息声明
		String msg;
		//判断areaId是否为空
		if(areaId==0){
			msg="one";
		}
		//将区域有效性设置为0，以及子节点的有效性
		try {
			areaService.updateById(0, areaId);
			msg="success";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			msg="two";
		}
		return msg;
	}
	/*
	 * 跳转添加页面
	 */
	
	@RequestMapping("/toAdd.do")
	public String toAdd(int id,Model model){
		int areaId=id;
		//判断areaId是否为空
		if(areaId==0){
			return "error/500";
		}
		//查询父亲区域名称
		try {
			String name=areaService.getNameById(areaId);
			//将区域名称放到model中
			model.addAttribute("name", name);
			//将区域id放到model中
			model.addAttribute("areaId", areaId);
			return "area/add";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "error/500";
		}
		
	}
	/*
	 * 添加操作
	 */
	@RequestMapping("/add.do")
	public String add(Area area,String provinceName,Model model,
			String cityName,String townName,HttpServletRequest request){
		String msg;
		//判断对象是否为空
		if(area==null){
			return "error/500";
		}
		//判断该区域是否已经存在
		try {
			int count=areaService.getCountByName(area.getName());
			//判断是否存在
			if(count!=0){
				//设置错误消息
				msg="添加失败,该区域已经存在,请检查是否已经失效！";
				model.addAttribute("msg", msg);
				//将区域名称放到model中
				model.addAttribute("name",area.getName());
				return "area/msg";
			}
		} catch (Exception e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
			return "error/500";
		}
		//获取帐户信息
		Account account=(Account) request.getSession().getAttribute("account");
		//获取帐户所属人姓名
		try {
			String name=employeeService.getNameById(account.getEmployeeId());
			//设置创建人姓名
			area.setCreateBy(name);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			return "error/500";		}
		//将区域信息保存到数据库中
		try {
			//创建一个list进行数据封装
			List<Object> list=new ArrayList<Object>();
			//将数据封装到list中
			list.add(area);
			list.add(provinceName);
			list.add(cityName);
			list.add(townName);			
			areaService.saveArea(list);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "error/500";
		}
		return "area/null";
		
	}
	/*
	 * 跳转修改页面
	 */
	@RequestMapping("/toAlter.do")
	public String toAlter(int id,Model model){
		int areaId=id;
		//判断ID是否为空
		if(areaId==0)
			return "error/500";
		//查询区域信息
		try {
			List<Object> list=areaService.getAreaById(areaId);
			Area area=(Area) list.get(0);
			String provinceName=(String) list.get(1);
			String cityName=(String) list.get(2);
			String townName=(String) list.get(3);			
			//将信息放到model中
			model.addAttribute("area", area);
			model.addAttribute("provinceName", provinceName);
			model.addAttribute("cityName", cityName);
			model.addAttribute("townName", townName);					
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "error/500";
		}
		return "area/alter";
	}
	/*
	 * 地区信息的修改
	 * 
	 */
	@RequestMapping("/alter.do")
	public String alter(Area area,String provinceName,
			String cityName,String townName,HttpServletRequest request){
		//判断对象是否为空
		if(area==null)
			return "error/500";
		//获取帐户信息
		Account account=(Account) request.getSession().getAttribute("account");
		//获取更新人姓名
		try {
			String name=employeeService.getNameById(account.getEmployeeId());
			//设置更新人姓名
			area.setUpdateBy(name);
			//设置更新时间
			area.setUpdateDate(new Date());
			//创建一个list进行数据封装
			List<Object> list=new ArrayList<Object>();
			//将数据封装到list中
			list.add(area);
			list.add(provinceName);
			list.add(cityName);
			list.add(townName);			
			//将对象保存到数据库中
			areaService.updateArea(list);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "error/500";
		}
		return "area/null";
	}
	
	/*
	 * 异步加载省信息
	 */
	@RequestMapping("/getProvinceName.do")
	@ResponseBody
	public String getProvinceName(){
		//获取所有有效的省信息
		try {
			return areaService.getAllProvinceName(1).toString();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "error/500";
		}
	}
	
	/*
	 * 异步加载市信息
	 */
	@RequestMapping("/getCityName.do")
	@ResponseBody
	public String getCityName(){
		//获取所有有效的市信息
		try {
			return areaService.getAllCityName(1).toString();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "error/500";
		}
	}
	
	/*
	 * 异步加载乡镇信息
	 */
	@RequestMapping("/getTownName.do")
	@ResponseBody
	public String getTownName(){
		//获取相关城市城镇信息信息
				try {
					String num=cityId+"";
					num=num.substring(0, 4);
					return areaService.getNamesByCondition(num).toString();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					return "error/500";
				}
	}	
	
	/*
	 * 获取下拉框所选择的市
	 */
	@RequestMapping("/getSelect.do")
	@ResponseBody
	public String getSelect(String select){
		
		try {
			select=URLDecoder.decode(select, "utf-8");
			System.out.println(select);
		} catch (UnsupportedEncodingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		//判断选择是否为空
		if("".equals(select)){
			return "fail";
		}
		//获取所选城市的ID
		try {
			cityId=areaService.getCityIdByName(select);
			return "success";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "fail";
		}
		
	}
	
	/*
	 * 更新区域状态
	 */
	@RequestMapping("/updateStatus.do")
	public String updateStatus(String name,int status,Model model){	
		//获取区域Id
		int areaId = 0;
		try {
			areaId=areaService.getIdByName(name);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			model.addAttribute("error", "设置失败");
			return "area/null";
		}
		//更新节点状态
		try {
			areaService.updateStatusById(status,areaId);
			model.addAttribute("error", "设置成功");
			return "area/null";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			model.addAttribute("error", "设置失败");
			return "area/null";
		}
	}
}
