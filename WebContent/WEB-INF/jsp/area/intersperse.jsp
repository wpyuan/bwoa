<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
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
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link rel="stylesheet" href="css/sapar.css" />
<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript" src="js/sapar.js"></script>
<title>区域变更</title>
</head>
<body>
	<div id="saper-container">
		<div id="saper-hd"></div>
		<div id="saper-bd">
			<div class="subfiled clearfix">
				<h2>区域变更</h2>
			</div>
			<div class="subfiled-content">
				<form class="saper-form">
					<div class="kv-item clearfix">
						<label>员工姓名：</label>
						<div class="kv-item-content">
							<input type="text" placeholder="填写员工姓名">
						</div>
					</div>

					<div class="kv-item clearfix">
						<label>原区域：</label>
						<div class="kv-item-content">
							<select>
								<option>选择区域</option>
								<option>模板1</option>
								<option>模板2</option>
							</select>
						</div>
						<div class="kv-item-tip">未变更前所在的区域</div>
					</div>

					<div class="kv-item clearfix">
						<label>新区域：</label>
						<div class="kv-item-content">
							<select>
								<option>选择区域</option>
								<option>模板1</option>
								<option>模板2</option>
							</select>
						</div>
						<div class="kv-item-tip">变更后所在的区域</div>
					</div>
					<div class="kv-item clearfix">
						<input type="submit" class="sapar-btn sapar-btn-recom query-btn"
							value="提交" />
					</div>
				</form>

			</div>
		</div>
		<div id="saper-ft"></div>
	</div>
</body>
</html>