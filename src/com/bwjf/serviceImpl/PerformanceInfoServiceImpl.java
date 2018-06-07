package com.bwjf.serviceImpl;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;

import net.sf.json.JSONArray;

import org.omg.CosNaming.NamingContextExtPackage.StringNameHelper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bwjf.entity.Account;
import com.bwjf.entity.Area;
import com.bwjf.entity.CollectMoney;
import com.bwjf.entity.Equipment;
import com.bwjf.entity.PerformanceInfo;

import com.bwjf.entity.Role;
import com.bwjf.entity.ServiceCharge;
import com.bwjf.entity.TaxDisc;
import com.bwjf.entity.TaxDiscReplace;
import com.bwjf.entity.form.PerformanceForm;
import com.bwjf.entity.form.TaxForm;
import com.bwjf.entity.view.EquipmentView;
import com.bwjf.entity.view.PerformanceInfoSelectView;

import com.bwjf.entity.view.ServiceView;
import com.bwjf.entity.view.StatisticalView;
import com.bwjf.entity.view.TaxView;
import com.bwjf.mapper.AccountMapper;
import com.bwjf.mapper.AreaMapper;
import com.bwjf.mapper.AsccMapper;
import com.bwjf.mapper.CollectMoneyMapper;
import com.bwjf.mapper.EquipmentMapper;
import com.bwjf.mapper.EscalationTaxMapper;
import com.bwjf.mapper.PerformanceInfoMapper;
import com.bwjf.mapper.PerformanceInfoSelectViewMapper;
import com.bwjf.mapper.RoleMapper;
import com.bwjf.mapper.ServiceChargeMapper;
import com.bwjf.mapper.TaxDiscMapper;
import com.bwjf.mapper.TaxDiscReplaceMapper;
import com.bwjf.service.PerformanceInfoService;
import com.bwjf.utils.DateUtil;

/**
 * @author 张恭雨
 * 创建时间：2017年11月15日 上午8:26:56
 * 类描述：绩效信息service实现
 * 版本：v1.0 
 */
@Service
@Transactional
public class PerformanceInfoServiceImpl implements PerformanceInfoService {
	private PerformanceInfoMapper infoMapper;
	private EquipmentMapper equipmentMapper;
	private ServiceChargeMapper chargeMapper;
	private TaxDiscMapper discMapper;
	private EscalationTaxMapper escalationTaxMapper;
	private TaxDiscReplaceMapper discReplaceMapper;
	private AreaMapper areaMapper;	
	private CollectMoneyMapper collectMoneyMapper;
	private AccountMapper accountMapper;	
	private RoleMapper roleMapper;
	private PerformanceInfoSelectViewMapper infoSelectViewMapper;
	private TaxDiscMapper taxDiscMapper;
	private AsccMapper asccMapper;
	
	
	public AsccMapper getAsccMapper() {
		return asccMapper;
	}
	@Resource
	public void setAsccMapper(AsccMapper asccMapper) {
		this.asccMapper = asccMapper;
	}
	public TaxDiscMapper getTaxDiscMapper() {
		return taxDiscMapper;
	}
	@Resource
	public void setTaxDiscMapper(TaxDiscMapper taxDiscMapper) {
		this.taxDiscMapper = taxDiscMapper;
	}
	public PerformanceInfoMapper getInfoMapper() {
		return infoMapper;
	}
	@Resource
	public void setInfoMapper(PerformanceInfoMapper infoMapper) {
		this.infoMapper = infoMapper;
	}
	public EquipmentMapper getEquipmentMapper() {
		return equipmentMapper;
	}
	@Resource
	public void setEquipmentMapper(EquipmentMapper equipmentMapper) {
		this.equipmentMapper = equipmentMapper;
	}
	public ServiceChargeMapper getChargeMapper() {
		return chargeMapper;
	}
	@Resource
	public void setChargeMapper(ServiceChargeMapper chargeMapper) {
		this.chargeMapper = chargeMapper;
	}
	public TaxDiscMapper getDiscMapper() {
		return discMapper;
	}
	@Resource
	public void setDiscMapper(TaxDiscMapper discMapper) {
		this.discMapper = discMapper;
	}
	public EscalationTaxMapper getEscalationTaxMapper() {
		return escalationTaxMapper;
	}
	@Resource
	public void setEscalationTaxMapper(EscalationTaxMapper escalationTaxMapper) {
		this.escalationTaxMapper = escalationTaxMapper;
	}
	public TaxDiscReplaceMapper getDiscReplaceMapper() {
		return discReplaceMapper;
	}
	@Resource
	public void setDiscReplaceMapper(TaxDiscReplaceMapper discReplaceMapper) {
		this.discReplaceMapper = discReplaceMapper;
	}
	public AreaMapper getAreaMapper() {
		return areaMapper;
	}
	@Resource
	public void setAreaMapper(AreaMapper areaMapper) {
		this.areaMapper = areaMapper;
	}	
	
	public CollectMoneyMapper getCollectMoneyMapper() {
		return collectMoneyMapper;
	}
	@Resource
	public void setCollectMoneyMapper(CollectMoneyMapper collectMoneyMapper) {
		this.collectMoneyMapper = collectMoneyMapper;
	}
	
	
	public AccountMapper getAccountMapper() {
		return accountMapper;
	}
	@Resource
	public void setAccountMapper(AccountMapper accountMapper) {
		this.accountMapper = accountMapper;
	}
	public RoleMapper getRoleMapper() {
		return roleMapper;
	}
	@Resource
	public void setRoleMapper(RoleMapper roleMapper) {
		this.roleMapper = roleMapper;
	}
	public PerformanceInfoSelectViewMapper getInfoSelectViewMapper() {
		return infoSelectViewMapper;
	}
	@Resource
	public void setInfoSelectViewMapper(
			PerformanceInfoSelectViewMapper infoSelectViewMapper) {
		this.infoSelectViewMapper = infoSelectViewMapper;
	}
	/*
	 * 获取所有设备的名称 
	 * 2017/11/20修改
	 */
	@Override
	public List<Equipment> getAllEquipmentName() throws Exception {
		System.out.println("---PerformanceInfoServiceImpl.getAllEquipmentName()---");
		return equipmentMapper.getAllName();
	}
	/*
	 * @作者:张恭雨
	 * 
	 * @时间 : 2017年11月21日 下午4:45:37
	 * 修改 2017-11-24  添加uuid、dataDate
	 * 修改 2017-11-24  修改 info.setCreateDate(DateUtil.getDate(form.getCT()));
	 * @方法描述:保存盘信息方法
	 */
	@Override
	public void saveTaxInfo(PerformanceInfo info, TaxForm form) throws Exception {
		System.out.println("---PerformanceInfoServiceImpl.saveTaxInfo()---");
		// 设置数据时间
		info.setDataTime(DateUtil.getDate(form.getDT()));
		// 设置创建时间
		info.setCreateDate(DateUtil.getDateTime(form.getCT()));		
		
		// 判断如果税控盘主盘数量不为空
		if (!"".equals(form.getSXZS())) {
			// 获取税控盘小规模主盘类型ID
			int taxDiscId = discMapper.getIdByCondition("小规模", "主盘");
			// 设置编号
			info.setTaxDiscId(taxDiscId);
			// 设置数量
			info.setQuantity(Integer.parseInt(form.getSXZS()));
			infoMapper.saveTaxInfo(info);
		}

		// 判断如果税控盘分盘数量不为空
		if (!"".equals(form.getSXFS())) {
			// 获取税控盘小规模主盘类型ID
			int taxDiscId = discMapper.getIdByCondition("小规模", "分盘");
			// 设置编号
			info.setTaxDiscId(taxDiscId);
			// 设置数量
			info.setQuantity(Integer.parseInt(form.getSXFS()));
			infoMapper.saveTaxInfo(info);
		}

		// 判断如果税控盘主盘数量不为空
		if (!"".equals(form.getSYZS())) {
			// 获取税控盘小规模主盘类型ID
			int taxDiscId = discMapper.getIdByCondition("一般纳税人", "主盘");
			// 设置编号
			info.setTaxDiscId(taxDiscId);
			// 设置数量
			info.setQuantity(Integer.parseInt(form.getSYZS()));
			infoMapper.saveTaxInfo(info);
		}

		// 判断如果税控盘主盘数量不为空
		if (!"".equals(form.getSYFS())) {
			// 获取税控盘小规模主盘类型ID
			int taxDiscId = discMapper.getIdByCondition("一般纳税人", "分盘");
			// 设置编号
			info.setTaxDiscId(taxDiscId);
			// 设置数量
			info.setQuantity(Integer.parseInt(form.getSYFS()));
			infoMapper.saveTaxInfo(info);
		}

		// 判断老户服务费主盘数量是否为空
		if (!"".equals(form.getFZS())) {
			// 获取服务费老户主盘编号
			int serviceChargeId = chargeMapper.getIdByCondition("老户", "主盘");
			// 设置编号
			info.setServiceChargeId(serviceChargeId);
			// 设置数量
			info.setQuantity(Integer.parseInt(form.getFZS()));
			infoMapper.saveServiceChargeInfo(info);
		}

		// 判断老户服务费分盘数量是否为空
		if (!"".equals(form.getFFS())) {
			// 获取服务费老户主盘编号
			int serviceChargeId = chargeMapper.getIdByCondition("老户", "分盘");
			// 设置编号
			info.setServiceChargeId(serviceChargeId);
			// 设置数量
			info.setQuantity(Integer.parseInt(form.getFFS()));
			infoMapper.saveServiceChargeInfo(info);
		}

		// 判断报税盘数量是否为空
		if (!"".equals(form.getBSPS())) {
			// 获取报税盘编号
			int escalationTaxId = escalationTaxMapper.getIdByName("报税盘");
			// 设置编号
			info.setEscalationTaxId(escalationTaxId);
			// 设置数量
			info.setQuantity(Integer.parseInt(form.getBSPS()));
			// 保存信息
			infoMapper.savaEscalationTaxInfo(info);
		}

		// 判断免费更换数量是否为空
		if (!"".equals(form.getSFCS())) {
			// 创建更换盘对象
			TaxDiscReplace taxDiscReplace = new TaxDiscReplace();
			// 设置员工编号
			taxDiscReplace.setEmployeeId(info.getEmployeeId());
			// 设置数量，默认类型为无偿更换，
			taxDiscReplace.setQuantity(Integer.parseInt(form.getSFCS()));
			//设置uuid
			taxDiscReplace.setUuid(info.getUuid());
			//设置数据日期
			taxDiscReplace.setDataDate(info.getDataTime());
			//设置创建时间
			taxDiscReplace.setCreateTime(info.getCreateDate());
			// 保存信息
			discReplaceMapper.saveTaxDiscReplace(taxDiscReplace);

		}

		// 判断有偿更换数量是否为空
		if (!"".equals(form.getSYCS())) {
			// 创建更换盘对象
			TaxDiscReplace taxDiscReplace = new TaxDiscReplace();
			// 设置员工编号
			taxDiscReplace.setEmployeeId(info.getEmployeeId());
			// 设置数量，，
			taxDiscReplace.setQuantity(Integer.parseInt(form.getSYCS()));
			// 设置类型
			taxDiscReplace.setReplaceType(1);
			// 设置价格	
			taxDiscReplace.setPrice(Double.parseDouble(form.getSYCM()));
			//设置uuid
			taxDiscReplace.setUuid(info.getUuid());
			//设置数据日期
			taxDiscReplace.setDataDate(info.getDataTime());
			//设置创建时间
			taxDiscReplace.setCreateTime(info.getCreateDate());
			// 保存信息
			discReplaceMapper.saveTaxDiscReplace(taxDiscReplace);

		}

	}
	@Override
	public double getPriceByType(String type) throws Exception {
		// 判断类型，获取税控盘价格
		if (type.equals("SXZS")) {
			return discMapper.getPriceByCondition("小规模", "主盘");
		}

		if (type.equals("SXFS")) {
			return discMapper.getPriceByCondition("小规模", "分盘");
		}

		if (type.equals("SYZS")) {
			return discMapper.getPriceByCondition("一般纳税人", "主盘");
		}

		if (type.equals("SYFS")) {
			return discMapper.getPriceByCondition("一般纳税人", "分盘");
		}

		//获取服务费价格
		if(type.equals("FZS")){
			return chargeMapper.getPriceByFamilyType("老户","主盘");
		}
				
		if(type.equals("FFS")){
			return chargeMapper.getPriceByFamilyType("老户","分盘");
		}

		// 获取报税盘价格
		if (type.equals("BSPS")) {
			return escalationTaxMapper.getPriceByName("报税盘");
		}

		return 0;
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
	/*
	 * @作者:张恭雨
	 * 
	 * @时间 : 2017年11月24日 上午8:25:05
	 * 
	 * @方法描述:获取该区域以及所有子区域的统计信息
	 */
	@Override
	public StatisticalView getStatisticsInfo(int areaId, String startTime,
			String endTime) throws Exception {
		//获取所有的子节点的区域ID
		List<Integer> areaIds=areaMapper.getAreaByParentIdExceptDepart(1, "部门", areaId);		
		List<Integer> areaIdOnes=areaMapper.getAreaIdByHasParentId(areaIds);
		
		//创建统计视图对象
		StatisticalView statisticalView=new StatisticalView();		
		List<Integer> employeeIds = null;
		//获取所有二级区域的员工ID
		employeeIds=accountMapper.getEmployeeIdByAreaId(areaIds);
		//获取所有三级区域的员工ID
		employeeIds.addAll(accountMapper.getEmployeeIdByAreaId(areaIdOnes));		
		//查询所有员工记录信息
		statisticalView=getTreeData(startTime, endTime,employeeIds,areaId);
		//设置
		statisticalView.setAreaId(areaId);
		
		return statisticalView;
	}
	private StatisticalView getTreeData(String startTime, String endTime,
			List<Integer> employeeIds,int areaId)
			throws Exception {
		StatisticalView statisticalView=new StatisticalView();
		
		Integer taxNumbers=infoMapper.getTaxNumByTime(startTime, endTime, employeeIds);
		Integer serviceNumbers=infoMapper.getServiceNumByTime(startTime, endTime, employeeIds);
		//获取到目前为止的年服务费收取数量
		String startYear=startTime.substring(0, 4)+"-01-01";
		Integer yearServiceNumber=infoMapper.getYearServiceNumByTime(startYear,endTime,employeeIds);
		
		Integer escalationNumbers=infoMapper.getEscalationNumByTime(startTime, endTime, employeeIds);
		Integer equipmentNumbers=infoMapper.getEquipmentNumByTime(startTime, endTime, employeeIds);
		Integer freeReplacementNumbers=discReplaceMapper.getReplaceNumByTime(startTime, endTime, employeeIds,0);
		Integer replacementNumbers=discReplaceMapper.getReplaceNumByTime(startTime, endTime, employeeIds,1);
		//获取应收数
		Integer percent=asccMapper.getNumberByYear(startTime.substring(0, 4),areaId);
		
		//将小数点转化成百分比
		//获取工厂实例
		NumberFormat nf=NumberFormat.getPercentInstance();
		//设置保留小数点位数
		nf.setMaximumFractionDigits(2);
		if(yearServiceNumber!=null){
			//设置服务费百分比
			if(percent!=null){
				if(nf.format((double)yearServiceNumber/percent)!=null){
					statisticalView.setPercent(nf.format((double)yearServiceNumber/percent));
				}
			}
		}else{
			statisticalView.setPercent("0.00%");
		}
		
				
		double total=0;
		double hasHandIn=0;
		
		if(taxNumbers!=null){
			//设置税控盘数量
			statisticalView.setTaxNumber(taxNumbers);
		}
		
		
		if(serviceNumbers!=null){
			//设置服务费数量
			statisticalView.setServiceNumber(serviceNumbers);	
		}		
		
		if(escalationNumbers!=null){
			//设置报税盘数量
			statisticalView.setEscalationNumber(escalationNumbers);
		}		
			
		
		//设置通用设备数量
		if(equipmentNumbers!=null){
			//设置通用设备数量
			statisticalView.setEquipmentNumber(equipmentNumbers);
		}		
		
		
		//设置免费更换数量
		if(freeReplacementNumbers!=null){
			//设置免费更换数量
			statisticalView.setFreeReplacementNumber(freeReplacementNumbers);	
		}		
		
		
		//设置有偿更换数量
		if(replacementNumbers!=null){
			
			statisticalView.setReplacementNumber(replacementNumbers);
		}	
		
		
		/*计算总金额,计算已转金额
		 * 
		 */
		//获取UUID
		List<String> uuid=infoMapper.getUUIDByCondition(startTime, endTime, employeeIds);
		List<String> uuidOne=discReplaceMapper.getUUIDByCondition(startTime, endTime, employeeIds);
		List<String> uuidTwo=new ArrayList<String>();
		uuidTwo=uuid;
		uuidTwo.removeAll(uuidOne);
		uuidTwo.addAll(uuidOne);
		if(uuidTwo.size()!=0){
			//total+=collectMoneyMapper.getTotalMoneyByUUID(uuidTwo); //zgy
			//hasHandIn+=collectMoneyMapper.getTransferMoneyByUUID(uuidTwo);//zgy
			total+=collectMoneyMapper.getTotalMoneyByuuid(uuidTwo); //wpy 20180606 update
			hasHandIn+=collectMoneyMapper.getTransferMoneyByuuid(uuidTwo);//wpy 20180606 update
			statisticalView.setTotalSalesAmount(total);
			statisticalView.setHasHandIn(hasHandIn);
			//判断结果是否大于零，如果小于则为默认值零
			if(total-hasHandIn>0) {
				statisticalView.setNotPay(total-hasHandIn);
			}
			
		}	
		
		return statisticalView;
	}
	
	
	@Override
	public String addCollectMoney(String ZXS, String YZZ,String createDate) throws Exception {
		System.out.println("---PerformanceInfoServiceImpl.addCollectMoney()---");		
		//添加记录
		CollectMoney collectMoney = new CollectMoney();
		//String uuid = UUID.randomUUID().toString()+" "+createDate;	//太长56长度
		String uuid = UUID.randomUUID().toString();
		collectMoney.setUuid(uuid);
		collectMoney.setRevenue(Integer.parseInt(ZXS));
		collectMoney.setTransfer(Integer.parseInt(YZZ));
		collectMoneyMapper.addCollectMoney(collectMoney);
		return uuid;		
	}
	@Override
	public List<StatisticalView> getUnfurledData(int areaId, String startTime,
			String endTime) throws Exception {
		//获取所有的子节点的区域ID
		List<Integer> areaIds=areaMapper.
				getAreaByParentIdExceptDepart(1, "部门", areaId);
		//创建一个list集合
		List<Integer> employeeIds=new ArrayList<Integer>();		
		//创建统计视图集合
		List<StatisticalView> views=new ArrayList<StatisticalView>();
		for(Integer aId:areaIds){
			List<Integer> aIds=new ArrayList<Integer>();
			aIds.add(aId);
			//获取该分公司的员工ID
			employeeIds=accountMapper.getEmployeeIdByAreaId(aIds);
			//获取节点下的所有子节点
			List<Integer> secondIds=areaMapper.getAreaIdByHasParentId(aIds);
			//判断集合是否为空
			if(secondIds.size()!=0){
				//获取区域下的所有员工Id
				employeeIds.addAll(accountMapper.getEmployeeIdByAreaId(secondIds));				
			}
			//设置该条记录区域等级
			StatisticalView view=getTreeData(startTime, endTime, employeeIds,aId);
			view.setAreaId(aId);
			view.setLevel(2);
			//将对象添加到集合中				
			views.add(view);
			
		}
		//获取三级区域数据
		List<StatisticalView> secondViews=getSecondUnfurledData(areaIds, startTime, endTime);
		views.addAll(secondViews);
		return views;
	}
	
	
	private List<StatisticalView> getSecondUnfurledData(List<Integer> areaIds,
			String startTime, String endTime) throws Exception {
		//创建集合对象
		List<StatisticalView> views=new ArrayList<StatisticalView>();
		if(areaIds.size()!=0){
			List<Integer> allAreaIds=areaMapper.getAreaIdByHasParentId(areaIds);
			
			//获取每个区域的信息
			for(Integer aId:allAreaIds){
				List<Integer> aIds=new ArrayList<Integer>();
				aIds.add(aId);
				List<Integer> employeeIds=accountMapper.getEmployeeIdByAreaId(aIds);
				StatisticalView view=getTreeData(startTime, endTime, employeeIds,aId);
				view.setAreaId(aId);
				view.setLevel(3);
				//将对象添加到集合中				
				views.add(view);
			}
		}				
		return views;
	}
	/*
	 * @作者:wangpeiyuan
	 * 
	 * @时间 : 2017年11月28日 上午11:44:31
	 * 
	 * @方法描述:
	 */
	@Override
	public List<PerformanceInfoSelectView> search(String startData, String endData, Account account,String employeeName) throws Exception {
		System.out.println("---PerformanceInfoServiceImpl.search()---");
		//先查询角色名，如果技术服务中心员工
		Role role = roleMapper.getRoleById(account.getRoleId());
		List<PerformanceInfoSelectView> infoSelectViews = new ArrayList<>();
		if(role.getName().equals("管理员")||role.getName().indexOf("技术服务中心")!=-1) {//管理员、技服员工查询
			if(employeeName==null ||employeeName==""||employeeName.length()==0) {//员工名为空
				infoSelectViews = infoSelectViewMapper.search(startData, endData);
			}else {	//不为空	
				List<PerformanceInfoSelectView> infoSelectViewStart = infoSelectViewMapper.search(startData, endData);
				for (PerformanceInfoSelectView performanceInfoSelectView : infoSelectViewStart) {
					if(performanceInfoSelectView.getEmployeeName().equals(employeeName)) {//与集合对比
						infoSelectViews.add(performanceInfoSelectView);
					}
				}
			}
			
		}else if(role.getName().equals("分公司经理")){

			if(employeeName==null ||employeeName==""||employeeName.length()==0) {//员工名为空
				Area area = areaMapper.getAreaById(account.getAreaId());//用户所在区域
				infoSelectViews = infoSelectViewMapper.searchByAreaName(startData, endData, area.getName());
			}else {	//不为空				
				List<PerformanceInfoSelectView> infoSelectViewStart = infoSelectViewMapper.search(startData, endData);			
				int areaId=0,areaParentId=0;
				Area areaChoose = new Area();
				for (PerformanceInfoSelectView performanceInfoSelectView : infoSelectViewStart) {	
					areaChoose = areaMapper.getAreaByName(performanceInfoSelectView.getAreaName());
					areaId = areaChoose.getAreaId();
					areaParentId = areaChoose.getParentId();
					if( (account.getAreaId()==areaId ||account.getAreaId()==areaParentId) && performanceInfoSelectView.getEmployeeName().equals(employeeName)  ) {
						infoSelectViews.add(performanceInfoSelectView);
					}
				}		
			}
		}else{//员工查询
			System.out.println("-----startData:"+startData+";endData:"+endData+";EmployeeId:"+account.getEmployeeId());
			infoSelectViews = infoSelectViewMapper.searchForEmployee(startData, endData,account.getEmployeeId());
		}
		return infoSelectViews;
	}
	
	@Override
	public PerformanceForm toAlter(String uuid) throws Exception {
		System.out.println("---PerformanceInfoServiceImpl.toAlter()---");
		PerformanceForm form = infoMapper.toAlter(uuid);
		if (form==null) {//单独录入税控盘更换表
			form = infoMapper.toAlterOnlyTaxdiscReplace(uuid);	
		}
		return form;
	}

	@Override
	public List<String> getToAlterEqmNum(String uuid) throws Exception {
		System.out.println("---PerformanceInfoServiceImpl.getToAlterEqmNum()---");	
		return infoMapper.getToAlterEqmNum(uuid);
	}

	
	@Override
	public void delet(String uuid) throws Exception {
		System.out.println("---PerformanceInfoServiceImpl.delet()---");	
		//1.删除performanceInfo
		infoMapper.deletPerformanceInfo(uuid);
		//2.删除taxdiscreplace
		discReplaceMapper.deletTaxdiscreplace(uuid);
		//3.删除collectmoney
		collectMoneyMapper.deletCollectmoney(uuid);
	}

	@Override
	public int check(int employeeId, String dataDate) throws Exception {
		String num = infoMapper.check(employeeId, dataDate);
		if(num!=null&&Integer.parseInt(num)>0) {//有当天记录
			return 0;
		}
		return 1;//无记录
	}
	
	
	/*****张恭雨 2017-11-29*****/
	/*
	 * 获取设备记录的详细信息
	 */
	@Override
	public List<EquipmentView> getEquipmentDetail(int areaId, String startTime,
			String endTime) throws Exception {
		//创建view集合对象
		List<EquipmentView> equipmentViews=new ArrayList<EquipmentView>();
		//声明一个集合对象
		List<Integer> employeeIds;
		employeeIds = getEmployeeIdsByAreaId(areaId);	
		//获取集合信息
		equipmentViews=infoMapper.
				getEquipmentViewByCondition(startTime, endTime, employeeIds);		
		//遍历集合获取设备名称和价格
		for(EquipmentView view:equipmentViews){
			Equipment equipment=equipmentMapper.
					getEquipmentById(view.getEquipmentId());
			view.setName(equipment.getName());
			view.setUnitPrice(equipment.getUnitPrice());
			view.setSize(equipmentViews.size());
		}
		return equipmentViews;
		
	}
	
	
	private List<Integer> getEmployeeIdsByAreaId(int areaId) throws Exception {
		List<Integer> employeeIds;
		//判断详细信息类型
		if(areaId==1){
			//获取分公司id
			List<Integer> areaIds=areaMapper.
					getAreaByParentIdExceptDepart(1, "部门", 1);
			//获取二级区域员工ID
			employeeIds=accountMapper.getEmployeeIdByAreaId(areaIds);
			//获取所有子区域ID
			List<Integer> secondAreaIds=areaMapper.
					getAreaIdByHasParentId(areaIds);
			//获取三级区域下的所有员工ID
			employeeIds.addAll(accountMapper.getEmployeeIdByAreaId(secondAreaIds));
			
		}else{
			//获取区域ID,
			List<Integer> areaIds=new ArrayList<Integer>();	
			//子区域ID
			areaIds=areaMapper.getAreaByParentId(areaId);
			//本区域ID
			areaIds.add(areaId);
			//查询员工Id
			employeeIds=accountMapper.
					getEmployeeIdByAreaId(areaIds);
		}
		return employeeIds;
	}
	@Override
	public List<TaxView> getTaxDetail(int areaId, String startTime,
			String endTime) throws Exception {
		//创建view集合对象
		List<TaxView> taxViews=new ArrayList<TaxView>();
		//声明一个集合对象
		List<Integer> employeeIds;
		employeeIds = getEmployeeIdsByAreaId(areaId);		
		//获取集合信息
		taxViews=infoMapper.
				getTaxViewByCondition(startTime, endTime, employeeIds);		
		//遍历集合获取税控盘类型和价格
		for(TaxView view:taxViews){
			TaxDisc taxDisc=taxDiscMapper.
					getTaxDiscById(view.getTaxDiscId());
			view.setTaxDiscType(taxDisc.getTaxDiscType());
			view.setUserType(taxDisc.getUserType());
			view.setPrice(taxDisc.getPrice());
		}
		return taxViews;
	}
	@Override
	public List<ServiceView> getServiceDetail(int areaId, String startTime,
			String endTime) throws Exception {
		//创建view集合对象
		List<ServiceView> servicViews=new ArrayList<ServiceView>();
		//声明一个集合对象
		List<Integer> employeeIds;
		employeeIds = getEmployeeIdsByAreaId(areaId);		
		//获取集合信息
		servicViews=infoMapper.
				getServiceViewByCondition(startTime, endTime, employeeIds);		
		//遍历集合获取税控盘类型和价格
		for(ServiceView view:servicViews){
			ServiceCharge serviceCharge=chargeMapper.
					getServiceChargeById(view.getServiceChargeId());
			view.setFamilyType(serviceCharge.getFamilyType());
			view.setPlateType(serviceCharge.getPlateType());
			view.setPrice(serviceCharge.getPrice());
		}
		return servicViews;
	}
	@Override
	public List<PerformanceInfoSelectView> searchByAreaName(Account account,Role role,String startDate, String endDate,String areaName) throws Exception {
		System.out.println("---PerformanceInfoServiceImpl.searchByAreaId()---");
		
		List<PerformanceInfoSelectView> infoSelectViews = new ArrayList<>();
		//管理员、技服员工查询
		if(areaName.equals("全部")) {
			List<PerformanceInfoSelectView> infoSelectView0 = infoSelectViewMapper.search(startDate, endDate);
			if(role.getName().equals("分公司经理")) {/////////2018/1/22
				int areaId=0,areaParentId=0;
				Area area = new Area();
				for (PerformanceInfoSelectView performanceInfoSelectView : infoSelectView0) {
					//if areaId == 
					area = areaMapper.getAreaByName(performanceInfoSelectView.getAreaName());
					areaId = area.getAreaId();
					areaParentId = area.getParentId();
					if(account.getAreaId()==areaId ||account.getAreaId()==areaParentId) {
						infoSelectViews.add(performanceInfoSelectView);
					}
				}	
			}else {
				for (PerformanceInfoSelectView performanceInfoSelectView : infoSelectView0) {
					infoSelectViews.add(performanceInfoSelectView);
				}
			}
		}else
			infoSelectViews = infoSelectViewMapper.searchByAreaName(startDate, endDate, areaName);
		return infoSelectViews;
	}
	@Override
	public Date getCreateDate(String uuid) throws Exception {
		Date createDate = infoMapper.getCreateDate(uuid);
		if(createDate==null) {
			createDate = discReplaceMapper.getCreateDate(uuid);
		}
		return createDate;
	}
	@Override
	public List<Integer> getChartDate(String year,String month,String day,
			String areaName) throws Exception {
		//获取区域ID
		int areaId=areaMapper.getIdByName(areaName);
		List<Integer> areaIds=new ArrayList<>();		
		List<Integer> secondAreaIds=areaMapper.getAreaByParentId(areaId);
		List<Integer> threeAreaIds = null;
		//判断子区域是否为空
		if(secondAreaIds.size()!=0){
			threeAreaIds=areaMapper.getAreaIdByHasParentId(secondAreaIds);
			areaIds=secondAreaIds;
		}
		
		//合并集合
		if(threeAreaIds!=null)
		  areaIds.addAll(threeAreaIds);
		areaIds.add(areaId);
		
		//获取区域下的所有员工Id
		List<Integer> employeeIds=accountMapper.getEmployeeIdByAreaId(areaIds);
		//根据Id和时间获取记录信息
		List<Integer> data=new ArrayList<Integer>();		
		String time=year+"/"+month+"/";
		for(int i=1;i<=Integer.parseInt(day);i++){
			String dataTime=time+i+"";
			Integer num=infoMapper.getChartDateByTime(dataTime, dataTime, employeeIds);
			if(num!=null)
				data.add(num);
			else
				data.add(0);
				
		}
		return data;
	}
	
}
