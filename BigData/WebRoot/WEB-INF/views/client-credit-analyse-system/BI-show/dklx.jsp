<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>贷款类型与逾期</title>
</head>
<script type="text/javascript" src="js/esl.js"></script>
<script src="js/echarts.js" type="text/javascript"></script>
<script src="js/highcharts.js" type="text/javascript"></script>
<script src="js/jquery-1.6.2.js"></script>

<script type="text/javascript">
	require.config({
		paths : {
			echarts : './js/dist',

		}
	});

	var myChart = null;
	require([ 'echarts', 'echarts/chart/line', // 按需加载所需图表，如需动态类型切换功能，别忘了同时加载相应图表
	'echarts/chart/bar', 'echarts/chart/pie' ],

	function(ec) {
		myChart = ec.init(document.getElementById('main'));
		var ecConfig = require('echarts/config');
		/* myChart.on(ecConfig.EVENT.CLICK, function(param) {
			var name = param.name;
			var value = param.value;
			var  d=param.selected
			alert(d)
		});  */

		myChart.on(ecConfig.EVENT.CLICK, function(param) {
			var selected = param;

			//alert(selected.dataIndex)
			// alert(selected.seriesIndex)

			var s2 = selected.seriesIndex;
			var s = selected.dataIndex;

			var x = option.xAxis[0].data[s];
			var q = option.legend.data[s2];
			window.open(encodeURI("dklxzq.jsp" + "?year=" + x + "?type=" + q));

		});

		$.ajax({
			type : "post",
			url : "dklxServerlet",
			data : {},
			dataType : 'text', //返回数据形式为json
			beforeSend : function() {
				myChart.showLoading({
					text : "图表数据正在努力加载..."
				});
			},

			success : function(result) {
				if (result) {

					var ss = result.split(":");
					var dataSyz = new Array();
					var dataWy = new Array();
					var dataGx = new Array();
					var dataSy = new Array();
					var a = ss[0].split(",");
					var b = ss[1].split(",");
					var c = ss[2].split(",");
					var d = ss[3].split(",");
					for ( var i = 0; i < a.length; i++) {
						dataSyz.push(a[i]);
					}
					for ( var i = 0; i < b.length; i++) {
						dataWy.push(b[i]);
					}
					for ( var i = 0; i < c.length; i++) {
						dataGx.push(c[i]);
					}
					for ( var i = 0; i < d.length; i++) {
						dataSy.push(d[i]);
					}
              
					option.series[0].data = dataGx;
					option.series[1].data = dataSyz;
					option.series[2].data = dataSy;
					option.series[3].data = dataWy;
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

		var option = {
			title : {
				//主标题文本，'\n'指定换行  
				text : '贷款类型--坏账率',
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
			legend : {
				data : [ '工薪族贷', '私营主贷', '随意贷', '物业主贷' ]
			},
			xAxis : [ {
				type : 'category',
				data : [ '2013', '2014', '2015' ]
			} ],
			yAxis : [ {
				type : 'value',
				name : '逾期个数',
				axisLabel : {
					formatter : '{value} 个'
				}
			} ],
			    series : [
        
        {
            name:'工薪族贷',
            type:'bar',
            data:[2.6, 5.9, 9.0, 26.4, 28.7, 70.7, 175.6, 182.2, 48.7, 18.8, 6.0, 2.3],
            markPoint : {
                data : [
                    {name : '年最高', value : 182.2, xAxis: 7, yAxis: 183, symbolSize:18},
                    {name : '年最低', value : 2.3, xAxis: 11, yAxis: 3}
                ]
            },
            markLine : {
                data : [
                    {type : 'average', name : '平均值'}
                ]
            }
        },
         {
            name:'私营主贷',
            type:'bar',
            data:[2.0, 4.9, 7.0, 23.2, 25.6, 76.7, 135.6, 162.2, 32.6, 20.0, 6.4, 3.3],
            markPoint : {
                data : [
                    {type : 'max', name: '最大值'},
                    {type : 'min', name: '最小值'}
                ]
            },
            markLine : {
                data : [
                    {type : 'average', name: '平均值'}
                ]
            }
        },
        {
            name:'随意贷',
            type:'bar',
            data:[2.6, 5.9, 9.0, 26.4, 28.7, 70.7, 175.6, 182.2, 48.7, 18.8, 6.0, 2.3],
            markPoint : {
                data : [
                    {name : '年最高', value : 182.2, xAxis: 7, yAxis: 183, symbolSize:18},
                    {name : '年最低', value : 2.3, xAxis: 11, yAxis: 3}
                ]
            },
            markLine : {
                data : [
                    {type : 'average', name : '平均值'}
                ]
            }
        },
         {
            name:'物业主贷',
            type:'bar',
            data:[2.0, 4.9, 7.0, 23.2, 25.6, 76.7, 135.6, 162.2, 32.6, 20.0, 6.4, 3.3],
            markPoint : {
                data : [
                    {type : 'max', name: '最大值'},
                    {type : 'min', name: '最小值'}
                ]
            },
            markLine : {
                data : [
                    {type : 'average', name: '平均值'}
                ]
            }
        },
        {
            name:'降水量',
            type:'bar',
            data:[2.6, 5.9, 9.0, 26.4, 28.7, 70.7, 175.6, 182.2, 48.7, 18.8, 6.0, 2.3],
            markPoint : {
                data : [
                    {name : '年最高', value : 182.2, xAxis: 7, yAxis: 183, symbolSize:18},
                    {name : '年最低', value : 2.3, xAxis: 11, yAxis: 3}
                ]
            },
            markLine : {
                data : [
                    {type : 'average', name : '平均值'}
                ]
            }
        }]

		};

		function openImage() {
			var data = myChart.getDataURL("png");
			$("#img").val(data);
			$("#exportForm").submit();
		}

	});
</script>
</head>

<body style="background-color:#4B5C88">
	<form id="exportForm" action="createServlet" method="post">
		<input type="hidden" name="img" id="img" />
	</form>
	<div
		style="font-family:Arial, Helvetica, sans-serif; text-align:center">
		<b><font size="7">贷款类型</font> </b> <br /> <br />
		<hr color="#0033CC" width="1024px" />
		<br />
		<hr color="#0033CC" width="1024px" />
		<div>
			<div id="main" style="height:600px;border:1px solid blue" />

		</div>
	</div>

</body>


</html>
