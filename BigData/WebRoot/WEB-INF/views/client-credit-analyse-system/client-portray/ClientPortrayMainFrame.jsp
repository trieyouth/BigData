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
<title>金融行业客户信用分析系统客户画像</title>
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
                <li><a href=<c:url value="/ccas/index/BIShow" />>商业智能</a></li>
			</ul>
        </div>
    </div>
    <div class="content">
    	<div class="meau">
        	<ul>
            	<li><a href="<c:url value="/ccas/index/clientPortray/checkCreditLevel" />" target="system1main" id="system1-meau1" style="border-top:1px solid #4C5C89;" onClick="system1meau1backgroundchange()">查看信用等级</a></li>
                <li><a href="<c:url value="/ccas/index/clientPortray/personalCreditQuery" />" target="system1main" id="system1-meau2" onClick="system1meau2backgroundchange()">给定信息画像</a></li>
                <li><a href="<c:url value="/ccas/index/clientPortray/personalCreditQueryByCard" />" target="system1main" id="system1-meau3" onClick="system1meau3backgroundchange()">已有用户画像</a></li>
            </ul>
        </div>
        <div class="main">
        	 <iframe src=<c:url value="/ccas/index/clientPortray/checkCreditLevel" /> name="system1main" width="100%"  height="100%" frameborder=”no” border=”0″ style="background:#fff;"></iframe>
        </div>
    </div>
    <div class="footer">
    	<p>重庆邮电大学 重庆慧都科技 联合开发</p>
    </div>
</div>

<script src="<c:url value="/js/system1-guide.js"/>"></script>
</body>
</html>

