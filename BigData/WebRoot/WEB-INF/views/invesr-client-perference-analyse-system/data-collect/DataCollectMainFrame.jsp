<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>
<html>
<head>
<meta charset="utf-8">
<title>金融行业客户信用分析系统</title>
<link href="../../css/style.css" rel="stylesheet" type="text/css">
</head>

<body>
<div class="system1-index-wrap">
	<div class="header">
    	<div class="logo">
        	<a href=<c:url value="/icpas/index" />>
        		<img src="<c:url value='/images/icpas/system2logo.png' />" alt="金融行业客户信用分析系统首页" width="40%">
        	</a>
        </div>
        <div class="nav">
        	<ul>
            <li><a href=<c:url value="/icpas/index" />>首页</a></li>
                <li><a href=<c:url value="/icpas/index/dataCollect" />>数据采集</a></li>
                <li><a href=<c:url value="/icpas/index/evaluateRiskPreference" />>偏好评估</a></li>
                <li><a href=<c:url value="/icpas/index/BIShow" />>商业智能</a></li>
			</ul>
        </div>
    </div>
    <div class="content">
    	<div class="meau">
        	<ul>
            	<li><a href="<c:url value='/icpas/index/dataCollect/generateData'/>" target="system1main" id="system1-meau1" style="border-top:1px solid #4C5C89;" onClick="system1meau1backgroundchange()">生成数据</a></li>
                <li><a href="<c:url value='/icpas/index/dataCollect/dataFileInput'/>" target="system1main" id="system1-meau2" onClick="system1meau2backgroundchange()">数据导入</a></li>
                <li><a href="<c:url value='/icpas/index/dataCollect/dataInput'/>" target="system1main" id="system1-meau3" onClick="system1meau3backgroundchange()">数据录入</a></li>
                <li><a href="<c:url value='/icpas/index/dataCollect/templetCreateRecordDetail'/>" target="system1main" id="system1-meau4" onClick="system1meau4backgroundchange()">模板管理</a></li>
                <li><a href="<c:url value='/icpas/index/dataCollect/collectingRecord'/>" target="system1main" id="system1-meau5" onClick="system1meau5backgroundchange()">采集记录</a></li>
            </ul>
        </div>
        <div class="main">
        	 <iframe src="<c:url value='/icpas/index/dataCollect/generateData'/>" name="system1main" width="100%"  height="100%" frameborder=”no” border=”0″></iframe>
        </div>
    </div>
    <div class="footer">
    	<p>重庆邮电大学 重庆慧都科技 联合开发</p>
    </div>
</div>
<script src="<c:url value="/js/system1-guide.js"/>"></script>
<script async>
	var height900=document.getElementById("continaer");
	w=height900.offsetWidth;
	h=w*0.5;
	//height900.style.height=h+"px";
	pd=w*0.01;
	//height900.style.padding=pd+"px"
					    function fun(){
            window.location.href="http://172.23.21.64:8080/BI/BI.jsp";}
</script>
  </body>
</html>
