<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<title>BI展示</title>
<style>
.con {
	width: 75%;
	margin: 0 auto;
	padding: 0;
	border: 0;
}
.don {
	width: 90%;
	height: 120px;
	margin: 0 auto;
	padding: 0;
	border: 0;
	background:  #4B5C22 ;
	text-align: center;
	line-height: 100%;        /*è®¾ç½®æå­è¡è·ç­äºdivçé«åº¦*/
}
</style>
<link href="<c:url value="/css/bootstrap.css"/>" rel="stylesheet" type="text/css">
</head>

<body  style="background-color:#4B5C88" style=border-style:inset> <!-- style="background-color:#4B5C88" style="background-image:url(imag/map.png)" -->
<br/>
<br/>
<h1 align="center">BI展示模块</h1>
<br/>
<br/>
<br/>
<br/>
<div class="con" style="border-style:double">
<table frame="void" width = "100%">
  <tr>
    <td width="25%"  height="120"  >
    	
      		<button  style="border-style:outset" class="don" onclick="javascript:location.assign(encodeURI('<c:url value="/ccas/index/BIShow/map" />'))"><label style="color:#FFF">地区贷款总量统计</label></button>
      	</a>
    </td>
  
      <td width="25%"  height="120"  >
    	
      		<button class="don" onclick="javascript:location.assign(encodeURI('<c:url value="/ccas/index/BIShow/jobpie" />'))"><label style="color:#FFF">行业逾期展示</label></button>
      	</a>
    </td>
    
      <td width="25%"  height="120"  >
      		<button class="don" onclick="javascript:location.assign(encodeURI('<c:url value="/ccas/index/BIShow/dklx" />'))"><label style="color:#FFF">贷款类型逾期展示</label></button>
      	</a>
    </td>
    
      <td width="25%"  height="120"  >
      		<button class="don" onclick="javascript:location.assign(encodeURI('<c:url value="/ccas/index/BIShow/dkzl" />'))"><label style="color:#FFF">贷款量统计</label></button>
      	</a>
    </td>
    
    
  </tr>
</table>

<div style="width:100%;height:30px;"></div>

<table frame="void" width = "100%">
  <tr>
    <td width="25%"  height="120"  >
    	
      		<button class="don" onclick="javascript:location.assign(encodeURI('<c:url value="/ccas/index/BIShow/xueli" />'))">
      		<label style="color:#FFF">学历逾期展示</label></button>
      	</a>
    </td>
  
      <td width="25%"  height="120"  >
      		<button class="don" onclick="javascript:location.assign(encodeURI('<c:url value="/ccas/index/BIShow/yixiang" />'))"><label style="color:#FFF">贷款周期调查统计</label></button>
      	</a>
    </td>
    
      <td width="25%"  height="120"  >
    
      		<button class="don" onclick="javascript:location.assign(encodeURI('http://172.23.27.190/ganglia/'))"><label style="color:#FFF">集群性能展示</label></button>
      	</a>
    </td>
    
      <td width="25%"  height="120"  >
   <button class="don" onclick="javascript:location.assign(encodeURI('<c:url value="/ccas/index/BIShow/jiqun" />'))"><label style="color:#FFF">系统监控</label></button>	</a>
      
    </td>
    
  </tr>
</table>




</div>
</body>
</html>
