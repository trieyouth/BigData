<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>贷款类型</title>
<script src="js/echarts.js"></script>
<script src="js/jquery.min.js"></script>
</head>
<body>

	<div
		style="font-family:Arial, Helvetica, sans-serif; text-align:center">
		<b><font id="tmye" size="7">贷款量</font> </b>

		<hr color="#0033CC" width="1024px" />
		<div id="H"></div>
		<hr color="#0033CC" width="1024px" />

		<div id="main" style="height:600px;border:1px solid blue"></div>
		<div style="margin-top:20px;">

			<input type="button" value="导出图片到Excel中" onclick="openImage()">
		</div>
		<form id="exportForm" action="createServlet" method="post">
			<input type="hidden" name="img" id="img" />
		</form>
</body>
<script type="text/javascript">
	var urlinfo = window.location.href;
	var yeartmp = urlinfo.split("?")[1].split("=")[1];
	var typetmp = urlinfo.split("?")[2].split("=")[1];
	var year = decodeURI(yeartmp);
	var mon = decodeURI(typetmp);
	document.getElementById("tmye").innerHTML = year + "年" + mon + "月行业贷款统计";

	//配置路径
	require.config({
		paths : {
			echarts : './js/dist',

		}
	});
	var myChart = null;
	require([ 'echarts', 'echarts/chart/line', // 按需加载所需图表，如需动态类型切换功能，别忘了同时加载相应图表
	'echarts/chart/bar', 'echarts/chart/pie' ], function(ec) {
		myChart = ec.init(document.getElementById('main'));
		myChart.on('click', function(param) {
			alert('点击了我！');

		});
		$.ajax({

			type : "post",
			url : "dklServerlet",
			data : {
				send : "two",
				year : year,
				type : mon
			},
			dataType : "json", //返回数据形式为json
			beforeSend : function() {

				myChart.showLoading({
					text : "图表数据正在努力加载..."
				});
			},

			success : function(result) {
				if (result) {
             option.title.text = year + '年'+ mon + '月行业贷款量统计';
					option.series[0].data = result;
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
				text : '行业贷款量分析',
				subtext : '模拟数据',
				x : 'center'
			},
			tooltip : {
				trigger : 'item',
				formatter : "{a} <br/>{b} : {c} ({d}%)"
			},
			legend : {
				orient : 'vertical',
				x : 'left',
				data : [ '房地产、建筑', '服务业', '广告、媒体', '会计、金融、银行、保险',
						'计算机、互联网、通信、电子', '贸易、消费、制造、营运', '能源、原材料' ]
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
						type : [ 'pie', 'funnel' ],
						option : {
							funnel : {
								x : '25%',
								width : '50%',
								funnelAlign : 'left',
								max : 1548
							}
						}
					},
					restore : {
						show : true
					},
					saveAsImage : {
						show : true
					}
				}
			},
			calculable : true,
			series : [ {
				name : '访问来源',
				type : 'pie',
				radius : '55%',
				center : [ '50%', '60%' ],

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