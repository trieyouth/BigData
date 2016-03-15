<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
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
<td colspan="5" height="30px" style="text-align:center; font-size: 30px;"><label  id="labelhead">数据采集记录 </label></td>
</tr>
<tr>
  <td width="20%"  height="25"  ><label id="labelhead" >采集记录编号 </label></td>  <!--模板编号-->
  <td width="30%"  height="25"  ><label id="labelhead" >生成数量 </label></td>
<!--   <td width="20%"  height="25"  ><label id="labelhead" >生成数量 </label></td> -->
  <td width="20%"  height="25"  ><label id="labelhead" >操作人 </label></td>
  <td width="20%"  height="25"  ><label id="labelhead" >详细信息 </label></td>
  <td width="10%"  height="25" ><label id="labelhead" >操作 </label></td>
</tr>
</table>
</div>
<div style="height:4px; width:100%;"></div>
<form method="post" action="<c:url value="/ccas/index/dataCollect/collectingRecord"/>">
<div id="lighttable">
  <table frame="void" width = "100%" height="30" border="1" cellspacing="0" bordercolor="#999999" style="border-collapse:collapse;">
    <span style="overflow:hidden;height:30"></span>
   
   <c:forEach items="${Singleusercreditinformations}" var="scis">
    <!--jsp循环此处的tr,在</td>前填数据-->
    <tr>
      <td width="20%"  height="30" class="cell" ><label id="labelbody" ><c:out value="${ scis.singleuserinfoId}"/></label></td>		
      <td width="30%"  height="30" class="cell"><label id="labelbody" ><c:out value="${ scis.generateRecordNum}"/></label></td>		
      <td width="20%"  height="30"class="cell"><label id="labelbody" ><c:out value="${ scis.userName}"/></label></td> 
      <td width="20%"  height="30"><label id="labelbody" ><a href="<c:url value="/ccas/index/dataCollect/checkCollectiong/${scis.singleuserinfoId}"/>" style="color:#09F">查看详情</a></label></td>		
      <td width="10%"  height="30"><label id="labelbody" ><a href="<c:url value="/ccas/index/dataCollect/deleteCollecting/${scis.singleuserinfoId}"/>"  style="color:#09F">删除</a></label></td> 
    </tr>
   </c:forEach> 
  </table>
</div>
</form>
</body>
</html>
