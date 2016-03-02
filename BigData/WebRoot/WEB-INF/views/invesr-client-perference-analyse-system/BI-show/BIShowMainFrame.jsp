<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8" pageEncoding="UTF-8"%>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
<title>客户风险偏好系统BI展示页面组主框架</title>
    
	<c:import url="../header1.jsp"/>
<style>
#labelbody {
	color: #FFF;
	font-size: 12px;
	font-family: Microsoft YaHei;
}
</style>
  </head>
  
  <body>
<div id="continaer">
  <c:import url="../header2.jsp"/>
  <div id="bod">
    
    <div id="rightbody" style="width:100%">
      <iframe src="<c:url value='/icpas/index/BIShow/bar'/>" name="rightbody" width="100%" height="100%"  frameborder=”no” border=”0″></iframe>
    </div>
  </div>
</div>

  </body>
</html>
