<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">
<title>广西百旺金赋科技OA系统</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"/>
<link rel="stylesheet" href="css/login.css" />
</head>
<body>
	<div id="container">
		<div id="bd">
			<form action="login.do" method="post" id="loginform">

				<div class="login">
					<div class="login-top">
						<h1 class="logo"></h1>
					</div>
					<div class="login-input">
						<p class="user ue-clear">
							<label>用户名</label> <input type="text" name="username"
								placeholder="${sessionScope.error}" />
						</p>
						<p class="password ue-clear">
							<label>密&nbsp;&nbsp;&nbsp;码</label> <input type="password"
								name="password" />
						</p>
					</div>
					<div class="login-btn ue-clear">
						<a style="cursor: pointer;" class="btn"
							onclick="$('#loginform').submit()"> 登录</a>
						<div class="remember ue-clear">
							<input type="checkbox" id="remember" /> <em></em> <label
								for="remember">记住密码</label>
						</div>
					</div>
				</div>
			</form>
		</div>
	</div>
	<div id="ft">developer：广西百旺运维部 &nbsp;&nbsp;&nbsp;2017-12-1 vers 1.0 &nbsp;&nbsp;&nbsp;Email： wpyuan168@foxmail.com , 18275880040@163.com
	</div>
</body>
<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript">
var height = $(window).height();
$("#container").height(height);
$("#bd").css("padding-top",height/2-$("#bd").height()/2);

$(window).resize(function(){
	var height = $(window).height();
	$("#bd").css("padding-top",$(window).height()/2-$("#bd").height()/2);
	$("#container").height(height);
	
});

$('#remember').focus(function(){
   $(this).blur();
});

$('#remember').click(function(e) {
	checkRemember($(this));
});

function checkRemember($this){
	if(!-[1,]){
		 if($this.prop("checked")){
			$this.parent().addClass('checked');
		}else{
			$this.parent().removeClass('checked');
		}
	}
}
</script>
</html>