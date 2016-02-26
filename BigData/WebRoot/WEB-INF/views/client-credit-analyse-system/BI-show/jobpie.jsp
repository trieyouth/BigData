<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>行业逾期分析</title>
<script src="<c:url value="/js/echarts.js"/>"></script>
<script src="<c:url value="/js/jquery.min.js"/>"></script>
</head>
<body style="background-color:#4B5C88">
	<div id="main" style="height:400px;border:1px solid blue"></div>
	<div id="main2" style="height:400px;border:1px solid blue"></div>
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
			echarts : './js/dist',
		}
	});
	var myChart = null;
	var mychart2 = null;
	require([ 'echarts', 'echarts/chart/funnel', // 按需加载所需图表，如需动态类型切换功能，别忘了同时加载相应图表
	'echarts/chart/bar', 'echarts/chart/pie', 'echarts/chart/line' ],

	function(ec) {
		myChart = ec.init(document.getElementById('main'));
		myChart2 = ec.init(document.getElementById('main2'));
		
		var ecConfig = require('echarts/config');
		
		myChart.on(ecConfig.EVENT.CLICK, function(param) {
			var name = param.name;
			myChart2.showLoading({
					text : "图表数据正在努力加载..."
				});
			$.get("jobPieServerlet?pie=ty&type="+encodeURI(name)+"&nocache="+ new Date().getTime(),
				function(data) {
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
					
					option2.series[0].data = data1;
					option2.series[1].data = data2;
					option2.series[2].data = data3;
					option2.series[3].data = data4;
					option2.series[4].data = data5;
					
					 myChart2.hideLoading();
			      option2.title.text = name + '行业收入情况';
			      myChart2.setOption(option2);
				});
		
			
			
		});

		option = {
			title : {
				text : '行业--逾期率',
				x : 'center'
			},
			tooltip : {
				trigger : 'item',
				formatter : "{a} <br/>{b} : {c} ({d}%)"
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
						type : [ 'pie', 'funnel' ]
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
			legend : {
				orient : 'vertical',
				x : 'left',
				data : [ '房地产、建筑', '服务业', '广告、媒体', '会计、金融、银行、保险',
						'计算机、互联网、通信、电子', '贸易、消费、制造、营运', '能源、原材料' ]
			},
			calculable : true,
			series : [ {
				name : '访问来源',
				type : 'pie',
				radius : '55%',
				center : [ '50%', 225 ],

			} ]
		};

		$.ajax({
		
			type : "post",
			url : "jobPieServerlet",
			data : {pie:"pie"},
			dataType : "json", //返回数据形式为json
			beforeSend : function() {

				myChart.showLoading({
					text : "图表数据正在努力加载..."
				});
			},

			success : function(result) {
				if (result) {
					option.series[0].data = result;

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


		option2 = {
			title : {
				text : '',
				link : 'http://hongyan.cqupt.edu.cn/',
				//副标题文本，'\n'指定换行  
				subtext : 'http://www.cqupt.edu.cn/cqupt/index.shtml',
				//副标题文本超链接  
				sublink : 'http://www.cqupt.edu.cn/cqupt/index.shtml',
				x : 'left'
			},

			tooltip : {
				trigger : 'axis',
				axisPointer : {
					type : 'shadow'
				}
			},
			legend : {
				data : [ '小于36000元', '36000-72000', '72000-96000', '96000-120000','大于120000']
			},
			toolbox : {
				show : true,
				orient : 'vertical',
				y : 'center',
				feature : {
					mark : {
						show : true
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
				type : 'category',
				data : [ '2013年', '2014年', '2015年' ]
			} ],
			yAxis : [ {
				type : 'value',
				splitArea : {
					show : true
				}
			} ],
			grid : {
				x2 : 40
			},
			series : [ {
				name : '小于36000元',
				type : 'bar',
				stack : '总量',
				
				markPoint : {
					data : [ {
						type : 'max',
						name : '最大值'
					}, {
						type : 'min',
						name : '最小值'
					} ]
				},
				markLine : {
					data : [ {
						type : 'average',
						name : '平均值'
					} ]
				}

			}, {
				name : '36000-72000',
				type : 'bar',
				stack : '总量',
				
				markPoint : {
					data : [ {
						type : 'max',
						name : '最大值'
					}, {
						type : 'min',
						name : '最小值'
					} ]
				},
				markLine : {
					data : [ {
						type : 'average',
						name : '平均值'
					} ]
				}
			}, {
				name : '72000-96000',
				type : 'bar',
				stack : '总量',
				
				markPoint : {
					data : [ {
						type : 'max',
						name : '最大值'
					}, {
						type : 'min',
						name : '最小值'
					} ]
				},
				markLine : {
					data : [ {
						type : 'average',
						name : '平均值'
					} ]
				}
			}, {
				name : '96000-120000',
				type : 'bar',
				stack : '总量',
				
				markPoint : {
					data : [ {
						type : 'max',
						name : '最大值'
					}, {
						type : 'min',
						name : '最小值'
					} ]
				},
				markLine : {
					data : [ {
						type : 'average',
						name : '平均值'
					} ]
				}
			}, {
				name : '大于120000',
				type : 'bar',
				stack : '总量',
				
				markPoint : {
					data : [ {
						type : 'max',
						name : '最大值'
					}, {
						type : 'min',
						name : '最小值'
					} ]
				},
				markLine : {
					data : [ {
						type : 'average',
						name : '平均值'
					} ]
				}
			} ]
		};

	});
	function openImage() {
		var data = myChart.getDataURL("png");
		$("#img").val(data);
		$("#exportForm").submit();
	}
</script>
</html>