package com.bwjf.serviceImpl;

import java.net.URLEncoder;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import net.sf.json.JSONArray;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bwjf.entity.Account;
import com.bwjf.entity.Area;
import com.bwjf.entity.Employee;
import com.bwjf.entity.EmployeeDateVo;
import com.bwjf.mapper.AccountMapper;
import com.bwjf.mapper.AreaMapper;
import com.bwjf.mapper.DepartmentMapper;
import com.bwjf.mapper.EmployeeMapper;
import com.bwjf.mapper.RoleMapper;
import com.bwjf.service.EmployeeService;
import com.bwjf.utils.DateUtil;
import com.bwjf.utils.MD5Util;
import com.bwjf.utils.PinyinUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;


/**
 * @author 张恭雨
 * 创建时间：2017年10月20日 下午4:04:53
 * 类描述：
 * 版本：v1.0 
 */
@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService {
	private EmployeeMapper employeeMapper;
	private DepartmentMapper departmentMapper;
	private AccountMapper accountMapper;
	private AreaMapper areaMapper;
	private RoleMapper roleMapper;
	public EmployeeMapper getEmployeeMapper() {
		return employeeMapper;
	}
	@Resource
	public void setEmployeeMapper(EmployeeMapper employeeMapper) {
		this.employeeMapper = employeeMapper;
	}

	public DepartmentMapper getDepartmentMapper() {
		return departmentMapper;
	}
	@Resource
	public void setDepartmentMapper(DepartmentMapper departmentMapper) {
		this.departmentMapper = departmentMapper;
	}
	public AccountMapper getAccountMapper() {
		return accountMapper;
	}
	@Resource
	public void setAccountMapper(AccountMapper accountMapper) {
		this.accountMapper = accountMapper;
	}
	public AreaMapper getAreaMapper() {
		return areaMapper;
	}
	@Resource
	public void setAreaMapper(AreaMapper areaMapper) {
		this.areaMapper = areaMapper;
	}
	public RoleMapper getRoleMapper() {
		return roleMapper;
	}
	@Resource
	public void setRoleMapper(RoleMapper roleMapper) {
		this.roleMapper = roleMapper;
	}
	@Override
	public String getNameById(int employeeId) throws Exception {
		//获取员工的姓名
		return employeeMapper.getNameById(employeeId);
	}
	/*
	 * 获取员工信息分页
	 */
	@Override
	public PageInfo<Employee> getEmployeeByPage(Integer pageNum,
			Integer pageSize) throws Exception {
		// TODO Auto-generated method stub
		PageHelper.startPage(pageNum, pageSize);
		//所有用户信息
		List<Employee> employees=employeeMapper.getEmployee();
		//判断集合是否为空
		if(employees==null){
			return null;
		}
		
		PageInfo<Employee> pageInfo=new PageInfo<Employee>(employees);
		return pageInfo;
	}
	/*
	 * 获取员工详细信息
	 */
	@Override
	public List<Object> getEmployeeDetailById(int employeeId) throws Exception {
		//获取员工详细信息
		Employee employee=employeeMapper.getEmployeeDetailById(employeeId);
		//根据部门ID获取部门名称
		String name=departmentMapper.getDepartmentNameById(employee.getDepartmentId());
		//创建一个list集合
		List<Object> list=new ArrayList<Object>();
		//创建对象
		EmployeeDateVo dateVo=new EmployeeDateVo();
		dateVo.setBirthdayVo(getFormatDate(employee.getBirthday()));
		dateVo.setGraduationDateVo(getFormatDate(employee.getGraduationDate()));
		dateVo.setHireDateVo(getFormatDate(employee.getHireDate()));
		dateVo.setPositivePhaseVo(getFormatDate(employee.getPositivePhase()));
		dateVo.setProbationPeriodVo(getFormatDate(employee.getProbationPeriod()));
		dateVo.setWorkDateVo(getFormatDate(employee.getWorkDate()));
		//将员工和部门名称放到集合中
		list.add(employee);
		list.add(name);
		list.add(dateVo);
		return list;
	}
	
	
	
	@Override
	public List<Object> getAlterEmployeeDetialById(int employeeId) throws Exception {
		//获取员工的详细信息
		Employee employee=employeeMapper.getEmployeeDetailById(employeeId);
		//根据部门ID获取部门名称
		String name=departmentMapper.getDepartmentNameById(employee.getDepartmentId());
		//创建一个list集合
		List<Object> list=new ArrayList<Object>();
		//判断地址是否为空
		if(employee.getAddress()!=null){
			//格式化显示地址
			String s[]=employee.getAddress().split("\\-");
			list.add(s[0]);
			list.add(s[1]);
			list.add(s[2]);
			list.add(s[3]);
		}
		
		//将数据放到集合中返回
		list.add(employee);
		list.add(name);		
		return list;
	}
	@Override
	public JSONArray getDepartmentNameByFiltrate(int status, int departmentId) throws Exception {
		//获取筛选条件下的部门名称
		List<String> list=departmentMapper.getNameByFiltrate(status, departmentId);
		JSONArray array=new JSONArray();
		array=JSONArray.fromObject(list);
		return array;
		
	}
	@Override
	public int getDepartmentIdById(int employeeId) throws Exception {
		//获取员工部门ID
		return employeeMapper.getDepartmentIdById(employeeId);
	}
	@Override
	public void updateEmployeeById(List<Object> list) throws Exception {
		saveOrUpdate(list,true);	
		
	}
	
	@Override
	public void deleteEmployeeById(int employeeId) throws Exception {
		// 删除员工信息		
		accountMapper.deleteAccountByEmployeeId(employeeId);
		employeeMapper.deleteEmployeeById(employeeId);
		
	}
	@Override
	public void saveEmployee(List<Object> list) throws Exception {
		//添加员工信息，
		saveOrUpdate(list,false);
		//添加帐户信息
		Employee employee=(Employee) list.get(0);
		String areaName =(String) list.get(7);
		//查询所属区域ID
		int areaId=areaMapper.getIdByName(areaName);
		//获取普通员工ID
		int roleId=roleMapper.getIdByName("普通用户");
		//获取用户id
		int employeeId=employeeMapper.getEmployeeIdByCard(employee.getIdCard());
		//获取帐户信息
		Account account=(Account) list.get(8);
		
		//设置账户属性
		account.setAccountId(PinyinUtil.getPinyin(employee.getName()));
		account.setEmployeeId(employeeId);
		account.setAreaId(areaId);
		account.setRoleId(roleId);
		account.setPassword(MD5Util.getMD5("123456"));
		//保存帐户信息
		accountMapper.saveAccount(account);
	}
	
	private String getFormatDate(Date date) throws ParseException{
		//格式化员工信息中的日期属性
		SimpleDateFormat foramt=new SimpleDateFormat("yyyy-MM-dd");
		//判断日期是否为空
		if("".equals(date)||date==null)
			return null;
		String time=foramt.format(date);		
		Date dateOne=foramt.parse(time);
		String s[]=dateOne.toLocaleString().split("\\ ");
		String result=s[0];
		return result;
	}
	
	private void saveOrUpdate(List<Object> list,boolean isUpdate) throws Exception {
		//获取集合中的信息
		Employee employee=(Employee) list.get(0);		
		String address=(String)list.get(1)+"-"+list.get(2)+"-"+list.get(3)+"-"+list.get(4);		
		String departmentName=(String) list.get(5);
		EmployeeDateVo dateVo=(EmployeeDateVo) list.get(6);
		//判断地址是否为空
		if(address.length()<=4){
			address="";
		}			
		//设置地址
		employee.setAddress(address);
		//判断是否为空
		if(!"".equals(departmentName)){
			//获取部门id
			Integer departmentId=departmentMapper.getIdByName(departmentName);
			//判断Id是否为空
			if(departmentId==null)
				//设置部门Id
				employee.setDepartmentId(0);
			else
				employee.setDepartmentId(departmentId);
		}
		//设置日期
		employee.setBirthday(DateUtil.getDate(dateVo.getBirthdayVo()));
		employee.setGraduationDate(DateUtil.getDate(dateVo.getGraduationDateVo()));
		employee.setHireDate(DateUtil.getDate(dateVo.getHireDateVo()));
		employee.setPositivePhase(DateUtil.getDate(dateVo.getPositivePhaseVo()));
		employee.setProbationPeriod(DateUtil.getDate(dateVo.getProbationPeriodVo()));
		employee.setWorkDate(DateUtil.getDate(dateVo.getWorkDateVo()));
		if(isUpdate){
			//保存更新信息		
			employeeMapper.updateEmployeeById(employee);
			accountMapper.updateStatusByEmployeeId(employee.getEmployeeId(), employee.getStatus());
		}else{
			//插入员工记录
			employeeMapper.saveEmployee(employee);
		}
		
	}
	@Override
	public PageInfo<Employee> searchEmployee(String msg,Integer pageNum,Integer pageSize) throws Exception {	
		
		//创建一个pageHelper对象
		PageHelper.startPage(pageNum, pageSize);	
		//声明一个员工集合
		List<Employee> employees;
		employees=employeeMapper.searchEmployeeByName(msg);
		//判断集合是否为空
		if(employees.size()==0){
			employees=employeeMapper.searchEmployeeByJob(msg);
		}
		if(employees.size()==0){
			employees=employeeMapper.searchEmployeeByPhone(msg);
		}
		if("".equals(employees)||employees==null){
			return null;
		}
		PageInfo<Employee> pageInfo=new PageInfo<Employee>(employees);
		return pageInfo;		
	}
	@Override
	public JSONArray getAllArea(int status) throws Exception {
		// 获取所有的区域信息
		List<Area> areas=areaMapper.getAllArea(status);
		//创建一个JSONArray对象
		JSONArray array=new JSONArray();
		//将数据转换成jsonarray格式
		array=JSONArray.fromObject(areas);
		return array;
	}
	
	//--------------------------------------------------------
	/*
	 * 王培源
	 */
	
	@Override
	public List<Employee> getEmployeeByList(List<Account> accountList) throws Exception{
		
		//1.输出数据流向日志	
		//2.查询员工信息,插入集合emList
		System.out.println("---EmployeeServiceImpl.getEmployeeByList(List<Account> accountList)---");
		System.out.println("---accountList.size()"+accountList.size()+"---");
		
		List<Employee> emList = new ArrayList<>();
		Employee e = null;
		for (Account account : accountList) {
			//System.out.println(account.toString());
			e = new Employee();
			e = employeeMapper.getEmployeeById(account.getEmployeeId());
			emList.add(e);
		}
		return emList;
	}

	@Override
	public List<Employee> getEmployeeByName(String name) throws Exception{
		System.out.println("---EmployeeServiceImpl.getEmployeeByName(name:"+name+")---");
		
		return employeeMapper.getEmployeeByName(name);
	}
	@Override
	public List<Employee> getOneEmployeeByName(String name) throws Exception{
		
		return employeeMapper.getOneEmployeeByName(name);
	}
	

}
