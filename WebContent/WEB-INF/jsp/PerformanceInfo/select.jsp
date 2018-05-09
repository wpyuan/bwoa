<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
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
<script type="text/javascript" src="js/performanceInfoSelect.js"></script>
<style type="text/css">
</style>
<title>查看/修改/删除</title>
</head>
<body>
	<div id="saper-container">
		<div id="saper-hd"></div>
		<div id="saper-bd">
			<div class="subfiled clearfix">
				<h2>记录查询</h2>
			</div>
			<div class="subfiled-content">
				<div class="search-box clearfix">
					<div class="kv-item clearfix">
						<label>数据日期：</label>
						<div class="kv-item-content time-select-wrap">
							<div class="time-select">
								<input id="startTime" type="text" value="${startTime}"
									onclick="changeInputType('startTime')">
							</div>
							<span class="line">-</span>
							<div class="time-select">
								<input id="endTime" type="text" value="${time}"
									onclick="changeInputType('endTime')">
							</div>
						</div>

					</div>

					<c:if test="${role.name=='管理员'||role.name=='技术服务中心员工'||role.name=='技术服务中心主任'||role.name=='分公司经理'}">
						<div class="kv-item clearfix">
							<label>员工姓名：</label>
							<div class="kv-item-content time-select-wrap">
								<div class="time-select">
									<input id="ename" type="text" value="${eName}" />
								</div>
							</div>

						</div>
					</c:if>
					<a href="javascript:search('${role.name}');"
						class="sapar-btn sapar-btn-recom query-btn">查询</a>
				</div>
				<!--表格开始-->
				<div class="table">

					<!--表格具体内容-->
					<div class="table-box">
						<table>
							<thead>
								<tr>
									<th>数据日期</th>
									<th>区域 <c:if
											test="${role.name=='管理员'||role.name=='技术服务中心员工'||role.name=='技术服务中心主任'||role.name=='分公司经理'}">
											<select id="areaSelect" onchange="selectArea()">
												<c:choose>
													<c:when test="${nowArea==null||nowArea==''}">
														<option value="全部">全部</option>
													</c:when>
													<c:otherwise>
														<option value="${nowArea}">${nowArea}</option>
														<option value="全部">全部</option>
													</c:otherwise>
												</c:choose>
												<c:forEach var="area" items="${areas}">
													<c:choose>
														<c:when test="${fn:contains(area.name,'分公司')==true}">
															<option style="background: #c1d3de" value="${area.name}">${area.name}
															</option>
														</c:when>
														<c:otherwise>
															<option value="${area.name}">
																&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; ${area.name}</option>
														</c:otherwise>
													</c:choose>
												</c:forEach>
											</select>
										</c:if>
									</th>
									<th>员工</th>
									<th>新户售盘</th>
									<th>服务费</th>
									<th>报税盘</th>
									<th>更换</th>
									<th>通用设备</th>
									<th>销售收入</th>
									<th>已转</th>
									<th>未转</th>
									<th>操作</th>
								</tr>
							</thead>
							<tbody align="center">
								<c:forEach var="pSelectv" items="${performanceInfoSelectViews}">
									<tr>
										<td>${pSelectv.dataDate}</td>
										<td>${pSelectv.areaName}</td>
										<td>${pSelectv.employeeName}</td>
										<td>${pSelectv.newSum}</td>
										<td>${pSelectv.serviceSum}</td>
										<td>${pSelectv.bspSum}</td>
										<td>${pSelectv.changeSum}</td>
										<td>${pSelectv.eqmSum}</td>
										<td>${pSelectv.revenue}</td>
										<td>${pSelectv.transfer}</td>
										<td>${pSelectv.revenue-pSelectv.transfer}</td>
										<td>   <c:choose>
												<c:when
													test="${role.name=='管理员'||role.name=='技术服务中心员工'|| role.name=='技术服务中心主任' || (role.name=='分公司经理'&&employeeName!=pSelectv.employeeName) }">							
  											<a
														href="performanceInfo/toDetail.do?uuid=${pSelectv.uuid }">详情</a>&nbsp;&nbsp;
										</c:when>
												<c:otherwise>
													<a href="performanceInfo/toAlter.do?uuid=${pSelectv.uuid }">修改</a>&nbsp;&nbsp;
											<a href="javascript:delet('${pSelectv.uuid }')">删除</a>
												</c:otherwise>
											</c:choose>
										</td>
									</tr>
								</c:forEach>
								<tr>
									<td>合计</td>
									<td></td>
									<td></td>
									<td>${XHSP}</td>
									<td>${FWF}</td>
									<td>${BSP}</td>
									<td>${GH}</td>
									<td>${TYSB}</td>
									<td>${XSSR}</td>
									<td>${YZ}</td>
									<td>${XSSR-YZ}</td>
									<td></td>
								<tr>
							</tbody>
						</table>
					</div>
				</div>
				<!--表格结束-->
			</div>
		</div>
	</div>
	</div>
	</div>
	<div id="saper-ft"></div>
	</div>
</body>
</html>