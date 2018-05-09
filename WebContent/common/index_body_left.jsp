<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=emulateIE7" />
<link rel="stylesheet" href="css/sapar.css" />
<link rel="stylesheet" href="css/index_inner.css" />
<link rel="stylesheet" href="ztree/css/zTreeStyle/zTreeStyle.css"
	type="text/css" />
<link rel="stylesheet" type="text/css" href="easyui-tabs/css/easyui.css">
<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript" src="ztree/js/jquery.ztree.core.min.js"></script>
<script type="text/javascript" src="ztree/js/jquery.ztree.core.js"></script>
<script type="text/javascript"
	src="ztree/js/jquery.ztree.excheck.min.js"></script>
<script type="text/javascript" src="easyui-tabs/js/jquery.easyui.min.js"></script>
<script type="text/javascript">
	/**************************ztree************************************/
	//设置ztree标题的颜色,ajax和ztree获取数据的方式都可以用
	function setFontCss(treeId, treeNode) {
		return treeNode.level == 1 ? {
			color : "black"
		} : {};
	};
	var zTreeNodes;
	var zTreeObj;
	var setting = {
		//  check: { 
		//     enable: true//启动多选框记得导入jquery.ztree.excheck-3.4.js  
		// }, 

		data : {
			simpleData : {
				enable : true,//如果设置为 true，请务必设置 setting.data.simpleData 内的其他参数: idKey / pIdKey / rootPId，并且让数据满足父子关系。 
				idKey : "menuId",
				pIdKey : "parentId",
				rootPId : 1
			},
			key : {
				name : "name",
				url : "" //设置节点点击之后跳转的链接，打开的是新页面
			}

		},

		view : {
			showLine : false,//显示连接线 
			showIcon : true,//显示节点图片 
			//fontCss: {color:"red"} 
			fontCss : setFontCss
		//节点颜色 

		},

		async : { //ztree异步请求数据 
			enable : true,
			url : "/oa/ztree/menu.do",//请求action方法 
			autoparam : [ "id" ]
		},

		callback : {
			//beforeClick: zTreeBeforeClick,
			//设置节点点击事件
			onClick : zTreeOnclick,
			onAsyncSuccess : zTreeOnAsyncSuccess

		}
	};

	/*      $(document).ready(function(){
	      	$.ajax({
	      		url:"index/menu.do",
	      		type:"post",
	      		data:{},
	      		dataType:"json",
	      		success : function(data){
	      			alert("success");
	      			zTreeNodes=data;
	      			zTreeObj= $.fn.zTree.init($("#treeDemo"), setting,zTreeNodes); 
	      		},
	      		
	      	});
	      });
	 */
	//启动树节点     
	$(function($) {

		$.fn.zTree.init($("#treeDemo"), setting);
	});

	//节点点击事件
	function zTreeOnclick(event, treeId, treeNode) {

		/*if(treeNode.link){
			$(document).ready(function(){
									  
			    $('#iframe').attr('src',treeNode.link);					  
			});
			
		}*/
		var zTree = $.fn.zTree.getZTreeObj("ztree");
		if (treeNode.isParent) {
			zTree.expandNode(treeNode);
			return false;
		} else {
			showPanel(treeNode.name, treeNode.link);
		}
	}

	function zTreeOnAsyncSuccess() {
		//alert('加载树成功');
		var treeObj = $.fn.zTree.getZTreeObj("treeDemo");
		//设置展开根节点,默认不展开
		// treeObj.expandAll(true);

	}

	function showPanel(stitle, urlpath) {
		//alert(urlpath); 子节点请求路径      
		if ($('#ttab').tabs('exists', stitle)) {
			$('#ttab').tabs('select', stitle);
		} else {
			$('#ttab')
					.tabs(
							'add',
							{
								title : stitle,
								content : "<iframe src="
										+ urlpath
										+ " scrolling='yes'  frameborder='0' id='iframeOne' width='100%' height='800px' ></iframe>",
								closable : true
							});
		}

	}

	//树节点的点击事件
	function zTreeBeforeClick(treeId, treeNode, clickFlag) {
		/*alert("treeNode.id--->"+treeNode.id);
		alert("treeNode.url--->"+treeNode.url);
		alert("treeNode.name--->"+treeNode.title);*/
		if (treeNode.url !== '') {//不新建标签页面显示,让页面显示在中心区域
			showPanel(treeNode.title, treeNode.url);
		}

		return (treeNode.id !== 1);
	};
	/*******************************************************************/
	//当浏览器窗口大小改变时，设置显示内容的高度  
	window.onresize = function() {

		/*$('#ttab').tabs('resize', {
			plain : false,
			boder : false,
			width : $(window).width(),
			height : $(window).height() - 50
		});*/
		$('#ttab').tabs('resize',{
			width : $("#ttab").parent().width(),
			height : "auto"
		});
	}
</script>
</head>
<body style="margin: 0; padding: 0">
	<div id="container">
		<div id="bd">
			<div class="wrap clearfix">

				<div class="sidebar">
					<h2 class="sidebar-header">
						<p>功能导航</p>
					</h2>
					<!-- 菜单实现 -->
					<div class="zTreeDemoBackground left"
						style="position: absolute; width: 10%; left: 0px">
						<ul id="treeDemo" class="ztree"></ul>
					</div>
				</div>

				<!-- 选型卡 -->
				<div id="ttab" class="easyui-tabs" data-options="border:false">
					<div title="首页"
						style="padding: 20px; display: none; height: 100%; width: 100%">
						<iframe src="/oa/common/index_body_right.jsp" id="iframeZero"
							scrolling="yes" frameborder="0" width="100%" height="100%"
							frameborder="0"> </iframe>
					</div>
				</div>

			</div>
		</div>
	</div>
</body>
</html>