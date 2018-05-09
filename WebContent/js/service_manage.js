var newOpen =null;

	var areaId;
    var setting = { 
 				 
                   data: { 
                       simpleData: { 
                           enable: true,//如果设置为 true，请务必设置 setting.data.simpleData 内的其他参数: idKey / pIdKey / rootPId，并且让数据满足父子关系。 
                           idKey: "areaId", 
                           pIdKey: "parentId", 
                           rootPId: 1 
                       },
                       key: {
                        name: "name",
                        url:""			//设置节点点击之后跳转的链接，打开的是新页面
                    }
 
                   }, 
                                  
                      
                   view: { 
                       showLine: false,//显示连接线 
                       showIcon: true,//显示节点图片 
                       addDiyDom: addDiyDom,    
                   }, 
                      
                  async: {    //ztree异步请求数据 
                       enable: true, 
                       url: "",//请求action方法 
                       autoparam:["id"] 
                   },                   
                   
                   callback:{
                        //beforeClick: zTreeBeforeClick,
                        //设置节点点击事件
                       	//onClick: zTreeOnclick,
                        //onAsyncSuccess: zTreeOnAsyncSuccess
                	   	onExpand: zTreeOnExpand		//捕获节点的展开事件
 
                   }
               };               
           
	$(function () {	
				$.ajax({
	            		url:"/oa/fuwu/getAreaData.do",
	            		type:"post",            		
	            		dataType:"json",
	            		success : function(result){
	            			queryHandler(result);
	            			
	            		},
	            		
	            	});  
	});
	
	/*
	 * 节点展开事件
	 */	
	
	function zTreeOnExpand(event, treeId, treeNode) {		
		   	
	};
           
/**
 * 自定义DOM节点
 */
var view=[];
function addDiyDom(treeId, treeNode) {	
    var spaceWidth = 15;
    var liObj = $("#" + treeNode.tId);
    var aObj = $("#" + treeNode.tId + "_a");
    var switchObj = $("#" + treeNode.tId + "_switch");
    var icoObj = $("#" + treeNode.tId + "_ico");
    var spanObj = $("#" + treeNode.tId + "_span");
    aObj.attr('title', '');    
    aObj.append('<div class="divTd swich fnt" style="width:30%"></div>');
    var div = $(liObj).find('div').eq(0);
    //从默认的位置移除
    switchObj.remove();
    spanObj.remove();
    icoObj.remove();
    //在指定的div中添加
    div.append(switchObj);
    div.append(spanObj);
    //隐藏了层次的span
    var spaceStr = "<span style='height:1px;display: inline-block;width:" + (spaceWidth * treeNode.level) + "px'></span>";
    switchObj.before(spaceStr);
    //图标垂直居中
    icoObj.css("margin-top","9px");
    switchObj.after(icoObj);
    var editStr = '';
    //宽度需要和表头保持一致
    var asccId=document.getElementById("asccId").value;
    var year=document.getElementById("year").value;
    var createBy=document.getElementById("createBy").value;
    var createDate=document.getElementById("createDate").value;
    var householdNumber=document.getElementById("householdNumber").value;
    /*
     * 单引号中嵌套单引号需要进行转译
     * var s4 = 'k(\'kkk\')';//正确，这是字符串嵌套，就是函数调用k('kkk');
     */
    if(treeNode.areaId==1){
		editStr += '<div class="divTd" style="width:14%">' +(year)+ '</div>';			
        editStr += '<div class="divTd" style="width:14%" ondblclick="alter(this,'+(asccId)+')">' + (householdNumber)+'</div>';
        editStr += '<div class="divTd" style="width:14%">' + (createDate) + '</div>';
        editStr += '<div class="divTd" style="width:14%">' + (createBy)+ '</div>';
        editStr += '<div class="divTd" style="width:14%"><a onclick="shanchu('+(asccId)+')">删除</a></div>';
    		
        //alert(editStr);
    }
    
    /*
     * 异步加载数据显示
     */
    for(var i=0;i<view.length;i++){    		
		if(view[i].areaId==treeNode.areaId){
			editStr += '<div class="divTd" style="width:14%">' +(view[i].year)+ '</div>';			
	        editStr += '<div class="divTd" style="width:14%" ondblclick="alter(this,'+(view[i].asccId)+')">' + (view[i].householdNumber)+'</div>';
	        editStr += '<div class="divTd" style="width:14%">' + (view[i].createDate) + '</div>';
	        editStr += '<div class="divTd" style="width:14%">' + (view[i].createBy)+ '</div>';
	        editStr += '<div class="divTd" style="width:14%"><a onclick="shanchu('+(view[i].asccId)+')">删除</a></div>';
        		
	      //alert(editStr);
		}    		
	}
    
    aObj.append(editStr);
}

//初始化列表
function queryHandler(zTreeNodes){	
	/*
	 * 异步加载节点展开需要加载的数据。
	 */
	$.ajax({
		url:"/oa/fuwu/getManageData.do",
		type:"post",
		dataType:"",
		success : function(data){
			//判断返回结果是否为空
			if(data!=""){
				for(var i=0;i<data.length;i++){
					view.push(data[i]);
				}	
			}else{
				alert("未查询到相关信息！");
			}
											
		},
		
	});
	
	//初始化树 
	$.fn.zTree.init($("#dataTree"), setting,zTreeNodes);
    //添加表头
    var li_head = ' <li class="head"><a><div class="divTd" style="width:30%">区域</div><div class="divTd" style="width:14%">年份</div>' +
        '<div class="divTd" style="width:14%">应收数</div><div class="divTd" style="width:14%">创建时间</div><div class="divTd" style="width:14%">创建人</div>'+
        '<div class="divTd" style="width:14%">操作</div>';
    var rows = $("#dataTree").find('li');
    if (rows.length > 0) {
        rows.eq(0).before(li_head);
    } else {
        $("#dataTree").append(li_head);
        $("#dataTree").append('<li ><div style="text-align: center;line-height: 30px;" >无符合条件数据</div></li>');
    }
}

//双击编辑内容
function alter(element,asccId){
	
	var oldhtml=element.innerHTML;
	//创建新的input元素
	var newobj=document.createElement('input');
	//为新增元素添加类型
	newobj.type='text';
	//设置新增元素的值
	newobj.value=oldhtml;
	//设置新增元素的ID
	newobj.id="houseHoldNumber";
	//为新增元素添加光标离开事件
	newobj.onblur=function(){
		//获取修改后元素的值
		var num=document.getElementById("houseHoldNumber").value;
		//判断值是否为空或者是否修改过
		if(num!=""&&num!=oldhtml){
    	   //提示用户是否确定修改
    	   	if(confirm("确定修改？")){
    	   		/*
    	   		 * 异步修改数据
    	   		 */
    	   		$.ajax({
    	   			url:"/oa/fuwu/update.do",
    	   			type:"post", 
    	   			data:{"number":num,"asccId":asccId},
    	   			dataType:"",
    	   			success : function(data){
    	   				if(data=="success"){
    	   					alert("修改成功！");
    	   					window.location.href="/oa/fuwu/manage.do";
    	   				}else{
    	   					alert("修改失败！");
    	   				}
    	   			},
    	   			
    	   		}); 
    		   	element.innerHTML = this.value;
    	   	}else{
    		   	element.innerHTML = oldhtml;
    	   	}
       	}else{
       		element.innerHTML = oldhtml;
       	}
        //当触发时设置父节点的双击事件为alter
        element.setAttribute("ondblclick", "alter(this);");
	}
	//设置该标签的子节点为空
    element.innerHTML = '';
    //添加该标签的子节点，input对象
    element.appendChild(newobj);
    //设置选择文本的内容或设置光标位置（两个参数：start,end；start为开始位置，end为结束位置；如果开始位置和结束位置相同则就是光标位置）
    newobj.setSelectionRange(0, oldhtml.length);
    //设置获得光标
    newobj.focus();

    //设置父节点的双击事件为空
    newobj.parentNode.setAttribute("ondblclick", "");

}
