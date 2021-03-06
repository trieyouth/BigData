<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

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
        	<a href=<c:url value="/ccas/index" />>
        		<img src="<c:url value='/images/ccas/system1logo.png' />" alt="金融行业客户信用分析系统首页" width="40%">
        	</a>
        </div>
        <div class="nav">
        	<ul>
            	<li><a href=<c:url value="/ccas/index" />>首页</a></li>
                <li><a href=<c:url value="/ccas/index/dataCollect" />>数据采集</a></li>
                <li><a href=<c:url value="/ccas/index/clientPortray" />>客户画像</a></li>
                <li><a href="/ccas/index/BIShow">商业智能</a></li>
			</ul>
        </div>
    </div>
    <div class="content">
    	<div class="meau">
        	 <ul>
          <hr color="#575C6F"/>
          
          <!-- onclick="javascript:window.open(encodeURI('map.jsp'))" -->
          <li ><a href="<c:url value="/ccas/index/BIShow/map" />"  target="system1main">地区贷款重量统计</a></li>
          <hr color="#575C6F"/>
          <li><a href="<c:url value="/ccas/index/BIShow/jobpie" />"   target="system1main">行业逾期展示</a></li>
          <hr color="#575C6F"/>
          <li><a href="<c:url value="/ccas/index/BIShow/dklx" />" target="system1main">贷款类型逾期展示</a></li>
          <hr color="#575C6F"/>
          <li><a href="<c:url value="/ccas/index/BIShow/dkzl" />" target="system1main">贷款量统计</a></li>
          <hr color="#575C6F"/>
          <li><a href="<c:url value="/ccas/index/BIShow/xueli" />" target="system1main">学历逾期展示</a></li>
          <hr color="#575C6F"/>
          <li><a href="<c:url value="/ccas/index/BIShow/yixiang" />" target="system1main">贷款周期调查统计</a></li>
          <hr color="#575C6F"/>
            <li><a href="http://172.23.27.190/ganglia/" target="system1main">集群性能展示</a></li>
          <hr color="#575C6F"/>
           <li><a href="<c:url value="/ccas/index/BIShow/jiqun" />" target="system1main">系统监控</a></li>
          <hr color="#575C6F"/>
           
        </ul>
        </div>
        <div class="main">
        	 <iframe src=<c:url value="/ccas/index/BIShow/map" /> name="system1main" width="100%"  height="100%" frameborder=”no” border=”0″></iframe>
        </div>
    </div>
    <div class="footer">
    	<p>重庆邮电大学 重庆慧都科技 联合开发</p>
    </div>
</div>

<script src="<c:url value="/js/system1-guide.js"/>"></script>
</body>
</html>

