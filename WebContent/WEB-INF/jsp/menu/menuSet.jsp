<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">    
    <title>菜单设置</title>
    <meta http-equiv="content-type" content="text/html; charset=UTF-8">
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"/>
	<script type="text/javascript" src="js/jquery.js"></script>
	<script type="text/javascript" src="ztree/js/jquery.ztree.all.js"></script>
	<link rel="stylesheet" href="ztree/css/metroStyle/metroStyle.css">
	<script type="text/javascript" src="ztree/js/jquery.ztree.core.js"></script>
	<script type="text/javascript" src="ztree/js/jquery.ztree.excheck.js"></script>
	<script type="text/javascript" src="ztree/js/jquery.ztree.exedit.js"></script>
	<script type="text/javascript" src="ztree/js/jquery.ztree.exhide.js"></script>
	<script type="text/javascript">
		   var zTree;
    	   var setting = {
            view:{
                addHoverDom:addHoverDom,
                removeHoverDom:removeHoverDom,
                selectedMulti:false,
                showIcon:true,
                showLine:true
            },
            edit: {              
                enable: true,			//设置菜单为可编辑状态
                editNameSelectAll:true,
                removeTitle:'删除',		//设置删除节点按钮名称
                renameTitle:'修改',    //设置修改节点按钮名称           
            },
             data: { 
                simpleData: { 
                      enable: true,//如果设置为 true，请务必设置 setting.data.simpleData 内的其他参数: idKey / pIdKey / rootPId，并且让数据满足父子关系。 
                      idKey: "menuId", //设置菜单主键
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
                       url: "menu/allMenu.do",//请求action方法 
                       autoparam:["id"] 
                   },
            callback:{
                beforeDrag:beforeDrag,//用户禁止拖动节点
                beforeRemove:beforeRemove,//点击删除时触发，用来提示用户是否确定删除
                beforeEditName: beforeEditName,//点击编辑时触发，用来判断该节点是否能编辑
                beforeRename:beforeRename,//编辑结束时触发，用来验证输入的数据是否符合要求
                onRemove:onRemove,//删除节点后触发，用户后台操作
                onRename:onRename,//编辑后触发，用于操作后台      
            }
        };
    //加载树    
    $(document).ready(function(){
        zTree = $.fn.zTree.init($("#tree"), setting);
    });
    //删除节点时触发，用来提示用户是否确定删除，
    function beforeRemove(e,treeId,treeNode){
        return confirm("你确定要删除吗？");
    }
    //删除节点后触发，
    function onRemove(e,treeId,treeNode){
    	//ajax删除信息        
                    $.ajax({
                        url: "menu/delete.do?menuId="+ treeNode.menuId,
                        type: "post",
                        async: false,
                        success: function (msg){                        	
                        	if(msg=="fail"){
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
                paramsArray.push(childNodes[i].menuId);
            }
            
            alert("删除父节点的id为："+treeNode.menuId+"\r\n他的孩子节点有："+paramsArray.join(","));
            return;
        }         
        alert("你点击要删除的节点的名称为："+treeNode.name+"\r\n"+"节点id为："+treeNode.menuId);
    }
    function beforeEditName(treeId,treeNode){
        /* if(treeNode.isParent){
            alert("不准编辑非叶子节点！");
            return false;
        } */
        return true;
    }
    function beforeRename(treeId,treeNode,newName,isCancel){
        if(newName.length < 2){
            alert("名称不能少于2个字符！");
            
            return false;
        }
        return true;
    }
    function onRename(e,treeId,treeNode,isCancel){
        alert("修改节点的id为："+treeNode.menuId+"\n修改后的名称为："+treeNode.name);
        //ajax修改信息   
        			var name=encodeURI(treeNode.name);
        			name=encodeURI(name);     
                    $.ajax({
                        url: "menu/alter.do?menuId="+ treeNode.menuId+"&name="+name,
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
    
    function beforeDrag(treeId,treeNodes){
        return false;
    }
    var newCount = 1;
    function addHoverDom(treeId,treeNode){
         var sObj = $("#" + treeNode.tId + "_span");
            if (treeNode.editNameFlag || $("#addBtn_" + treeNode.tId).length > 0) return;
            var addStr = "<span class='button add' id='addBtn_" + treeNode.tId
						+ "' title='add node' onfocus='this.blur();'></span>";
            sObj.after(addStr);
            var btn = $("#addBtn_" + treeNode.tId);
            
            if (btn) btn.bind("click", function () {
                var zTree = $.fn.zTree.getZTreeObj("treeDemo");
                if (confirm("确认为 " + treeNode.name + " 添加子节点吗？")) {
                    //zTree.addNodes(treeNode, { id: (100 + newCount), pId: treeNode.id, name: "new node" + (newCount++) });               
                   
                    $.ajax({
                        url: "menu/add.do?parentId="+ treeNode.menuId,
                        type: "post",
                        async: false,
                        success: function (msg){
                        	if(msg==1){
                        	 alert("父节点不能为空！");
                             window.location.reload();
                        	}
                        	if(msg==2){
                        	 alert("添加失败！");
                             window.location.reload();
                        	}  
                        	if(msg==3){
                        	 alert("添加成功！");
                             window.location.reload();
                        	}                          	                           
                           
                            
                        }
                    });
                }
            });
        }
        
    function removeHoverDom(treeId,treeNode){
        $("#addBtn_"+treeNode.tId).unbind().remove();
    }
    </script>
<body>
    <ul id="tree" class="ztree"></ul>
</body>
</html>
