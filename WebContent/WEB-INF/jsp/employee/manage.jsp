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
<title>员工管理</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"/>
<link rel="stylesheet" href="css/sapar.css" />
<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript" src="js/sapar.js"></script>
<script src="https://unpkg.com/vue@2.4.4/dist/vue.min.js"></script>
    <style>
        .pageination_align {
            text-align: center
        }
        
		#app{
			position: absolute;
			top: 60%;
			right: 10px;
		}
		
        .pageination {
            color: #48576a;
            font-size: 12px;
            display: inline-block;
            user-select: none;
        }

        .pagination_page {
            padding: 0 4px;
            border: 1px solid #d1dbe5;
            border-right: 0;
            background: #fff;
            font-size: 13px;
            min-width: 28px;
            height: 28px;
            line-height: 28px;
            cursor: pointer;
            box-sizing: border-box;
            text-align: center;
            float: left;
        }

        .pagination_page_right {
            border-right: 1px solid #d1dbe5;
        }

        .pagination_page:hover {
            color: #20a0ff;
        }

        .disabled {
            color: #e4e4e4 !important;
            background-color: #fff;
            cursor: not-allowed;
        }

        .pagination_page_active {
            border-color: #20a0ff;
            background-color: #20a0ff;
            color: #fff !important;;
            cursor: default;
        }
    </style>

</head>
<body>
    <div id="saper-container">
        <div id="saper-hd"></div>
        <div id="saper-bd">
            <div class="subfiled clearfix">
                <h2>员工管理</h2>
            </div>
            <div class="subfiled-content">
	            <form action="employee/search.do" method="post">	
	                <div class="search-box clearfix">
	                    <div class="kv-item clearfix" style="position: absolute;left: 0%">
	                        <label>查询：</label>
	                        <div class="kv-item-content">
	                            <input type="text" style="width: 150px" placeholder="姓名/职位/手机号" name="msg">
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
                    <!--表格操作-->
                    <div class="table-operate ue-clear">
                        <a href="employee/toAdd.do" class="add" >添加</a>                       
                    </div>
                    <!--表格具体内容-->
                    <div class="table-box">
                        <table>
                            <thead>
                                <tr>
                                    <th>姓名</th>
                                    <th>工号</th>
                                    <th>手机号码</th>
                                    <th>职位</th>
                                    <th>入职时间</th>
                                    <th>居住地址</th>
                                    <th>操作</th>
                                </tr>
                            </thead>
                            <tbody>
	                            <c:forEach items="${employees}" var="employee">
	                            	<tr>                                	
	                                	<td>${employee.name}</td>
	                                	<td>${employee.employeeId}</td>
	                                	<td>${employee.phone}</td> 
	                                	<td>${employee.nowJob}</td> 
	                                	<td>${employee.hireDate}</td> 
	                                	<td>${employee.address}</td>
	                                	<td><a href="employee/detail.do?employeeId=${employee.employeeId}">详情</a>
	                                		<a href="employee/toAlter.do?employeeId=${employee.employeeId}">修改</a>
	                                		<a href="employee/delete.do?employeeId=${employee.employeeId}">删除</a>
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
<div id="app">
    <pageination :total="model.total" :size="model.size" :page="model.page" :changge="pageFn" ></pageination>    
</div>
<script src="js/pageination.js"></script>

<script>
  window.onload=function () {
      var app = new Vue({
          el: '#app',
          data() {
              return {
                  model:{
                      total:${total},//总页数
                      size:${length},//每页显示条目个数不传默认10
                      page:${pageNum},//当前页码
                  }
              }
          },
          methods:{
              //页码切换执行方法
              pageFn(val){
                  this.model.page=val;                  
                  $.ajax({
					url:"employee/selectPage.do?start="+val,
					type:"post",
					async: false,
					success: function(data){
						
					
						if(data=="success"){													
							location.href="employee/see.do?length=10&start="+val;
						}						
					}
					
				});                 
              }
          }
      })
  }

</script>    
</body>

<script type="text/javascript">

</script>
</html>