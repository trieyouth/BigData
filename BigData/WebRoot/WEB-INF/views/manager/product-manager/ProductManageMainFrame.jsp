<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>"/>
    
    <meta charset="utf-8">
    <title>产品管理主框架</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">	
	<link href="<c:url value="/css/mycss.css"/>" rel="stylesheet">
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
  <div id="header"> <a href="<c:url value="/manager/index" />"> <img src="<c:url value='/images/manager/logo.png' />" width="620" height="75" alt="logo" > </a>
    <hr color="#6F7DA0"/>
    <div id="navhead">
      <div class="nav">
        <ul>
          <li><a href="<c:url value='manager/product/index'/>">产品管理</a></li>
          <li><a href="<c:url value='manager/user/index'/>">用户管理</a></li>
        </ul>
      </div>
    </div>
    <hr color="#848FAD"/>
  </div>
  <div id="bod">
    <div id="leftbody"> <br/>
      <div class="meau">
        <ul>
          <hr color="#575C6F"/>
          <!--选择子功能-->
          <li ><a href="<c:url value='manager/product/list'/>" target="rightbody" >现有产品管理</a></li>
          <hr color="#575C6F"/>
          <li><a href="<c:url value='manager/product/add'/>"  target="rightbody">增加产品</a></li>
          <hr color="#575C6F"/>
        
          
        </ul>
      </div>
    </div>
    <div id="rightbody">
      <iframe src="<c:url value='manager/product/list'/>" name="rightbody" width="100%" height="100%"  frameborder=”no” border=”0″></iframe>
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
