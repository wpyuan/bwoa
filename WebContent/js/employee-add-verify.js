/*
 * 判断是否为空方法
 */
function isNull(obj){
	if(obj.length==0){		
		return true;
	}
	return false;
}
/*
 *判断是否是汉字
 */
function isHanZi(obj){
	var reg=/^[\u0391-\uFFE5]+$/; 
	if(obj!=""&&!reg.test(obj)){
		return false;
	} 
	return true;
}
/*
 * 判断手机号是否合法
 */
function validatemobile(obj){
	var reg=/^(((13[0-9]{1})|(15[0-9]{1})|(18[0-9]{1}))+\d{8})$/;
	if(!reg.test(obj)){
		alert("请输入有效的手机号码");
		return false;
	}
	return true;
}
/*
 * 判断身份证号是否合法
 */
function validatcard(obj){
	// 身份证号码为15位或者18位，15位时全为数字，18位前17位为数字，最后一位是校验位，可能为数字或字符X  
   var reg = /(^\d{15}$)|(^\d{18}$)|(^\d{17}(\d|X|x)$)/;  
   if(reg.test(obj) == false)  
   {  
       alert("身份证输入不合法");  
       return  false;  
   } 
   return true;
}


/*
 * 表单验证
 */
function verify(){
	/*
	 * 验证名字
	 */
	var name=document.getElementById("name");
	if(isNull(name.value)){
		alert("请输入姓名");
		return false
	}
		
			
	if(!isHanZi(name.value)){
		alert("名字只能是中文");
		return false;
	}
		
		
	/*
	 * 验证手机号
	 */
	var phone=document.getElementById("phone");	
	if(!validatemobile(phone.value))
		return false;
	/*
	 * 验证身份证
	 * 
	 */
	var card=document.getElementById("idCard");
	if(!validatcard(card.value))
		return false;
		
	/*
	 * 验证籍贯
	 */
	var nativePlace=document.getElementById("nativePlace");
	if(isNull(nativePlace.value)){
		alert("请输入籍贯");
		return false;
	}
		
			
	if(!isHanZi(nativePlace.value)){
		alert("籍贯只能是中文");
		return false;
	}		
	
	/*
	 * 验证学历
	 */
	var educational=document.getElementById("educational");
	if(isNull(educational.value)){
		alert("请输入学历");
		return false
	}		
			
	if(!isHanZi(educational.value)){
		alert("学历只能是中文")
		return false;
	}
	
	/*
	 *验证地址
	 */
	var address=document.getElementById("addressDetail");
	if(isNull(address.value)){
		alert("详细地址不能为空");
		return false;
	}
	
	/*
	 * 验证邮箱
	 */
	var email=document.getElementById("email");
	if(isNull(email.value)){
		alert("请输入邮箱");
		return false;
	}
	
	/*
	 * 验证职位
	 */
	var lastJob=document.getElementById("lastJob")
	if(isNull(lastJob.value)){
		alert("请填写原职位信息");
		return false;
	}
	if(!isHanZi(lastJob.value)){
		alert("职位信息只能是汉字");
		return false;
	}
	
	var nowJob=document.getElementById("nowJob")
	if(isNull(lastJob.value)){
		alert("请填写职位信息");
		return false;
	}
	if(!isHanZi(lastJob.value)){
		alert("职位信息只能是汉字");
		return false;
	}
	/*
	 * 验证民族
	 */
	var nation=document.getElementById("nation");
	if(isNull(nation.value)){
		alert("请填写民族信息");
		return false;
	}
	if(!isHanZi(nation.value)){
		alert("民族只能是汉字");
		return false;
	}
	
	/*
	 * 验证政治面貌
	 */
	
	var politicsStatus=document.getElementById("politicsStatus");
	if(isNull(nation.value)){
		alert("请填写政治面貌信息");
		return false;
	}
	if(!isHanZi(nation.value)){
		alert("政治面貌只能是汉字");
		return false;
	}	
}	


