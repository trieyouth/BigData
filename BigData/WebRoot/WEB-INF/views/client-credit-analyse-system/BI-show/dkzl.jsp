<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>贷款总量统计</title>
<script src="<c:url value="/js/echarts.js"/>"></script>
<script src="<c:url value="/js/esl.js"/>" language="javascript" charset="utf-8"></script>
<script src="<c:url value="/js/jquery-1.6.2.js"/>"></script>
<link rel="stylesheet" href="<c:url value='/css/bootstrap.css' />">
</head>
<body style="background-color:#4B5C88">

	<div
		style="font-family:Arial, Helvetica, sans-serif; text-align:center">
		<b><font id="tmye" size="7">贷款总量统计</font>
		</b>

		<hr color="#0033CC" width="1024px" />
		<div id="H"></div>
		<hr color="#0033CC" width="1024px" />

		<div id="main" style="height:600px;border:1px solid blue"></div>
		<div style="margin-top:20px;">
		</div>
		<form id="exportForm" action="createServlet" method="post">
			<input type="hidden" name="img" id="img" />
		</form>
</body>
<script type="text/javascript">
	
 
			require.config({
			paths : {
				echarts : '/BigData/js/dist',

			}
		});
		var myChart = null;
		require([ 'echarts', 'echarts/chart/line', // 按需加载所需图表，如需动态类型切换功能，别忘了同时加载相应图表
		'echarts/chart/bar', 'echarts/chart/pie'],
         
		function(ec) {
			myChart = ec.init(document.getElementById('main'));
           var ecConfig = require('echarts/config');
		
		  myChart.on(ecConfig.EVENT.CLICK, function(param) {
			var selected = param;
             var year=selected.name.split("-")[0];
               var mon=selected.name.split("-")[1];
			window.open(encodeURI("/BigData/ccas/index/BIShow/dkzl/ty/" + year + "/" + mon));

		});

   
			$.ajax({
		type : "get",
		url : "/BigData/ccas/index/BIShow/dkzl/pie",
		dataType : 'text', //返回数据形式为json
		beforeSend : function() {
			myChart.showLoading({
				text : "图表数据正在努力加载..."
			});
		},

		success : function(result) {
			if (result) {
			var ss = result.split(",");
					var data= new Array();
				
					for ( var i = 0; i < ss.length; i++) {
						data.push(ss[i]);
					}
				option.series[0].data =data;
				myChart.setOption(option, true);
			    myChart.hideLoading();
			}
		},
		
		error : function(errorMsg) {
			alert("不好意思，大爷，图表请求数据失败啦!");

		}
	});

			option = {
				title : {
					text : '2013年-2015年贷款总量',
					subtext : '模拟数据',
					//主标题文本超链接  
					link : 'http://hongyan.cqupt.edu.cn/',
					//副标题文本，'\n'指定换行  
					subtext : 'http://www.cqupt.edu.cn/cqupt/index.shtml',
					//副标题文本超链接  
					sublink : 'http://www.cqupt.edu.cn/cqupt/index.shtml',
					x : 'left',
					y : 'top'
				},
				tooltip : {
					trigger : 'axis'
				},
				legend : {
					data : ['贷款总量' ]
				},
				toolbox : {
					show : true,
					feature : {
						mark : {
							show : true
						},
						dataZoom : {
							show : true
						},
						dataView : {
							show : true
						},
						magicType : {
							show : true,
							type : [ 'line', 'bar' ]
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
				dataZoom : {
					show : true,
					realtime : true,
					start : 20,
					end : 80
				},
				xAxis : [ {
					type : 'category',
					boundaryGap : false,
					data : function() {
						var list = [];
						for ( var i = 2013; i <= 2015; i++) {
							for ( var j = 1; j <= 12; j++) {
							if(j<10){
								list.push(i + '-' +'0'+ j);
								}else{
								list.push(i + '-'+ j);
								}
							}
						}
						return list;
					}()
				} ],
				yAxis : [ {
					type : 'value',
					position : 'right',
					axisLabel : {

                 formatter: '{value}￥'

                      },
					min:32000000000, 

                   max:33000000000 
				} ],
				series : [ {
					name : '贷款总量',
					type : 'line',
					
				} ]
			};
			//myChart.setOption(option);
		});

	function openImage() {
		var data = myChart.getDataURL("png");
		$("#img").val(data);
		$("#exportForm").submit();
	}
</script>
</html>