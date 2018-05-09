<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"/>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="css/sapar.css" />
<link rel="stylesheet" type="text/css" href="css/detail.css" />
<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript" src="js/sapar.js"></script>
<script type="text/javascript" src="js/areaChange.js"></script>
<title>部门管理</title>
</head>
<body>
	<div id="saper-container">
		<div id="saper-hd"></div>
		<div id="saper-bd">
			<div class="subfiled clearfix">
				<h2>检索员工</h2>
			</div>
			<div class="subfiled-content">
				<div class="search-box clearfix">

					<div class="kv-item clearfix">
						<label>姓名：</label>
						<div class="kv-item-content">
							<input id="queryName" type="text" placeholder="请输入员工姓名" />
						</div>
					</div>

					<a href="javascript:query();" class="sapar-btn sapar-btn-recom query-btn">查询</a>
				</div>


				<!--表格开始-->
				<div class="table">
		
					<!--表格具体内容-->
					<div class="table-box">
						<table>
							<thead>
								<tr>
									<th class="num">所在区域</th>
									<th class="num">变更区域为</th>
									<th class="num">工号</th>
									<th class="num">姓名</th>
									<th class="operate">操作</th>
								</tr>
							</thead>
							<tbody>		
								<c:forEach var="v" items="${accountAreaEmployeeRoleViews}" varStatus="a">								
									<tr>
										<td id="${v.areaId}">${v.areaName}</td>				
										<th>
											<select id="newAreaId">
												<c:forEach var="areaAll" items="${areaAllList}">											
													<option value="${areaAll.areaId}">							
														${areaAll.name}
													</option>
												</c:forEach>
											</select>
										</th>
										<td>${v.employeeId}</td>
										<td>${employeeName}</td>
										<td><a href="javascript:edit(${v.areaId},${v.employeeId});">确认变更</a></td>
									</tr>						
								</c:forEach>
							</tbody>
						</table>
					</div>
				</div>
				<!--表格结束-->
			</div>
		</div>
		<div id="saper-ft"></div>
	</div>
</body>
</html>