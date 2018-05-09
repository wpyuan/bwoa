package com.bwjf.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bwjf.entity.Account;
import com.bwjf.entity.Area;
import com.bwjf.entity.Equipment;
import com.bwjf.entity.PerformanceInfo;
import com.bwjf.entity.Role;
import com.bwjf.entity.form.PerformanceForm;
import com.bwjf.entity.form.TaxForm;
import com.bwjf.entity.view.EquipmentView;
import com.bwjf.entity.view.ServiceView;
import com.bwjf.entity.view.StatisticalView;
import com.bwjf.entity.view.TaxView;
import com.bwjf.service.AreaService;
import com.bwjf.service.EqmAddService;
import com.bwjf.service.PerformanceInfoService;
import com.bwjf.service.RoleService;
import com.bwjf.utils.CodeChangeUtil;
import com.bwjf.utils.DateUtil;
import com.fasterxml.jackson.annotation.JsonCreator.Mode;

import net.sf.json.JSONObject;

/**
 * @author 张恭雨 创建时间：2017年11月15日 上午8:09:14 类描述：绩效信息操作控制 版本：v1.0
 */

/**
 * @author 张恭雨 创建时间：2017年11月21日 下午6:35:30 类描述： 版本：v1.0
 */
@Controller
@RequestMapping("/performanceInfo")
public class PerformanceInfoController {
	private DateUtil dateUtil;
	private JSONObject jsonData;// 2017/11/20
	private PerformanceInfoService infoService;
	private EqmAddService eqmAddService;
	private RoleService roleService;
	private CodeChangeUtil codeChangeUtil;
	private AreaService areaService;

	public AreaService getAreaService() {
		return areaService;
	}

	@Resource
	public void setAreaService(AreaService areaService) {
		this.areaService = areaService;
	}

	public RoleService getRoleService() {
		return roleService;
	}

	@Resource
	public void setRoleService(RoleService roleService) {
		this.roleService = roleService;
	}

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

	/*
	 * 跳转信息录入页面 2017/11/22
	 */
	@RequestMapping("/toAdd")
	public String toAdd(Model model) {
		System.out.println("===PerformanceInfoController.toAdd()===");
		List<Equipment> eqmList = new ArrayList<>();
		try {
			eqmList = infoService.getAllEquipmentName();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String time = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
		String data = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
		model.addAttribute("data", data);
		model.addAttribute("time", time);
		model.addAttribute("eqmList", eqmList);
		return "PerformanceInfo/add";
	}

	/*
	 * @作者:王培源
	 * 
	 * @时间 : 2017年11月22日 下午
	 * 
	 */
	@RequestMapping("/addCollectMoney")
	@ResponseBody
	public String addCollectMoney(String ZXS, String YZZ, String createDate) {
		System.out.println("===PerformanceInfoController.addCollectMoney()===");
		String UUID = null;
		try {
			UUID = infoService.addCollectMoney(ZXS, YZZ, createDate); // 插入金额记录
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Map map = new HashMap();
		map.put("UUID", UUID);
		jsonData = JSONObject.fromObject(map);
		return jsonData.toString();
	}

	// 修改：
	/*
	 * @作者:张恭雨
	 * 
	 * @时间 : 2017年11月21日 下午3:02:14 修改时间 2017/11/22
	 * 
	 * @方法描述:盘信息录入
	 */
	@RequestMapping("/addTanInfo")
	@ResponseBody
	public String addTaxInfo(TaxForm form, HttpServletRequest request, String UUID) {
		System.out.println("===PerformanceInfoController.addTaxInfo()===");
		// 获取account对象
		Account account = (Account) request.getSession().getAttribute("account");
		// 创建PerformanceInfo对象
		PerformanceInfo info = new PerformanceInfo();
		// 设置员工ID
		info.setEmployeeId(account.getEmployeeId());
		// 设置UUID
		info.setUuid(UUID);
		// Map map = new HashMap();
		try {
			// 保存信息
			infoService.saveTaxInfo(info, form);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}
		// jsonData = JSONObject.fromObject(map);
		return jsonData.toString();
	}

	// 统计页面 2017/11/20
	@RequestMapping("/total.do")
	public String total(Model model, Integer areaId) {
		// 获取当前时间
		String time = new SimpleDateFormat("yyyy/MM/dd").format(new Date());
		String stime = new SimpleDateFormat("yyyy/MM/dd").format(new Date());
		String year = new SimpleDateFormat("yyyy年MM月").format(new Date());

		model.addAttribute("startTime", stime);
		model.addAttribute("time", time);
		model.addAttribute("year", year);

		try {
			StatisticalView view = infoService.getStatisticsInfo(areaId, stime, time);
			model.addAttribute("view", view);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "PerformanceInfo/total";
	}

	// 跳转到查询页面 2017/11/20
	@RequestMapping("/toSelect")
	public String toSelect(HttpServletRequest request, Model model) {
		System.out.println("===PerformanceInfoController.toSelect()===");
		// 0.获取帐户信息
		Account account = (Account) request.getSession().getAttribute("account");
		// 0.1.获取角色名
		Role role = new Role();
		try {
			role = roleService.getRoleById(account.getRoleId());

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// 1.获取当前时间
		String time = new SimpleDateFormat("yyyy/MM/dd").format(new Date());
		String stime = new SimpleDateFormat("yyyy/MM/1").format(new Date());
		// 2.获取地区,不含部门和广西百旺
		List<Area> areas = new ArrayList<>();
		try {
			// 返回有效的区域信息
			List<Area> aList = areaService.getAllArea(1);
			if(role.getName().equals("分公司经理")) {	
				for (Area area : aList) {
					
					if (area.getDescription().indexOf("部门") == -1 && area.getDescription().indexOf("总部") == -1
							&& ( account.getAreaId() == area.getAreaId()||account.getAreaId() == area.getParentId() ) ) {
						areas.add(area);
					}
				}
			}else {
				for (Area area : aList) {

					if (area.getDescription().indexOf("部门") == -1 && area.getDescription().indexOf("总部") == -1 ) {
						areas.add(area);
					}
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		model.addAttribute("areas", areas);
		model.addAttribute("startTime", stime);
		model.addAttribute("time", time);
		model.addAttribute("role", role);
		return "PerformanceInfo/select";

	}

	// 跳转到查询页面 2017/11/20
	@RequestMapping("/select.do")
	@ResponseBody
	public String select(String startTime, String endTime, Model model, HttpServletRequest request, int areaId) {
		HttpSession session = request.getSession();
		try {
			String year = new SimpleDateFormat("yyyy年MM月").format(new Date());
			StatisticalView view = infoService.getStatisticsInfo(areaId, startTime, endTime);
			session.setAttribute("startTime", startTime);
			session.setAttribute("time", endTime);
			session.setAttribute("view", view);
			session.setAttribute("year", year);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "fail";
		}
		return "success";

	}

	/*
	 * @作者:张恭雨
	 * 
	 * @时间 : 2017年11月27日 上午11:33:11
	 * 
	 * @方法描述:树节点展开数据加载
	 */
	@RequestMapping("/unfurledData.do")
	@ResponseBody
	public List<StatisticalView> UnfurledData(int areaId, String startTime, String endTime, Model model) {
		List<StatisticalView> views = null;
		try {
			views = infoService.getUnfurledData(areaId, startTime, endTime);
			model.addAttribute("startTime", startTime);
			model.addAttribute("time", endTime);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return views;
	}

	@RequestMapping("/selectResult.do")
	public String selectResult(String year, Model model, String falg) {
		if (falg.equals("true")) {
			year = codeChangeUtil.changeUTF8(year);
			model.addAttribute("year", year);
		}
		return "PerformanceInfo/total";
	}

	/*
	 * 查询记录详细信息
	 */
	@RequestMapping("/detail.do")
	public String detail(String type, Integer areaId, String startTime, String endTime, Model model) {
		// 判断查询消息信息类型
		if ("tax".equals(type)) {
			try {
				List<TaxView> taxViews = infoService.getTaxDetail(areaId, startTime, endTime);
				model.addAttribute("taxViews", taxViews);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return "error/500";
			}
			return "PerformanceInfo/taxDetail";
		}
		if ("service".equals(type)) {
			try {
				List<ServiceView> serviceViews = infoService.getServiceDetail(areaId, startTime, endTime);
				model.addAttribute("serviceViews", serviceViews);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return "error/500";
			}
			return "PerformanceInfo/serviceDetail";
		}
		if ("equipment".equals(type)) {
			try {
				List<EquipmentView> equipmentViews = infoService.getEquipmentDetail(areaId, startTime, endTime);
				model.addAttribute("equipmentViews", equipmentViews);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return "error/500";

			}
			return "PerformanceInfo/equipmentDetail";
		}
		return null;
	}

	// 跳转到修改页面 2017/11/27
	@RequestMapping("/toAlter")
	public String toAlter(Model model, String uuid) {
		System.out.println("===PerformanceInfoController.toAlter(uuid:" + uuid + ")===");
		// 1.拿到设备列表表头
		List<Equipment> eqmList = new ArrayList<>();
		try {
			eqmList = infoService.getAllEquipmentName();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// 1.1拿到设备销售数量
		List<String> eqmNumList = new ArrayList<>();
		try {
			eqmNumList = infoService.getToAlterEqmNum(uuid);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		model.addAttribute("eqmNumList", eqmNumList);
		// 2.拿到每项详细数据
		PerformanceForm pform = new PerformanceForm();
		try {
			pform = infoService.toAlter(uuid);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		model.addAttribute("pform", pform);
		model.addAttribute("eqmList", eqmList);
		model.addAttribute("uuid", uuid);
		return "PerformanceInfo/alter";

	}

	// 跳转到页面 2017/11/21
	@RequestMapping("/toAddSKPChange")
	public String toAddSKPChange() {
		System.out.println("===PerformanceInfoController.toAddSKPChange()===");

		return "PerformanceInfo/addSKPChange";

	}

	/*
	 * 获取价格信息
	 */
	@RequestMapping("/getPrice")
	@ResponseBody
	public double getPrice(String type) {

		try {
			return infoService.getPriceByType(type);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		}
	}

	/*
	 * 异步加载区域JSON数据
	 */
	@RequestMapping("/getAreaData.do")
	@ResponseBody
	public String getAreaDate() {
		try {
			return infoService.getAreaData(1, "部门").toString();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	@RequestMapping("/checkCreateDate")
	@ResponseBody
	public String checkCreateDate(String uuid) {

		Map map = new HashMap();
		// 先比较时间是否符合删除时限
		Date nowDate = new Date();// 当前时间
		Date cDate = null;
		try {
			cDate = infoService.getCreateDate(uuid);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} // 创建时间
		String tDate = dateUtil.getTomorrow(cDate);
		Date tomorrowDate = dateUtil.getDateTime(tDate); // 获取创建时间的明天日期时间
		if (!nowDate.after(tomorrowDate)) {
			map.put("msg", "true");
		} else {
			System.out.println("不在删除有效时间内");
			map.put("msg", "false");// 删除失败！不在删除有效时间内
		}
		jsonData = JSONObject.fromObject(map);
		return jsonData.toString();
	}

	/*
	 * @作者:王培源
	 * 
	 * @时间 : 2017年11月28日 下午6:35:42
	 * 
	 * @方法描述:
	 */
	// 删除2017/11/27
	@RequestMapping("/delet")
	public String delet(Model model, String uuid) {
		System.out.println("===PerformanceInfoController.delet(uuid:" + uuid + ")===");
		try {
			infoService.delet(uuid);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "redirect:/performanceInfo/toSelect.do";

	}

	// 检查当天是否有录入记录
	@RequestMapping("/check")
	@ResponseBody
	public String check(HttpServletRequest request, String dataDate) {
		// 获取account对象
		Account account = (Account) request.getSession().getAttribute("account");
		int flag = 0;
		Map map = new HashMap();
		try {
			flag = infoService.check(account.getEmployeeId(), dataDate);
			if (flag == 0) {
				map.put("flag", "error");
			} else {
				map.put("flag", "success");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		jsonData = JSONObject.fromObject(map);
		return jsonData.toString();
	}

	/*
	 * 提交修改
	 */
	@RequestMapping("/alter")
	@ResponseBody
	public String alter(String ZXS, String YZZ, String createDate, TaxForm form, String[] num, String dataTime,
			HttpServletRequest request) {
		System.out.println("===PerformanceInfoController.alter()===");
		Map map = new HashMap();
		// 先比较时间是否符合修改时限
		Date nowDate = new Date();
		Date cDate = dateUtil.getDateTime(createDate);

		String tDate = dateUtil.getTomorrow(cDate);
		Date tomorrowDate = dateUtil.getDateTime(tDate); // 获取创建时间的明天日期时间
		System.out.println("cDate:" + cDate + ";tDate:" + tDate);
		System.out
				.println("alter----nowDate:" + nowDate + ";createDate:" + createDate + ";tomorrowDate:" + tomorrowDate);
		if (!nowDate.after(tomorrowDate)) {
			System.out.println("在修改有效时间内");
			String UUID = null;
			try {
				UUID = infoService.addCollectMoney(ZXS, YZZ, createDate); // 插入金额记录
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			// 获取account对象
			Account account = (Account) request.getSession().getAttribute("account");
			// 创建PerformanceInfo对象
			PerformanceInfo info = new PerformanceInfo();
			// 设置员工ID
			info.setEmployeeId(account.getEmployeeId());
			// 设置UUID
			info.setUuid(UUID);
			// Map map = new HashMap();
			try {
				// 保存信息
				infoService.saveTaxInfo(info, form);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();

			}

			List<Equipment> eqmNoList = new ArrayList<>();
			try {
				eqmNoList = infoService.getAllEquipmentName();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				eqmAddService.add(account, eqmNoList, num, createDate, dataTime, UUID);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			map.put("UUID", UUID);
			map.put("msg", "修改成功");
			jsonData = JSONObject.fromObject(map);
			return jsonData.toString();
		} else {
			System.out.println("不在修改有效时间内");
			String JZSJ = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(tomorrowDate);
			map.put("msg", "修改失败！此记录修改截至时间：[ " + JZSJ + " ]");
			jsonData = JSONObject.fromObject(map);
			return jsonData.toString();
		}

	}

	// 跳转到详情页面 2017/11/27
	@RequestMapping("/toDetail")
	public String toDetail(Model model, String uuid) {
		System.out.println("===PerformanceInfoController.toDetail(uuid:" + uuid + ")===");
		// 1.拿到设备列表表头
		List<Equipment> eqmList = new ArrayList<>();
		try {
			eqmList = infoService.getAllEquipmentName();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// 1.1拿到设备销售数量
		List<String> eqmNumList = new ArrayList<>();
		try {
			eqmNumList = infoService.getToAlterEqmNum(uuid);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		model.addAttribute("eqmNumList", eqmNumList);
		// 2.拿到每项详细数据
		PerformanceForm pform = new PerformanceForm();
		try {
			pform = infoService.toAlter(uuid);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		model.addAttribute("pform", pform);
		model.addAttribute("eqmList", eqmList);
		model.addAttribute("uuid", uuid);
		return "PerformanceInfo/detail";

	}
	/**********************************************************/
	/*
	 * 2018-2-1
	 * 张恭雨
	 * 跳转报表页面
	 */
	@RequestMapping("/toChart.do")
	public String toChart(Model model){
		String year = new SimpleDateFormat("yyyy年MM月").format(new Date());
		model.addAttribute("year", year);
		return "PerformanceInfo/chart";
	}
	/*
	 * 2018-2-1
	 * 张恭雨
	 * 获取报表数据
	 */
	@RequestMapping("/getChartDate.do")
	@ResponseBody
	public List<Integer> getChartDate(String year,String month,String day,String areaName){
		//解码区域名称
		String name=codeChangeUtil.changeUTF8(areaName);
		try {
			return infoService.getChartDate(year, month,day, name);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		
	}	

}
