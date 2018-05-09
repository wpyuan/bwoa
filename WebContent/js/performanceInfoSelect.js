/**
 * @作者 王培源
 * @创建时间 2017/11/22
 */
// 区域选择器
function selectArea() {
	var areaName = document.getElementById('areaSelect').value;
	var startTime = document.getElementById('startTime').value;
	var endTime = document.getElementById('endTime').value;
	areaName = encodeURI(areaName);// 1.编码
	areaName = encodeURI(areaName);// 2.编码
	window.location.href = "/oa/performanceInfoSelect/areaChoose.do?areaName="
			+ areaName + "&startData=" + startTime + "&endData=" + endTime;
}
// 删除
function delet(uuid) {
	// 判断是否在删除时限内 checkCreateDate.do
	$.ajax({
		url : "/oa/performanceInfo/checkCreateDate.do", // 要提交的URL路径
		type : "post", // 发送请求的方式
		data : "uuid=" + uuid, // 要发送到服务器的数据
		dataType : "json", // 指定传输的数据格式
		success : function(result) {// 请求成功后要执行的代码
			if (result.msg == 'true') {
				window.location.href = "/oa/performanceInfo/delet.do?uuid="
						+ uuid;
			} else {
				alert("删除失败！未在创建后24小时内删除。");
			}
		}
	});

}
/*
 * 日期比较函数
 */
function CompareDate(d1, d2) {

	return ((new Date(d1.replace(/-/g, "\/"))) > (new Date(d2.replace(/-/g,
			"\/"))));

}

function search(roleName) {
	// console.log("search()");
	var startTime = document.getElementById('startTime').value;
	var endTime = document.getElementById('endTime').value;
	var eName ="";
	if(roleName=='管理员'||roleName=='技术服务中心员工'||roleName=='技术服务中心主任'||roleName=='分公司经理'){
		eName = document.getElementById('ename').value;	
		if(eName.length ==0){
			//alert("null");
		}
		else {
			//alert("not null:"+eName);
			eName = encodeURI(eName);// 1.编码
			eName = encodeURI(eName);// 2.编码
		}
	}
	// 如果起始时间>结束时间
	if (CompareDate(startTime, endTime)) {
		alert("错误！起始时间大于结束时间，请重新选择时间。");
	} else {
		//alert(eName);
		window.location.href = "/oa/performanceInfoSelect/search.do?startData="
				+ startTime + "&endData=" + endTime + "&eName=" + eName;
	}
}
function changeInputType(str) {
	document.getElementById(str).type = "date";
}