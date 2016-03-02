<%@page import="com.zero.entity.Finaproduct"%>>
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
    <title>产品详细信息</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">

<link href='<c:url value="/css/mycss.css" />' rel="stylesheet">

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
#inputwidth1 {
	width: 300px;
	height: 50px;
	background: Transparent;
	border: 1px solid #788587;
	color:#FFF;
 //border:#000;
 //font-size:14px;
}
</style>
  <body>
    <div style="height:8px; width:100%;"></div>
<form  method="get"  action="">
  <div id="lightcolor">
 <div style="height:8px; width:100%;"></div>
  <label  id="labelhead">理财产品详细信息</label>
  <div style="height:8px; width:100%;"></div>
  <label id="labelhead" >&nbsp&nbsp&nbsp&nbsp产品编号:&nbsp&nbsp&nbsp </label>
  <label id="labelbody">${product.prodCode}</label> <!--此label内容为从后台查询得到-->
  
  <div style="height:4px; width:100%;"></div>
  <label id="labelhead" >&nbsp&nbsp&nbsp&nbsp产品名称:&nbsp&nbsp&nbsp </label>
  <label id="labelbody">${product.prodName}</label><!--此label内容为从后台查询得到-->
  
  <div style="height:4px; width:100%;"></div>
  <label id="labelhead">&nbsp&nbsp&nbsp&nbsp风险等级:&nbsp&nbsp&nbsp </label>
  <label id="labelbody">${product.riskLevel}</label><!--此label内容为从后台查询得到-->
  
  <div style="height:4px; width:100%;"></div>
  <label id="labelhead">&nbsp&nbsp&nbsp&nbsp发行时间:&nbsp&nbsp&nbsp </label>
  <label id="labelbody">${product.issueDate}</label> <!--此label内容为从后台查询得到-->
  
  <div style="height:4px; width:100%;"></div>
  <div>
  <div style="float:left">
   <label id="labelhead">&nbsp&nbsp&nbsp&nbsp产品明细:&nbsp&nbsp&nbsp </label>
  </div>
    <textarea  type="textarea" id="inputwidth1" name="textarea" >
   ${product.prodDetail}
    </textarea>
  </div>
  
  <div style="height:4px; width:100%;"></div>
  <label id="labelhead">&nbsp&nbsp&nbsp&nbsp最低金额:&nbsp&nbsp&nbsp </label>
  <label id="labelbody"></label> <!--此label内容为从后台查询得到-->

  </div>
 
</form>
  </body>
</html>
