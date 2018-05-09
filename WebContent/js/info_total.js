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
	            		url:"/oa/performanceInfo/getAreaData.do",
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
    aObj.append('<div class="divTd swich fnt" style="width:20%"></div>');
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
    //获取数据\   	
    var taxNumber=document.getElementById("taxNumber").value;
    var serviceNumber=document.getElementById("serviceNumber").value;    
    var escalationNumber=document.getElementById("escalationNumber").value;    
    var equipmentNumber=document.getElementById("equipmentNumber").value;
    var freeReplacementNumber=document.getElementById("freeReplacementNumber").value;
    var replacementNumber=document.getElementById("replacementNumber").value;
    var totalSalesAmount=document.getElementById("totalSalesAmount").value;
    var hasHandIn=document.getElementById("hasHandIn").value;
    var notPay=document.getElementById("notPay").value;
    var percent=document.getElementById("percent").value;
    /*
     * 单引号中嵌套单引号需要进行转译
     * var s4 = 'k(\'kkk\')';//正确，这是字符串嵌套，就是函数调用k('kkk');
     */
    /*
     * 跳转页面后的数据显示
     */
    if(treeNode.areaId==1){
    	editStr += '<div class="divTd" style="width:8%"><a onClick="detail(\'tax\','+treeNode.areaId+')">' + (taxNumber) + '</a></div>';     	
        editStr += '<div class="divTd" style="width:8%"><a onClick="detail(\'service\','+treeNode.areaId+')">' + (serviceNumber) +'('+ (percent)+')'+'</a></div>';
        editStr += '<div class="divTd" style="width:8%">' + (escalationNumber) + '</div>';
        editStr += '<div class="divTd" style="width:8%"><a onClick="detail(\'equipment\','+treeNode.areaId+')">' + (equipmentNumber) + '</a></div>';
        editStr += '<div class="divTd" style="width:8%">' + (freeReplacementNumber) + '</div>';
        editStr += '<div class="divTd" style="width:8%">' + (replacementNumber) + '</div>';
        editStr += '<div class="divTd" style="width:12%">' + (totalSalesAmount) + '</div>';
        editStr += '<div class="divTd" style="width:10%">' + (hasHandIn) + '</div>';
        editStr += '<div class="divTd" style="width:10%">' + (notPay) + '</div>';         
    }
    /*
     * 异步加载数据显示
     */
    for(var i=0;i<view.length;i++){    		
		if(view[i].areaId==treeNode.areaId){
			areaId=treeNode.areaId;
			editStr += '<div class="divTd" style="width:8%"><a onClick="detail(\'tax\','+treeNode.areaId+')">' + (view[i].taxNumber) + '</a></div>';
			//设置不显示三级菜单的百分比
	        editStr += '<div class="divTd" style="width:8%"><a onClick="detail(\'service\','+treeNode.areaId+')">' + (view[i].serviceNumber) +('('+ (view[i].percent)+')') +'</a></div>';
	        editStr += '<div class="divTd" style="width:8%">' + (view[i].escalationNumber) + '</div>';
	        editStr += '<div class="divTd" style="width:8%"><a onClick="detail(\'equipment\','+treeNode.areaId+')">' + (view[i].equipmentNumber) + '</a></div>';
	        editStr += '<div class="divTd" style="width:8%">' + (view[i].freeReplacementNumber) + '</div>';
	        editStr += '<div class="divTd" style="width:8%">' + (view[i].replacementNumber) + '</div>';
	        editStr += '<div class="divTd" style="width:12%">' + (view[i].totalSalesAmount) + '</div>';
	        editStr += '<div class="divTd" style="width:10%">' + (view[i].hasHandIn) + '</div>';
	        editStr += '<div class="divTd" style="width:10%">' + (view[i].notPay) + '</div>'; 
		}    		
	}
    
    aObj.append(editStr);
}

//初始化列表
function queryHandler(zTreeNodes){
	//获取日期
	var startTime=document.getElementById("startTime").value;
	var endTime=document.getElementById("endTime").value;
	/*
	 * 异步加载节点展开需要加载的数据。
	 */
	
	$.ajax({
		url:"/oa/performanceInfo/unfurledData.do?startTime="+startTime+"&endTime="+endTime+"&areaId=1",
		type:"post",
		dataType:"",
		success : function(data){
			for(var i=0;i<data.length;i++){
				view.push(data[i]);	
			}								
		},
		
	});
	
	//初始化树 
	$.fn.zTree.init($("#dataTree"), setting,zTreeNodes);
    //添加表头
    var li_head = ' <li class="head"><a><div class="divTd" style="width:20%">区域</div><div class="divTd" style="width:8%">新户售盘数</div>' +
        '<div class="divTd" style="width:8%">老户服务费</div><div class="divTd" style="width:8%">报税盘</div><div class="divTd" style="width:8%">通用设备</div>'+
        '<div class="divTd" style="width:8%">税控盘更换（免费）</div><div class="divTd" style="width:8%">税控盘更换（有偿）</div>'+
        '<div class="divTd" style="width:12%">总销售金额</div><div class="divTd" style="width:10%">已上交</div><div class="divTd" style="width:10%">未上交</div></a></li>';
    var rows = $("#dataTree").find('li');
    if (rows.length > 0) {
        rows.eq(0).before(li_head);
    } else {
        $("#dataTree").append(li_head);
        $("#dataTree").append('<li ><div style="text-align: center;line-height: 30px;" >无符合条件数据</div></li>');
    }
}


//日期模糊查询方法
function select(){
	//获取查询日期	
	var startTime=document.getElementById("startTime").value;
	var endTime=document.getElementById("endTime").value;
	var year=document.getElementById("year").value;
	$.ajax({
		url:"/oa/performanceInfo/select.do?startTime="+startTime+"&endTime="+endTime+"&areaId=1",
		type:"post",
		dataType:"",
		success : function(result){			
			if(result=="success"){				
				window.location.href='/oa/performanceInfo/selectResult.do?falg=false';
			}else{
				alert("查询失败！没有服务费年份总数");
			}
		},
		
	}); 
}

//日期定向选择查询  
function selectClear(years,month,day){
	//获取年份和月份
	var year=years.innerHTML.substring(0, 4);
	var month=month.innerHTML.substring(0,month.innerHTML.length-1);
	var startTime;
	var endTime;
	//判断天数
	if(day=="上半年"){
		//拼接字符串
		startTime=year+"-"+month+"-"+"01";
		endTime=year+"-"+06+"-"+30;
	}else if(day=="下半年"||day=="全年"){
		//拼接字符串
		startTime=year+"-"+month+"-"+"01";
		endTime=year+"-"+12+"-"+31;
	}else{
		//拼接字符串
		startTime=year+"-"+month+"-"+"01";
		endTime=year+"-"+month+"-"+day;	
	}
	
	//查询
	$.ajax({
		url:"/oa/performanceInfo/select.do?startTime="+startTime+"&endTime="+endTime+"&areaId=1",
		type:"post",
		dataType:"",
		success : function(result){			
			if(result=="success"){
				var timeYear=encodeURI(years.innerHTML.substring(0, 5)+month+"月");
				timeYear=encodeURI(timeYear);	
				window.location.href='/oa/performanceInfo/selectResult.do?year='+timeYear+"&falg=true";	
								
			}else{
				alert("查询失败！没有服务费年份总数");
			}
			
		},
		
	});
}

//减少年份
function reduceYear(year){
	var value=year.innerHTML.substring(0, 4);
	value=value*1-1;
	if(value>0){		
		value=value+year.innerHTML.substring(4,year.innerHTML.length);
		year.innerHTML=value;
	}else{
		alert("年份不能小于零");
	}
	
	
}

//增加年份
function addYear(year){
	var value=year.innerHTML.substring(0, 4);
	value=value*1+1;
	value=value+year.innerHTML.substring(4,year.innerHTML.length);
	year.innerHTML=value;
	
}

/*
*查询详细信息
*/
function detail(type,areaId){	
	//alert(areaId)
	var startTime=document.getElementById("startTime").value;
	var endTime=document.getElementById("endTime").value;
	window.open('/oa/performanceInfo/detail.do?type='+type+'&areaId='+areaId+'&startTime='+startTime+'&endTime='+endTime,'blank_','resizable=no,width=650,height=450,top=250,left=400');
}

/*
 * 显示天数
 */
var calendarText;
function showDay(){	
	var calendarSelect=document.getElementById("calendarSelect");
	var str='';
	//获取年月
	var year=document.getElementById("year").innerHTML.substring(0,4);
	var month=document.getElementById("year").innerHTML.substring(5,document.getElementById("year").innerHTML.length-1);
	var day;
	
	//判断是否是大月
	if(month<=8){
		if(month%2!=0||month==8){
			day=31;
		}else if(month!=2){
			day=30;
		}else{
			if(year % 4 ==0 && year % 100 != 0 || year % 400 == 0){
				day=29;
			}else{
				day=28;
			}
		}
	}else{
		if(month%2==0){
			day=31;
		}else{
			day=30;
		}
	}
	//alert("tian"+day);
	
	for(var i=0;i<2;i++){
		str+='<tr>';
		str+='<th class="num" style="background: bisque;color: black;"><a id="january" style="color: black;"></a></th>';
		for(var j=1;j<17;j++){
			if(i==0)
				str+='<th class="num" style="background: bisque;"><a id="january" style="color: black;" onclick="selectByDay('+year+','+month+','+j+')">'+(j)+'日</a></th>';			
			if(i==1){
				var temp=16+j;
				str+='<th class="num" style="background: bisque;"><a id="january" style="color: black;" onclick="selectByDay('+year+','+month+','+temp+')">'+(temp<=day?temp+'日':"")+'</a></th>';
			}		
				
		}
		str+='<th class="num" style="background: bisque;"><a id="january" style="color: black;"></a></th>';
		str+='</tr>';
	}
	//str='<tr></tr>'+str;
	//alert(str);
	calendarText=document.getElementById("month").innerHTML;
	calendarText='<tr id="month">'+calendarText+'</tr>'+str;
	calendarSelect.innerHTML=calendarText;
}

/*
 * 查询每一天的统计信息
 */
function selectByDay(year,month,day){
	var startTime=year+'-'+month+'-'+day;
	var endTime=year+'-'+month+'-'+day;
	
	//查询
	$.ajax({
		url:"/oa/performanceInfo/select.do?startTime="+startTime+"&endTime="+endTime+"&areaId=1",
		type:"post",
		dataType:"",
		success : function(result){			
			if(result=="success"){
				var timeYear=encodeURI(year+'年'+month+'月');
				timeYear=encodeURI(timeYear);	
				window.location.href='/oa/performanceInfo/selectResult.do?year='+timeYear+"&falg=true";									
			}else{
				alert("查询失败！没有服务费年份总数");
			}
			
		},
		
	});
}
