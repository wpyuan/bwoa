
//月查询
function selectMonth(years,month,day){
	//获取年份和月份
	var year=years.innerHTML.substring(0, 4);
	var month=month.innerHTML.substring(0,month.innerHTML.length-1);
	var days=new Array();
	//获取区域
	var areaName=document.getElementById("area").value;
	for(var i=1;i<=day;i++){
		days[i-1]=i;
	}
	
	//验证区域信息
	if(areaName=="请选择区域"){
		alert("请选择区域");
		return;
	}
	
	//编码，解决乱码问题
	areaName=encodeURI(areaName);
	areaName=encodeURI(areaName);
		
	//查询
	$.ajax({
		url:"/oa/performanceInfo/getChartDate.do?year="+year+"&month="+month+"&day="+day+"&areaName="+areaName,
		type:"post",
		dataType:"",
		success : function(result){			
			if(result!=""){
				 var ctx = document.getElementById("myChart").getContext('2d');
					var myChart = new Chart(ctx, {
					    type: 'line',
					    data: {
					        labels: days,
					        datasets: [{
					            label: '售盘数',
					            data: result,		           
					            borderColor: [
					                'rgba(255,99,132,1)',
					                'rgba(54, 162, 235, 1)',
					                'rgba(255, 206, 86, 1)',
					                'rgba(75, 192, 192, 1)',
					                'rgba(153, 102, 255, 1)',
					                'rgba(255, 159, 64, 1)'
					            ],
					            borderWidth: 1,
					        }]
					    },
					    options: {		    	
					        scales: {
					            yAxes: [{
					                ticks: {
					                    max: 150,
					                    mix: 0,
					                    stepSize: 10					                    
					                }
					            }]
					        }
					    }
					    
					});
					
			//设置时间
			document.getElementById("year").innerHTML=year+"年"+month+"月";		
								
			}else{
				alert("查询失败！");
			}
			
		},
		
	});
}


       
/*
 * 区域选择
 */		
		var falg = true;   
		function showArea(){
				var area=document.getElementById("area");
				$.ajax({
					url:"performanceInfo/getAreaData.do",
					type:"post",
					data:{},			
					dataType:"json",
					success: function(data){
						//判断是否为第一次执行
						if(falg==true){
							//将数据转换成json格式										
							var child=eval(data);				
							for(var i=0;i<child.length;i++){
							//动态的创建节点				
							var areaName=document.createElement("option");				
							//设置节点的value属性				
							areaName.innerHTML=child[i].name;				
							//添加子节点
							area.appendChild(areaName);
							//设置全局变量为
							falg=false;	
						}
																	
					}
				}
				
			});
		}