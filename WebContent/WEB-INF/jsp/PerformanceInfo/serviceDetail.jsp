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
											<thead>
												<tr>
													<th colspan="6">服务费收取</th>													
												</tr>
												<tr>													
													<th rowspan="2" colspan="2">主盘</th>
													<th rowspan="2" colspan="2">分盘</th>
													<th rowspan="2" colspan="2">合计</th>

												</tr>
											</thead>

											<tbody align="center">		
												<c:forEach items="${serviceViews}" var="view">
													<c:if test="${view.familyType=='老户'}">
														<c:if test="${view.plateType=='主盘'}">
															<!-- 老户服务费主盘数量 -->
															<td style="height: 30px; width: 50px; padding-left: 0px">
																${view.total}
															</td>
															<td style="height: 30px; width: 50px; padding-left: 0px">
																${view.total*view.price}
															</td>
														</c:if>
														<c:if test="${view.plateType=='分盘'}">
															<!-- 老户服务费主盘数量 -->
															<td style="height: 30px; width: 50px; padding-left: 0px">
																${view.total}
															</td>
															<td style="height: 30px; width: 50px; padding-left: 0px">
																${view.total*view.price}
															</td>
														</c:if>
													</c:if>
													<c:if test="${view.familyType=='新户'}">
														<c:if test="${view.plateType=='主盘'}">
															<!-- 老户服务费主盘数量 -->
															<td style="height: 30px; width: 50px; padding-left: 0px">
																${view.total}
															</td>
															<td style="height: 30px; width: 50px; padding-left: 0px">
																${view.total*view.price}
															</td>
														</c:if>
														<c:if test="${view.plateType=='分盘'}">
															<!-- 老户服务费主盘数量 -->
															<td style="height: 30px; width: 50px; padding-left: 0px">
																${view.total}
															</td>
															<td style="height: 30px; width: 50px; padding-left: 0px">
																${view.total*view.price}
															</td>
														</c:if>
													</c:if>
												</c:forEach>
													<td style="height: 30px; width: 50px; padding-left: 0px">
														<!-- 只能输入数字和小数点 --> <input id="serviceNum"
														readonly="readonly" type="text"
														style="width: 100%; border: 0px" />
													</td>
													<td style="height: 30px; width: 50px; padding-left: 0px">
														<!-- 只能输入数字和小数点 --> <input id="servicePrice"
														readonly="readonly" type="text"
														style="width: 100%; border: 0px" />
													</td>												
											</tbody>
										</table>
									</div>	
														
										
  </body>
</html>
