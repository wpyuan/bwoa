<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
<link rel="stylesheet" href="css/JFtable.css" />
<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript" src="js/sapar.js"></script>
<script type="text/javascript" src="js/performanceInfoAlter.js"></script>
<title>信息录入</title>
<style type="text/css">
th {
	text-align: center;
}
</style>
</head>
<body>
	<input id="emqListSize" type="hidden" value="${eqmList.size()}"/>
	<div id="saper-container">
		<div id="saper-hd"></div>
		<div id="saper-bd">
			<div class="subfiled clearfix">
				<h2>录入</h2>
			</div>
			<div class="subfiled-content">
				<div class="tab-container" data-trigger="click">
					<div class="tab">
						<a href="javascript:;" class="current">盘录入</a> <a
							href="javascript:;">设备录入</a> <a href="javascript:zssjejs();" ">金额录入</a>

					</div>

					<div class="tab-content">
						<!-- tab1-->
						<div class="tab-content-item">

							<form id="addform">
								<div class="search-box clearfix">
									<div class="kv-item clearfix">
										<label>数据日期：</label>
										<div class="kv-item-content time-select-wrap">
											<div class="time-select">
												<input type="text" name="DT" id="DT" value="${pform.dataDate }"  disabled="disabled">
											</div>
										</div>

									</div>
								</div>


								<!--表格开始-->
								<div class="table">
									<input type="hidden" name="CT" id="CT" value="${pform.addTime}">
									<h4 style="text-align: right;">录入时间：${pform.addTime}</h4>
									<!--表格具体内容-->
									<div class="table-box">
										<table border="1px" cellpadding="0" cellspacing="0">
											<thead>
												<tr>

													<th colspan="10">新盘售盘数量</th>
													<th colspan="6">老户服务费收取</th>
													<th colspan="3" rowspan="3">报税盘</th>

												</tr>
												<tr>
													<th colspan="4">小规模</th>
													<th colspan="4">一般纳税人</th>
													<th rowspan="2" colspan="2">合计</th>

													<th rowspan="2" colspan="2">主盘</th>
													<th rowspan="2" colspan="2">分盘</th>
													<th rowspan="2" colspan="2">合计</th>

												</tr>
												<tr>
													<th colspan="2">主盘</th>
													<th colspan="2">分盘</th>
													<th colspan="2">主盘</th>
													<th colspan="2">分盘</th>
												</tr>
												<tr>
													<th>数量</th>
													<th>金额</th>
													<th>数量</th>
													<th>金额</th>
													<th>数量</th>
													<th>金额</th>
													<th>数量</th>
													<th>金额</th>
													<th>数量</th>
													<th>金额</th>
													<th>数量</th>
													<th>金额</th>
													<th>数量</th>
													<th>金额</th>
													<th>数量</th>
													<th>金额</th>
													<th>数量</th>
													<th>金额</th>
													<th>合计</th>

												</tr>
											</thead>

											<tbody>
												<tr>
													<!-- 税控盘小规模主盘数量 -->
													<td style="height: 30px; width: 50px; padding-left: 0px">
														<!-- 只能输入数字和小数点 --> <input name="SXZS" id="sxzs" value="${pform.XXZS}" disabled="disabled"
														maxlength="7"
														oninput="this.value=this.value.replace(/\D/g,'').replace(/^0+(?=\d)/,'');calculationMoney(sxzs,Msxzs,'SXZS')"
														 type="text" style="width: 100%; border: 0px" />
													</td>
													<td style="height: 30px; width: 50px; padding-left: 0px">
														<!-- 只能输入正整数 --> <input id="Msxzs" disabled="disabled" value="${pform.XXZJ}"	disabled="disabled"			
														 type="text" style="width: 100%; border: 0px" />
													</td>

													<!--税控盘小规模分盘数量 -->
													<td style="height: 30px; width: 50px; padding-left: 0px">
														<!-- 只能输入数字和小数点 --> <input name="SXFS" id="sxfs" value="${pform.XXFS}" disabled="disabled"
														maxlength="7"
														oninput="this.value=this.value.replace(/\D/g,'').replace(/^0+(?=\d)/,'');calculationMoney(sxfs,Msxfs,'SXFS')"
														 type="text" style="width: 100%; border: 0px" />
													</td>
													<td style="height: 30px; width: 50px; padding-left: 0px">
														<!-- 只能输入数字和小数点 --> <input id="Msxfs" disabled="disabled" value="${pform.XXFJ}" disabled="disabled"
														 type="text" style="width: 100%; border: 0px" />
													</td>

													<!-- 税控盘一般主盘数量 -->
													<td style="height: 30px; width: 50px; padding-left: 0px">
														<!-- 只能输入数字和小数点 --> <input name="SYZS" id="syzs"  value="${pform.XYZS}" disabled="disabled"
														maxlength="7"
														oninput="this.value=this.value.replace(/\D/g,'').replace(/^0+(?=\d)/,'');calculationMoney(syzs,Msyzs,'SYZS')"
														 type="text" style="width: 100%; border: 0px" />
													</td>
													<td style="height: 30px; width: 50px; padding-left: 0px">
														<!-- 只能输入数字和小数点 --> <input id="Msyzs" disabled="disabled" value="${pform.XYZJ}" disabled="disabled"
														 type="text" style="width: 100%; border: 0px" />
													</td>

													<!-- 税控盘一般分盘数量 -->
													<td style="height: 30px; width: 50px; padding-left: 0px">
														<!-- 只能输入数字和小数点 --> <input name="SYFS" id="syfs" value="${pform.XYFS}" disabled="disabled"
														maxlength="7"
														oninput="this.value=this.value.replace(/\D/g,'').replace(/^0+(?=\d)/,'');calculationMoney(syfs,Msyfs,'SYFS')"
														 type="text" style="width: 100%; border: 0px" />
													</td>
													<td style="height: 30px; width: 50px; padding-left: 0px">
														<!-- 只能输入数字和小数点 --> <input id="Msyfs" disabled="disabled" value="${pform.XYFJ}" disabled="disabled"
														 type="text" style="width: 100%; border: 0px" />
													</td>
													<td style="height: 30px; width: 50px; padding-left: 0px">
														<!-- 只能输入数字和小数点 --> <input id="taxNum" disabled="disabled" value="${pform.XXZS+pform.XXFS+pform.XYZS+pform.XYFS}" disabled="disabled"
														 type="text" style="width: 100%; border: 0px" />
													</td>
													<td style="height: 30px; width: 50px; padding-left: 0px">
														<!-- 只能输入数字和小数点 --> <input id="taxPrice" value="${pform.XXZJ+pform.XXFJ+pform.XYZJ+pform.XYFJ}" disabled="disabled"
														disabled="disabled"  type="text"
														style="width: 100%; border: 0px" />
													</td>

													<!-- 老户服务费主盘数量 -->
													<td style="height: 30px; width: 50px; padding-left: 0px">
														<!-- 只能输入数字和小数点 --> <input name="FZS" id="fzs" value="${pform.LZS }" disabled="disabled"
														maxlength="7"
														oninput="this.value=this.value.replace(/\D/g,'').replace(/^0+(?=\d)/,'');calculationMoney(fzs,Mfzs,'FZS')"
														 type="text" style="width: 100%; border: 0px" />
													</td>
													<td style="height: 30px; width: 50px; padding-left: 0px">
														<!-- 只能输入数字和小数点 --> <input id="Mfzs" disabled="disabled" value="${pform.LZJ }" disabled="disabled"
														 type="text" style="width: 100%; border: 0px" />
													</td>

													<!-- 老户服务费分盘数量 -->
													<td style="height: 30px; width: 50px; padding-left: 0px">
														<!-- 只能输入数字和小数点 --> <input name="FFS" id="ffs" value="${pform.LFS}" disabled="disabled"
														maxlength="7" 
														oninput="this.value=this.value.replace(/\D/g,'').replace(/^0+(?=\d)/,'');calculationMoney(ffs,Mffs,'FFS')"
														 type="text" style="width: 100%; border: 0px" />
													</td>
													<td style="height: 30px; width: 50px; padding-left: 0px">
														<!-- 只能输入数字和小数点 --> <input id="Mffs" disabled="disabled" value="${pform.LFJ }" disabled="disabled"
														 type="text" style="width: 100%; border: 0px" /> 
													</td>
													<td style="height: 30px; width: 50px; padding-left: 0px">
														<!-- 只能输入数字和小数点 --> <input id="serviceNum" value="${pform.LZS+pform.LFS}" disabled="disabled" 
														disabled="disabled"  type="text"
														style="width: 100%; border: 0px" />
													</td>
													<td style="height: 30px; width: 50px; padding-left: 0px">
														<!-- 只能输入数字和小数点 --> <input id="servicePrice" value="${pform.LZJ+pform.LFJ}" disabled="disabled"
														disabled="disabled"  type="text"
														style="width: 100%; border: 0px" />
													</td>

													<!-- 报税盘数量 -->
													<td style="height: 30px; width: 50px; padding-left: 0px">
														<!-- 只能输入数字和小数点 --> <input name="BSPS" id="bsps" value="${pform.BSPS }" disabled="disabled"
														maxlength="7"
														oninput="this.value=this.value.replace(/\D/g,'').replace(/^0+(?=\d)/,'');calculationMoney(bsps,Mbsps,'BSPS')"
														 type="text" style="width: 100%; border: 0px" />
													</td>
													<td style="height: 30px; width: 50px; padding-left: 0px">
														<!-- 只能输入数字和小数点 --> <input id="Mbsps" disabled="disabled" value="${pform.BSPJ }" disabled="disabled"
														 type="text" style="width: 100%; border: 0px" />
													</td>
													<td style="height: 30px; width: 50px; padding-left: 0px">
														<!-- 只能输入数字和小数点 --> <input id="bspsTotal" value="${pform.BSPJ }" disabled="disabled"
														maxlength="7"
														oninput="this.value=this.value.replace(/\D/g,'').replace(/^0+(?=\d)/,'')"
														 type="text" style="width: 100%; border: 0px" />
													</td>
												</tr>
											</tbody>

										</table>
									</div>
								</div>
								<!--表格结束-->
								<!--表格开始-->
								<div class="table">

									<!--表格具体内容-->
									<div class="table-box">
										<table border="1px" cellpadding="0" cellspacing="0">
											<thead>
												<tr>
													<th rowspan="2">税控盘免费更换</th>
													<th colspan="2">税控盘有偿更换</th>
													<th colspan="2">合计</th>

												</tr>
												<tr>
													<th>数量</th>
													<th>金额</th>
													<th>数量</th>
													<th>金额</th>

												</tr>
											</thead>
											<tbody>
												<tr>
													<!-- 税控盘免费更换数量 -->
													<td style="height: 30px; width: 50px; padding-left: 0px">
														<!-- 只能输入数字和小数点 --> <input name="SFCS" id="sfcs" value="${pform.SKPMFGH }" disabled="disabled"
														maxlength="7"
														oninput="this.value=this.value.replace(/\D/g,'').replace(/^0+(?=\d)/,'');calculateReplace(sfcs,sycs,sycm)"
														 type="text" style="width: 100%; border: 0px" />
													</td>

													<!-- 税控盘有偿更换数量 -->
													<td style="height: 30px; width: 50px; padding-left: 0px">
														<!-- 只能输入数字和小数点 --> <input name="SYCS" id="sycs" value="${pform.SKPYCGHS }" disabled="disabled"
														maxlength="7"
														oninput="this.value=this.value.replace(/\D/g,'').replace(/^0+(?=\d)/,'');calculateReplace(sfcs,sycs,sycm)"
														 type="text" style="width: 100%; border: 0px" />
													</td>

													<!-- 税控盘有偿更换金额 -->
													<td style="height: 30px; width: 50px; padding-left: 0px">
														<!-- 只能输入数字和小数点 --> <input name="SYCM" id="sycm" value="${pform.SKPYCGHJ }" disabled="disabled"
														maxlength="7"
														oninput="this.value=this.value.replace(/\D/g,'').replace(/^0+(?=\d)/,'');calculateReplace(sfcs,sycs,sycm)"
														 type="text" style="width: 100%; border: 0px" />
													</td>
													<td style="height: 30px; width: 50px; padding-left: 0px">
														<!-- 只能输入数字和小数点 --> <input id="replaceNum" value="${pform.SKPMFGH+pform.SKPYCGHS}" disabled="disabled"
														maxlength="7"
														oninput="this.value=this.value.replace(/\D/g,'').replace(/^0+(?=\d)/,'')"
														 type="text" style="width: 100%; border: 0px" />
													</td>
													<td style="height: 30px; width: 50px; padding-left: 0px">
														<!-- 只能输入数字和小数点 --> <input id="replacePrice" value="${pform.SKPYCGHJ }" disabled="disabled"
														maxlength="7"
														oninput="this.value=this.value.replace(/\D/g,'').replace(/^0+(?=\d)/,'')"
														 type="text" style="width: 100%; border: 0px" />
													</td>
												</tr>
											</tbody>

										</table>
									</div>
								</div>							
							</form>
						</div>
						<!-- tab2 -->
						<div class="tab-content-item">

							<div class="search-box clearfix">
								<div class="kv-item clearfix">
									<label>数据日期：</label>
									<div class="kv-item-content time-select-wrap">
										<div class="time-select">
											<input id="dataTime" type="text" value="${pform.dataDate}"  disabled="disabled"/>
										</div>

									</div>
								</div>
							</div>
							<!--表格开始-->
							<div class="table">
								<h4 style="text-align: right;">录入时间：${pform.addTime}</h4>
								<input type="hidden" id="addTime" value="${pform.addTime}" />
								<!--表格具体内容-->
								<div class="table-box">
									<table border="1px" cellpadding="0" cellspacing="0"
										bordercolor="blue">
										<thead>
											<tr>
												<th colspan="12">通用设备销售数量</th>
											</tr>
											<tr>
												<!-- 查询数据库,显示设备型号 -->											
												<c:forEach var="eqm" items="${eqmList}">
													<th>${eqm.name }</th>
												</c:forEach>
												<th>合计</th>
											</tr>

										</thead>

										<tbody>
											<tr>
												<c:forEach var="eqm" items="${eqmList}" varStatus="e">
												<c:forEach var="eqmNum" items="${eqmNumList}" varStatus="en">
												<c:if test="${e.index==en.index }">
													<td style="height: 30px; padding-left: 0px"><input
														id="${e.index}${e.index}" name="${eqm.unitPrice}"
														type="hidden" /> <!-- 只能输入数字 --> <input id="${e.index}"
														maxlength="7" value="${eqmNum}" disabled="disabled"
														oninput="this.value=this.value.replace(/\D/g,'').replace(/^0+(?=\d)/,'');countHj(${eqmList.size()})"
														 type="text" style="width: 100%; border: 0px" />
													</td>
												</c:if>	
												</c:forEach>	
												</c:forEach>
												<td style="height: 30px; padding-left: 0px">
													<!-- 只能输入数字 --> <input id="eqmhj" disabled="disabled"	
													maxlength="7"
													oninput="this.value=this.value.replace(/\D/g,'').replace(/^0+(?=\d)/,'')"
													 type="text" style="width: 100%; border: 0px" />
												</td>

											</tr>
										</tbody>

									</table>
								</div>
							</div>
							<!--表格结束-->						
						</div>

						<!-- tab3 -->
						<div class="tab-content-item">

							<div class="search-box clearfix">
								<div class="kv-item clearfix">
									<label>数据日期：</label>
									<div class="kv-item-content time-select-wrap">
										<div class="time-select">
											<input id="tab3DataTime" type="text" value="${pform.dataDate}" disabled="disabled"/>
										</div>

									</div>
								</div>
							</div>

							<!--表格开始-->
							<div class="table">
								<h4 style="text-align: right;">录入时间：${pform.addTime}</h4>
								<!--表格具体内容-->
								<div class="table-box">
									<table border="1px" cellpadding="0" cellspacing="0"
										bordercolor="blue">
										<thead>
											<tr>
												<th colspan="3">金额</th>
											</tr>
											<tr>
												<th>总销售收入</th>
												<th>已转账</th>
												<th>未转账</th>
											</tr>
										</thead>

										<tbody>
											<tr>
												<td style="height: 30px; padding-left: 0px">
													<!-- 只能输入数字和小数点 --> <input id="ZXS"	 value="${pform.ZXS}" disabled="disabled"	  
													maxlength="7" 									
													 type="text" style="width: 100%; border: 0px" disabled="disabled"/>
												</td>
												<td style="height: 30px; padding-left: 0px">
													<!-- 只能输入数字和小数点 --> <input id="YZZ" value="${pform.YZZ }" disabled="disabled"
													maxlength="7"
													oninput="this.value=this.value.replace(/\D/g,'').replace(/^0+(?=\d)/,'');countWZZ()"
													 type="text" style="width: 100%; border: 0px" />
												</td>
												<td style="height: 30px; padding-left: 0px">
													<!-- 只能输入数字和小数点 --> <input id="WZZ" value="${pform.ZXS*1-pform.YZZ*1}" disabled="disabled"
													maxlength="7"
													oninput="this.value=this.value.replace(/\D/g,'').replace(/^0+(?=\d)/,'')"
													 type="text" style="width: 100%; border: 0px" />
												</td>
											</tr>
										</tbody>
									</table>
								</div>
							</div>
							<!--表格结束-->
							<!-- 
							<div class="subfiled-content">
								<a href="javascript:update('${uuid }');" style="left: 90%"
									class="sapar-btn sapar-btn-recom query-btn">修改</a>
							</div>
							 -->
						</div>

					</div>

				</div>
			</div>
		</div>
		<div id="saper-ft"></div>
	</div>

</body>

</html>