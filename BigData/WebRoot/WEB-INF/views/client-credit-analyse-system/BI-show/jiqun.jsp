<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>集群性能监控</title>
<script src="js/echarts.js"></script>
<script src="js/jquery.min.js"></script>
</head>
<body style="background-color:#4B5C88">
  
<div style="font-family:Arial, Helvetica, sans-serif; text-align:center">
  <b><font size="7">系统检测</font></b>
	<br  />

	<hr color="#0033CC" width="1024px" />
		<br  />
     <hr color="#0033CC" width="1024px" />
     
    </div>
    <div id="main" style="height:600px;border:1px solid blue"/>
<form id="exportForm" action="createServlet" method="post">
	<input type="hidden" name="img" id="img" />
</form>
</body>
<script type="text/javascript">

var timeTicket;
 //配置路径
 require.config({
            paths: {
                echarts: './js/dist',
               
               
            }
        });
        var myChart = null;
        require(
            [
                'echarts',
                'echarts/chart/gauge'
            ],
            
            function (ec) {
                 myChart = ec.init(document.getElementById('main'));
                
                myChart.on('click', function (param) {
                    alert('点击了我！');

         });
         myChart.showLoading({
				text : "图表数据正在努力加载..."
			});
			
			
   function aj(){
    $.ajax({
		type : "post",
		url : "xitongServlet",
		data : {},
		dataType : 'text', //返回数据形式为json
		beforeSend : function() {
			myChart.showLoading({
				text : "图表数据正在努力加载..."
			});
		},

		success : function(result) {
			if (result) {
			 var ss = result.split(",");
			  myChart.hideLoading();
				option.series[0].data[0].value =ss[0];
                option.series[1].data[0].value =ss[1];
                option.series[2].data[0].value =ss[2];	
               	
               // option.series[5].data[0].value =ss[4];
				//myChart.setOption(option, true);
			   
			}
		},
		
		error : function(errorMsg) {
			alert("不好意思，大爷，图表请求数据失败啦!");

		}
	});
   }
         clearInterval(timeTicket);
   timeTicket = setInterval(function (){
        aj();
	 myChart.setOption(option,true);
},5000);
  option = {
    tooltip : {
        formatter: "{a} <br/>{c} {b}"
    },
    toolbox: {
        show : true,
        feature : {
            mark : {show: true},
            restore : {show: true},
            saveAsImage : {show: true}
        }
        
    },
    series : [
        {
            name:'当前登录用户数',
            type:'gauge',
            z: 3,
            min:0,
            max:20,
            splitNumber:10,
            axisLine: {            // 坐标轴线
                lineStyle: {       // 属性lineStyle控制线条样式
                    width: 10
                }
            },
            axisTick: {            // 坐标轴小标记
                length :15,        // 属性length控制线长
                lineStyle: {       // 属性lineStyle控制线条样式
                    color: 'auto'
                }
            },
            splitLine: {           // 分隔线
                length :20,         // 属性length控制线长
                lineStyle: {       // 属性lineStyle（详见lineStyle）控制线条样式
                    color: 'auto'
                }
            },
            title : {
                textStyle: {       // 其余属性默认使用全局文本样式，详见TEXTSTYLE
                    fontWeight: 'bolder',
                    fontSize: 20,
                    fontStyle: 'italic'
                }
            },
            detail : {
                textStyle: {       // 其余属性默认使用全局文本样式，详见TEXTSTYLE
                    fontWeight: 'bolder'
                }
            },
            data:[{value: 1, name: '当前用户数'}]
        },
        {
            name:'正在运行的任务数',
            type:'gauge',
            center : ['25%', '55%'],    // 默认全局居中
            radius : '50%',
            min:0,
            max:10,
            endAngle:45,
            splitNumber:10,
            axisLine: {            // 坐标轴线
                lineStyle: {       // 属性lineStyle控制线条样式
                    width: 8
                }
            },
            axisTick: {            // 坐标轴小标记
                length :12,        // 属性length控制线长
                lineStyle: {       // 属性lineStyle控制线条样式
                    color: 'auto'
                }
            },
            splitLine: {           // 分隔线
                length :20,         // 属性length控制线长
                lineStyle: {       // 属性lineStyle（详见lineStyle）控制线条样式
                    color: 'auto'
                }
            },
            pointer: {
                width:5
            },
            title : {
                offsetCenter: [0, '-30%'],       // x, y，单位px
            },
            detail : {
                textStyle: {       // 其余属性默认使用全局文本样式，详见TEXTSTYLE
                    fontWeight: 'bolder'
                }
            },
            data:[{value: 1.5, name: '正在运行的任务数'}]
        },
        
      {
            name:'运行成功数',
            type:'gauge',
            center : ['75%', '50%'],    // 默认全局居中
            radius : '50%',
            min:0,
            max:1000,
            startAngle:135,
            splitNumber:10,
            axisLine: {            // 坐标轴线
                lineStyle: {       // 属性lineStyle控制线条样式
                    width: 8
                }
            },
            axisTick: {            // 坐标轴小标记
                length :12,        // 属性length控制线长
                lineStyle: {       // 属性lineStyle控制线条样式
                    color: 'auto'
                }
            },
            splitLine: {           // 分隔线
                length :20,         // 属性length控制线长
                lineStyle: {       // 属性lineStyle（详见lineStyle）控制线条样式
                    color: 'auto'
                }
            },
            pointer: {
                width:5
            },
            title : {
                offsetCenter: [0, '-30%'],       // x, y，单位px
            },
            detail : {
                textStyle: {       // 其余属性默认使用全局文本样式，详见TEXTSTYLE
                    fontWeight: 'bolder'
                }
            },
            data:[{value: 1.5, name: '已跑任务数'}]
        },
        
       
    ]
};
        
        /*  {
            name:'内存',
            type:'gauge',
            center : ['75%', '55%'],    // 默认全局居中
            radius : '50%',
            min:0,
            max:100,
            startAngle:135,
            splitNumber:10,
            axisLine: {            // 坐标轴线
                lineStyle: {       // 属性lineStyle控制线条样式
                    width: 8
                }
            },
            axisTick: {            // 坐标轴小标记
                length :12,        // 属性length控制线长
                lineStyle: {       // 属性lineStyle控制线条样式
                    color: 'auto'
                }
            },
            splitLine: {           // 分隔线
                length :20,         // 属性length控制线长
                lineStyle: {       // 属性lineStyle（详见lineStyle）控制线条样式
                    color: 'auto'
                }
            },
            pointer: {
                width:5
            },
            title : {
                offsetCenter: [0, '-30%'],       // x, y，单位px
            },
            detail : {
                textStyle: {       // 其余属性默认使用全局文本样式，详见TEXTSTYLE
                    fontWeight: 'bolder'
                }
            },
            data:[{value: 1.5, name: '内存利用率'}]
        }, */
       



            }
        );
function openImage(){
	var data = myChart.getDataURL("png");
    $("#img").val(data);
    $("#exportForm").submit();
}
</script>
</html>