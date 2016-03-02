<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>流量统计</title>
<script src="js/echarts.js"></script>
<script src="js/jquery.min.js"></script>
<script src="js/esl"></script>
<script src="js/zrender.js"></script>
</head>
<body style="background-color:#4B5C88">
	<div id="line" style="height:600px;border:1px solid blue"></div>
	
</body>
<script type="text/javascript">

//配置路径
require.config({
	 paths:{
		 echarts: './js/dist',		 
	 }
});
 var myChart =null;
require(
	[
		'echarts',
		'echarts/chart/map' //地图,
	],
	
	function(ec){
		    myChart = ec.init(document.getElementById('line'));
		option = {
    tooltip : {
        trigger: 'item'
    },
    toolbox: {
        show : true,
        orient: 'vertical',
        x:'right',
        y:'center',
        feature : {
            mark : {show: true},
            dataView : {show: true, readOnly: false}
        }
    },
    series : [
        {
            tooltip: {
                trigger: 'item',
                formatter: '{b}'
            },
            name: '选择器',
            type: 'map',
            mapType: 'china',
            mapLocation: {
                x: 'left',
                y: 'top',
                width: '40%'
            },
            roam: true,
            selectedMode : 'single',
            itemStyle:{
                normal:{label:{show:true}},
                emphasis:{label:{show:true}}
            },
            data:[
               
            ]
        }
    ],
    animation: false
};
 myChart.setOption(option, true);
var ecConfig = require('echarts/config');
myChart.on(ecConfig.EVENT.MAP_SELECTED, function (param){
    var selected = param.selected;
   var selectedProvince;
    for (var p in selected) {
        if (selected[p]) {
            selectedProvince = p ;
        }
    }
    
    if (typeof selectedProvince == 'undefined') {
        option.series.splice(1);
        option.legend = null;
        option.dataRange = null;
        myChart.setOption(option, true);
        return;
    }

    option.series[1] = {
        name: '随机数据',
        type: 'map',
        mapType: selectedProvince,
        itemStyle:{
            normal:{label:{show:true}},
            emphasis:{label:{show:true}}
        },
        mapLocation: {
            x: '35%'
        },
        roam: true,
        data:[]
    };
    option.legend = {
        x:'right',
        data:['随机数据']
    };
    option.dataRange = {
        orient: 'horizontal',
        x: 'right',
        min: 0,
        max: 1000,
        color:['orange','yellow'],
        text:['高','低'],           // 文本，默认为数值文本
        splitNumber:0
    };
    myChart.setOption(option, true);
})
                    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		     });
   

        
    

</script>
</html>