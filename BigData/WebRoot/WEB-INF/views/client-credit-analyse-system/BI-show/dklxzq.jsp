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
<body style="background-color:#4B5C88">

	<div
		style="font-family:Arial, Helvetica, sans-serif; text-align:center">
		<b><font id="tmye" size="7">贷款类型</font>
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
	var urlinfo = window.location.href;
	var yeartmp = urlinfo.split("?")[1].split("=")[1];
	var typetmp = urlinfo.split("?")[2].split("=")[1];
	var year = decodeURI(yeartmp);
	var type = decodeURI(typetmp);
	document.getElementById("tmye").innerHTML = year + "年" + type + "月份展示";



	//配置路径
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
		myChart.on('click', function(param) {
			alert('点击了我！');

		});
        	$.ajax({
	  
		type : "post",
		url : "dklxzqServerlet",
		data : {year:year,type:type},
		dataType : "text", //返回数据形式为json
		beforeSend : function() {
			myChart.showLoading({
				text : "图表数据正在努力加载..."
			});
		},

		success : function(result) {
			if (result) {
			var ss=  result.split(":");
			var a=ss[0].split(",");
			var b=ss[1].split(",");
			 var data1=new Array();
			  var data2=new Array();
			 for(var i=0;i<a.length;i++){
                      data1.push(a[i]);
                     }
                      for(var i=0;i<b.length;i++){
                      data2.push(b[i]);
                     }
				option.series[0].data = data1;
				option.series[1].data = data2;
				myChart.setOption(option, true);
			    myChart.hideLoading();
			}
		},
		
		error : function(errorMsg) {
			alert("不好意思，大爷，图表请求数据失败啦!");

		}
	});

	  var option = {
                		title: {  
                            //主标题文本，'\n'指定换行  
                            text: '逾期-月份',  
                            //主标题文本超链接  
                            link: 'http://hongyan.cqupt.edu.cn/',  
                            //副标题文本，'\n'指定换行  
                            subtext: 'http://www.cqupt.edu.cn/cqupt/index.shtml',  
                            //副标题文本超链接  
                            sublink: 'http://www.cqupt.edu.cn/cqupt/index.shtml',  
                            x: 'left',  
                            y: 'top'  
                        },  
                        tooltip : {
                            trigger: 'axis'
                        },
                        legend: {
                            data:['逾期个数','未逾期']
                        },
                        toolbox: {
                            show : true,
                            feature : {
		                        mark : {show: true}, //辅助线开关
		                        dataView : {show: true, readOnly: false}, //数据视图
		                        magicType : {show: true, type: ['line', 'bar','stack', 'tiled']}, //动态类型转换
		                        restore : {show: true}, //还原
		                        exportexcel : {
						show : true,//是否显示    
						title : '导出图片到Excel', //鼠标移动上去显示的文字    
						icon : 'excel.png', //图标    
						option : {},
						onclick : function(option) {//点击事件,这里的option1是chart的option信息    
							openImage();//这里可以加入自己的处理代码，切换不同的图形    
						}
					},
		                        saveAsImage : {show: true} //保存图片
		                    }
                        },
                        calculable : true,
                        xAxis : [
                            {
                                type : 'category',
                                data : ['1月','2月','3月','4月','5月','6月','7月','8月','9月','10月','11月','12月']
                            }
                        ],
                        yAxis : [
                            {
                                type : 'value',
                                splitArea : {show : true}
                            }
                        ],
                        series : [
                            {
                                name:'逾期个数',
                                type:'bar',
                               
                                
                              markPoint: {  
                                data: [  
                                    {type: 'max', name: '最大值'},  
                                    {type: 'min', name: '最小值'}  
                                ]  
                            },
                            
                         
                           },
                        
                        
                            {
                                name:'未逾期',
                                type:'line',
                               markPoint: {  
                                    data: [  
                                        {type: 'max', name: '最大值'},  
                                        {type: 'min', name: '最小值'}  
                                    ]  
                                },
                                
                               
                            }
                        ]
                    };
                      }
        );
    
    
	function openImage() {
		var data = myChart.getDataURL("png");
		$("#img").val(data);
		$("#exportForm").submit();
	}
</script>
</html>