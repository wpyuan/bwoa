/**
 * @作者 王培源
 * @创建时间 2017/11/21
 */

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
	document.getElementById('WZZ').value = ZXS*1-YZZ*1;
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
	document.getElementById('WZZ').value = sumSellMoney - document.getElementById('YZZ').value;
	
}
/**
 * @作者 王培源
 * @创建时间 2017/11/20
 */
/*
 * 张恭雨 获取指定form中的所有的<input>对象
 */
   
function getElements(formId) {    
    var form = document.getElementById(formId);    
    var elements = new Array();    
    var tagElements = form.getElementsByTagName('input');    
    for (var j = 0; j < tagElements.length; j++){  
         elements.push(tagElements[j]);  
  
    }  
    return elements;    
}   
/*
 * 张恭雨 获取单个input中的【name,value】数组
 */ 

function inputSelector(element) {    
  if (element.checked)    
     return [element.name, element.value];    
}    
      
function input(element) {    
    switch (element.type.toLowerCase()) {    
      case 'submit':    
      case 'hidden':    
      case 'password':    
      case 'text': 
        return [element.name, element.value];    
      case 'checkbox':    
      case 'radio':    
        return inputSelector(element);    
    }    
    return false;    
}    
/*
 * 张恭雨 获取单个input中的【name,value】数组 组合URL
 */   

function serializeElement(element) {    
    var method = element.tagName.toLowerCase();    
    var parameter = input(element);    
    
    if (parameter) {    
      var key = encodeURIComponent(parameter[0]);    
      if (key.length == 0) return;    
    
      if (parameter[1].constructor != Array)    
        parameter[1] = [parameter[1]];    
          
      var values = parameter[1];    
      var results = [];    
      for (var i=0; i<values.length; i++) {    
        results.push(key + '=' + encodeURIComponent(values[i]));    
      }    
      return results.join('&');    
    }    
 }    
  
// 调用方法
function serializeForm(formId) {    
    var elements = getElements(formId);    
    var queryComponents = new Array();    
    
    for (var i = 0; i < elements.length; i++) {    
      var queryComponent = serializeElement(elements[i]);    
      if (queryComponent)    
        queryComponents.push(queryComponent);    
    }    
    
    return queryComponents.join('&');  
}
/**
 * 总销售金额计算zssjejs
 */
function zssjejs() {
	var length = document.getElementById('emqListSize').value;// wpy2017/11/22
	countAllSellMoney(length);// 计算总金额 //wpy2017/11/22
}

/*
 * 保存盘录入信息
 */
function update(uuid) {
	//alert(uuid);
	var flag = add();//先添加
	if(flag){
		window.location.href = "/oa/performanceInfo/delet.do?uuid="+uuid;//后删除
		
	}
}
function add(){
	var tab1DataTime = document.getElementById('DT').value;
	var tab2DataTime = document.getElementById('dataTime').value;
	var tab3DataTime = document.getElementById('tab3DataTime').value;
	var createDate = document.getElementById('addTime').value;
	var ZXS = document.getElementById('ZXS').value;
	var YZZ = document.getElementById('YZZ').value;
	var YCGHNum = document.getElementById('sycs').value;//有偿更换数量
	var YCGHMoney = document.getElementById('sycm').value;//有偿更换金额
	if( ZXS*1==0 ){
		alert("修改失败！未填写任何数据。");
		return false;
	}else if(YZZ==null||YZZ==""){
		alert("修改失败！未填写已转账数据。");
		return false;
	}
	//alert(YCGHNum*1+";"+YCGHMoney*1);
	if( YCGHNum*1!=0 && YCGHMoney*1==0 ){
		alert("修改失败！未填写有偿更换金额数据。");
		return false;
	}
	
	if(tab1DataTime==tab2DataTime&&tab2DataTime==tab3DataTime){
		
		// 获取表单提交的值
		var params=serializeForm('addform');
		// 获取数据日期
		var DT=document.getElementById("DT");
		var length = document.getElementById("emqListSize").value;
		
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
			url : "/oa/performanceInfo/alter.do?"+params+"&DT="+DT.value,   // 要提交的URL路径
			type : "post",      // 发送请求的方式
			data :	{		
				"ZXS":ZXS,
				"YZZ":YZZ,
				"createDate":createDate,
				"dataTime" : dataTime,
				"num" : num
				},			// 要发送到服务器的数据
			dataType : "json", // 指定传输的数据格式
			success : function(result) {// 请求成功后要执行的代码
				 alert(result.msg);
			}
		});
	}else{
		alert("三个表的数据日期不一致，请修改一致再行提交！");
	}
	return true;
}

/*
 * 计算金额
 */

function calculationMoney(firstObj,secondObj,type){
	
	/*
	 * 异步加载获取该类型的价格信息
	 */
	$.ajax({
		url : "/oa/performanceInfo/getPrice.do?type="+type,   // 要提交的URL路径
		type : "post",      // 发送请求的方式
		data :	{},			// 要发送到服务器的数据
		success : function(data) {// 请求成功后要执行的代码
			
			secondObj.value=data*firstObj.value;
			
			if(type.charAt(0)=="S"){							
				calculateTax();	
				return
			}
			
			
			
			if(type.charAt(0)=="F"){
				calculateService();
				return;
			}
			
			
			if(type.charAt(0)=="B"){				
				calculateEscalation();
				return;
			}
			
		}
	});	
}

/*
 * 计算盘的数量和金额
 */
function calculateTax(){
	var num1=document.getElementById("sxzs").value;
	var price1=document.getElementById("Msxzs").value;
	
	var num2=document.getElementById("sxfs").value;
	var price2=document.getElementById("Msxfs").value;
	
	var num3=document.getElementById("syzs").value;
	var price3=document.getElementById("Msyzs").value;
	
	var num4=document.getElementById("syfs").value;
	var price4=document.getElementById("Msyfs").value;
	
	var taxNum=document.getElementById("taxNum");
	var taxPrice=document.getElementById("taxPrice");
	
	taxNum.value=num1*1+num2*1+num3*1+num4*1;
	taxPrice.value=price1*1+price2*1+price3*1+price4*1;	
	
}

/*
 * 计算服务费的数量和金额
 */
function calculateService(){
	var num1=document.getElementById("fzs").value;
	var price1=document.getElementById("Mfzs").value;
	
	var num2=document.getElementById("ffs").value;
	var price2=document.getElementById("Mffs").value;
	
	var serviceNum=document.getElementById("serviceNum");
	var servicePrice=document.getElementById("servicePrice");
	
	serviceNum.value=num1*1+num2*1;
	servicePrice.value=price1*1+price2*1;	
	
}

/*
 * 计算报税盘合计
 */
function calculateEscalation(){
	var price=document.getElementById("Mbsps").value;
	
	var bspsTotal=document.getElementById("bspsTotal");
	bspsTotal.value=price;
	
	
}

/*
 * 计算更换总计
 */

function calculateReplace(firstObj,secondObj,threeObj){
	var num1=document.getElementById("sfcs").value;
	var num2=document.getElementById("sycs").value;
	//var price=document.getElementById("sycm").value;
	document.getElementById("sycm").value=num2*200;
	document.getElementById("replacePrice").value=num2*200
	var replaceNum=document.getElementById("replaceNum");
	var replacePrice=document.getElementById("replacePrice");
	
	replaceNum.value=num1*1+num2*1;
	replacePrice.value=price;
		
}

/*
 * 计算总和
 */
function getTotalMoney(){
	var taxMoney=document.getElementById("taxPrice").value;
	var serviceMoney=document.getElementById("servicePrice").value;
	var bspsTotal=document.getElementById("bspsTotal").value;
	var sycm=document.getElementById("sycm").value;
	
	var total;
	total=taxMoney*1+serviceMoney*1+bspsTotal*1+sycm*1;
	
	return total;
}
