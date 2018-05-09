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
<meta http-equiv="X-UA-Compatible" content="IE=emulateIE7" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=emulateIE7" />
<link rel="stylesheet" href="css/sapar.css" />
<link rel="stylesheet" type="text/css" href="css/system_index.css" />
<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript" src="js/sapar.js"></script>

</head>
<body>
	<div id="saper-container">
		<div id="saper-hd"></div>
		<div id="saper-bd">
			<!--表格开始-->
			<div class="table">

				<!--表格具体内容-->
				<div class="table-box">
					<table>
						<thead>
							<tr>
								<th>类型</th>
								<th>公告标题</th>
								<th>回复/浏览</th>
								<th>发布人</th>
								<th>发布日期</th>
							</tr>
						</thead>
						<tbody>
							<tr>
								<td id="no">通知</td>
								<td><a>关于严格落实国家发展改革委关于降低增值税税控系统产品及维护服务价格的通知</a></td>
								<td style="width: 100px;">11/4056</td>
								<td>广西百旺金赋科技有限公司</td>
								<td>2017-10-18</td>
							</tr>

						</tbody>
					</table>
				</div>
			</div>
			<!--表格结束-->
		</div>
		<div id="saper-ft"></div>
	</div>
</body>
</html>