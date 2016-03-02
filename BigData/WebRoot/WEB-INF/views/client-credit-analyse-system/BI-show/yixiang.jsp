<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>贷款意向</title>
<script src="js/echarts.js"></script>
<script src="js/jquery.min.js"></script>
</head>
<body style="background-color:#4B5C88">
<div style="font-family:Arial, Helvetica, sans-serif; text-align:center">
  <b><font size="7">贷款意向周期统计</font></b>
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
                'echarts/chart/line',   // 按需加载所需图表，如需动态类型切换功能，别忘了同时加载相应图表
                'echarts/chart/bar',
                'echarts/chart/pie'
            ],
            
            function (ec) {
                 myChart = ec.init(document.getElementById('main'));
                
                myChart.on('click', function (param) {
                    alert('点击了我！');

         });
         
option = {
    title : {
        text: '贷款周期趋势',
        subtext: '模拟'
    },
    tooltip : {
        trigger: 'axis'
    },
    legend: {
        data:['意向','征询','贷款成功']
    },
    toolbox: {
        show : true,
        feature : {
            mark : {show: true},
            dataView : {show: true, readOnly: false},
            magicType : {show: true, type: ['line', 'bar', 'stack', 'tiled']},
            restore : {show: true},
            saveAsImage : {show: true}
        }
    },
    calculable : true,
    xAxis : [
        {
            type : 'category',
            boundaryGap : false,
            data : ['start','10天','20天','30天','40天','50天','60天']
        }
    ],
    yAxis : [
        {
            type : 'value'
        }
    ],
    series : [
        {
            name:'贷款成功',
            type:'line',
            smooth:true,
            itemStyle: {normal: {areaStyle: {type: 'default'}}},
            data:[10, 12, 21, 54, 260, 830, 710]
        },
        {
            name:'征询',
            type:'line',
            smooth:true,
            itemStyle: {normal: {areaStyle: {type: 'default'}}},
            data:[30, 182, 434, 791, 390, 30, 10]
        },
        {
            name:'意向',
            type:'line',
            smooth:true,
            itemStyle: {normal: {areaStyle: {type: 'default'}}},
            data:[1320, 1132, 601, 234, 120, 90, 20]
        }
    ]
};
                 
                  myChart.setOption(option);
                 
               
            }
        );
function openImage(){
	var data = myChart.getDataURL("png");
    $("#img").val(data);
    $("#exportForm").submit();
}
</script>
</html>