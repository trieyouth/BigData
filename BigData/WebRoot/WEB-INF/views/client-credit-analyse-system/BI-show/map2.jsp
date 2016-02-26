<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>流量统计</title>
<script src="js/echarts.js"></script>
</head>
<body>
<div id="line" style="height:400px;border:1px solid blue"></div>
<div id="message" style="height:600px;border:1px solid blue"></div>
</body>
<script type="text/javascript">

//配置路径
require.config({
	 paths:{
		 echarts: './js/dist',		 
	 }
});
 var myChart =null;
  var myChart2=null;
require(
	[
		'echarts',
		'echarts/chart/map' //地图,
	],
	
	function(ec){
		    myChart = ec.init(document.getElementById('line'));
		     myChart2 = ec.init(document.getElementById('message'));
   
option = {
    tooltip : {
        trigger: 'item',
        formatter: '{b}'
    },
    series : [
        {
            name: '中国',
            type: 'map',
            mapType: 'china',
            selectedMode : 'multiple',
            itemStyle:{
                normal:{label:{show:true}},
                emphasis:{label:{show:true}}
            },
            data:[
              /*   {name:'广东',selected:true} */
            ]
        }
    ]
};
     myChart.setOption(option);    
//////////////////////////////////////////////////////
 option2={
  title: {
        text : '',
       
    },
         tooltip : {
        trigger: 'item',
        formatter: '{b}'
    },
    series : [
        {
            name: '中国',
            type: 'map',
           // mapType: 'china',
            selectedMode : 'multiple',
            itemStyle:{
                normal:{label:{show:true}},
                emphasis:{label:{show:true}}
            },
            data:[
               
            ]
        }
    ]  
        };        
        
        
        
        
        
        ////////////////////////////////////////////////////////
       
    var ecConfig = require('echarts/config');  
     myChart.on(ecConfig.EVENT.CLICK, function(param){
      option2.series[0].mapType="";
     option2.series[0].mapType=param.name;
     option2.title.text = param.name + '市';
     myChart2.setOption(option2);
  
});   

                      
    /* myChart.on(ecConfig.EVENT.MAP_SELECTED, function (param){
    var selected = param.selected;
    var str = '';
    for (var p in selected) {
        if (selected[p]) {
            str = p ;
        }
    }
     option2.title.text = str + '市';
     option2.series[0].mapType=str;
      myChart2.setOption(option2);

      });
      */
     /////////////////// ////
        
     });
        
        
        
        
 
  /* 	var ecConfig = require('echarts/config');
     myChart.on(ecConfig.EVENT.CLICK, eConsole);
    function eConsole(param){
  option. series.mapType=param.name;
   myChart.setOption(option);
   alert(param.name);
}           */                  

</script>
</html>