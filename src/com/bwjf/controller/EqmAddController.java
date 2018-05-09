package com.bwjf.controller;


import java.util.ArrayList;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bwjf.entity.Account;
import com.bwjf.entity.Equipment;
import com.bwjf.service.EqmAddService;
import com.bwjf.service.PerformanceInfoService;

import net.sf.json.JSONObject;

/**
 * @author 王培源 创建时间：2017年11月21日
 */
@Controller
@RequestMapping("/eqmAdd")
public class EqmAddController {

	private JSONObject jsonData;// 2017/11/20
	
	private PerformanceInfoService infoService;
	private EqmAddService eqmAddService;
	
	public EqmAddService getEqmAddService() {
		return eqmAddService;
	}
	@Resource
	public void setEqmAddService(EqmAddService eqmAddService) {
		this.eqmAddService = eqmAddService;
	}

	public PerformanceInfoService getInfoService() {
		return infoService;
	}

	@Resource
	public void setInfoService(PerformanceInfoService infoService) {
		this.infoService = infoService;
	}
	
	public JSONObject getJsonData() {
		return jsonData;
	}

	public void setJsonData(JSONObject jsonData) {
		this.jsonData = jsonData;
	}

	// 跳转到页面 2017/11/21
	@RequestMapping("/add")
	@ResponseBody
	public String add(HttpServletRequest request,String[] num,String createDate,String dataTime,String UUID) {
		System.out.println("===EqmAddController.add()===");		
		// 获取帐户信息
		Account account = (Account) request.getSession().getAttribute("account");
		List<Equipment> eqmNoList = new ArrayList<>();
		try {
			eqmNoList = infoService.getAllEquipmentName();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			eqmAddService.add(account,eqmNoList,num,createDate,dataTime,UUID);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Map map = new HashMap();
		map.put("msg", "保存成功");
		jsonData = JSONObject.fromObject(map);
		return jsonData.toString();
	}
}
