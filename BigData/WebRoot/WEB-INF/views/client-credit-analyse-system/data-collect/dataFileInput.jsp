<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>数据录入</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link href="<c:url value="/css/style.css"/>" rel="stylesheet" type="text/css">
	<link href="<c:url value="/css/mycss.css"/>" rel="stylesheet" type="text/css">
  </head>
  
  <body style="background:#fff;">
  <div style="margin:0 auto;width:90%;background:#fff;">
  
  <h4 align="center" style="margin:10px auto;padding-top:10px;">数据导入功能</h4>
  <p style="margin-top:10px;">可通过本页面将本地文件导入到大数据平台，支持xxx格式。导入前请下载下面为您提供的模板，并按照模板填写自己要导入的数据。</p>
  
	<p style="margin-top:20px;font-size:18px;"><a href="<c:url value='/ccas/index/dataCollect/filedownload'/>">模板下载</a></p></br>
    
    <form method="post" action="<c:url value='/ccas/index/dataCollect/dataFileInput' />" enctype="multipart/form-data">
    	
        
    
        <input class="filepath" type="text" size="30" name="upfile" id="upfile" > 
        <div style="height:10px;"></div>
 		<input class="choicefile" type="button" value="浏览" onclick="file.click()"> 
		<input type="file" id="file"  name="file" style="display:none" onchange="upfile.value=this.value">
  		<input class="submitfile" type="submit" value="提交" name="submit">
        
        
    </form>
   
  
  
  
  
   
   </div>
  </body>
</html>
