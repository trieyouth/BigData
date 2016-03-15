<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>模板管理</title>
    <meta charset="utf-8">
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
   <link href="<c:url value="/css/mycss.css"/>" rel="stylesheet" type="text/css">
  </head>
  
<body>
<div style="height:10px; width:100%;"></div>
<div id="lightcolor">

<table frame="void" width = "100%" height="25" >
<tr>
<td colspan="5" height="30px" style="text-align:center; font-size: 30px;"><label  id="labelhead">模板管理 </label></td>
</tr>
<tr>
  <td width="20%"  height="25"  ><label id="labelhead" >编号 </label></td>  <!--模板编号-->
  <td width="30%"  height="25"  ><label id="labelhead" >创建时间 </label></td>
<!--   <td width="20%"  height="25"  ><label id="labelhead" >生成数量 </label></td> -->
  <td width="20%"  height="25"  ><label id="labelhead" >创建人 </label></td>
<!--   <td width="20%"  height="25"  ><label id="labelhead" >详细信息 </label></td> -->
  <td width="10%"  height="25" ><label id="labelhead" >操作 </label></td>
</tr>
</table>
</div>
<div style="height:4px; width:100%;"></div>
<form  method="get" action="<c:url value="/icpas/index/dataCollect/templetCreateRecordDetail"/>">
<div id="lighttable">
  <table  frame="void" width = "100%" height="25" >
   <c:forEach items="${Secondtemplatedatas}" var="std">
    <tr>
      <td width="20%"  height="30" class="cell" ><label id="labelbody" ><c:out value="${ std.tempId}"/></label></td>		
      <td width="30%"  height="30" class="cell"><label id="labelbody" ><c:out value="${ std.tempDate} ${ std.tempTime}"/> </label></td>		
      <td width="20%"  height="30"class="cell"><label id="labelbody" ><c:out value="${ std.adminId }"/></label></td> 
      <td width="10%"  height="30"><label id="labelbody" ><a href="<c:url value="/icpas/index/dataCollect/deleteTemplate/${ std.tempId}"/>" style="color:#09F">删除</a></label></td> 
    </tr>
    </c:forEach> 
  </table>
</div>
</form>
</body>
</html>
