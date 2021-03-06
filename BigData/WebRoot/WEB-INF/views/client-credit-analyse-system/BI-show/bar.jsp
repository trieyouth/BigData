<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>行业逾期分析</title>
<script src="js/echarts.js"></script>
<script src="js/jquery.min.js"></script>
</head>
<body style="background-color:#4B5C88">
	<div id="main" style="height:400px;border:1px solid blue"></div>
	<div style="margin-top:20px;">
	</div>
	<form id="exportForm" action="createServlet" method="post">
		<input type="hidden" name="img" id="img" />
	</form>
</body>
<script type="text/javascript">
	//配置路径
	require.config({
		paths : {
			echarts : '/js/dist',
		}
	});
	var myChart = null;
	
	require([ 'echarts', 'echarts/chart/funnel', // 按需加载所需图表，如需动态类型切换功能，别忘了同时加载相应图表
	'echarts/chart/bar', 'echarts/chart/pie', 'echarts/chart/line' ],

	function(ec) {
		myChart = ec.init(document.getElementById('main'));
	
			 $.ajax({
			type : "post",
			url : "ftServerlet",
			data : {},
			dataType : 'text', //返回数据形式为json
			beforeSend : function() {
				myChart.showLoading({
					text : "图表数据正在努力加载..."
				});
			},
			success : function(data) {
				if (data) {
				   var ss = data.split(";");
					var data1 = new Array();
					var data2 = new Array();
					var data3 = new Array();
					var data4 = new Array();
					var data5 = new Array();
					
					var a = ss[0].split(",");
					var b = ss[1].split(",");
					var c = ss[2].split(",");
					var d = ss[3].split(",");
					var e = ss[4].split(",");
					
					for ( var i = 0; i < a.length; i++) {
						data1.push(a[i]);
					}
					for ( var i = 0; i < b.length; i++) {
						data2.push(b[i]);
					}
					for ( var i = 0; i < c.length; i++) {
						data3.push(c[i]);
					}
					for ( var i = 0; i < d.length; i++) {
						data4.push(e[i]);
					}
					for ( var i = 0; i < e.length; i++) {
						data5.push(e[i]);
					}
					
					option.series[0].data = data1;
					option.series[1].data = data2;
					option.series[2].data = data3;
					option.series[3].data = data4;
					option.series[4].data = data5;
					 myChart.hideLoading();
			         myChart.setOption(option);
					}
			},
			complete : function() {
				myChart.hideLoading();
			},
			error : function(errorMsg) {
				alert("不好意思，大爷，图表请求数据失败啦!");

			}
		});


		var option = {
		title : {
				text : '投资承载能力',
				x : 'left'
			},
			tooltip : {
				trigger : 'axis',
				axisPointer : { // 坐标轴指示器，坐标轴触发有效
					type : 'shadow' // 默认为直线，可选为：'line' | 'shadow'
				}
			},
			legend : {
				data : [ '30岁以下', '31-40岁', '41-50岁', '51-60岁', '60岁以上' ]
			},
			toolbox : {
				show : true,
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
						icon : 'excel.png', //图标    
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
			xAxis : [ {
				type : 'value'
			} ],
			yAxis : [ {
				type : 'category',
				data : ['10%以下', '10%-30%',  '30-50%', '50%-70%', '70%以上' ]
			} ],
			series : [ {
				name : '30岁以下',
				type : 'bar',
				stack : '总量',
				itemStyle : {
					normal : {
						label : {
							show : true,
							position : 'insideRight'
						}
					}
				},
				//data : [ 320, 302, 301, 334, 390]
			}, {
				name : '31-40岁',
				type : 'bar',
				stack : '总量',
				itemStyle : {
					normal : {
						label : {
							show : true,
							position : 'insideRight'
						}
					}
				},
				//data : [ 120, 132, 101, 134, 90 ]
			}, {
				name : '41-50岁',
				type : 'bar',
				stack : '总量',
				itemStyle : {
					normal : {
						label : {
							show : true,
							position : 'insideRight'
						}
					}
				},
				//data : [ 220, 182, 191, 234, 290 ]
			}, {
				name : '51-60岁',
				type : 'bar',
				stack : '总量',
				itemStyle : {
					normal : {
						label : {
							show : true,
							position : 'insideRight'
						}
					}
				},
				//data : [ 150, 212, 201, 154, 190]
			}, {
				name : '60岁以上',
				type : 'bar',
				stack : '总量',
				itemStyle : {
					normal : {
						label : {
							show : true,
							position : 'insideRight'
						}
					}
				},
				//data : [ 820, 832, 901, 934, 1290]
			} ]
		};

		myChart.setOption(option);

	});
	function openImage() {
		var data = myChart.getDataURL("png");
		$("#img").val(data);
		$("#exportForm").submit();
	}
</script>
</html>