/**
 * @作者 王培源
 * @描述 pwdModify.jsp的js
 * @创建时间 2017/11/3
 */
	function show(){
		var Oldpassword = document.getElementById("Oldpassword").value;
		document.getElementById("p1").innerHTML = "";
		
		//alert("show()"+Oldpassword);
		$.ajax({
			url : "/oa/account/Oldpassword.do",
			type : "get", 
			data : "Oldpassword="+Oldpassword,
			dataType : "json",
			success: function(result){
				document.getElementById("p1").innerHTML = result.msg;
				if(result.msg=="√"){
					document.getElementById("Oldpassword").disabled=true;//输入正确就禁止编辑
					document.getElementById("Newpassword").disabled=false;	//解锁
					document.getElementById("Newpassword2").disabled=false;	//解锁
				}
				else{
					
					if(result.msg==null || result.msg.length<=0){
						map.put("msg", "× 请输入原密码");						
					}else
						map.put("msg", "× 请输入原密码或密码错误");
				}
			}
		});
	}
	
	function show2(){
		var Oldpassword = document.getElementById("Oldpassword").value;
		var Newpassword = document.getElementById("Newpassword").value;
		document.getElementById("p2").innerHTML = "";
		
		if(Oldpassword==Newpassword){
			document.getElementById("p2").innerHTML = "× 不能与原密码相同";			
		}else{
			if(Newpassword!="")
				document.getElementById("p2").innerHTML = "√";	
			else
				document.getElementById("p2").innerHTML = "× 不能为空";
		}
		show3();//2次判断
	}
	function show3(){
		var Newpassword = document.getElementById("Newpassword").value;
		var Newpassword2 = document.getElementById("Newpassword2").value;
		document.getElementById("p3").innerHTML = "";
		if(Newpassword!=Newpassword2){
			if(Newpassword2!="")
				document.getElementById("p3").innerHTML = "× 新密码和确认密码不一致，请确认";

		}else{
			if(Newpassword2!="")
				document.getElementById("p3").innerHTML = "√";
			else if(Newpassword!="")
				document.getElementById("p3").innerHTML = "× 不能为空";
		}
		
	}
	function s(){
		var Oldpassword = document.getElementById("Oldpassword").value;
		var Newpassword = document.getElementById("Newpassword").value;
		var Newpassword2 = document.getElementById("Newpassword2").value;
		$.ajax({
			url : "/oa/account/pwdModify2.do",
			type : "get", 
			data: [ 
			       {"name":"Oldpassword","value":Oldpassword},
			       {"name":"Newpassword","value":Newpassword},
			       {"name":"Newpassword2","value":Newpassword2},
			       ],
			dataType : "json",
			success: function(result){		
				if(result.msg=="√"){
					alert("修改成功！");
					top.location.href='/oa/login.jsp';	
				}
			}
		});
	}