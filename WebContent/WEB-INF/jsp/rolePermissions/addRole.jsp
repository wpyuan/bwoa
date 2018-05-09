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
<script type="text/javascript" src="<%=path%>/js/addRole.js"></script>
<title>添加角色</title>
</head>
<body>
	
	<div class="subfiled clearfix">
		<h2>添加角色</h2>
	</div>
	<div class="subfiled-content">
		<div class="search-box clearfix">
			<div class="kv-item clearfix">
				<label>已有角色：</label>
				<div class="kv-item-content" id="roleList">
					<br>				
					<c:forEach var="role" items="${roleList}">
						<p style="font-size: 12px">● ${role.name }</p><br>
					</c:forEach>					
					<br>
				</div>
			</div>
			
			<div class="kv-item clearfix">
				
				<div class="kv-item-content">
					<input id="addRoleName" type="text" placeholder="请输入角色名" />
					<p id="msg" style="color: red;font-size: 15px"></p>
				</div>
				
			</div>
			<a href="javascript:addRoleName();" class="sapar-btn sapar-btn-recom query-btn" >确定</a>
		</div>
	</div>
</body>
</html>