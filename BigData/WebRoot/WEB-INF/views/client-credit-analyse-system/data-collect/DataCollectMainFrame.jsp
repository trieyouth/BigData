<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
<title>数据采集页面组主框架</title>
    <c:import url="../header1.jsp"/>
</head>

<body>
<div id="continaer">
  <c:import url="../header2.jsp"/>
  <div id="bod">
    <div id="leftbody"> <br/>
      <div class="meau">
        <ul>
          <hr color="#575C6F"/>
          <form  method="post">
          
          <!--选择子功能-->
         <li ><a href="<c:url value="/ccas/index/dataCollect/generateData" />" target="rightbody" >生成数据</a></li>
          <hr color="#575C6F"/>
          <li><a href="<c:url value="/ccas/index/dataCollect/dataFileInput" />"  target="rightbody" >数据导入</a></li>
          <hr color="#575C6F"/>
          <li><a href="<c:url value="/ccas/index/dataCollect/dataInput" />" target="rightbody">数据录入</a></li>
          <hr color="#575C6F"/>
          <li ><a href="<c:url value="/ccas/index/dataCollect/templateManage" />" target="rightbody" >模板管理</a></li>
          <hr color="#575C6F"/>
          <li><a href="<c:url value="/ccas/index/dataCollect/operationLog" />"  target="rightbody">采集记录</a></li>
          <hr color="#575C6F"/>
          </form>
        </ul>
      </div>
    </div>
    <div id="rightbody">
      <iframe src="<c:url value='/ccas/index/dataCollect/generateData' />" name="rightbody" width="100%" height="100%"  frameborder=”no” border=”0″></iframe>
    </div>
  </div>
</div>
<script async>
	var height900=document.getElementById("continaer");
	w=height900.offsetWidth;
	h=w*0.5;
	//height900.style.height=h+"px";
	pd=w*0.01;
	//height900.style.padding=pd+"px"
</script>
  </body>
</html>
