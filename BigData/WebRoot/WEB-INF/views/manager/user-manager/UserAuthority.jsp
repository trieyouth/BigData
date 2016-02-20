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
    
    <meta charset="utf-8">
    <title>用户权限</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
<link href="WebView/css/mycss.css" rel="stylesheet" type="text/css"  >
  </head>
  <style>
#lightcolor {
	width: 96%;
	padding-top: 10px;
	padding-bottom: 10px;
	padding-left: 10px;
	margin-left: 1%;
	background-color: #4B5C88;
	border: 0;
}
</style>
  <body>
    <div style="height:4px; width:100%;"></div>
   
   
   <div id="lightcolor" >
   
<table frame="void" width = "50%" height="30" style="text-align:center;">


<tr>
  <td width="50%" height="30"><label id="labelhead" >&nbsp编号 </label></td>  <!--模板编号-->
  <td width="50%" height="30"><label id="labelhead" >&nbsp权限描述 </label></td>
</tr>
</table>
</div>
    <div style="height:1px; width:100%;"></div>  
    <div id="lightcolor" >
   
<table frame="void"  width = "50%" height="22px" style="text-align:center;">

<tr>
  <td width="50%" height="22px"><label id="labelbody" >qx000${auth} </label></td>  
  <!--模板编号-->
  <td width="50%" height="22px"><label id="labelbody" >${authDetail} </label></td>
</tr>



</table>
</div>  


 <div style="height:8px; width:100%;"></div>
   <div id="buttoncon">
   <a href="<c:url value='/manager/user/authupdate/'/>${username}">
    <button name="btnGenerate" type="submit" style="width:150px ;height:25px;background:#2976BE;border:0;color:#FFF;font-family: Microsoft YaHei;">更改用户权限</button>
    </a> 
  </div>
  </body>
</html>
