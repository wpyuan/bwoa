<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath%>">
<title>应收信息管理</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"/>
<link rel="stylesheet" href="css/sapar.css" />
<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript" src="js/sapar.js"></script>
<script type="text/javascript" src="js/service_add.js"></script>
<script type="text/javascript" src="js/service_manage.js"></script>
<link href="ztree/css/zTreeStyle/zTreeStyle.css" rel="stylesheet">
<link href="css/service_manage.css" rel="stylesheet">
<script src="ztree/js/jquery-3.2.1.min.js"></script>
<script src="ztree/js/jquery.ztree.all.min.js"></script>
<script src="https://unpkg.com/vue@2.4.4/dist/vue.min.js"></script>

</head>
<body>
    <div id="saper-container">
        <div id="saper-hd"></div>
        <div id="saper-bd">
            <div class="subfiled clearfix">
                <h2>应收信息管理</h2>
            </div>
            <div class="subfiled-content">
	            <form action="fuwu/manage.do" method="post">	
	                <div class="search-box clearfix">
	                    <div class="kv-item clearfix" style="position: absolute;left: 0%">
	                        <label>查询：</label>
	                        <div class="kv-item-content">
	                            <input type="text" style="width: 150px" placeholder="请输入年份" name="year">
	                        </div>
	                    </div>	                    
	                    <div class="kv-item clearfix" style="position: absolute;left: 270px">                        
	                        <div class="kv-item-content">	                            
	                            <input type="submit" value="搜索" class="sapar-btn sapar-btn-recom query-btn">
	                        </div>
	            		</div>
	            	</div>
	              </form>   
	              
	              
	              <!--表格开始-->
	            <div class="table" style="position: absolute;top: 12%;width: 100%;height: 100%" >                                
	                <!-- ztree表格 -->	
					<div class="layer">
			            <div id="tableMain">
			                <ul id="dataTree" class="ztree">
			                </ul>
			            </div>
			        </div>
                 </div>
                 
                  <!-- 获取后台传过来的值 -->
		        <div style="display: none">		
		       		<input type="text" id="asccId" value="${view.asccId}">        	
		        	<input type="text" id="year" value="${view.year}">
		        	<input type="text" id="createBy" value="${view.createBy}">
		        	<input type="text" id="createDate" value="${view.createDate}">
		        	<input type="text" id="householdNumber" value="${view.householdNumber}">
		        </div>	
				 <!--表格结束-->

            </div>
        </div>
    </div>
</body>
</html>