package com.bwjf.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bwjf.entity.Account;
import com.bwjf.entity.Area;
import com.bwjf.entity.Ascc;
import com.bwjf.entity.view.AsccView;
import com.bwjf.service.FuWuService;

/**
 * @author 张恭雨
 * 创建时间：2017-12-8 上午9:14:31
 * 类描述：服务管理控制层
 * 版本：v1.0 
 */
@Controller
@RequestMapping("/fuwu")
public class FuWuController {
	private FuWuService fuWuService;
	private String selectYear;
	public FuWuService getFuWuService() {
		return fuWuService;
	}
	@Resource
	public void setFuWuService(FuWuService fuWuService) {
		this.fuWuService = fuWuService;
	}

	public String getSelectYear() {
		return selectYear;
	}
	public void setSelectYear(String selectYear) {
		this.selectYear = selectYear;
	}
		
	/*
	 * 初始化添加页面信息
	 */
	
	@RequestMapping("/toAdd.do")
	public String toAdd(Model model){
		try {
			//获取区域信息
			List<Area> areas=getFuWuService().getAreaNames(1);
			model.addAttribute("areas", areas);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "error/500";
		}
		return "service/add";
	}
	
	/*
	 * 异步加载区域JSON数据
	 */
	@RequestMapping("/getAreaData.do")
	@ResponseBody
	public String getAreaDate() {
		try {
			return fuWuService.getAreaData(1, "部门").toString();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
	/*
	 * 异步加载地区信息
	 */
	@RequestMapping("/showArea.do")
	@ResponseBody
	public List<Area> showArea(){
		try {
			//返回区域信息
			return getFuWuService().getAreaNames(1);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		
	}
	
	/*
	 * 保存添加信息
	 */
	@RequestMapping("/save.do")
	@ResponseBody
	public String save(String str,String year,
			HttpServletRequest request){
		Account account=(Account) request.getSession().getAttribute("account");
		try {
			String result=fuWuService.saveAscc(str, year, account.getAccountId());
			return result;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "fail";
		}
		
	}
	/*
	 * 应收管理,页面跳转
	 */
	@RequestMapping("/manage.do")
	public String manage(String year,Model model){
		//判断年份是否为空
		if("".equals(year)||year==null){
			//获取当前年份
			SimpleDateFormat sdf=new SimpleDateFormat("yyyy");
			year=sdf.format(new Date());
			selectYear=year;
		}else{
			selectYear=year;
		}
		try {
			AsccView view=fuWuService.getFirstViewByYear(year,1);
			model.addAttribute("view", view);
			return "service/manage";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "error/500";
		}
	}
	
	/*
	 * 异步加载应收数据
	 */
	@RequestMapping("/getManageData.do")
	@ResponseBody
	public List<AsccView> getManageData(){
		try {
			return fuWuService.getAsccViewByYear(selectYear);			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		
	}
	
	/*
	 * 更新信息
	 */
	@RequestMapping("/update.do")
	@ResponseBody
	public String update(int number,int asccId){
		try {
			//更新信息
			fuWuService.updateAscc(number,asccId);
			return "success";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "fail";
		}
	}
	
	
	/*
	 * 删除信息
	 */
	@RequestMapping("/delete.do")
	@ResponseBody
	public String delete(int asccId){
		try {
			fuWuService.deleteById(asccId);
			return "success";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "fail";
		}
		
	}
	
}
