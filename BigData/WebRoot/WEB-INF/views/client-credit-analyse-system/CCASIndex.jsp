<!doctype html>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta charset="utf-8">
<title>金融行业客户信用分析系统</title>
<link href="<c:url value="/css/style.css"/>" rel="stylesheet" type="text/css">
<link href="<c:url value="/css/mycss.css"/>" rel="stylesheet" type="text/css">
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
                <li><a href=<c:url value="/ccas/index/BIShow" />>商业智能</a></li>
			</ul>
        </div>
    </div>
    <div class="content">
    	<p id="datacollect" style="visibility:hidden;" >数据采集包括“数据生成”、“数据导入”、"数据录入"等功能</p>
        <p id="bishow" style="visibility:hidden;" >商业智能展示功能</p>
        <p id="customermsg" style="visibility:hidden;" >给客户画像</p>
    	<img src="<c:url value='/images/ccas/system1indexguide.png' />" alt="功能导航图"  usemap="#system1-guide">
        <map name="system1-guide" id="system1-guide">
        <area 
        	shape="rect"
            onMouseOver="datacollectshowmsg()"
            onMouseOut="datacollecthiddenmsg()"
            onClick="datacollectclick()"
			coords="6,75,90,230"
			alt="数据采集" />
        
         <area 
        	shape="rect"
            onMouseOver="bishowshowmsg()"
            onMouseOut="bishowhiddenmsg()"
            onClick="bishowclick()"
			coords="285,5,365,125"
			alt="智能展示" />
         
          <area 
        	shape="rect"
            onMouseOver="customermsgshowmsg()"
            onMouseOut="customermsghiddenmsg()"
            onClick="customermsgclick()"
			coords="300,230,357,352"
			alt="客户画像" />
    </div>
    <div class="footer">
    	<p>重庆邮电大学 重庆慧都科技 联合开发</p>
    </div>
</div>

<script src="<c:url value="/js/system1-guide.js"/>"></script>
</body>
</html>
