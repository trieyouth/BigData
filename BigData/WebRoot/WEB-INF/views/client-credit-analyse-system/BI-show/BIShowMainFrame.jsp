<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8" pageEncoding="UTF-8"%>

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
          
          <!-- onclick="javascript:window.open(encodeURI('map.jsp'))" -->
          <li ><a href="<c:url value="/ccas/index/BIShow/map" />"  target="rightbody">地区贷款重量统计</a></li>
          <hr color="#575C6F"/>
          <li><a href="<c:url value="/ccas/index/BIShow/jobpie" />"   target="rightbody">行业逾期展示</a></li>
          <hr color="#575C6F"/>
          <li><a href="<c:url value="/ccas/index/BIShow/dklx" />" target="rightbody">贷款类型逾期展示</a></li>
          <hr color="#575C6F"/>
          <li><a href="<c:url value="/ccas/index/BIShow/dkzl" />" target="rightbody">贷款量统计</a></li>
          <hr color="#575C6F"/>
          <li><a href="<c:url value="/ccas/index/BIShow/xueli" />" target="rightbody">学历逾期展示</a></li>
          <hr color="#575C6F"/>
          <li><a href="<c:url value="/ccas/index/BIShow/yixiang" />" target="rightbody">贷款周期调查统计</a></li>
          <hr color="#575C6F"/>
            <li><a href="http://172.23.27.190/ganglia/" target="rightbody">集群性能展示</a></li>
          <hr color="#575C6F"/>
           <li><a href="<c:url value="/ccas/index/BIShow/jiqun" />" target="rightbody">系统监控</a></li>
          <hr color="#575C6F"/>
           
        </ul>
      </div>
    </div>
    <div id="rightbody">
       <iframe src="<c:url value="/ccas/index/BIShow/BI" />" name="rightbody" width="100%" height="100%"  frameborder=”no” border=”0″></iframe> 
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
