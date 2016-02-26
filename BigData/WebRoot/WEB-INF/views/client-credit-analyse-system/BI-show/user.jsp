
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户数</title>
<script src="js/echarts.js"></script>
<script src="js/jquery.min.js"></script>

 
</head>
<body style="background-color:#4B5C88">
<div style="font-family:Arial, Helvetica, sans-serif; text-align:center">
  <b><font size="7">当前系统登录用户监控</font></b>
	<br  />

	<hr color="#0033CC" width="1024px" />
		<br  />
     <hr color="#0033CC" width="1024px" />
     
    </div>
    <div id="main" style="height:400px;border:1px solid blue"/>
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
         
   option = {
    tooltip : {
        formatter: "{a} <br/>{b} : {c}%"
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
            name:'CPU利用率',
            type:'gauge',
            z: 3,
            min:0,
            max:100,
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
            data:[{value: 40, name: '当前用户数%'}]
        },
        
    ]
};
 myChart.showLoading({
				   text : "图表数据正在努力加载..."
			}); 

clearInterval(timeTicket);
timeTicket = setInterval(function (){

    $.ajax({
				type : "post",
				url :"ajaxServlet",
				data : {},
				dataType :String, 
				
				beforeSend:function(){
				  myChart.showLoading({
				   text : "图表数据正在努力加载..."
			}); 
		},
		
		
				success : function(result) {
					 if (result) {
				var data=result
				myChart.hideLoading();
                 option.series[0].data[0].value=data ;
                 myChart.setOption(option,true);
					} 
				},
				complete:function(){
				myChart.hideLoading();
				},
				error : function(errorMsg) {
					alert("不好意思，大爷，图表请求数据失败啦!");
					
				}
			});
		
    
       },3000);
    
            }
        );
        
       


</script>
</html>