
/*
*添加年服务费应收信息
*/

function save(area,year,number){
	//获取tab格式化信息
	var str=getVal();
	//获取年份
	var year=document.getElementById("year").value;
	/*
	 * 保存信息
	 */	
	$.ajax({
		url:"/oa/fuwu/save.do",
		type:"post", 
		data:{"str":str,"year":year},
		dataType:"",
		success : function(data){
			if(data=="success"){
				alert("保存成功！");
			}else if(data=="exist"){
				alert("添加记录中有已经存在信息！");			
			}else if(data=="fail"){
				alert("保存失败！");
			}
		},
		
	}); 
	
}
/*
 * 删除记录
 */
function shanchu(asccId){
	//提示用户是否删除
	if(confirm("确定删除！")){
		/*
		 * 保存信息
		 */	
		$.ajax({
			url:"/oa/fuwu/delete.do",
			type:"post", 
			data:{"asccId":asccId},
			dataType:"",
			success : function(data){
				if(data=="success"){
					alert("删除成功！");
					window.location.href="/oa/fuwu/manage.do";
				}else{
					alert("删除失败！");
				}
			},
			
		}); 
	}
}
/*
 * 获取tab中填入的值，格式化
 */
function getVal(){
	var str="";
	//获取tab
	var tab=document.getElementById("msg");
	//获tab内的全部input
	var textinputs = tab.getElementsByTagName('input');
	//遍历
	for(var i = 0; i < textinputs.length; i++) {
		//获取input的值
		if(textinputs[i].name!="areaName"){
			if(textinputs[i].value!="")
				str+=textinputs[i].value+":";
			else
				str+="zero:";
		}
	}
	return str;
}