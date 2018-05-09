/**
 * @作者 王培源
 * @描述 areaChange.jsp的js
 * @创建时间 2017/11/3
 */
//查询
function query() {
	var name = document.getElementById('queryName').value;
	name=encodeURI(name);//1.编码
	name=encodeURI(name);//2.编码
	window.location.href="/oa/account/queryAreaByEmployeeName.do?name="+name;
}
//编辑
function edit(areaId,employeeId) {				
	var newAreaId = document.getElementById('newAreaId').value;
	//alert(employeeId+","+newAreaId);
			
	$.ajax({
		url : "/oa/account/areaChange.do?areaId="+newAreaId,   //要提交的URL路径
		type : "post",      //发送请求的方式
		data : "employeeId="+employeeId,       //要发送到服务器的数据
		dataType : "json", //指定传输的数据格式
		success : function(result) {//请求成功后要执行的代码	
			alert(result.msg);
			document.getElementById(areaId).innerHTML = result.newAreaName;
		}
	});			
}