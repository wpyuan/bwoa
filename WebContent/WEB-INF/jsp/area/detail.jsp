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
    
    <title>区域信息</title>
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
	<title>区域信息</title>
</head>

<body>
    <div id="saper-container">
        <div id="saper-hd"></div>
        <div id="saper-bd">
            <div class="subfiled clearfix">
                <h2>区域信息</h2>
            </div>
            <div class="subfiled-content">
                <div class="tab-container" data-trigger="hover">
                    <div class="tab">
                        <a href="javascript:;" class="current">基本信息</a>                        
                    </div>
                    <div class="tab-content">
                        <div class="tab-content-item">
                            <form name="f1" id="f1" action="?m=system&amp;c=myInfo&amp;a=updateInfo&amp;type=1" method="post">
                            	<!--
                                	作者：张恭雨
                                	时间：2017-10-18
                                	描述：表单左部
                                -->
                            	<div id="form-left">                            		
	                                <div class="kv-item clearfix">
	                                    <label>区域名称：</label>
	                                    <div class="kv-item-content" style="line-height:30px;">
	                                        ${area.name}
	                                    </div>
	                                </div>
	                                <div class="kv-item clearfix">
	                                    <label><span class="impInfo">*</span>有效性：</label>
	                                    <div class="kv-item-content">
	                                        <input name="" type="text"  readonly="readonly" value="${area.status==1?"有效":"无效"}">
	                                    </div>
	                                </div>
	
	                                
	                                
	                                <div class="kv-item clearfix">
	                                    <label><span class="impInfo">*</span>省：</label>
	                                    <div class="kv-item-content">
	                                        <input name="" type="text"  readonly="readonly" value="${provinceName}">
	                                    </div>
	                                </div>
	                                
	                                <div class="kv-item clearfix">
	                                    <label><span class="impInfo">*</span>市：</label>
	                                    <div class="kv-item-content">
	                                        <input name="" type="text"  readonly="readonly" value="${cityName}" >
	                                    </div>
	                                </div>	                                
	                               
	                                 <div class="kv-item clearfix">
	                                    <label>乡镇：</label>
	                                    <div class="kv-item-content">
	                                        <input name="" type="text"  readonly="readonly" value="${townName}">
	                                    </div>
	                                </div>
	                                
	                                <div class="kv-item clearfix">
	                                    <label>创建人：</label>
	                                    <div class="kv-item-content">
	                                        <input name="" type="text"  readonly="readonly" value="${area.createBy}">
	                                    </div>
	                                </div>
		                                
	                                <div class="kv-item clearfix">
	                                    <label>创建时间：</label>
	                                    <div class="kv-item-content">
	                                        <input name="" type="text" readonly="readonly" value="${area.createDate}">
	                                    </div>
	                                </div>
	
	                                <div class="kv-item clearfix">
	                                    <label>更新时间：</label>
	                                    <div class="kv-item-content">
	                                        <input name="" type="text" readonly="readonly" value="${area.updateDate}">
	                                    </div>
	                                </div>
	
	                                <div class="kv-item clearfix">
	                                    <label>更新人：</label>
	                                    <div class="kv-item-content">
	                                        <input name="" type="text" readonly="readonly" value="${area.updateBy}">
	                                    </div>
	                                </div>
	                                
	
	                                <div class="kv-item clearfix">
	                                    <label>区域等级：</label>
	                                    <div class="kv-item-content">
	                                        <input name="" type="text" readonly="readonly" value="${area.regionLevel}">
	                                    </div>
	                                </div>                              
	                                
	                                
	                                <div class="kv-item clearfix">
	                                    <label>区域链接：</label>
	                                    <div class="kv-item-content">
	                                        <input name="" type="text" readonly="readonly" value="${area.link}">
	                                    </div>
	                                </div>	 
	                                
	                                <div class="kv-item clearfix">
	                                    <label><span class="impInfo">*</span>区域描述：</label>	                                    
	                                    <div class="kv-item-content">
	                                        <textarea name="" readonly="readonly">${area.description}</textarea>
	                                    </div>
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
