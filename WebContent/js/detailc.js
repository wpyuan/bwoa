/**
 * 
 */

function showXHDetail() {
		var content = "<br><br><br><div class=\"alert alert-warning\" role=\"alert\">明细</div>"+
						//表格开始
						"<div class=\"table\">"+
							//表格操作
							"<div class=\"table-operate ue-clear\"><a href=\"javascript:;\" class=\"add\">导出excel</a></div>"+
							//表格具体内容	
							"<div class=\"table-box\">" +	
							"<table border=\"1px\" cellpadding=\"0\" cellspacing=\"0\"><thead><tr><th class=\"name\" rowspan=\"2\">地区</th>" +
										"<th class=\"name\" rowspan=\"2\">员工</th>" +
										"<th class=\"num\" colspan=\"2\">小规模</th>" +
										"<th class=\"process\" colspan=\"2\">一般纳税人</th><th class=\"process\" rowspan=\"2\">合计</th></tr>" +
										"<tr>"+
										"<th>主盘</th>"+
										"<th>分盘</th>" +
										"<th>主盘</th>"+
										"<th>分盘</th>" +
										"</tr>" +
										"</thead><tbody>"+
											"<tr>"+
											"<td>暂无数</td>"+
											"<td>暂无数据</td>" +
											"<td>暂无数据</td>" +
											"<td>暂无数据</td>" +
											"<td>暂无数据</td>" +
											"<td>暂无数据</td>" +
											"<td>暂无数据</td>" +
											"</tr>" +
											"</tbody></table></div></div>";
		//表格结束
		document.getElementById('detail').innerHTML = content;
		document.getElementById('detail').style.display="";
		

	} 
function showOldDetail() {
	var content = "<br><br><br><div class=\"alert alert-warning\" role=\"alert\">明细</div>"+
	//表格开始
	"<div class=\"table\">"+
		//表格操作
		"<div class=\"table-operate ue-clear\"><a href=\"javascript:;\" class=\"add\">导出excel</a></div>"+
		//表格具体内容	
		"<div class=\"table-box\">" +	
		"<table border=\"1px\" cellpadding=\"0\" cellspacing=\"0\"><thead><tr><th class=\"name\" rowspan=\"2\">地区</th>" +
					"<th class=\"name\" >员工</th>" +
					"<th class=\"num\" >主盘</th>" +
					"<th class=\"process\" >分盘</th><th class=\"process\" >合计</th></tr>" +
					"</thead><tbody>"+
						"<tr>"+
						"<td>暂无数</td>"+
						"<td>暂无数据</td>" +
						"<td>暂无数据</td>" +
						"<td>暂无数据</td>" +
						"<td>暂无数据</td>" +
						"</tr>" +
						"</tbody></table></div></div>";
//表格结束
document.getElementById('detail').innerHTML = content;
document.getElementById('detail').style.display="";

} 
function showEqmDetail() {
	var content = "<br><br><br><div class=\"alert alert-warning\" role=\"alert\">明细</div>"+
	//表格开始
	"<div class=\"table\">"+
		//表格操作
		"<div class=\"table-operate ue-clear\"><a href=\"javascript:;\" class=\"add\">导出excel</a></div>"+
		//表格具体内容	
		"<div class=\"table-box\">" +	
		"<table border=\"1px\" cellpadding=\"0\" cellspacing=\"0\"><thead><tr><th class=\"name\" rowspan=\"2\">地区</th>" +
					"<th class=\"name\" >员工</th>" +
					"<th class=\"num\" >A</th>" +
					"<th class=\"process\" >B</th><th class=\"process\" >合计</th></tr>" +
					"</thead><tbody>"+
						"<tr>"+
						"<td>暂无数</td>"+
						"<td>暂无数据</td>" +
						"<td>暂无数据</td>" +
						"<td>暂无数据</td>" +
						"<td>暂无数据</td>" +
						"</tr>" +
						"</tbody></table></div></div>";
//表格结束
document.getElementById('detail').innerHTML = content;
document.getElementById('detail').style.display="";
}