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
    
    <title>权限分配</title>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"/>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">	
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<meta charset="utf-8">
	<link rel="stylesheet" href="css/sapar.css" />
	<script type="text/javascript" src="js/jquery.js"></script>
	<script type="text/javascript" src="js/sapar.js"></script>
</head>

<body>
    <div id="saper-container">
        <div id="saper-hd"></div>
        <div id="saper-bd">
            <div class="subfiled clearfix">
                <h2>角色列表</h2>
            </div>
            <div class="subfiled-content">
           	 <form action="permissions/search.do" method="post">
                <div class="search-box clearfix">
                    <div class="kv-item clearfix">
                        <label>查询：</label>
                        <div class="kv-item-content">
                            <input type="text" placeholder="请输入信息" name="msg">
                        </div>
                    </div>                    
                    <div class="kv-item clearfix" style="position: absolute;left: 30%;top: 5.5%">                        
	                        <div class="kv-item-content">	                            
	                            <input type="submit" value="搜索" class="sapar-btn sapar-btn-recom query-btn">
	                        </div>
	            	</div>
                </div>
              </form> 

                <!--表格开始-->
                <div class="table">                    
                    <!--表格具体内容-->
                    <div class="table-box">
                        <table>
                            <thead>
                                <tr>
                                    <th>编号</th>
                                    <th>名称</th>
                                    <th>操作</th>
                                </tr>
                            </thead>
                            <tbody>
                            <c:forEach items="${roles}" var="role">
                            	  <tr>                                	
                                	<td>${role.roleId}</td>
                                	<td>${role.name}</td>                                	
                                	<td><a href="permissions/toTree.do?roleId=${role.roleId}">分配</a>                                		
                                	</td> 
                                </tr>
                            </c:forEach>                      
                                
                            </tbody>
                        </table>
                    </div>
                </div><!--表格结束-->
            </div>
        </div>
        <div id="saper-ft"></div>
    </div>
    
</body>

<script type="text/javascript">

</script>
</html>
