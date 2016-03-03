<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>饼状图</title>

</head>
<script src="<c:url value="/js/echarts.js"/>"></script>
<script src="<c:url value="/js/esl.js"/>" language="javascript" charset="utf-8"></script>
<script src="<c:url value="/js/jquery-1.6.2.js"/>"></script>
<link rel="stylesheet" href="<c:url value='/css/bootstrap.css' />">
<script type="text/javascript">
//配置路径
require.config({
		paths : {
			echarts : '/BigData/js/dist',

		}
	});

	var myChart = null;
	require([ 'echarts', 'echarts/chart/line', // 按需加载所需图表，如需动态类型切换功能，别忘了同时加载相应图表
	'echarts/chart/bar', 'echarts/chart/pie', 'echarts/chart/funnel' ],

	function(ec) {
		myChart = ec.init(document.getElementById('main'));
				
     $.ajax({
			type : "post",
			url : "xlpieServerlet",
			data : {},
			dataType : 'json', //返回数据形式为json
			beforeSend : function() {
				myChart.showLoading({
					text : "图表数据正在努力加载..."
				});
			},

			success : function(result) {
				if (result) {
				   var msg=new Array();
			       var ser=eval(result);
						     
						 $.each(ser,function(i){
						    msg[i]=ser[i].value;
						 }) ;
				
					option.series[0].data =msg;
					option.series[1].data =msg;
					option.series[2].data =result;
					myChart.hideLoading();
					myChart.setOption(option, true);
				}
			},
			complete : function() {
				myChart.hideLoading();
			},
			error : function(errorMsg) {
				alert("不好意思，大爷，图表请求数据失败啦!");

			}
		});
	
	option = {
	title : {
        text: '学历与坏账',
        subtext: '模拟数据',
        x:'left'
    },
				tooltip : {
					trigger : 'axis',
					x:'left'
				},
				toolbox : {
					show : true,
					y : 'top',
					feature : {
						mark : {
							show : true
						},
						dataView : {
							show : true,
							readOnly : false
						},
						magicType : {
							show : true,
							type : [ 'line', 'bar', 'stack', 'tiled' ]
						},
						restore : {
							show : true
						},
						exportexcel : {
						show : true,//是否显示    
						title : '导出图片到Excel', //鼠标移动上去显示的文字    
						icon : '/BigData/images/ccas/BI/excel.png', //图标    
						option : {},
						onclick : function(option) {//点击事件,这里的option1是chart的option信息    
							openImage();//这里可以加入自己的处理代码，切换不同的图形    
						}
					},
						saveAsImage : {
							show : true
						}
					}
				},
				calculable : true,
				legend : {
					data : [ '高中或中专', '本科', '初中或以下', '大专']
				},
				xAxis : [ {
					type : 'category',
					splitLine : {
						show : false
					},
					data : [ '高中或中专', '本科', '初中或以下', '大专']
				} ],
				yAxis : [ {
					type : 'value',
					position : 'right'
				} ],
				series : [ {
					name : '分布',
					type : 'bar',
					barGap:'20%'
					
				},
				{
					name : '分布',
					type : 'line',
					
				},
				{
					name : '占比',
					type : 'pie',
					tooltip : {
						trigger : 'item',
						formatter : '{a} <br/>{b} : {c} ({d}%)'
					},
					legend: {
        orient : 'vertical',
        x : 'left',
      data : [ '高中或中专', '本科', '初中或以下', '大专']
    },
					center : [ 160, 130 ],
					radius : [ 0, 50 ],
					itemStyle : {
						normal : {
							labelLine : {
								length : 20
							}
						}
					},
				
				} ]
			};

                    
function exportImg(){
	var data = myChart.getDataURL("png");
	$("#img").val(data);
	$("#exportForm").submit();	
}
		
	}
);


</script>
<body  style="background-color:#4B5C88" >
	<form id="exportForm" action="createServlet" method="post">
		<input type="hidden" name="img" id="img" />
	</form>
	<div
		style="font-family:Arial, Helvetica, sans-serif; text-align:center">
		<b><font size="7">学历-逾期</font> </b> <br /> <br />
		<hr color="#0033CC" width="1024px" />
		<br />
		<hr color="#0033CC" width="1024px" />
		<div>
			<div id="main" style="height:600px;border:1px solid blue" />

		</div>
	</div>

</body>
</html>