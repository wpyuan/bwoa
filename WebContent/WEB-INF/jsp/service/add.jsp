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
    
    <title>年应收服务费录入</title>
    
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
	<link rel="stylesheet" href="css/reset.css" />
	<link rel="stylesheet" href="css/style.css" />
  </head>
  
  <body>
    				<div class="tab-content" style="position: absolute;top: 20px">
						<div class="tab-content-item">
								<div >
									 <!--表格开始-->
					                <div class="table" style="position: absolute;top: 12%;width: 100%;height: 100%" >
					                    <!--表格具体内容-->
					                    <div class="table-box">
					                        <table>
					                            <thead>
					                            	<tr>
					                            		 <th>年份:<select id="year">
					                                    						<option>2017</option>
					                                    						<option>2018</option>
					                                    						<option>2019</option>
					                                    						<option>2020</option>
					                                    						<option>2021</option>
					                                    						<option>2022</option>
					                                    						<option>2023</option>
					                                    					</select></th>
					                                     <th></th>				
					                            	</tr>
					                                <tr>
					                                    <th width="40%">区域</th>					                                   
					                                    <th width="30%">应收数</th>
					                                </tr>
					                            </thead>
					                            <tbody id="msg">
						                            <c:forEach items="${areas}" var="area">
						                            	<tr>                                	
						                                	<td width="40%">
						                                		<input type="hidden" name="" value="${area.areaId}">
						                                		<input type="text" name="areaName" value="${area.name}" readonly="readonly">
						                                	</td>						                                	
						                                	<td width="30%"><input type="text" name="" value=""></td>
						                                </tr>	                                
						                            </c:forEach>                                
					                            </tbody>                            
					                        </table>
					                    </div>
					                    <!--表格结束-->						                
					                </div>
						</div>
						<div style="position: absolute;left: 350px">
							<input type="submit" class="sapar-btn sapar-btn-recom query-btn" value="提交" onclick="save()"/>										
						</div>
					</div>
  </body>
</html>
