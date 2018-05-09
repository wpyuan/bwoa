<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
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
<script type="text/javascript" src="js/pwdModify.js"></script>
<title>修改密码</title>
</head>

<body>
	<div id="saper-container">
		<div id="saper-hd"></div>
		<div id="saper-bd">
			<div class="subfiled clearfix">
				<h2>修改密码</h2>
				<h2>${msg}</h2>
			</div>
			<div class="subfiled-content">
				<form class="saper-form">
					<div class="kv-item clearfix">
						<label>用户名：</label>
						<div class="kv-item-content">
							<div class="user-name" style="line-height: 30px;">${account.getAccountId() }</div>
						</div>
					</div>
					<div class="kv-item clearfix">
						<label><span class="impInfo">*</span>原密码：</label>
						<div class="kv-item-content">
							<input id="Oldpassword" name="Oldpassword" type="password" placeholder="原密码" onblur="show()" class="password ue-clear"> <h3 id="p1" style="color: red;position: absolute; left: 360px;top:90px"></h3>
						</div>
					</div>
					<div class="kv-item clearfix">
						<label><span class="impInfo">*</span>新密码：</label>
						<div class="kv-item-content">
							<input id="Newpassword" name="Newpassword" type="password"  placeholder="新密码" onblur="show2()" class="password ue-clear" disabled><h3 id="p2" style="color: red;position: absolute; left: 360px;top:130px"></h3>
						</div>
					</div>
					<div class="kv-item clearfix">
						<label><span class="impInfo">*</span>确认密码：</label>
						<div class="kv-item-content">
							<input id="Newpassword2" name="Newpassword2" type="password" placeholder="确认密码" onblur="show3()" class="password ue-clear" disabled><h3 id="p3" style="color: red;position: absolute; left: 360px;top:170px"></h3>
						</div>
					</div>
					<div class="buttons">
						<a href="javascript:;" onclick="s()" class="sapar-btn sapar-btn-recom">确定</a>
					</div>
				</form>
			</div>
		</div>
		<div id="saper-ft"></div>
	</div>
</body>

</html>