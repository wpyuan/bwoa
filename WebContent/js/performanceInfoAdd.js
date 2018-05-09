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
function submit(UUID) {
	// 获取表单提交的值
	var params=serializeForm('addform');
	// 获取数据日期
	var DT=document.getElementById("DT");
	var length = document.getElementById("emqListSize").value;
	// alert(params);
	$.ajax({
		url : "/oa/performanceInfo/addTanInfo.do?"+params+"&DT="+DT.value,   // 要提交的URL路径
		type : "post",      // 发送请求的方式
		data :	{"UUID":UUID},			// 要发送到服务器的数据
		dataType : "json", // 指定传输的数据格式
		success : function(result) {// 请求成功后要执行的代码
			// alert(result.msg);
			// 保存设备录入信息
			save(length,UUID);
		}
	});		
} 
function add(){
	// 0.是否为空，为空提示录入失败
	var ZXS = document.getElementById('ZXS').value;
	var YZZ = document.getElementById('YZZ').value;
	var createDate = document.getElementById('addTime').value;
	var YCGHNum = document.getElementById('sycs').value;//有偿更换数量
	var YCGHMoney = document.getElementById('sycm').value;//有偿更换金额
	
	if( ZXS*1==0 ){
		alert("录入失败！未填写任何数据。");
		return;
	}else if(YZZ==null||YZZ==""){
		alert("录入失败！未填写已转账数据。");
		return;
	}
	if( YCGHNum*1!=0 && YCGHMoney*1==0 ){
		alert("录入失败！未填写有偿更换金额数据。");
		return;
	}
	// 1.执行录入
	var tab1DataTime = document.getElementById('DT').value;
	var tab2DataTime = document.getElementById('dataTime').value;
	var tab3DataTime = document.getElementById('tab3DataTime').value;
	if(tab1DataTime==tab2DataTime&&tab2DataTime==tab3DataTime){
		
		// 1.1.判读是否是今天第一次录入 是继续，否 return
		
		$.ajax({
			url : "/oa/performanceInfo/check.do",   // 要提交的URL路径
			type : "post",      // 发送请求的方式
			data :	{"dataDate":tab1DataTime},			// 要发送到服务器的数据
			dataType : "json", // 指定传输的数据格式
			success : function(result) {// 请求成功后要执行的代码
				if(result.flag=="error"){
					alert("录入失败！今天已录入。若要继续录入，请查看修改当天记录。");
					
				}else{
					//1.2.执行录入
					$.ajax({
						url : "/oa/performanceInfo/addCollectMoney.do",   // 要提交的URL路径
						type : "post",      // 发送请求的方式
						data :	{"ZXS":ZXS,"YZZ":YZZ,"createDate":createDate},			// 要发送到服务器的数据
						dataType : "json", // 指定传输的数据格式
						success : function(result) {// 请求成功后要执行的代码
							// alert(result.msg);
							submit(result.UUID);// tab1/tab2录入
						}
					});
				}
			}
		});
	}else{
		alert("三个表的数据日期不一致，请修改一致再行提交！");
	}
	
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
	//var price=document.getElementById("sycm").value; 2017-12-5改 自动计算有偿更换 金额
	document.getElementById("sycm").value=num2*200;
	//设置更换总金额
	document.getElementById("replacePrice").value=num2*200
	//设置更换数量
	var replaceNum=document.getElementById("replaceNum");
	replaceNum.value=num1*1+num2*1;
	
		
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
// 三个日期同步
function dateEqually(id) {
	var date = document.getElementById(id).value;
	document.getElementById('DT').value = date;
	document.getElementById('dataTime').value = date;
	document.getElementById('tab3DataTime').value = date;
}