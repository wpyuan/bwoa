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
    
    <title>详细信息</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" href="css/JFtable.css" />
	<script type="text/javascript" src="js/jquery.js"></script>
	<script type="text/javascript" src="js/sapar.js"></script>
	<script type="text/javascript" src="js/performanceInfoAdd.js"></script>
	<script type="text/javascript" src="js/eqmAdd.js"></script>
	<title>信息录入</title>
	<style type="text/css">
	th {
		text-align: center;
	}
</style>

  </head>
  
  <body>
   							 <!--表格开始-->
								<div class="table">									
									<div class="table-box">
										<table border="1px" cellpadding="0" cellspacing="0" >
											<thead >
												<tr>
													<th colspan="${equipmentViews[0].size*4}">通用设备销售数量</th>
												</tr>
												<tr>
												
													<!-- 查询数据库,显示设备型号 -->
													<c:forEach items="${equipmentViews}" var="view">																										
														<th colspan="4">${view.name}</th>
													</c:forEach>													
												</tr>
												<tr>												
													<c:forEach items="${equipmentViews}" var="view">													
														<th colspan="2">数量</th>
														<th colspan="2">单价</th>
													</c:forEach>													
												</tr>
	
											</thead>


											<tbody align="center">	
													<c:forEach var="view" items="${equipmentViews}">
														
														<td style="height: 30px; width: 50px; padding-left: 0px" colspan="2">
															${view.total}
														</td>
														<td style="height: 30px; width: 50px; padding-left: 0px" colspan="2">
															 ${view.total*view.unitPrice}
														</td>
													</c:forEach>							
											</tbody>
										</table>
									</div>	
														
										
  </body>
</html>
