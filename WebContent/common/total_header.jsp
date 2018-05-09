<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
	<link rel="stylesheet" href="css/JFtable.css" />
	<link rel="stylesheet" type="text/css" href="css/detail.css" />
	<script type="text/javascript" src="js/jquery.js"></script>
	<script type="text/javascript" src="js/sapar.js"></script>
	<script type="text/javascript" src="js/total.js"></script>
	<script type="text/javascript" src="js/detailc.js"></script>
	<link href="ztree/css/zTreeStyle/zTreeStyle.css" rel="stylesheet">
	<link href="css/info_total.css" rel="stylesheet">
	<script src="ztree/js/jquery-3.2.1.min.js"></script>
	<script src="ztree/js/jquery.ztree.all.min.js"></script>
	<script src="js/info_total.js"></script>
  </head>
  
  <body>
    
  			<div class="subfiled clearfix">
				<h2>数据统计</h2>
				<!--表格开始-->
				<div class="table">
					<!--表格具体内容-->
					<div class="table-box">
						<table>
							<thead id="calendarSelect">
								<tr id="month">
									<th class="name" id="year">${year}</th>
									<th class="num"><a onclick="reduceYear(year)">&lt; &lt;</a></th>
									<th class="num"><a onclick="selectClear(year,january,'31')" id="january">1月</a></th>
									<th class="num"><a onclick="selectClear(year,february,'28')" id="february">2月</a></th>
									<th class="num"><a onclick="selectClear(year,march,'31')" id="march">3月</a></th>
									<th class="num"><a onclick="selectClear(year,april,'30')" id="april">4月</a></th>
									<th class="num"><a onclick="selectClear(year,may,'31')" id="may">5月</a></th>
									<th class="num"><a onclick="selectClear(year,june,'30')" id="june">6月</a></th>
									<th class="num"><a onclick="selectClear(year,july,'31')" id="july">7月</a></th>
									<th class="num"><a onclick="selectClear(year,august,'31')" id="august">8月</a></th>
									<th class="num"><a onclick="selectClear(year,september,'30')" id="september">9月</a></th>
									<th class="num"><a onclick="selectClear(year,october,'31')" id="october">10月</a></th>
									<th class="num"><a onclick="selectClear(year,november,'30')" id="november">11月</a></th>
									<th class="num"><a onclick="selectClear(year,december,'31')" id="december">12月</a></th>
									<th class="num"><a onclick="selectClear(year,january,'上半年')">上半年</a></th>
									<th class="num"><a onclick="selectClear(year,june,'下半年')">下半年</a></th>
									<th class="num"><a onclick="selectClear(year,january,'全年')">全年</a></th>
									<th class="num"><a onclick="addYear(year)">&gt;&gt;</a></th>
								</tr>
							</thead>
						</table>
					</div>
				</div>
			</div>
  </body>
</html>
