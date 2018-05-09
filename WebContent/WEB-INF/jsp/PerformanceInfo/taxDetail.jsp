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
   							 <!--表格开始 -->
								<div class="table">									
									<!--表格具体内容-->
									<div class="table-box">
										<table border="1px" cellpadding="0" cellspacing="0">
											<thead>
												<tr>
													<th colspan="10">新盘售盘数量</th>
												</tr>
												<tr>
													<th colspan="5">小规模</th>
													<th colspan="5">一般纳税人</th>
													
												</tr>
												<tr>
													<th colspan="2.5">主盘</th>
													<th colspan="2.5">分盘</th>
													<th colspan="2.5">主盘</th>
													<th colspan="2.5">分盘</th>
												</tr>
												<tr>
													<th>数量</th>
													<th>金额</th>
													<th>数量</th>
													<th>金额</th>
													<th>数量</th>
													<th>金额</th>
													<th>数量</th>
													<th>金额</th>
											</thead>

											<tbody align="center">
												<tr>
												
													<c:forEach items="${taxViews}" var="view">
														<c:if test="${view.userType=='小规模'}">
															<c:if test="${view.taxDiscType=='主盘'}">
																<td style="height: 30px; width: 50px; padding-left: 0px">
																	${view.total}
																</td>
																<td style="height: 30px; width: 50px; padding-left: 0px">
																	${view.total*view.price}
																</td>
															</c:if>
															<c:if test="${view.taxDiscType=='分盘'}">
																<td style="height: 30px; width: 50px; padding-left: 0px">
																	${view.total}
																</td>
																<td style="height: 30px; width: 50px; padding-left: 0px">
																	${view.total*view.price}
																</td>
															</c:if>															
														</c:if>	
														<c:if test="${view.userType=='一般纳税人'}">
															<c:if test="${view.taxDiscType=='主盘'}">
																<td style="height: 30px; width: 50px; padding-left: 0px">
																	${view.total}
																</td>
																<td style="height: 30px; width: 50px; padding-left: 0px">
																	${view.total*view.price}
																</td>
															</c:if>
															<c:if test="${view.taxDiscType=='分盘'}">
																<td style="height: 30px; width: 50px; padding-left: 0px">
																	${view.total}
																</td>
																<td style="height: 30px; width: 50px; padding-left: 0px">
																	${view.total*view.price}
																</td>
															</c:if>	
														</c:if>																				
													</c:forEach>
													
												</tr>
											</tbody>
										</table>
									</div>
								</div>	
										
  </body>
</html>
