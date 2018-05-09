<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"/>
<link rel="stylesheet" href="css/sapar.css" />
<link rel="stylesheet" type="text/css" href="css/my_info.css" />
<link rel="stylesheet" href="css/form.css" />
<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript" src="js/sapar.js"></script>
<!-- 
<script type="text/javascript" src="js/employee-add-verify.js"></script>
 -->
<link rel="stylesheet" href="css/reset.css" />
<link rel="stylesheet" href="css/style.css" />
<style media="screen">
	body{padding:100px;font-size: 14px;}
	h1{font-size: 26px;}
	p{font-size: 14px; margin-top: 10px;}
	pre{background:#eee;border:1px solid #ddd;border-left:4px solid #f60;padding:15px;margin-top: 15px;}
	h2{font-size: 20px;margin-top: 20px;}
	.case{margin-top: 15px}
	.ECalendar{width:400px;height:30px;}
</style>
<script src="js/jquery.min.js"></script>
<script src="js/Ecalendar.jquery.min.js"></script>
<script type="text/javascript">
var isFirst = true;   
function showDepartment(){
		var department=document.getElementById("department");
		$.ajax({
			url:"employee/showDepartment.do",
			type:"post",
			data:{},			
			dataType:"json",
			success: function(data){
				//判断是否为第一次执行
				if(isFirst==true){
					//将数据转换成json格式										
					var child=eval(data);				
					for(var i=0;i<child.length;i++){
					//动态的创建节点				
					var departmentName=document.createElement("option");				
					//设置节点的value属性				
					departmentName.innerHTML=child[i];				
					//添加子节点
					department.appendChild(departmentName);
					//设置全局变量为
					isFirst=false;	
				}
															
			}
		}
		
	});
}
</script>
<script type="text/javascript">
var falg = true;   
function showArea(){
		var area=document.getElementById("area");
		$.ajax({
			url:"employee/showArea.do",
			type:"post",
			data:{},			
			dataType:"json",
			success: function(data){
				//判断是否为第一次执行
				if(falg==true){
					//将数据转换成json格式										
					var child=eval(data);				
					for(var i=0;i<child.length;i++){
					//动态的创建节点				
					var areaName=document.createElement("option");				
					//设置节点的value属性				
					areaName.innerHTML=child[i].name;				
					//添加子节点
					area.appendChild(areaName);
					//设置全局变量为
					falg=false;	
				}
															
			}
		}
		
	});
}
</script>

<title>添加员工信息</title>
</head>
<body>
	<div id="saper-container">
		<div id="saper-hd"></div>
		<div id="saper-bd">
			<div class="subfiled clearfix">
				<h2>我的信息</h2>
			</div>
			<div class="subfiled-content">
				<div class="tab-container" data-trigger="hover">
					<div class="tab">
						<a href="javascript:;" class="current">添加信息</a>
					</div>
					<div class="tab-content">
						<div class="tab-content-item">
							<form name="f1" id="f1"
								action="employee/add.do"
								onsubmit="return verify()"
								method="post">
								<!--
                                	作者：张恭雨
                                	时间：2017-10-18
                                	描述：表单左部
                                -->
								<div id="form-left">
									<div class="kv-item clearfix">
										<label>员工姓名：</label>
										<div class="kv-item-content" style="line-height: 30px;">
											<input name="name" id="name" type="text" placeholder="姓名" value="${employee.name}">
										</div>
									</div>	
									
									<div class="kv-item clearfix">
										<label><span class="impInfo">*</span>电话：</label>
										<div class="kv-item-content">
											<input name="phone" id="phone" type="text" placeholder="电话" value="${employee.phone}">
										</div>
									</div>

									<div class="kv-item clearfix">
										<label><span class="impInfo">*</span>身份证号：</label>
										<div class="kv-item-content">
											<input name="idCard" type="text"
												id="idCard"
												placeholder="请输入18位身份证号" value="${employee.idCard}">
										</div>
									</div>

									<div class="kv-item clearfix">
										<label><span class="impInfo">*</span>籍贯：</label>
										<div class="kv-item-content">
											<input name="nativePlace" id="nativePlace" type="text" placeholder="籍贯" value="${employee.nativePlace}">
										</div>
									</div>

									<div class="kv-item clearfix">
										<label><span class="impInfo">*</span>学历：</label>
										<div class="kv-item-content">
											<input name="educational" type="text"
												id="educational"
												placeholder="学历" value="${employee.educational}">
										</div>
									</div>

									<div class="kv-item clearfix">
										<label><span class="impInfo">*</span>部门：</label>
										<div class="kv-item-content" >
											<select name="departmentName" id="department" onclick="showDepartment()">
												<option>请选择部门</option>												
											</select>
										</div>
									</div>

									<div class="kv-item address clearfix">
										<label><span class="impInfo">*</span>详细地址：</label>
										<div class="kv-item-content">
											<div class="outer">
												<select name="province" id="province">
													<option value="请选择">请选择</option>
												</select><br/>
												<select name="city" id="city">
													<option value="请选择">请选择</option>
												</select><br/>
												<select name="town" id="town">
													<option value="请选择">请选择</option>
												</select>
											</div>											
											 <input name="addressDetail" id="addressDetail" type="text" placeholder="街道" value="${addressThree}">
										</div>
									</div>

									<div class="kv-item clearfix">
										<label>入职时间：</label>
										<div class="calendarWarp" style="">
												<input type="date" name="hireDateVo" 												
												placeholder="入职日期"
												value="${employee.hireDate}"	/>
										</div>										
									</div>

									<div class="kv-item clearfix">
										<label>邮箱：</label>
										<div class="kv-item-content">
											<input name="email" type="email" placeholder="邮箱" value="${employee.email}">
										</div>
									</div>

									<div class="kv-item clearfix">
										<label>原职位：</label>
										<div class="kv-item-content">
											<input name="lastJob" id="lastJob" type="text" placeholder="原职位" value="${employee.lastJob}">
										</div>
									</div>


									<div class="kv-item clearfix">
										<label>现职位：</label>
										<div class="kv-item-content">
											<input name="nowJob" id="nowJob" type="text" placeholder="原职位" value="${employee.nowJob}">
										</div>
									</div>
								</div>
								<!--
                                	作者：张恭雨
                                	时间：2017-10-18
                                	描述：表单右部
                                -->
								<div id="form-rigth">
									<div class="kv-item clearfix">
										<label><span class="impInfo">*</span>性别：</label>
										<div class="kv-item-content">
											<span class="choose"> <input name="sex"
												type="radio" checked="true" value="男"> <span
												class="text">男</span>
											</span> <span class="choose"> <input name="sex"
												type="radio" value="女"> <span class="text">女</span>
											</span>
										</div>
									</div>

									<div class="kv-item clearfix">
										<label>民族：</label>
										<div class="kv-item-content">
											<input name="nation" id="nation" type="text" placeholder="民族" value="${employee.nation}">
										</div>
									</div>									
									

									<div class="kv-item clearfix">
										<label>出生日期：</label>										
										<div class="case">
											<div class="calendarWarp" style="">
												<input type="date" name="birthdayVo"
												id="birthday" 												
												placeholder="出生日期"
												value="${employee.birthday}"	/>
											</div>
										</div>
									</div>
									
									

									<div class="kv-item clearfix">
										<label>政治面貌：</label>
										<div class="kv-item-content">
											<input name="politicsStatus" 
												id="politicsStatus"
												type="text"
												placeholder="政治面貌"
												value="${employee.politicsStatus}">
										</div>
									</div>

									<div class="kv-item clearfix">
										<label>工作时间：</label>
										<div class="case">
											<div class="calendarWarp" style="">
												<input type="date" name="workDateVo" 												
												placeholder="工作时间"
												value="${employee.workDate}"	/>
											</div>
										</div>																	
									</div>

									<div class="kv-item clearfix">
										<label>试用日期：</label>
										<div class="case">
											<div class="calendarWarp" style="">
												<input type="date" name="probationPeriodVo"												
												placeholder="试用日期"
												value="${employee.probationPeriod}"	/>
											</div>
										</div>											
									</div>


									<div class="kv-item clearfix">
										<label>转正日期：</label>
										<div class="case">
											<div class="calendarWarp" style="">
												<input type="date" name="positivePhaseVo"												
												placeholder="转正日期"
												value="${employee.positivePhase}"	/>
											</div>
										</div>
										
									</div>

									<div class="kv-item clearfix">
										<label>毕业时间：</label>
										<div class="case">
											<div class="calendarWarp" style="">
												<input type="date" name="graduationDateVo"												
												placeholder="毕业时间"
												value="${employee.graduationDate}"	/>												
											</div>
										</div>
									</div>

									<div class="kv-item clearfix">
										<label>员工状态：</label>
										<div class="kv-item-content">
											<span class="choose"> <input name="status"
												type="radio" checked="true" value="1"> <span
												class="text">在职</span>
											</span> <span class="choose"> <input name="status"
												type="radio" value="0"> <span class="text">离职</span>
											</span>
										</div>
									</div>
								</div>
								<!--
                                	作者：张恭雨
                                	时间：2017-10-18
                                	描述：表单底部
                                -->
								<div id="form-button-left">
									<div class="kv-item clearfix">
										<label>家庭关系：</label>
										<div class="kv-item-content">
											<textarea name="familyRelationships"
												placeholder="家庭关系">${employee.familyRelationships}</textarea>
										</div>
									</div>

									<div class="kv-item clearfix">
										<label>社会关系：</label>
										<div class="kv-item-content">
											<textarea name="socialRelations" placeholder="社会关系">${employee.socialRelations}</textarea>
										</div>
									</div>


								</div>

								<div id="form-button-right">
								
									<div class="kv-item clearfix">
										<label><span class="impInfo">*</span>所属区域：</label>
										<div class="kv-item-content" >
											<select name="areaName" id="area" onclick="showArea()">
												<option>请选择区域</option>												
											</select>
										</div>
									</div>
								
									<div class="kv-item clearfix">
										<label>个人简历：</label>
										<div class="kv-item-content">
											<textarea name="resume" placeholder="个人简历">${employee.resume}</textarea>
										</div>
									</div>
									
									<div class="kv-item clearfix">
										<label>特长爱好：</label>
										<div class="kv-item-content">
											<textarea name="specialty" placeholder="特长爱好">${employee.specialty}</textarea>
										</div>
									</div>

									<div class="kv-item clearfix">
										<label>备注：</label>
										<div class="kv-item-content">
											<textarea name="remark" placeholder="备注">${employee.remark}</textarea>
										</div>
									</div>

								</div>
								<div id="form-button-tijiao">
									<input type="submit"
										class="sapar-btn sapar-btn-recom query-btn" value="提交" />
								</div>

							</form>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<div id="saper-ft"></div>
	</div>

</body>

<script type="text/javascript">
	$('select').iSelect();
</script>
<script src="js/jquery-1.10.2.js"></script>
<script src="js/area.js"></script>
<script src="js/select.js"></script>
</html>