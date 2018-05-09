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
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"/>
<link rel="stylesheet" href="<%=path%>/css/sapar.css" />
<script type="text/javascript" src="<%=path%>/js/jquery.js"></script>
<script type="text/javascript" src="<%=path%>/js/sapar.js"></script>
<link href="<%=path%>/ztree/css/zTreeStyle/zTreeStyle.css"
	type="text/css" rel="stylesheet">
<script type="text/javascript"
	src="<%=path%>/js/jquery.js"></script>
<script type="text/javascript"
	src="<%=path%>/ztree/js/jquery.ztree.core.min.js"></script>
<script type="text/javascript"
	src="<%=path%>/ztree/js/jquery.ztree.excheck.min.js"></script>
<script type="text/javascript" src="<%=path%>/js/role.js"></script>
<title>角色分配</title>

</head>

<body>
	<div id="saper-container">

		<div style="position: absolute; width: 100%;">

			<div class="subfiled clearfix">
				<h2>检索用户信息</h2>
			</div>
		</div>
		<div style="position: absolute; left: 20px; top: 50px;">

			<div class="search-box clearfix">
				<p id="choseContext" style="color: green"></p>
				<div class="kv-item clearfix">
					<label><h2>筛选方式：</h2></label>
				</div>
				<div class="kv-item clearfix">	
					<label><input type="radio" name="chooseType" value="按姓名" onclick="showChooseType()" checked/>按姓名</label>					
					<label><input type="radio" name="chooseType" value="按区域" onclick="showChooseType()"/>按区域</label>
				</div>
				
				<div class="kv-item clearfix" id="chooes1">
					<label>员工姓名：</label>

					<div class="kv-item-content time-select-wrap">
						<input type="hidden" id="dq" value="null"> 
						<input type="hidden" id="dqid" value="${dqid }"> 
						<input type="text" id="name" name="name" style="width: 100px; height: 31px" value="${name}" onblur="getName()" placeholder="请输入姓名" />
					</div>
					<a onclick="searchByName(0)" class="sapar-btn sapar-btn-recom query-btn">查询</a>
				</div>
				
				<div class="kv-item clearfix" id="chooes2" style="display: none;">
					<label>区域选择：</label>
					<!-- 菜单实现 -->
					<div class="zTreeDemoBackground left"
						style="position: absolute; left: 70px;">
						<ul id="treeDemo" class="ztree"></ul>
					</div>
				</div>
			</div>
		</div>
		<div
			style="position: absolute; left: 25%; top: 50px; width: 75%; height: 100%">
			<!--表格开始-->
			<div class="table">

				<!--表格具体内容-->
				<div class="table-box">
					<table>
						<thead>
							<tr>
								<th>工号</th>
								<th>区域</th>
								<th>员工姓名</th>
								<th>角色</th>
								<th>操作</th>
							</tr>
						</thead>
						<tbody id="tbody">

							<c:forEach var="view" items="${accountAreaEmployeeRoleViewList}">
								<tr>
									<td id="no">${view.employeeId}</td>
									<td>${view.areaName}</td>
									<td>${view.employeeName}</td>
									<td style="width: 100px;"><select id="${view.employeeId}"
										style="width: 100%;">
											<option value="${view.roleId }">${view.roleName}</option>
											<c:forEach var="roles" items="${roleList}">
												<c:if test="${roles.name!=role.name}">
													<option value="${roles.roleId}">${roles.name}</option>
												</c:if>
											</c:forEach>
									</select></td>
									<td><a href="" onclick="save(${view.employeeId});">保存</a></td>
								</tr>

							</c:forEach>
						</tbody>
					</table>
				</div>
			</div>
			<!-- 分页求美工 -->
			<div id="paging">
				<c:if test="${type=='normal'}">
					<a href="roleIndex.do"> 首页 </a>
				</c:if>
				<c:if test="${type=='search'}">
					<a onclick="searchByName(0)"> 首页 </a>
				</c:if>
				<c:if test="${nowPage>0}">

					<c:if test="${type=='normal'}">
						<a
							href="rolePageContent.do?page=${nowPage-1}&pageNumber=${pageNumber}">
							&lt;&lt;上一页 </a>
					</c:if>

					<c:if test="${type=='search'}">
						<a onclick="searchByName(${nowPage-1})">&lt;&lt;上一页 </a>
					</c:if>

				</c:if>
				${nowPage+1}/${pageNumber}

				<c:if test="${nowPage<pageNumber-1}">

					<c:if test="${type=='normal'}">
						<a
							href="rolePageContent.do?page=${nowPage+1}&pageNumber=${pageNumber}">
							下一页&gt;&gt; </a>
					</c:if>

					<c:if test="${type=='search'}">
						<a onclick="searchByName(${nowPage+1})">下一页&gt;&gt; </a>
					</c:if>

				</c:if>
				<c:if test="${type=='normal'}">
					<a
						href="rolePageContent.do?page=${pageNumber-1}&pageNumber=${pageNumber}">
						尾页 </a>
				</c:if>
				<c:if test="${type=='search'}">
					<a onclick="searchByName(${pageNumber-1})">尾页 </a>
				</c:if>
			</div>
		</div>

		<div id="saper-ft"></div>
	</div>

</body>
</html>