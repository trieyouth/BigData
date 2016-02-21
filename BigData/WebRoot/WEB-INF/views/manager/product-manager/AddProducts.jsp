<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <meta charset="utf-8">
    <title>增加产品</title>
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
<form  method="post" name="form1">
  <div id="lightcolor">
 <div style="height:8px; width:100%;"></div>
  <label  id="labelhead">增加产品</label>

  <div style="height:8px; width:100%;"></div>
  <label id="labelhead" >&nbsp&nbsp&nbsp&nbsp产品编号:&nbsp&nbsp&nbsp </label>
 <input  type="text" id="inputwidth" name="procode"  required >
  
  <div style="height:4px; width:100%;"></div>
  <label id="labelhead" >&nbsp&nbsp&nbsp&nbsp产品名称:&nbsp&nbsp&nbsp </label>
 <input  type="text" id="inputwidth" name="proname"  required >
  
  <div style="height:4px; width:100%;"></div>
  <label id="labelhead">&nbsp&nbsp&nbsp&nbsp风险等级:&nbsp&nbsp&nbsp </label>
 <input  type="text" id="inputwidth" name="proriskleval"   required>
  
  <div style="height:4px; width:100%;"></div>
  <label id="labelhead">&nbsp&nbsp&nbsp&nbsp发行时间:&nbsp&nbsp&nbsp </label>
<input  type="date"  id="inputwidth" name="proinittime"  required >


 
  <div style="height:4px; width:100%;"></div>
  <label id="labelhead">&nbsp&nbsp&nbsp&nbsp最低金额:&nbsp&nbsp&nbsp </label>
  <input  type="text" id="inputwidth" name="prominmony"   required onkeyup="this.value=this.value.replace(/\D/g,'')">
  
  <div style="height:4px; width:100%;"></div>
 
 
  <div>
  <div style="float:left">
   <label id="labelhead">&nbsp&nbsp&nbsp&nbsp产品明细:&nbsp&nbsp&nbsp </label>
  </div>
    <textarea  type="textarea" id="inputwidth1" name="prodetail"  >
    </textarea>
  </div>
  
 
  
 
 
 
 
 
  </div>
 
 
       <div style="height:10px; width:100%;"></div>
  <!--选择按钮功能-->
  <div id="buttoncon">
    <button name="btnGenerate" type="submit" style="width:150px ;height:25px;background:#2976BE;border:0;color:#FFF;font-family: Microsoft YaHei;">增加产品</button>
    <!--点击此按钮后台获得参数-->
    <button  type="reset" style="width:150px ;height:25px;background:#A74544;border:0;color:#FFF;font-family: Microsoft YaHei;">重新设置参数</button>
  
  </div>
 
 
</form>


  

  </body>
</html>
