<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>年应收服务费修改</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" href="css/sapar.css" />
	<link rel="stylesheet" type="text/css" href="css/my_info.css" />
	<script type="text/javascript" src="js/jquery.js"></script>
	<script type="text/javascript" src="js/sapar.js"></script>
	<script type="text/javascript" src="js/service_add.js"></script>
	<script type="text/javascript" src="js/service_update.js"></script>
	<link rel="stylesheet" href="css/reset.css" />
	<link rel="stylesheet" href="css/style.css" />

  </head>
  
  <body>
    				<div class="tab-content" style="position: absolute;top: 20px">
						<div class="tab-content-item">
								<div >
									<div class="kv-item clearfix">
										<label><span class="impInfo">*</span>区域选择：</label>
										<div class="kv-item-content" style="line-height: 30px;">
											<select id="area" onclick="showArea()">
												<option>${list[1]}</option>												
											</select>
										</div>
									</div>	

									<div class="kv-item clearfix">
										<label><span class="impInfo">*</span>年份：</label>
										<div class="kv-item-content">
											<select id="year">
												<option>${list[0].year}</option>
												<option>2017</option>
												<option>2018</option>
												<option>2019</option>
												<option>2020</option>
												<option>2021</option>
											</select>
										</div>
									</div>
									<div class="kv-item clearfix">
										<label><span class="impInfo">*</span>应收户数：</label>
										<div class="calendarWarp" style="">
												<input type="text" id="number"
												value="${list[0].householdNumber}"											
												placeholder="应收户数"
												/>
												<input type="hidden" value="${list[0].asccId}" id="asccId"> 
										</div>										
									</div>

								<div style="position: absolute;left: 85%">
									<input type="submit"
										class="sapar-btn sapar-btn-recom query-btn" value="修改" onclick="update(area,year,number,asccId)"/>
								</div>
						</div>
					</div>
  </body>
</html>
