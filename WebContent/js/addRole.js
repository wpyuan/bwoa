/**
 * @作者 王培源
 * @描述 addRole.jsp的js
 * @创建时间 2017/11/3
 */
		function addRoleName() {
			var roleName = document.getElementById("addRoleName").value;
			roleName=encodeURI(roleName);//1.编码
			roleName=encodeURI(roleName);//2.编码
			if(roleName==null||roleName==""){
				document.getElementById('msg').style.color = 'red';	
				document.getElementsByTagName('input')[0].style.border = '2px solid red';
				document.getElementById('msg').innerHTML = "角色名不能为空";
			}
			//alert(roleName);
			else{
					$.ajax({
					url : "/oa/addRole.do", //要提交的URL路径
					type : "post", //发送请求的方式
					data : "name=" + roleName, //要发送到服务器的数据
					dataType : "json", //指定传输的数据格式
					success : function(result) {//请求成功后要执行的代码	
						//alert(result.msg);
						var roleListContext="";
						roleListContext = "<br>";
						
						for (var i = 0; i < result.roleList.length; i++) {
							roleListContext += "<p style='font-size: 12px'>● "+result.roleList[i].name+"</p><br>";
						}
						roleListContext += "<p id='newAddRoleName'></p><br>";						
						document.getElementById('roleList').innerHTML = roleListContext;		
						if(result.msg=="添加失败，已有角色"){
							document.getElementById('msg').style.color = 'red';	
							document.getElementsByTagName('input')[0].style.border = '2px solid red';
						}else{
							document.getElementsByTagName('input')[0].style.border = '1px solid #c5c5c5';
							document.getElementById('msg').style.color = 'blue';
						}
						document.getElementById('msg').innerHTML = result.msg;
					}
				});
			}
		}
		function reset() {
			document.getElementById('addRoleName').value = "";
		}