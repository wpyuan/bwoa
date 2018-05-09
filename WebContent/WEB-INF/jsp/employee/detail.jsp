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
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"/>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link rel="stylesheet" href="css/sapar.css" />
<link rel="stylesheet" type="text/css" href="css/my_info.css" />
<link rel="stylesheet" type="text/css" href="css/info.css" />
<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript" src="js/sapar.js"></script>
<title>我的资料信息</title>
</head>
<body>
    <div id="saper-container">
        <div id="saper-hd"></div>
        <div id="saper-bd">
            <div class="subfiled clearfix">
                <h2>我的资料</h2>
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
                            	<div id="div-left">                            		
	                                <div class="kv-item clearfix">
	                                    <label>员工姓名：</label>
	                                    <div class="kv-item-content" style="line-height:30px;">
	                                       ${employee.name}
	                                    </div>
	                                </div>
	                                <div class="kv-item clearfix">
	                                    <label><span class="impInfo">*</span>电话：</label>
	                                    <div class="kv-item-content">
	                                        <input value="${employee.phone}" type="text" readonly="readonly">
	                                    </div>
	                                </div>
	
	                                <div class="kv-item clearfix">
	                                    <label><span class="impInfo">*</span>身份证号：</label>
	                                    <div class="kv-item-content">
	                                        <input value="${employee.idCard}" type="text"  readonly="readonly">
	                                    </div>
	                                </div>
	                                
	                                <div class="kv-item clearfix">
	                                    <label><span class="impInfo">*</span>籍贯：</label>
	                                    <div class="kv-item-content">
	                                        <input value="${employee.nativePlace}" type="text"  readonly="readonly">
	                                    </div>
	                                </div>
	                                
	                                <div class="kv-item clearfix">
	                                    <label><span class="impInfo">*</span>学历：</label>
	                                    <div class="kv-item-content">
	                                        <input value="${employee.educational}" type="text"  readonly="readonly">
	                                    </div>
	                                </div>
	                                
	                                <div class="kv-item clearfix">
	                                    <label><span class="impInfo">*</span>部门：</label>
	                                    <div class="kv-item-content">
	                                        <input value="${name}" type="text"  readonly="readonly">
	                                    </div>
	                                </div>
	
	                                <div class="kv-item clearfix">
	                                    <label><span class="impInfo">*</span>居住地址：</label>
	                                    <div class="kv-item-content">	                                        
	                                        <textarea name="resume" readonly="readonly">${employee.address}</textarea>	                                        
	                                    </div>	                                    	
	                                </div>
	                                
	                                <div class="kv-item clearfix">
	                                    <label>入职时间：</label>
	                                    <div class="kv-item-content">
	                                        <input value="${dateVo.hireDateVo}" type="text" readonly="readonly">
	                                    </div>
	                                </div>
	
	                                <div class="kv-item clearfix">
	                                    <label>邮箱：</label>
	                                    <div class="kv-item-content">
	                                        <input value="${employee.email}" type="email" readonly="readonly">
	                                    </div>
	                                </div>
	
	                                <div class="kv-item clearfix">
	                                    <label>原职位：</label>
	                                    <div class="kv-item-content">
	                                        <input value="${employee.lastJob}" type="text" readonly="readonly">
	                                    </div>
	                                </div>
	                                
	
	                                <div class="kv-item clearfix">
	                                    <label>现职位：</label>
	                                    <div class="kv-item-content">
	                                        <input value="${employee.nowJob}" type="text" readonly="readonly">
	                                    </div>
	                                </div>
                            	</div>
                            	<!--
                                	作者：张恭雨
                                	时间：2017-10-18
                                	描述：表单右部
                                -->
								<div id="div-rigth">		
									
	                                
	
	                                <div class="kv-item clearfix">
	                                    <label><span class="impInfo">*</span>性别：</label>	                                    
	                                    <div class="kv-item-content">
	                                        <input value="${employee.sex}" type="text" readonly="readonly">
	                                    </div>                                                                         
	                                    
	                                </div>
	                                
	                                <div class="kv-item clearfix">
	                                    <label>民族：</label>
	                                    <div class="kv-item-content">
	                                        <input value="${employee.nation}" type="text" placeholder="民族" readonly="readonly">
	                                    </div>
	                                </div>
	                                
	                                <div class="kv-item clearfix">
	                                    <label>出生日期：</label>
	                                    <div class="kv-item-content">
	                                        <input value="${dateVo.birthdayVo}" type="text" placeholder="出生日期" readonly="readonly">
	                                    </div>
	                                </div>
	                                
	                                <div class="kv-item clearfix">
	                                    <label>政治面貌：</label>
	                                    <div class="kv-item-content">
	                                        <input value="${employee.politicsStatus}" type="text" placeholder="政治面貌" readonly="readonly">
	                                    </div>
	                                </div>
	                                
	                                <div class="kv-item clearfix">
	                                    <label>工作时间：</label>
	                                    <div class="kv-item-content">
	                                        <input value="${dateVo.workDateVo}" type="text" placeholder="工作时间" readonly="readonly">
	                                    </div>
	                                </div>
	                                	                                
	                                <div class="kv-item clearfix">
	                                    <label>试用日期：</label>
	                                    <div class="kv-item-content">
	                                        <input value="${dateVo.probationPeriodVo}" type="text" placeholder="试用日期" readonly="readonly">
	                                    </div>
	                                </div>
	                                
	                                <div class="kv-item clearfix">
	                                    <label>转正日期：</label>
	                                    <div class="kv-item-content">
	                                    	<input value="${dateVo.positivePhaseVo}" type="text" placeholder="转正日期" readonly="readonly">	                                        
	                                    </div>
	                                </div>
	                                
	                                <div class="kv-item clearfix">
	                                    <label>毕业时间：</label>
	                                    <div class="kv-item-content">
	                                    	<input value="${dateVo.graduationDateVo}" type="text" placeholder="转正日期" readonly="readonly">	                                        
	                                    </div>
	                                </div>
	                                
	                                <div class="kv-item clearfix">
	                                    <label>员工状态：</label>
	                                    <div class="kv-item-content">
	                                        <input type="text" value="${employee.status==1?"在职":"离职"}" readonly="readonly"/>
	                                    </div>
	                                </div>
								</div>
                                <!--
                                	作者：张恭雨
                                	时间：2017-10-18
                                	描述：表单底部
                                -->
                                <div id="div-button-left">
	                                <div class="kv-item clearfix">
	                                    <label>家庭关系：</label>
	                                     <div class="kv-item-content">
	                                     	<textarea name="resume" readonly="readonly">${employee.familyRelationships}</textarea>	                                        
	                                    </div>	                                    	
	                                </div>
	                                
	                                <div class="kv-item clearfix">
	                                    <label>社会关系：</label>
	                                    <div class="kv-item-content">
	                                    	<textarea name="resume" readonly="readonly">${employee.socialRelations}</textarea>	                                        
	                                    </div>	                                    
	                                </div>                 	
                                </div>
                                
                                <div id="div-button-right">
                                	<div class="kv-item clearfix">
	                                    <label>个人简历：</label>
	                                    <div class="kv-item-content">	                                        
	                                        <textarea name="resume" readonly="readonly">${employee.resume}</textarea>
	                                    </div>	                                    	
	                                </div>
	                                
	                                <div class="kv-item clearfix">
										<label>特长爱好：</label>
										<div class="kv-item-content">
											<textarea name="specialty" placeholder="特长爱好">${employee.specialty}</textarea>
										</div>
									</div>
	                                
	                                <div class="kv-item clearfix">
										<label>备注：</label>
										<div class="kv-item-content">
											<textarea name="resume" >${employee.remark}</textarea>
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