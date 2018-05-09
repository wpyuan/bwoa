<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">    
    <title>区域编辑</title>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"/>
    <meta http-equiv="content-type" content="text/html; charset=UTF-8">
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<script type="text/javascript" src="js/jquery.js"></script>
	<script type="text/javascript" src="ztree/js/jquery.ztree.all.js"></script>
	<link rel="stylesheet" href="ztree/css/zTreeStyle/zTreeStyle.css">
	<script type="text/javascript" src="ztree/js/jquery.ztree.core.js"></script>
	<script type="text/javascript" src="ztree/js/jquery.ztree.excheck.js"></script>
	<script type="text/javascript" src="ztree/js/jquery.ztree.exedit.js"></script>
	<script type="text/javascript" src="ztree/js/jquery.ztree.exhide.js"></script>
	<script type="text/javascript">
		   var zTree;
    	   var setting = {
            view:{               
                selectedMulti:false,
                showIcon:true,
                showLine:true
            },
            edit: {              
                enable: true,			//设置菜单为可编辑状态
                editNameSelectAll:true,
                removeTitle:'删除',		//设置删除节点按钮名称        
                renameTitle:'修改'	   //设置修改节点按钮名称                             
            },
             data: { 
                simpleData: { 
                      enable: true,//如果设置为 true，请务必设置 setting.data.simpleData 内的其他参数: idKey / pIdKey / rootPId，并且让数据满足父子关系。 
                      idKey: "areaId", //设置菜单主键
                      pIdKey: "parentId", //设置父菜单id                      
                      rootPId: 1 		  //设置根节点id
                    },
                key: {                	 
                     name: "name",		  //设置菜单名称
                     url:""			//设置节点点击之后跳转的链接，打开的是新页面
                    }
 
            }, 
            async: {    //ztree异步请求数据 
                       enable: true, 
                       url: "area/tree.do",//请求action方法 
                       autoparam:["id"] 
                   },
            callback:{
                beforeDrag:beforeDrag,//用户禁止拖动节点
                beforeRemove:beforeRemove,//点击删除时触发，用来提示用户是否确定删除
                beforeEditName: beforeEditName,//点击编辑时触发，用来判断该节点是否能编辑
                beforeRename:beforeRename,//编辑结束时触发，用来验证输入的数据是否符合要求
                onRemove:onRemove,//删除节点后触发，用户后台操作
                onRename:onRename,//编辑后触发，用于操作后台                
                onClick:clickNode,//点击节点触发的事件
                onClick: zTreeOnclick,//点击触发事件。
            }
        };
    //加载树    
    $(document).ready(function(){
        zTree = $.fn.zTree.init($("#tree"), setting);
    });
    //节点点击事件
    function zTreeOnclick(event, treeId, treeNode){
        	if(treeNode.link){
          		$(document).ready(function(){
       								  
			    $('#edit').attr('src',"area/toAdd.do?id="+treeNode.areaId);					  
			});
          		
          	}else{
          		alert("没有链接");
          	}
         }
    //删除节点时触发，用来提示用户是否确定删除，
    function beforeRemove(e,treeId,treeNode){
        return confirm("你确定要删除吗？");
    }
    //删除节点后触发，
    function onRemove(e,treeId,treeNode){
    				//ajax删除信息        
                    $.ajax({
                        url: "area/delete.do?areaId="+ treeNode.areaId,
                        type: "post",
                        async: false,
                        success: function (msg){
                        	if(msg=="one"){
                        	 alert("区域id不能为空");
                             window.location.reload();
                        	}
                        	if(msg=="two"){
                        	  alert("删除失败");
                        	  window.location.reload();
                        	}
                        	if(msg=="success"){
                        	 alert("删除成功");
                             window.location.reload();
                        	}                     	
                            
                        }
                    });
        if(treeNode.isParent){
            var childNodes = zTree.removeChildNodes(treeNode);
            var paramsArray = new Array();
            for(var i = 0; i < childNodes.length; i++){
                paramsArray.push(childNodes[i].id);
            }
            
            alert("删除父节点的id为："+treeNode.menuId+"\r\n他的孩子节点有："+paramsArray.join(","));
            return;
        }         
        alert("你点击要删除的节点的名称为："+treeNode.name+"\r\n"+"节点id为："+treeNode.id);
    }
    function beforeEditName(treeId,treeNode){        
        if(treeNode.link){
          		$(document).ready(function(){
       								  
			    $('#edit').attr('src',"area/toAlter.do?id="+treeNode.areaId);					  
			});
          		
          	}else{
          		alert("没有链接");
          	}
        return false;
    }
    function beforeRename(treeId,treeNode,newName,isCancel){
        if(newName.length < 3){
            alert("名称不能少于3个字符！");            
            return false;
        }
        return true;
    }
    function onRename(e,treeId,treeNode,isCancel){
        alert("修改节点的id为："+treeNode.menuId+"\n修改后的名称为："+treeNode.name);
        //ajax修改信息        
                    $.ajax({
                        url: "menu/alter.do?menuId="+ treeNode.menuId+"&name="+treeNode.name,
                        type: "post",
                        async: false,
                        success: function (msg){
                        	if(msg=="fail"){
                        	 alert("修改失败");
                             window.location.reload();
                        	}
                        	if(msg=="success"){
                        	 alert("修改成功");
                             window.location.reload();
                        	}                     	
                            
                        }
                    });
    }
    function clickNode(e,treeId,treeNode){
        if(treeNode.id == 11){
            location.href=treeNode.url;
        }else{
            alert("节点名称："+treeNode.name+"\n节点id："+treeNode.id);
        }
    }
    function beforeDrag(treeId,treeNodes){
        return false;
    }
   
    </script>
<body>
    <ul id="tree" class="ztree"></ul>
    <div style="position: absolute;left: 50%;top: 10px" >
		<iframe src="" id="edit" width="600px" height="800px" frameborder="0"></iframe>
	</div>	
</body>
</html>
