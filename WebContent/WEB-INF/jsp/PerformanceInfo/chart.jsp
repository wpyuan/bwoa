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
    
    <title>图表</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" href="css/JFtable.css" />
	<link rel="stylesheet" type="text/css" href="css/detail.css" />
	<script type="text/javascript" src="js/jquery.js"></script>
	<script type="text/javascript" src="js/Chart.js" ></script>
	<script type="text/javascript" src="js/chart-calendar.js" ></script>
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>		<!-- 日历 -->
  				<div class="table">
  					<div class="table-box">
						<table>
							<thead id="calendarSelect">
								<tr id="month" >
									<th class="name" id="year">${year}</th>
									<th class="num"><a onclick="reduceYear(year)">&lt; &lt;</a></th>
									<th class="num"><a onclick="selectMonth(year,january_s,'31')" id="january_s">1月</a></th>
									<th class="num"><a onclick="selectMonth(year,february,'28')" id="february">2月</a></th>
									<th class="num"><a onclick="selectMonth(year,march,'31')" id="march">3月</a></th>
									<th class="num"><a onclick="selectMonth(year,april,'30')" id="april">4月</a></th>
									<th class="num"><a onclick="selectMonth(year,may,'31')" id="may">5月</a></th>
									<th class="num"><a onclick="selectMonth(year,june,'30')" id="june">6月</a></th>
									<th class="num"><a onclick="selectMonth(year,july,'31')" id="july">7月</a></th>
									<th class="num"><a onclick="selectMonth(year,august,'31')" id="august">8月</a></th>
									<th class="num"><a onclick="selectMonth(year,september,'30')" id="september">9月</a></th>
									<th class="num"><a onclick="selectMonth(year,october,'31')" id="october">10月</a></th>
									<th class="num"><a onclick="selectMonth(year,november,'30')" id="november">11月</a></th>
									<th class="num"><a onclick="selectMonth(year,december,'31')" id="december">12月</a></th>
									<th class="num"><a onclick="addYear(year)">&gt;&gt;</a></th>
								</tr>
							</thead>
						</table>
					</div>
				</div>
				<!-- 区域选择 -->
				<div>
					<select name="areaName" id="area" onclick="showArea()">
					   <option>请选择区域</option>												
					</select>				
				</div>	
		<div width="400px" height="400px">
			<canvas id="myChart"></canvas>
		</div>
  </body>
	<script type="text/javascript" src="js/chart-init.js" ></script>
</html>
