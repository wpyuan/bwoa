<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
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
<title>统计</title>

</head>
<body onload="showDay()">
	<div id="saper-container">
		<div id="saper-hd"></div>
		<div id="saper-bd">
			<div class="subfiled clearfix">
				<h2>数据统计</h2><br/>
				<!--表格开始-->
				<div class="table">
					<!--表格具体内容-->
					<div class="table-box">
						<table>
							<thead id="calendarSelect">
								<tr id="month" >
									<th class="name" id="year">${year}</th>
									<th class="num"><a onclick="reduceYear(year)">&lt; &lt;</a></th>
									<th class="num"><a onclick="selectClear(year,january_s,'31')" id="january_s">1月</a></th>
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
									<th class="num"><a onclick="selectClear(year,january_s,'上半年')">上半年</a></th>
									<th class="num"><a onclick="selectClear(year,june,'下半年')">下半年</a></th>
									<th class="num"><a onclick="selectClear(year,january_s,'全年')">全年</a></th>
									<th class="num"><a onclick="addYear(year)">&gt;&gt;</a></th>
								</tr>
							</thead>
						</table>
					</div>
				</div>
			</div>
			<div class="subfiled-content">
				<div class="search-box clearfix">
					<div class="kv-item clearfix">
						<label>日期：</label>
						<div class="kv-item-content time-select-wrap">
							<div class="time-select">
								<input id="startTime" type="text" value="${startTime }"
									onfocus="changInputType('startTime')" placeholder="开始时间">								
							</div>
							<span class="line">-</span>
							<div class="time-select">
								<input id="endTime" type="text" value="${time }"
									onfocus="changInputType('endTime')" placeholder="结束时间">								
							</div>
						</div>

					</div>
					<a onclick="select()" class="sapar-btn sapar-btn-recom query-btn">查询</a>
				</div>
				
				<!-- 
				<div class="alert alert-warning" role="alert">新户售盘数量：<b>0</b>&nbsp;&nbsp;&nbsp;老户服务费收取户数：<b>0</b>&nbsp;&nbsp;&nbsp;通用设备销售数量：<b>0</b></div>
				 -->
				<!--表格开始-->
				<div class="table">

					<!--表格操作-->
					<div class="table-operate ue-clear">
						<a href="javascript:;" class="add">导出excel</a>						
					</div>
				<!-- ztree表格 -->	
				<div class="layer">
		            <div id="tableMain">
		                <ul id="dataTree" class="ztree">
		                </ul>
		            </div>
		        </div>
		        <!-- 获取后台传过来的值 -->
		        <div style="display: none">		        	
		        	<input type="text" id="taxNumber" value="${view.taxNumber}">
		        	<input type="text" id="serviceNumber" value="${view.serviceNumber}">
		        	<input type="text" id="escalationNumber" value="${view.escalationNumber}">
		        	<input type="text" id="equipmentNumber" value="${view.equipmentNumber}">
		        	<input type="text" id="freeReplacementNumber" value="${view.freeReplacementNumber}">
		        	<input type="text" id="replacementNumber" value="${view.replacementNumber}">
		        	<input type="text" id="totalSalesAmount" value="${view.totalSalesAmount}">
		        	<input type="text" id="hasHandIn" value="${view.hasHandIn}">
		        	<input type="text" id="notPay" value="${view.notPay}">	
		        	<input type="text" id="percent" value="${view.percent}">	        		        	
		        </div>				
				<!--表格结束-->
				<!-- 明细表格 -->
				<div id="detail" style="display: none"></div>
			</div>
		</div>
		
	</div>
	<div id="saper-ft"></div>
	</div>
</body>
</html>