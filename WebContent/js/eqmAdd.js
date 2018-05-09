/**
 * @作者 王培源
 * @创建时间 2017/11/21
 */
function save(length,UUID) {
	var num = new Array(length);
	for (var i = 0; i < length; i++) {
		num[i] = document.getElementById("num"+i).value;
	}
	var createDate = document.getElementById('addTime').value;
	var dataTime = document.getElementById('dataTime').value;
	$.ajax({
		async : false,
		cache : false,
		traditional : true,
		url : "/oa/eqmAdd/add.do", // 要提交的URL路径
		type : "post", // 发送请求的方式
		data : {
			"num" : num,
			"createDate" : createDate,
			"dataTime" : dataTime,
			"UUID":UUID
		}, // 要发送到服务器的数据
		dataType : "json", // 指定传输的数据格式
		success : function(result) {// 请求成功后要执行的代码
			alert(result.msg);
		}
	});
}
//输入时计算合计
function countHj(length) {
	var sum = 0;
	for (var i = 0; i < length; i++) {
		sum += new Number(document.getElementById("num"+i).value);
	}
	document.getElementById('eqmhj').value = sum;
}
//输入已转账时计算未转账
function countWZZ() {
	var ZXS = document.getElementById('ZXS').value;
	var YZZ = document.getElementById('YZZ').value;
	
	if(ZXS*1-YZZ*1<0){
		document.getElementById('WZZ').value =0;	
	}else{
		document.getElementById('WZZ').value =ZXS*1-YZZ*1;	
	}
	
}

/**************第二部分：设备(tab2)*************/ 
function tab2TotalMoney(length) {
	//1.取出单价
	var x = document.getElementsByTagName("input");
	var priceList = new Array(length);
	var k=0;
	for (i = 0; i < x.length; i++) {
		if (x[i].type == 'hidden') {
			for (j = 0; j < length; j++) {
				var jj=j.toString()+j.toString();			
				if (x[i].id == jj) {									
					priceList[k]=x[i].name;
					k++;
					break;
				}
			}
		}
	}
	//2.计算金额sumEqmMoney
	var sumEqmMoney=0;
	var num = new Array(length);
	for (var i = 0; i < priceList.length; i++) {
		num[i] = document.getElementById("num"+i).value;//取出数量
		sumEqmMoney += priceList[i]*num[i];
	}
	return sumEqmMoney;
}
// 计算总销售金额
function countAllSellMoney(length) {
	var sumSellMoney = 0;
	/**************第一部分：盘（tab1）*************/
	var sumPanMoney = getTotalMoney();
	/**************第二部分：设备(tab2)*************/ 
	var sumEqmMoney =  tab2TotalMoney(length);
	/**************第三部分：显示总销售收入(tab3)*************/ 
	sumSellMoney = sumPanMoney*1 + sumEqmMoney*1;
	document.getElementById('ZXS').value = sumSellMoney;
	
}