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
<link rel="stylesheet" type="text/css" href="css/box.css" />
<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript" src="js/sapar.js"></script>
<script type="text/javascript" src="js/department.js"></script>
<title>部门管理</title>
</head>
<body>
	
	<div id="saper-container">
		<div id="saper-hd"></div>
		<div id="saper-bd">
			<div class="subfiled clearfix">
				<h2>部门管理</h2>
			</div>
			<div class="subfiled-content">
				<div class="search-box clearfix">

					<div class="kv-item clearfix">
						<label>部门名：</label>
						<div class="kv-item-content">
							<input id="queryName" type="text" placeholder="请输入部门名" />
						</div>
					</div>

					<a href="javascript:query();"
						class="sapar-btn sapar-btn-recom query-btn">查询</a>
				</div>


				<!--表格开始-->
				<div class="table">

					<!--表格操作-->
					<div class="table-operate ue-clear">
						<a href="javascript:msgBox(1);" class="add">添加部门</a>
					</div>

					<div id="inputbox" class="box">
						<div class="search-box clearfix">
							<div class="kv-item clearfix">
								<div class="kv-item-content">
									<input id="departmentName" style="width: 150px" type="text"
										placeholder="请输入部门名" />
									<p
										style="position: absolute; left: 190px; top: 150px; color: red"
										id="msg"></p>
								</div>
							</div>
						</div>

						<a class="sapar-btn sapar-btn-recom query-btn" onClick="add()">确定</a>
						<a style="position: absolute; left: 70px; top: 183px;"
							class="sapar-btn sapar-btn-recom query-btn" onClick="msgBox(0)">退出</a>

					</div>

					<!--表格具体内容-->
					<div class="table-box">
						<table>
							<thead>
								<tr>
									<th class="num">部门名</th>
									<!-- <th class="num">状态</th>  -->
									<th class="operate">操作</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach var="d" items="${departmentList}">
									<tr>
										<td id="${d.departmentId}">${d.name}</td>
										<!-- 								
										<td>
										<c:if test="${d.status==1}">
											有效
										</c:if>
										<c:if test="${d.status==0}">
											无效
										</c:if>
										</td>
										 -->
										<td><a
											href="javascript:edit(${d.departmentId},'${d.name}');">编辑</a>&nbsp;&nbsp;&nbsp;&nbsp;
											<a href="javascript:delet(${d.departmentId});">删除</a></td>
									</tr>
								</c:forEach>
								<tr>
									<td id="newDepartmentName"></td>
									<!-- <td id="newStatus"></td>  -->
									<td id="newOperationButton"></td>
								</tr>
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