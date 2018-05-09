package com.bwjf.entity;

import java.util.Date;

/**
 * @author 张恭雨
 * 创建时间：2017-10-17 下午3:48:07
 * 类描述：员工信息实体类
 * 版本：v1.0 
 */
public class Employee {
	private int employeeId;			//员工ID
	private String name;			//员工姓名
	private String idCard;			//身份证号
	private String phone;			//手机号
	private String address;			//居住地址
	private String lastJob;			//原职位
	private String nowJob;			//现职位
	private	String nativePlace;		//籍贯
	private String educational;		//学历
	private int departmentId;		//部门ID	
	private Date hireDate;			//入职时间
	private String email;			//邮箱
	private String sex;				//性别
	private String nation;			//民族	
	private Date birthday;			//出生日期
	private String politicsStatus;	//政治面貌	
	private Date workDate;		//工作时间
	private String specialty;		//特长
	private String familyRelationships;		//家庭关系
	private String socialRelations;			//社会关系
	private String resume;			//个人简历
	private String remark;			//备注	
	private Date probationPeriod;		//试用日期
	private Date positivePhase;			//转正日期	
	private Date graduationDate;		//毕业时间
	private int status;				//员工是否在职 1：在职，0：离职
	
	public int getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getLastJob() {
		return lastJob;
	}
	public void setLastJob(String lastJob) {
		this.lastJob = lastJob;
	}
	public String getNowJob() {
		return nowJob;
	}
	public void setNowJob(String nowJob) {
		this.nowJob = nowJob;
	}
	public String getNativePlace() {
		return nativePlace;
	}
	public void setNativePlace(String nativePlace) {
		this.nativePlace = nativePlace;
	}
	public String getEducational() {
		return educational;
	}
	public void setEducational(String educational) {
		this.educational = educational;
	}
	public int getDepartmentId() {
		return departmentId;
	}
	public void setDepartmentId(int departmentId) {
		this.departmentId = departmentId;
	}
	
	public Date getHireDate() {
		return hireDate;
	}
	public void setHireDate(Date hireDate) {
		this.hireDate = hireDate;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getNation() {
		return nation;
	}
	public void setNation(String nation) {
		this.nation = nation;
	}


	public String getSpecialty() {
		return specialty;
	}
	public void setSpecialty(String specialty) {
		this.specialty = specialty;
	}
	public String getFamilyRelationships() {
		return familyRelationships;
	}
	public void setFamilyRelationships(String familyRelationships) {
		this.familyRelationships = familyRelationships;
	}
	public String getSocialRelations() {
		return socialRelations;
	}
	public void setSocialRelations(String socialRelations) {
		this.socialRelations = socialRelations;
	}
	public String getResume() {
		return resume;
	}
	public void setResume(String resume) {
		this.resume = resume;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	
	public Date getProbationPeriod() {
		return probationPeriod;
	}
	public void setProbationPeriod(Date probationPeriod) {
		this.probationPeriod = probationPeriod;
	}
	
	public Date getPositivePhase() {
		return positivePhase;
	}
	public void setPositivePhase(Date positivePhase) {
		this.positivePhase = positivePhase;
	}
	
	public Date getGraduationDate() {
		return graduationDate;
	}
	public void setGraduationDate(Date graduationDate) {
		this.graduationDate = graduationDate;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}

	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public String getPoliticsStatus() {
		return politicsStatus;
	}
	public void setPoliticsStatus(String politicsStatus) {
		this.politicsStatus = politicsStatus;
	}
	
	public Date getWorkDate() {
		return workDate;
	}
	public void setWorkDate(Date workDate) {
		this.workDate = workDate;
	}
	public String getIdCard() {
		return idCard;
	}
	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}
	
	
	
	
	
}
