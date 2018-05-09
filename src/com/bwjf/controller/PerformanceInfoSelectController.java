package com.bwjf.controller;

import java.util.ArrayList;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.bwjf.entity.Account;
import com.bwjf.entity.Area;
import com.bwjf.entity.Role;
import com.bwjf.entity.view.PerformanceInfoSelectView;
import com.bwjf.service.AreaService;
import com.bwjf.service.EmployeeService;
import com.bwjf.service.PerformanceInfoService;
import com.bwjf.service.RoleService;
import com.bwjf.utils.CodeChangeUtil;

import net.sf.json.JSONObject;

@Controller
@RequestMapping("/performanceInfoSelect")
public class PerformanceInfoSelectController {

	private JSONObject jsonData;// 2017/11/27
	private PerformanceInfoService inforService;
	private RoleService roleService;
	private AreaService areaService;
	private CodeChangeUtil changeUtil;
	private EmployeeService employeeService;

	public EmployeeService getEmployeeService() {
		return employeeService;
	}

	@Resource
	public void setEmployeeService(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}

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

	public PerformanceInfoService getInforService() {
		return inforService;
	}

	@Resource
	public void setInforService(PerformanceInfoService inforService) {
		this.inforService = inforService;
	}

	public JSONObject getJsonData() {
		return jsonData;
	}

	public void setJsonData(JSONObject jsonData) {
		this.jsonData = jsonData;
	}

	@RequestMapping("/search")
	public String select(HttpServletRequest request, Model model, String startData, String endData, String eName) {

		if (eName != null || eName != "" || eName.length() > 0) {
			eName = changeUtil.changeUTF8(eName);
		}
		System.out.println("===PerformanceInfoSelectController.select(eName=" + eName + ")===");
		// 1.获取帐户信息
		Account account = (Account) request.getSession().getAttribute("account");
		List<PerformanceInfoSelectView> performanceInfoSelectViews = new ArrayList<PerformanceInfoSelectView>();
		int XHSP = 0;
		int FWF = 0;
		int BSP = 0;
		int GH = 0;
		int TYSB = 0;
		double XSSR = 0;
		double YZ = 0;
		try {
			performanceInfoSelectViews = inforService.search(startData, endData, account, eName);
			for (PerformanceInfoSelectView performanceInfoSelectView : performanceInfoSelectViews) {
				XHSP += performanceInfoSelectView.getNewSum();
				FWF += performanceInfoSelectView.getServiceSum();
				BSP += performanceInfoSelectView.getBspSum();
				GH += performanceInfoSelectView.getChangeSum();
				TYSB += performanceInfoSelectView.getEqmSum();
				XSSR += performanceInfoSelectView.getRevenue();
				YZ += performanceInfoSelectView.getTransfer();
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// 2.获取角色名
		Role role = new Role();
		try {
			role = roleService.getRoleById(account.getRoleId());

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// 3.获取地区,不含部门和广西百旺
		List<Area> areas = new ArrayList<>();
		try {
			// 返回有效的区域信息
			List<Area> aList = areaService.getAllArea(1);
			if (role.getName().equals("分公司经理")) {
				for (Area area : aList) {

					if (area.getDescription().indexOf("部门") == -1 && area.getDescription().indexOf("总部") == -1
							&& (account.getAreaId() == area.getAreaId() || account.getAreaId() == area.getParentId())) {
						areas.add(area);
					}
				}
			} else {
				for (Area area : aList) {

					if (area.getDescription().indexOf("部门") == -1 && area.getDescription().indexOf("总部") == -1) {
						areas.add(area);
					}
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// 4.获取员工姓名
		String employeeName = null;
		try {
			employeeName = employeeService.getNameById(account.getEmployeeId());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		model.addAttribute("employeeName", employeeName);
		model.addAttribute("areas", areas);
		model.addAttribute("startTime", startData);
		model.addAttribute("time", endData);
		model.addAttribute("eName", eName);
		model.addAttribute("role", role);
		model.addAttribute("performanceInfoSelectViews", performanceInfoSelectViews);
		model.addAttribute("XHSP", XHSP);
		model.addAttribute("FWF", FWF);
		model.addAttribute("BSP", BSP);
		model.addAttribute("GH", GH);
		model.addAttribute("TYSB", TYSB);
		model.addAttribute("XSSR", XSSR);
		model.addAttribute("YZ", YZ);
		return "PerformanceInfo/select";
	}

	@RequestMapping("/areaChoose")
	public String areaChoose(HttpServletRequest request, Model model, String startData, String endData,
			String areaName) {
		// 0.areaName解码
		areaName = changeUtil.changeUTF8(areaName);
		System.out.println("===PerformanceInfoSelectController.areaChoose(areaName:" + areaName + ")===");
		// 1.获取帐户信息
		Account account = (Account) request.getSession().getAttribute("account");
		// 2.获取角色名
		Role role = new Role();
		try {
			role = roleService.getRoleById(account.getRoleId());

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// 3.获取表格数据
		List<PerformanceInfoSelectView> performanceInfoSelectViews = new ArrayList<PerformanceInfoSelectView>();
		int XHSP = 0;
		int FWF = 0;
		int BSP = 0;
		int GH = 0;
		int TYSB = 0;
		double XSSR = 0;
		double YZ = 0;
		try {
			performanceInfoSelectViews = inforService.searchByAreaName(account, role, startData, endData, areaName);
			for (PerformanceInfoSelectView performanceInfoSelectView : performanceInfoSelectViews) {
				XHSP += performanceInfoSelectView.getNewSum();
				FWF += performanceInfoSelectView.getServiceSum();
				BSP += performanceInfoSelectView.getBspSum();
				GH += performanceInfoSelectView.getChangeSum();
				TYSB += performanceInfoSelectView.getEqmSum();
				XSSR += performanceInfoSelectView.getRevenue();
				YZ += performanceInfoSelectView.getTransfer();
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// 4.获取地区,不含部门和广西百旺
		List<Area> areas = new ArrayList<>();
		try {
			// 返回有效的区域信息
			List<Area> aList = areaService.getAllArea(1);
			if (role.getName().equals("分公司经理")) {
				for (Area area : aList) {

					if (area.getDescription().indexOf("部门") == -1 && area.getDescription().indexOf("总部") == -1
							&& (account.getAreaId() == area.getAreaId() || account.getAreaId() == area.getParentId())) {
						areas.add(area);
					}
				}
			} else {
				for (Area area : aList) {

					if (area.getDescription().indexOf("部门") == -1 && area.getDescription().indexOf("总部") == -1) {
						areas.add(area);
					}
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		model.addAttribute("nowArea", areaName);
		model.addAttribute("areas", areas);
		model.addAttribute("startTime", startData);
		model.addAttribute("time", endData);
		model.addAttribute("role", role);
		model.addAttribute("performanceInfoSelectViews", performanceInfoSelectViews);
		model.addAttribute("XHSP", XHSP);
		model.addAttribute("FWF", FWF);
		model.addAttribute("BSP", BSP);
		model.addAttribute("GH", GH);
		model.addAttribute("TYSB", TYSB);
		model.addAttribute("XSSR", XSSR);
		model.addAttribute("YZ", YZ);
		return "PerformanceInfo/select";
	}

}
