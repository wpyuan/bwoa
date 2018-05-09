<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">
<title>广西百旺金赋科技有限公司办公系统首页</title>
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"/>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link rel="stylesheet" href="css/sapar.css" />
<link rel="stylesheet" href="css/index.css" />
<script type="text/javascript" src="js/browserClose.js"></script>
</head>
<script type="text/javascript">

</script>
<body>

	<div id="container">
		<div id="hd">
			<div class="hd-wrap clearfix">
				<div class="top-light"></div>
				<h1 class="logo"></h1>

				<div class="toolbar">
					<div class="login-info clearfix">
						<div class="welcome clearfix">
							<span>欢迎您,</span>
							<!-- 	<a href="employee/information.do" class="user-name">${userName}</a> -->
							<a class="user-name">${userName}</a>
						</div>
						<div class="login-msg clearfix">
							<a href="javascript:;" class="msg-txt">消息</a> <a
								href="javascript:;" class="msg-num">0</a>
						</div>
					</div>
					<div class="tool clearfix">

						<a href="javascript:;" class="help-btn">帮助</a> <a
							href="javascript:;" class="quit-btn exit">退出</a>
					</div>
				</div>
			</div>
		</div>
		<div id="bd">
			<div class="wrap clearfix">
				<iframe src="common/index_body_left.jsp" id="iframe" width="100%"
					height="100%" frameborder="0"> </iframe>
			</div>
		</div>
		<div id="ft" class="clearfix">
			<div class="ft-left">
				<span>广西百旺金赋办公系统</span> <em>Office&nbsp;System</em>
			</div>
			<div class="ft-right">
				<span>Automation</span> <em>2.0&nbsp;2017</em>
			</div>
		</div>
	</div>
	<div class="exitDialog">
		<div class="dialog-content">
			<div class="ui-dialog-icon"></div>
			<div class="ui-dialog-text">
				<p class="dialog-content">你确定要退出系统？</p>
				<p class="tips">如果是请点击“确定”，否则点“取消”</p>

				<div class="buttons">
					<input type="button" class="button long2 ok" value="确定" /> <input
						type="button" class="button long2 normal" value="取消" />
				</div>
			</div>

		</div>
	</div>

</body>
<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript" src="js/sapar.js"></script>
<script type="text/javascript" src="js/index.js"></script>
</html>
