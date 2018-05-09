/**
 * 
 */
		var dIdDT=0;
		//添加部门窗口状态（打开/关闭）
		function msgBox(n) {
			//alert("add");
			//方式1：
			/*var str = prompt("部门名", "请输入部门名");
			if (str) {
				alert("您刚输入的是：" + str)
			}*/
			//方式2：
			document.getElementById('inputbox').style.display = n ? 'block'
					: 'none'; /* 点击按钮打开/关闭 对话框 */
		}
		//添加
		function add() {
			var departmentName = document.getElementById('departmentName').value;
			departmentName=encodeURI(departmentName);//1.编码
			departmentName=encodeURI(departmentName);//2.编码
			$.ajax({
						url : "/oa/department/add.do", //要提交的URL路径
						type : "post", //发送请求的方式
						data : "name=" + departmentName, //要发送到服务器的数据
						dataType : "json", //指定传输的数据格式
						success : function(result) {//请求成功后要执行的代码						
							if (result.msg == "部门添加成功！") {
								dIdDT=result.dId;
								var newOperationButtonStr = "";
								//alert(result.msg);
								msgBox(0);//添加成功，关闭窗口
								document.getElementById('newDepartmentName').innerHTML = result.newDepartmentName;
								//document.getElementById('newStatus').innerHTML = "有效";
								newOperationButtonStr = "<a href=\"javascript:edit(-1,\'"
										+ departmentName
										+ "\');\">编辑</a>"
										+ "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href=\"javascript:delet(-1);\">删除</a>";
								
								document.getElementById('newOperationButton').innerHTML = newOperationButtonStr;

							} else if (result.msg == "部门已存在但失效，是否将其设置为有效？") {

								var flag = confirm("部门已存在但失效，是否将其设置为有效？"); //在页面上弹出确认选择对话框
								if (flag) {
									//alert(result.dId);
									update(result.dId, departmentName, 1);//修改状态为有效
									msgBox(0);//设置成功，关闭窗口
								} else {
									//alert("0");
								}

							} else {
								//添加失败
								document.getElementById('msg').innerHTML = result.msg;
							}
						}
					});
		}
		//修改状态为有效
		function update(dId, name, status) {
			name=encodeURI(name);//1.编码
			name=encodeURI(name);//2.编码
			window.location.href = "/oa/department/setStatus.do?departmentId=" + dId + "&name="
					+ name + "&status=" + status;
		}
		//查询
		function query() {
			var name = document.getElementById('queryName').value;
			name=encodeURI(name);//1.编码
			name=encodeURI(name);//2.编码
			window.location.href = "/oa/department/query.do?name=" + name;
		}
		//编辑
		function edit(dId, name) {
			//alert(dId+","+name);
			var editTb = "<input type=\"hidden\" id=\"dNameHidden"+dId+"\" value=\""+name+"\"/>"
					+ "<input type=\"text\" id=\"dName\" style=\"height:23px\" value=\""+name+"\"/>"
					+ "&nbsp;&nbsp;&nbsp;&nbsp;<a href=\"javascript:updateName("
					+ dId
					+ ");\" >修改</a>&nbsp;&nbsp;&nbsp;&nbsp;"
					+ "<a href=\"javascript:reset(" + dId + ");\" >撤销</a>";
			if (dId == -1) {
				document.getElementById('newDepartmentName').innerHTML = editTb;
			} else {
				document.getElementById(dId).innerHTML = editTb;
			}

		}
		//修改部门名
		function updateName(dId) {
			var name = document.getElementById('dName').value;
			name=encodeURI(name);//1.编码
			name=encodeURI(name);//2.编码
			var status = 1;
			window.location.href = "/oa/department/update.do?departmentId=" + dId + "&name="
					+ name + "&status=" + status;
		}
		//撤销
		function reset(dId) {
			var name = document.getElementById('dNameHidden'+dId).value;
			//alert("reset->dId:"+dId+";name:"+name);
			if (dId == -1) {
				document.getElementById('newDepartmentName').innerHTML = name;
			} else {
				document.getElementById(dId).innerHTML = name;
			}
		}
		//删除
		function delet(dId) {
			//alert(dId);	
			if(dId==-1){
				window.location.href = "/oa/department/delet.do?departmentId=" + dIdDT;	
			}else{
				window.location.href = "/oa/department/delet.do?departmentId=" + dId;
			}
		}