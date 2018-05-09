/*
 * 计算该月天数
 */

function getDay(){	
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