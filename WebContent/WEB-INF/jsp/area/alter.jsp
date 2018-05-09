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
    <title>修改区域</title>    
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"/>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<meta charset="utf-8">
	<link rel="stylesheet" type="text/css" href="css/sapar.css" />
	<link rel="stylesheet" type="text/css" href="css/my_info.css" />
	<link rel="stylesheet" href="css/form.css" />
	<script type="text/javascript" src="js/jquery.js"></script>
	<script type="text/javascript" src="js/sapar.js"></script>
	<script type="text/javascript">
		var isFirst = true;   
		function showProvince(){
				var province=document.getElementById("province");
				//判断是否为第一次执行
				if(isFirst==true){
					$.ajax({
						url:"area/getProvinceName.do",
						type:"post",
						data:{},			
						dataType:"json",
						success: function(data){							
								//将数据转换成json格式										
								var child=eval(data);				
								for(var i=0;i<child.length;i++){
								//动态的创建节点				
								var provinceName=document.createElement("option");				
								//设置节点的value属性				
								provinceName.innerHTML=child[i];				
								//添加子节点
								province.appendChild(provinceName);
								//设置全局变量为
								isFirst=false;	
							}
																		
						}	
				});
			}
		}
</script>
<script type="text/javascript">
		var falg = true;   
		function showCity(){
				var city=document.getElementById("city");
				//判断是否为第一次执行
				if(falg==true){
					$.ajax({
						url:"area/getCityName.do",
						type:"post",
						data:{},			
						dataType:"json",
						success: function(data){
															
								//将数据转换成json格式										
								var child=eval(data);				
								for(var i=0;i<child.length;i++){
								//动态的创建节点				
								var cityName=document.createElement("option");				
								//设置节点的value属性				
								cityName.innerHTML=child[i];				
								//添加子节点
								city.appendChild(cityName);
								//设置全局变量为
								falg=false;	
							}
																		
						}			
					
				});
			}
		}
		function getSelect(){			
			var select=document.getElementById("city").value;
			var town=document.getElementById("town");	
			select=encodeURI(select);
			select=encodeURI(select);					
			$.ajax({
					url:"area/getSelect.do?select="+select,
					type:"post",					
					async: false,
					success: function(data){										
						if(data=="fail"){
							alert("加载失败");
						}
						if(data=="success"){
							getTown();
						}
					}					
						
			});
					
						
		}
		
		function getTown(){
			//清空所有子节点
			$("#town").empty();
			//删除选中的节点
			var index=town.selectedIndex;
			town.options.remove(index);
			$.ajax({
				url:"area/getTownName.do",
				type:"post",
				data:{},			
				dataType:"json",
				success: function(data){						
				//将数据转换成json格式													
				var child=eval(data);				
				for(var i=0;i<child.length;i++){
				//动态的创建节点				
				var townName=document.createElement("option");				
				//设置节点的value属性				
				townName.innerHTML=child[i];							
				//添加子节点
				town.appendChild(townName);							
																		
				}
			}
								
		  });	
		}
</script>


<script type="text/javascript">
$(document).ready(function () {
	var falg=document.getElementById("status-chose").value;
	if(falg=='1'){
		document.getElementById("status-first").checked=true;
	}else{
		document.getElementById("status-second").checked=true;
	} 	 
})
</script> 
</head>

<body>
    <div id="saper-container">
        <div id="saper-hd"></div>
        <div id="saper-bd">
            <div class="subfiled clearfix">
                <h2>修改区域</h2>
            </div>
            <div class="subfiled-content">
                <div class="tab-container" data-trigger="hover">
                    <div class="tab">
                        <a href="javascript:;" class="current">基本信息</a>                        
                    </div>
                    <div class="tab-content">
                        <div class="tab-content-item">                        	
                            <form name="f1" id="f1" action="area/alter.do" method="post">
                            	<!--
                                	作者：张恭雨
                                	时间：2017-10-18
                                	描述：表单左部
                                -->
                            	<div id="form-left">                            		
	                                <div class="kv-item clearfix">
	                                    <label>区域名称：</label>
	                                    <div class="kv-item-content" style="line-height:30px;">
	                                        <input type="text" name="name"  placeholder="区域名称" value="${area.name}">
	                                    </div>
	                                </div>	
	                                
	                                 <div class="kv-item clearfix">	                                    
	                                    <div class="kv-item-content" style="line-height:30px;">
	                                        <input type="hidden" name="areaId" value="${area.areaId}">
	                                    </div>
	                                </div>                                
		                             
	
	                                <div class="kv-item clearfix">
	                                    <label>区域等级：</label>
	                                    <div class="kv-item-content">
	                                    	<select name="regionLevel">
												<option>${area.regionLevel}</option>
												<option>1</option>
												<option>2</option>
												<option>3</option>												
											</select>	                                        
	                                    </div>
	                                </div>                              
	                               
	                                
									<div class="kv-item clearfix">
										<label><span class="impInfo">*</span>区域状态：</label>
										<div class="kv-item-content">
											<span class="choose"> <input name="status"
												id="status-frist"
												type="radio" checked="true" value="1"> <span
												class="text">有效</span>
											</span> <span class="choose"> <input name="status"
												id="status-second"												
												type="radio" value="0"> <span class="text">无效</span>
												<input type="hidden" id="status-chose" value="${area.status}">
											</span>
										</div>
									</div>
	                                
	                                 <div class="kv-item clearfix">
										<label><span class="impInfo">*</span>省：</label>
										<div class="kv-item-content" >
											<select name="provinceName" id="province" onclick="showProvince()">
												<option>${provinceName}</option>												
											</select>
										</div>
									</div>
	                                
	                                <div class="kv-item clearfix">
										<label><span class="impInfo">*</span>市：</label>
										<div class="kv-item-content" >
											<select name="cityName" id="city" onclick="showCity()" onchange="getSelect()">
												<option>${cityName}</option>												
											</select>
										</div>
									</div>
	                                
	                                <div class="kv-item clearfix">
										<label><span class="impInfo">*</span>城镇：</label>
										<div class="kv-item-content" >
											<select name="townName" id="town">
												<option>${townName}</option>												
											</select>
										</div>
									</div>  
	                                
	                                <div class="kv-item clearfix">
	                                    <label><span class="impInfo">*</span>区域描述：</label>	                                    
	                                    <div class="kv-item-content">
	                                        <textarea name="description" placeholder="区域描述" >${area.description}</textarea>
	                                    </div>
	                                </div>
	                                
	                                <div class="kv-item clearfix">
										<input type="submit"
										class="sapar-btn sapar-btn-recom query-btn" value="提交" />
									</div>
                            	</div>                            	                               
                            </form>
                        </div>                       
                      </div>                       
                    </div>
                </div>
            </div>
        </div>
        <div id="saper-ft"></div>
    </div>
    
</body>

<script type="text/javascript">
$('select').iSelect();
</script>
</html>

